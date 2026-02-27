package org.millenaire.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

/**
 * Костёр инуитов - для готовки и обогрева
 */
public class BlockFirePit extends Block {
    
    public BlockFirePit(Settings settings) {
        super(settings);
    }
    
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        // Частицы огня и дыма
        double x = pos.getX() + 0.5;
        double y = pos.getY() + 0.5;
        double z = pos.getZ() + 0.5;
        
        world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 0.05, 0.0);
        world.addParticle(ParticleTypes.FLAME, x, y, z, 0.0, 0.02, 0.0);
    }
}
