package org.millenaire.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

/**
 * Базовый класс для культур Millénaire (рис, турмерик, кукуруза, виноград)
 */
public class BlockMillCrop extends CropBlock {
    
    public static final int MAX_AGE = 7;
    public static final IntProperty AGE = Properties.AGE_7;
    
    public BlockMillCrop(Settings settings) {
        super(settings);
    }
    
    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }
    
    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }
    
    @Override
    protected ItemConvertible getSeedsItem() {
        // Переопределяется в конкретных реализациях
        return null;
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
