package org.millenaire.common.culture;

import org.millenaire.Millenaire;
import java.util.*;

/**
 * Менеджер культур Millénaire
 * 
 * Загружает и управляет всеми культурами из файлов данных
 */
public class CultureManager {
    
    private static final Map<String, Culture> CULTURES = new LinkedHashMap<>();
    
    /**
     * Загрузить все культуры
     */
    public static void loadCultures() {
        Millenaire.LOGGER.info("[{}] Загрузка культур...", Millenaire.MOD_ID);
        
        // Базовые культуры из оригинального мода
        registerCulture(new Culture("norman", "Norman", "norman")
            .setDescription("Средневековые нормандские деревни")
            .addVillageType("hamlet", "Деревушка")
            .addVillageType("village", "Деревня")
            .addVillageType("fort", "Форт"));
        
        registerCulture(new Culture("indian", "Hindi", "indian")
            .setDescription("Индийские деревни с храмами")
            .addVillageType("hamlet", "Деревушка")
            .addVillageType("village", "Деревня"));
        
        registerCulture(new Culture("mayan", "Mayan", "mayan")
            .setDescription("Деревни майя с пирамидами")
            .addVillageType("hamlet", "Поселение")
            .addVillageType("village", "Город"));
        
        registerCulture(new Culture("japanese", "Japanese", "japanese")
            .setDescription("Японские деревни с пагодами")
            .addVillageType("hamlet", "Деревушка")
            .addVillageType("village", "Деревня"));
        
        registerCulture(new Culture("byzantines", "Byzantine", "byzantines")
            .setDescription("Византийские деревни со церквями")
            .addVillageType("hamlet", "Деревушка")
            .addVillageType("village", "Поселение")
            .addVillageType("fort", "Крепость"));
        
        registerCulture(new Culture("inuits", "Inuit", "inuits")
            .setDescription("Инуитские поселения в снежных биомах")
            .addVillageType("hamlet", "Лагерь")
            .addVillageType("village", "Поселение"));
        
        registerCulture(new Culture("seljuk", "Seljuk", "seljuk")
            .setDescription("Сельджукские деревни")
            .addVillageType("hamlet", "Лагерь")
            .addVillageType("village", "Деревня"));
        
        Millenaire.LOGGER.info("[{}] Загружено {} культур", Millenaire.MOD_ID, CULTURES.size());
    }
    
    /**
     * Зарегистрировать культуру
     */
    public static void registerCulture(Culture culture) {
        CULTURES.put(culture.getId(), culture);
    }
    
    /**
     * Получить культуру по ID
     */
    public static Culture getCulture(String id) {
        return CULTURES.get(id);
    }
    
    /**
     * Получить все культуры
     */
    public static Collection<Culture> getAllCultures() {
        return CULTURES.values();
    }
    
    /**
     * Получить случайную культуру для биома
     */
    public static Culture getRandomCultureForBiome(String biomeId) {
        // TODO: Реализовать выбор культуры на основе биома
        // Снежные биомы -> Inuit
        // Пустыня -> Mayan, Seljuk
        // Леса -> Norman, Japanese
        // Равнины -> Norman, Indian, Byzantine
        
        List<Culture> cultures = new ArrayList<>(CULTURES.values());
        return cultures.get(new Random().nextInt(cultures.size()));
    }
}
