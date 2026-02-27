package org.millenaire.common.culture;

import java.util.*;

/**
 * Культура Millénaire
 * 
 * Определяет стиль зданий, профессии жителей, товары для торговли
 */
public class Culture {
    
    private final String id;
    private final String name;
    private final String langPrefix;
    private String description = "";
    
    // Типы деревень для этой культуры
    private Map<String, String> villageTypes = new LinkedHashMap<>();
    
    // Профессии жителей
    private List<VillagerProfession> professions = new ArrayList<>();
    
    // Здания культуры
    private List<String> buildingPlans = new ArrayList<>();
    
    // Имена для жителей (мужские/женские)
    private List<String> maleNames = new ArrayList<>();
    private List<String> femaleNames = new ArrayList<>();
    private List<String> familyNames = new ArrayList<>();
    
    // Товары для торговли
    private List<TradeGood> tradeGoods = new ArrayList<>();
    
    // Биомы, где может появиться культура
    private List<String> validBiomes = new ArrayList<>();
    
    public Culture(String id, String name, String langPrefix) {
        this.id = id;
        this.name = name;
        this.langPrefix = langPrefix;
    }
    
    // ==================== БИЛДЕР МЕТОДЫ ====================
    
    public Culture setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public Culture addVillageType(String typeId, String typeName) {
        villageTypes.put(typeId, typeName);
        return this;
    }
    
    public Culture addProfession(VillagerProfession profession) {
        professions.add(profession);
        return this;
    }
    
    public Culture addBuildingPlan(String planId) {
        buildingPlans.add(planId);
        return this;
    }
    
    public Culture addValidBiome(String biomeId) {
        validBiomes.add(biomeId);
        return this;
    }
    
    // ==================== УТИЛИТАРНЫЕ МЕТОДЫ ====================
    
    /**
     * Получить случайное мужское имя
     */
    public String getRandomMaleName() {
        if (maleNames.isEmpty()) return "John";
        return maleNames.get(new Random().nextInt(maleNames.size()));
    }
    
    /**
     * Получить случайное женское имя
     */
    public String getRandomFemaleName() {
        if (femaleNames.isEmpty()) return "Jane";
        return femaleNames.get(new Random().nextInt(femaleNames.size()));
    }
    
    /**
     * Получить случайную фамилию
     */
    public String getRandomFamilyName() {
        if (familyNames.isEmpty()) return "Smith";
        return familyNames.get(new Random().nextInt(familyNames.size()));
    }
    
    /**
     * Проверить подходит ли биом для этой культуры
     */
    public boolean isValidBiome(String biomeId) {
        return validBiomes.isEmpty() || validBiomes.contains(biomeId);
    }
    
    // ==================== ГЕТТЕРЫ ====================
    
    public String getId() { return id; }
    public String getName() { return name; }
    public String getLangPrefix() { return langPrefix; }
    public String getDescription() { return description; }
    public Map<String, String> getVillageTypes() { return villageTypes; }
    public List<VillagerProfession> getProfessions() { return professions; }
    public List<String> getBuildingPlans() { return buildingPlans; }
    public List<String> getValidBiomes() { return validBiomes; }
    
    /**
     * Профессия жителя
     */
    public static class VillagerProfession {
        private final String id;
        private final String nameKey;
        private final boolean isMale;
        private final List<String> goals = new ArrayList<>();
        
        public VillagerProfession(String id, String nameKey, boolean isMale) {
            this.id = id;
            this.nameKey = nameKey;
            this.isMale = isMale;
        }
        
        public String getId() { return id; }
        public String getNameKey() { return nameKey; }
        public boolean isMale() { return isMale; }
        public List<String> getGoals() { return goals; }
    }
    
    /**
     * Товар для торговли
     */
    public static class TradeGood {
        private final String itemId;
        private final int buyPrice;
        private final int sellPrice;
        
        public TradeGood(String itemId, int buyPrice, int sellPrice) {
            this.itemId = itemId;
            this.buyPrice = buyPrice;
            this.sellPrice = sellPrice;
        }
        
        public String getItemId() { return itemId; }
        public int getBuyPrice() { return buyPrice; }
        public int getSellPrice() { return sellPrice; }
    }
}
