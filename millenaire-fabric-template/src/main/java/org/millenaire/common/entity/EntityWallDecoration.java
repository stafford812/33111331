package org.millenaire.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

/**
 * Настенные декорации - иконы, картины, развешанные шкуры
 */
public class EntityWallDecoration extends AbstractDecorationEntity {
    
    private String decorationType = "icon_small";
    
    public EntityWallDecoration(EntityType<? extends AbstractDecorationEntity> entityType, World world) {
        super(entityType, world);
    }
    
    public EntityWallDecoration(World world, BlockPos pos, Direction direction, String type) {
        super(MillEntities.WALL_DECORATION, world, pos);
        this.decorationType = type;
        this.setFacing(direction);
    }
    
    @Override
    public int getWidthPixels() {
        return switch (decorationType) {
            case "icon_large", "hide_hanging" -> 32;
            case "icon_medium" -> 24;
            default -> 16;
        };
    }
    
    @Override
    public int getHeightPixels() {
        return switch (decorationType) {
            case "icon_large", "hide_hanging" -> 32;
            case "icon_medium" -> 24;
            default -> 16;
        };
    }
    
    @Override
    public void onBreak(Entity entity) {
        // Выпадает предмет при разрушении
    }
    
    @Override
    public void onPlace() {
        // Логика при размещении
    }
    
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putString("DecorationType", decorationType);
    }
    
    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        decorationType = nbt.getString("DecorationType");
    }
    
    public String getDecorationType() { return decorationType; }
}
