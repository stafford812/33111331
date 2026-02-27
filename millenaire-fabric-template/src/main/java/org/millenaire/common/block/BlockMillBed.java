package org.millenaire.common.block;

import net.minecraft.block.BedBlock;
import net.minecraft.block.enums.BedPart;

/**
 * Кровати Millénaire - соломенная, византийская, инуитская
 */
public class BlockMillBed extends BedBlock {
    
    public BlockMillBed(Settings settings) {
        super(null, settings); // DyeColor null для кастомных кроватей
    }
}
