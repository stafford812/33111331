package org.millenaire.common.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import org.millenaire.Millenaire;

/**
 * Генерация мира Millénaire
 * 
 * Регистрирует генерацию деревень в мире
 */
public class MillWorldGen {
    
    public static void register() {
        Millenaire.LOGGER.info("[{}] Регистрация генерации мира...", Millenaire.MOD_ID);
        
        // TODO: Зарегистрировать структуры деревень
        // В Fabric 1.21.1 структуры регистрируются через datapack
        // или программно через BiomeModifications
        
        // Пример добавления feature в биомы:
        // BiomeModifications.addFeature(
        //     BiomeSelectors.foundInOverworld(),
        //     GenerationStep.Feature.SURFACE_STRUCTURES,
        //     RegistryKey.of(RegistryKeys.PLACED_FEATURE, Millenaire.id("village"))
        // );
        
        Millenaire.LOGGER.info("[{}] Генерация мира зарегистрирована", Millenaire.MOD_ID);
    }
}
