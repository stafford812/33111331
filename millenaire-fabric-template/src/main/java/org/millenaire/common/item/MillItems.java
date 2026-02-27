package org.millenaire.common.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.millenaire.Millenaire;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Регистрация всех предметов мода Millénaire
 * 
 * Портировано с оригинального MillItems.java (1.12.2 Forge)
 */
public class MillItems {
    
    private static final Map<String, Item> ITEMS = new LinkedHashMap<>();
    
    // ==================== ТВОРЧЕСКАЯ ВКЛАДКА ====================
    
    public static final RegistryKey<ItemGroup> MILLENAIRE_GROUP = RegistryKey.of(
        RegistryKeys.ITEM_GROUP, Millenaire.id("millenaire_items")
    );
    
    // ==================== ДЕНЬЕ (ВАЛЮТА) ====================
    
    public static final Item DENIER = registerItem("denier",
        new Item(new Item.Settings().maxCount(64)));
    
    public static final Item DENIER_ARGENT = registerItem("denier_argent",
        new Item(new Item.Settings().maxCount(64)));
    
    public static final Item DENIER_OR = registerItem("denier_or",
        new Item(new Item.Settings().maxCount(64)));
    
    // ==================== ЕДА ====================
    
    // Сырое мясо
    public static final Item BEARMEAT_RAW = registerItem("bearmeat_raw",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(3).saturationModifier(0.3f).meat().build())));
    
    public static final Item BEARMEAT_COOKED = registerItem("bearmeat_cooked",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(8).saturationModifier(0.8f).meat().build())));
    
    public static final Item WOLFMEAT_RAW = registerItem("wolfmeat_raw",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.2f).meat().build())));
    
    public static final Item WOLFMEAT_COOKED = registerItem("wolfmeat_cooked",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.6f).meat().build())));
    
    public static final Item SEAFOOD_RAW = registerItem("seafood_raw",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.1f).build())));
    
    public static final Item SEAFOOD_COOKED = registerItem("seafood_cooked",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(5).saturationModifier(0.5f).build())));
    
    // Приготовленная еда
    public static final Item CIDER = registerItem("cider",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(4).saturationModifier(0.3f).build())));
    
    public static final Item CALVA = registerItem("calva",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.1f).build())));
    
    public static final Item WINE = registerItem("wine",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(3).saturationModifier(0.2f).build())));
    
    public static final Item SOUVLAKI = registerItem("souvlaki",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(8).saturationModifier(0.8f).meat().build())));
    
    public static final Item RICE = registerItem("rice",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.3f).build())));
    
    public static final Item TURMERIC = registerItem("turmeric",
        new Item(new Item.Settings()));
    
    public static final Item MASA = registerItem("masa",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(5).saturationModifier(0.5f).build())));
    
    // ==================== РЕСУРСЫ ====================
    
    public static final Item SILK = registerItem("silk",
        new Item(new Item.Settings()));
    
    public static final Item SILK_WORM = registerItem("silk_worm",
        new Item(new Item.Settings()));
    
    public static final Item HIDE = registerItem("hide",
        new Item(new Item.Settings()));
    
    public static final Item TANNED_HIDE = registerItem("tanned_hide",
        new Item(new Item.Settings()));
    
    public static final Item FUR = registerItem("fur",
        new Item(new Item.Settings()));
    
    public static final Item OLIVE_OIL = registerItem("olive_oil",
        new Item(new Item.Settings()));
    
    public static final Item GRAPE = registerItem("grape",
        new Item(new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.1f).build())));
    
    // Семена
    public static final Item RICE_SEEDS = registerItem("rice_seeds",
        new AliasedBlockItem(null, new Item.Settings())); // TODO: связать с блоком
    
    public static final Item TURMERIC_SEEDS = registerItem("turmeric_seeds",
        new AliasedBlockItem(null, new Item.Settings()));
    
    public static final Item MAIZE_SEEDS = registerItem("maize_seeds",
        new AliasedBlockItem(null, new Item.Settings()));
    
    // ==================== ИНСТРУМЕНТЫ ====================
    
    // Византийские инструменты (на основе железа)
    public static final Item BYZANTINE_PICKAXE = registerItem("byzantine_pickaxe",
        new PickaxeItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 1, -2.8f))));
    
    public static final Item BYZANTINE_AXE = registerItem("byzantine_axe",
        new AxeItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON, 6.0f, -3.1f))));
    
    public static final Item BYZANTINE_SHOVEL = registerItem("byzantine_shovel",
        new ShovelItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.IRON, 1.5f, -3.0f))));
    
    public static final Item BYZANTINE_HOE = registerItem("byzantine_hoe",
        new HoeItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.IRON, -2, -1.0f))));
    
    // Инуитские инструменты
    public static final Item ULU = registerItem("ulu",
        new SwordItem(ToolMaterials.STONE, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 3, -2.4f))));
    
    public static final Item INUIT_BOW = registerItem("inuit_bow",
        new BowItem(new Item.Settings().maxDamage(384)));
    
    public static final Item SPEAR = registerItem("spear",
        new SwordItem(ToolMaterials.STONE, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 4, -2.8f))));
    
    // ==================== ОРУЖИЕ ====================
    
    public static final Item BYZANTINE_MACE = registerItem("byzantine_mace",
        new SwordItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 5, -2.6f))));
    
    public static final Item NORMAN_BROADSWORD = registerItem("norman_broadsword",
        new SwordItem(ToolMaterials.IRON, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 4, -2.4f))));
    
    // ==================== СПЕЦИАЛЬНЫЕ ПРЕДМЕТЫ ====================
    
    public static final Item VILLAGE_WAND = registerItem("village_wand",
        new ItemVillageWand(new Item.Settings().maxCount(1)));
    
    public static final Item NEGATION_WAND = registerItem("negation_wand",
        new ItemNegationWand(new Item.Settings().maxCount(1)));
    
    public static final Item PARCHMENT_VILLAGE = registerItem("parchment_village",
        new Item(new Item.Settings().maxCount(1)));
    
    public static final Item TRAVEL_BOOK = registerItem("travel_book",
        new Item(new Item.Settings().maxCount(1)));
    
    // Иконы (Византия)
    public static final Item ICON_SMALL = registerItem("icon_small",
        new Item(new Item.Settings()));
    
    public static final Item ICON_MEDIUM = registerItem("icon_medium",
        new Item(new Item.Settings()));
    
    public static final Item ICON_LARGE = registerItem("icon_large",
        new Item(new Item.Settings()));
    
    // Инуитские резные фигурки
    public static final Item INUIT_CARVING = registerItem("inuit_carving",
        new Item(new Item.Settings()));
    
    // ==================== АМУЛЕТЫ ====================
    
    public static final Item AMULET_ALCHEMIST = registerItem("amulet_alchemist",
        new ItemAmulet(new Item.Settings().maxCount(1)));
    
    public static final Item AMULET_VISHNU = registerItem("amulet_vishnu",
        new ItemAmulet(new Item.Settings().maxCount(1)));
    
    public static final Item AMULET_YGGDRASIL = registerItem("amulet_yggdrasil",
        new ItemAmulet(new Item.Settings().maxCount(1)));
    
    public static final Item AMULET_SKOLL_HATI = registerItem("amulet_skoll_hati",
        new ItemAmulet(new Item.Settings().maxCount(1)));
    
    // ==================== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ====================
    
    private static Item registerItem(String name, Item item) {
        ITEMS.put(name, item);
        return item;
    }
    
    public static void register() {
        Millenaire.LOGGER.info("[{}] Регистрация предметов...", Millenaire.MOD_ID);
        
        // Регистрация творческой вкладки
        Registry.register(Registries.ITEM_GROUP, MILLENAIRE_GROUP,
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(DENIER))
                .displayName(Text.translatable("itemGroup.millenaire"))
                .build()
        );
        
        // Регистрация предметов
        for (Map.Entry<String, Item> entry : ITEMS.entrySet()) {
            Registry.register(Registries.ITEM, Millenaire.id(entry.getKey()), entry.getValue());
        }
        
        // Добавление в творческую вкладку
        ItemGroupEvents.modifyEntriesEvent(MILLENAIRE_GROUP).register(content -> {
            for (Item item : ITEMS.values()) {
                content.add(item);
            }
        });
        
        Millenaire.LOGGER.info("[{}] Зарегистрировано {} предметов", Millenaire.MOD_ID, ITEMS.size());
    }
}
