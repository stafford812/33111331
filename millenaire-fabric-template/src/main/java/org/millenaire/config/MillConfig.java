package org.millenaire.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import org.millenaire.Millenaire;

/**
 * Конфигурация мода Millénaire
 * 
 * Использует Cloth Config для GUI настроек
 */
@Config(name = Millenaire.MOD_ID)
public class MillConfig implements ConfigData {
    
    private static MillConfig INSTANCE;
    
    // ==================== ГЕНЕРАЦИЯ ====================
    
    @ConfigEntry.Category("generation")
    @ConfigEntry.Gui.Tooltip
    public boolean enableVillageGeneration = true;
    
    @ConfigEntry.Category("generation")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 8, max = 64)
    public int villageMinDistance = 24;
    
    @ConfigEntry.Category("generation")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 16, max = 128)
    public int villageMaxDistance = 48;
    
    @ConfigEntry.Category("generation")
    @ConfigEntry.Gui.Tooltip
    public boolean generateInAllBiomes = false;
    
    // ==================== ЖИТЕЛИ ====================
    
    @ConfigEntry.Category("villagers")
    @ConfigEntry.Gui.Tooltip
    public boolean villagersCanDie = true;
    
    @ConfigEntry.Category("villagers")
    @ConfigEntry.Gui.Tooltip
    public boolean villagersRespawn = true;
    
    @ConfigEntry.Category("villagers")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 100, max = 10000)
    public int villagerRespawnTime = 1200; // в тиках (1 минута)
    
    @ConfigEntry.Category("villagers")
    @ConfigEntry.Gui.Tooltip
    public boolean showVillagerNames = true;
    
    // ==================== СТРОИТЕЛЬСТВО ====================
    
    @ConfigEntry.Category("building")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
    public int buildingSpeed = 10; // процент от нормальной скорости
    
    @ConfigEntry.Category("building")
    @ConfigEntry.Gui.Tooltip
    public boolean instantBuilding = false; // для отладки
    
    // ==================== ТОРГОВЛЯ ====================
    
    @ConfigEntry.Category("trading")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 10, max = 500)
    public int tradePriceMultiplier = 100; // процент
    
    @ConfigEntry.Category("trading")
    @ConfigEntry.Gui.Tooltip
    public boolean reputationAffectsPrices = true;
    
    // ==================== ПРОИЗВОДИТЕЛЬНОСТЬ ====================
    
    @ConfigEntry.Category("performance")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 32, max = 256)
    public int villageRenderDistance = 128;
    
    @ConfigEntry.Category("performance")
    @ConfigEntry.Gui.Tooltip
    public boolean asyncVillageProcessing = true;
    
    // ==================== ОТЛАДКА ====================
    
    @ConfigEntry.Category("debug")
    @ConfigEntry.Gui.Tooltip
    public boolean debugMode = false;
    
    @ConfigEntry.Category("debug")
    @ConfigEntry.Gui.Tooltip
    public boolean showVillageBorders = false;
    
    @ConfigEntry.Category("debug")
    @ConfigEntry.Gui.Tooltip
    public int logLevel = 1; // 0=none, 1=info, 2=debug, 3=verbose
    
    // ==================== ИНИЦИАЛИЗАЦИЯ ====================
    
    public static void init() {
        AutoConfig.register(MillConfig.class, GsonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(MillConfig.class).getConfig();
    }
    
    public static MillConfig get() {
        return INSTANCE;
    }
}
