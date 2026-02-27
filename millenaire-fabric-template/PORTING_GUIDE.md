# Руководство по портированию Millénaire с 1.12.2 Forge на 1.21.1 Fabric

## Содержание

1. [Обзор изменений](#обзор-изменений)
2. [Перенос ассетов](#перенос-ассетов)
3. [Адаптация кода](#адаптация-кода)
4. [Различия API](#различия-api)
5. [Чек-лист](#чек-лист)

---

## Обзор изменений

### Основные различия Forge 1.12.2 vs Fabric 1.21.1

| Аспект | Forge 1.12.2 | Fabric 1.21.1 |
|--------|--------------|---------------|
| Модлоадер | ForgeModLoader | Fabric Loader |
| API | Forge API | Fabric API |
| Маппинги | MCP/SRG | Yarn/Intermediary |
| Java | 8 | 21 |
| Регистрация | @Mod + GameRegistry | ModInitializer + Registry |
| События | @SubscribeEvent | Fabric Events |
| GUI | GuiScreen | Screen |
| Сеть | SimpleNetworkWrapper | Fabric Networking |
| Config | Forge Config | Cloth Config |

---

## Перенос ассетов

### Структура папок

**Оригинал (1.12.2):**
```
assets/millenaire/
├── textures/
│   ├── blocks/
│   ├── items/
│   └── entity/
├── models/
│   ├── block/
│   └── item/
├── blockstates/
└── lang/
    └── en_us.lang
```

**Fabric 1.21.1:**
```
assets/millenaire/
├── textures/
│   ├── block/          # Было blocks/
│   ├── item/           # Было items/
│   └── entity/
├── models/
│   ├── block/
│   └── item/
├── blockstates/
└── lang/
    └── en_us.json      # Было .lang, теперь JSON
```

### Шаги переноса текстур

1. **Скопировать папки текстур:**
   ```bash
   cp -r original/textures/blocks/* fabric/textures/block/
   cp -r original/textures/items/* fabric/textures/item/
   cp -r original/textures/entity/* fabric/textures/entity/
   ```

2. **Переименовать файлы (если нужно):**
   - Убедитесь что имена в нижнем регистре
   - Замените пробелы на подчёркивания

### Конвертация lang файлов

**Оригинал (.lang):**
```
item.denier.name=Denier
tile.painted_brick.white.name=White Painted Brick
```

**Fabric (.json):**
```json
{
  "item.millenaire.denier": "Denier",
  "block.millenaire.painted_brick_white": "White Painted Brick"
}
```

**Скрипт конвертации:**
```python
import json
import re

def convert_lang(input_file, mod_id="millenaire"):
    translations = {}
    with open(input_file, 'r') as f:
        for line in f:
            if '=' in line and not line.startswith('#'):
                key, value = line.strip().split('=', 1)
                # Конвертировать ключ
                new_key = key.replace('.name', '')
                new_key = new_key.replace('tile.', f'block.{mod_id}.')
                new_key = new_key.replace('item.', f'item.{mod_id}.')
                translations[new_key] = value
    
    return json.dumps(translations, indent=2, ensure_ascii=False)
```

---

## Адаптация кода

### Регистрация мода

**Forge 1.12.2:**
```java
@Mod(modid = "millenaire", name = "Millénaire", version = "8.1.2")
public class Mill {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) { }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) { }
}
```

**Fabric 1.21.1:**
```java
public class Millenaire implements ModInitializer {
    public static final String MOD_ID = "millenaire";
    
    @Override
    public void onInitialize() {
        // Вся инициализация здесь
    }
}
```

### Регистрация блоков

**Forge 1.12.2:**
```java
@SubscribeEvent
public static void registerBlocks(RegistryEvent.Register<Block> event) {
    event.getRegistry().register(new BlockPaintedBrick().setRegistryName("painted_brick"));
}
```

**Fabric 1.21.1:**
```java
public static final Block PAINTED_BRICK = Registry.register(
    Registries.BLOCK,
    Identifier.of("millenaire", "painted_brick"),
    new Block(AbstractBlock.Settings.copy(Blocks.BRICKS))
);
```

### Регистрация сущностей

**Forge 1.12.2:**
```java
EntityRegistry.registerModEntity(
    new ResourceLocation("millenaire", "villager"),
    MillVillager.class,
    "villager",
    id++,
    MODID,
    128, 3, true
);
```

**Fabric 1.21.1:**
```java
public static final EntityType<MillVillager> VILLAGER = Registry.register(
    Registries.ENTITY_TYPE,
    Identifier.of("millenaire", "villager"),
    FabricEntityTypeBuilder.create(SpawnGroup.MISC, MillVillager::new)
        .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
        .build()
);

// В onInitialize():
FabricDefaultAttributeRegistry.register(VILLAGER, MillVillager.createAttributes());
```

### События

**Forge 1.12.2:**
```java
@SubscribeEvent
public void onServerTick(TickEvent.ServerTickEvent event) {
    // ...
}
```

**Fabric 1.21.1:**
```java
ServerTickEvents.END_SERVER_TICK.register(server -> {
    // ...
});
```

### GUI / Screens

**Forge 1.12.2:**
```java
public class GuiTrade extends GuiScreen {
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        // ...
    }
}
```

**Fabric 1.21.1:**
```java
public class TradeScreen extends Screen {
    public TradeScreen() {
        super(Text.translatable("millenaire.gui.trade"));
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        // ...
    }
}
```

### Сетевые пакеты

**Forge 1.12.2:**
```java
SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel("millenaire");
network.registerMessage(VillageDataHandler.class, VillageDataPacket.class, 0, Side.CLIENT);
```

**Fabric 1.21.1:**
```java
// Определение пакета
public record VillageDataPayload(int villageId, String data) implements CustomPayload {
    public static final CustomPayload.Id<VillageDataPayload> ID = 
        new CustomPayload.Id<>(Identifier.of("millenaire", "village_data"));
    
    @Override
    public Id<? extends CustomPayload> getId() { return ID; }
}

// Регистрация
PayloadTypeRegistry.playS2C().register(VillageDataPayload.ID, VillageDataPayload.CODEC);
ServerPlayNetworking.registerGlobalReceiver(VillageDataPayload.ID, (payload, context) -> {
    // Обработка
});
```

---

## Различия API

### Идентификаторы

**Forge:** `new ResourceLocation("millenaire", "block")`
**Fabric:** `Identifier.of("millenaire", "block")`

### NBT

**Forge 1.12.2:**
```java
NBTTagCompound nbt = new NBTTagCompound();
nbt.setInteger("value", 42);
int value = nbt.getInteger("value");
```

**Fabric 1.21.1:**
```java
NbtCompound nbt = new NbtCompound();
nbt.putInt("value", 42);
int value = nbt.getInt("value");
```

### Текст

**Forge 1.12.2:**
```java
new TextComponentTranslation("millenaire.message")
```

**Fabric 1.21.1:**
```java
Text.translatable("millenaire.message")
```

### ItemStack

**Forge 1.12.2:**
```java
new ItemStack(item, count, metadata)
```

**Fabric 1.21.1:**
```java
new ItemStack(item, count)  // Нет metadata, используйте Components
```

---

## Чек-лист портирования

### Этап 1: Базовая структура
- [x] Создать build.gradle.kts для Fabric
- [x] Создать fabric.mod.json
- [x] Главный класс ModInitializer
- [x] Клиентский класс ClientModInitializer

### Этап 2: Блоки и предметы
- [ ] Перенести текстуры блоков
- [ ] Перенести текстуры предметов  
- [ ] Создать JSON модели
- [ ] Зарегистрировать все блоки
- [ ] Зарегистрировать все предметы
- [ ] Творческие вкладки

### Этап 3: Сущности
- [ ] Портировать MillVillager
- [ ] Портировать WallDecoration
- [ ] Создать рендереры
- [ ] AI Goals

### Этап 4: Деревни
- [ ] Система Village
- [ ] Система Building
- [ ] BuildingPlan загрузчик
- [ ] VillageResources

### Этап 5: Культуры
- [ ] Загрузчик культур
- [ ] Система профессий
- [ ] Система торговли
- [ ] Система квестов

### Этап 6: Генерация мира
- [ ] Структуры деревень
- [ ] Биомные ограничения

### Этап 7: GUI
- [ ] Экран торговли
- [ ] Экран информации о деревне
- [ ] Книга путешественника
- [ ] Экран квестов

### Этап 8: Сеть
- [ ] Синхронизация деревень
- [ ] Пакеты торговли
- [ ] Пакеты квестов

### Этап 9: Полировка
- [ ] Локализация
- [ ] Конфигурация
- [ ] Тестирование
- [ ] Документация

---

## Полезные ссылки

- [Fabric Wiki](https://fabricmc.net/wiki/)
- [Fabric API GitHub](https://github.com/FabricMC/fabric)
- [Yarn Mappings](https://github.com/FabricMC/yarn)
- [Cloth Config](https://github.com/shedaniel/cloth-config)
