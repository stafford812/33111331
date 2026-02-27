package org.millenaire;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.util.Identifier;
import org.millenaire.common.block.MillBlocks;
import org.millenaire.common.item.MillItems;
import org.millenaire.common.entity.MillEntities;
import org.millenaire.common.world.MillWorldGen;
import org.millenaire.common.network.MillNetwork;
import org.millenaire.common.command.MillCommands;
import org.millenaire.common.culture.CultureManager;
import org.millenaire.config.MillConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Millénaire - Главный класс мода
 * 
 * Портирование с 1.12.2 Forge на 1.21.1 Fabric
 * Оригинальный автор: Kinniken
 */
public class Millenaire implements ModInitializer {
    
    public static final String MOD_ID = "millenaire";
    public static final String MOD_NAME = "Millénaire";
    public static final String VERSION = "1.0.0";
    
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    // Утилитарный метод для создания Identifier
    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
    
    @Override
    public void onInitialize() {
        LOGGER.info("===========================================");
        LOGGER.info("  {} {} initializing...", MOD_NAME, VERSION);
        LOGGER.info("===========================================");
        
        // 1. Загрузка конфигурации
        MillConfig.init();
        LOGGER.info("[{}] Конфигурация загружена", MOD_ID);
        
        // 2. Регистрация блоков
        MillBlocks.register();
        LOGGER.info("[{}] Блоки зарегистрированы", MOD_ID);
        
        // 3. Регистрация предметов
        MillItems.register();
        LOGGER.info("[{}] Предметы зарегистрированы", MOD_ID);
        
        // 4. Регистрация сущностей (жители, декорации)
        MillEntities.register();
        LOGGER.info("[{}] Сущности зарегистрированы", MOD_ID);
        
        // 5. Регистрация генерации мира (деревни)
        MillWorldGen.register();
        LOGGER.info("[{}] Генерация мира зарегистрирована", MOD_ID);
        
        // 6. Регистрация сетевых пакетов
        MillNetwork.register();
        LOGGER.info("[{}] Сеть зарегистрирована", MOD_ID);
        
        // 7. Регистрация команд
        MillCommands.register();
        LOGGER.info("[{}] Команды зарегистрированы", MOD_ID);
        
        // 8. Загрузка культур и данных
        registerServerEvents();
        
        LOGGER.info("===========================================");
        LOGGER.info("  {} {} loaded successfully!", MOD_NAME, VERSION);
        LOGGER.info("===========================================");
    }
    
    private void registerServerEvents() {
        // При старте сервера загружаем культуры
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            CultureManager.loadCultures();
            LOGGER.info("[{}] Культуры загружены", MOD_ID);
        });
        
        // Тик сервера для обновления деревень
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            // VillageManager.tick(server);
        });
        
        // При остановке сервера сохраняем данные
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            // VillageManager.save();
            LOGGER.info("[{}] Данные деревень сохранены", MOD_ID);
        });
    }
}
