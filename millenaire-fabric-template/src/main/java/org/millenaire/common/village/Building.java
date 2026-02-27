package org.millenaire.common.village;

import net.minecraft.util.math.BlockPos;
import java.util.HashMap;
import java.util.Map;

/**
 * Здание деревни Millénaire
 */
public class Building {
    
    private String id;
    private String planId;       // ID плана здания
    private String name;
    private BlockPos position;
    private int level = 0;       // Уровень улучшения
    private int maxLevel;
    
    // Прогресс строительства (0-100)
    private int buildProgress = 0;
    private boolean isComplete = false;
    
    // Жители, приписанные к этому зданию
    private Map<String, java.util.UUID> assignedVillagers = new HashMap<>();
    
    // Ресурсы, необходимые для строительства
    private Map<String, Integer> requiredResources = new HashMap<>();
    private Map<String, Integer> providedResources = new HashMap<>();
    
    public Building(String id, String planId, BlockPos position) {
        this.id = id;
        this.planId = planId;
        this.position = position;
    }
    
    /**
     * Обновить прогресс строительства
     */
    public void updateBuildProgress(int amount) {
        buildProgress = Math.min(100, buildProgress + amount);
        if (buildProgress >= 100) {
            isComplete = true;
        }
    }
    
    /**
     * Проверить есть ли все ресурсы для строительства
     */
    public boolean hasAllResources() {
        for (Map.Entry<String, Integer> entry : requiredResources.entrySet()) {
            int provided = providedResources.getOrDefault(entry.getKey(), 0);
            if (provided < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Улучшить здание
     */
    public boolean upgrade() {
        if (level < maxLevel && isComplete) {
            level++;
            buildProgress = 0;
            isComplete = false;
            // Загрузить новые требования ресурсов
            return true;
        }
        return false;
    }
    
    // ==================== ГЕТТЕРЫ/СЕТТЕРЫ ====================
    
    public String getId() { return id; }
    public String getPlanId() { return planId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BlockPos getPosition() { return position; }
    public int getLevel() { return level; }
    public int getMaxLevel() { return maxLevel; }
    public int getBuildProgress() { return buildProgress; }
    public boolean isComplete() { return isComplete; }
    public Map<String, java.util.UUID> getAssignedVillagers() { return assignedVillagers; }
}
