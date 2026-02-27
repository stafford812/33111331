package org.millenaire.common.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.millenaire.Millenaire;

/**
 * Регистрация сущностей Millénaire
 */
public class MillEntities {
    
    // Жители деревень
    public static final EntityType<MillVillager> VILLAGER = Registry.register(
        Registries.ENTITY_TYPE,
        Millenaire.id("villager"),
        FabricEntityTypeBuilder.create(SpawnGroup.MISC, MillVillager::new)
            .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
            .trackRangeBlocks(128)
            .trackedUpdateRate(3)
            .build()
    );
    
    // Настенные декорации (иконы, картины)
    public static final EntityType<EntityWallDecoration> WALL_DECORATION = Registry.register(
        Registries.ENTITY_TYPE,
        Millenaire.id("wall_decoration"),
        FabricEntityTypeBuilder.create(SpawnGroup.MISC, EntityWallDecoration::new)
            .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
            .trackRangeBlocks(64)
            .trackedUpdateRate(10)
            .build()
    );
    
    public static void register() {
        Millenaire.LOGGER.info("[{}] Регистрация сущностей...", Millenaire.MOD_ID);
        
        // Регистрация атрибутов жителей
        FabricDefaultAttributeRegistry.register(VILLAGER, MillVillager.createVillagerAttributes());
        
        Millenaire.LOGGER.info("[{}] Сущности зарегистрированы", Millenaire.MOD_ID);
    }
}
