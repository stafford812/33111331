package org.millenaire.common.village;

import java.util.HashMap;
import java.util.Map;

/**
 * Ресурсы деревни Millénaire
 * 
 * Управляет всеми ресурсами, которые жители собирают и используют
 */
public class VillageResources {
    
    // Хранилище ресурсов (itemId -> количество)
    private Map<String, Integer> resources = new HashMap<>();
    
    // Максимальная вместимость (зависит от зданий-хранилищ)
    private Map<String, Integer> maxCapacity = new HashMap<>();
    
    /**
     * Добавить ресурс
     */
    public boolean addResource(String itemId, int amount) {
        int current = resources.getOrDefault(itemId, 0);
        int max = maxCapacity.getOrDefault(itemId, Integer.MAX_VALUE);
        
        int newAmount = Math.min(current + amount, max);
        resources.put(itemId, newAmount);
        
        return newAmount == current + amount; // true если всё добавлено
    }
    
    /**
     * Забрать ресурс
     */
    public int takeResource(String itemId, int amount) {
        int current = resources.getOrDefault(itemId, 0);
        int taken = Math.min(current, amount);
        
        resources.put(itemId, current - taken);
        return taken;
    }
    
    /**
     * Получить количество ресурса
     */
    public int getResourceCount(String itemId) {
        return resources.getOrDefault(itemId, 0);
    }
    
    /**
     * Проверить есть ли достаточно ресурса
     */
    public boolean hasResource(String itemId, int amount) {
        return getResourceCount(itemId) >= amount;
    }
    
    /**
     * Установить максимальную вместимость
     */
    public void setMaxCapacity(String itemId, int capacity) {
        maxCapacity.put(itemId, capacity);
    }
    
    /**
     * Получить все ресурсы
     */
    public Map<String, Integer> getAllResources() {
        return new HashMap<>(resources);
    }
    
    /**
     * Подсчитать общую стоимость ресурсов (в денье)
     */
    public int getTotalValue() {
        // TODO: реализовать с учётом цен
        return 0;
    }
}
