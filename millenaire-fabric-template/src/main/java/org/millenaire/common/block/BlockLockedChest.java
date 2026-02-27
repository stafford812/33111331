package org.millenaire.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Запертый сундук - используется жителями для хранения ресурсов деревни
 * Игрок не может открыть напрямую
 */
public class BlockLockedChest extends Block {
    
    public BlockLockedChest(Settings settings) {
        super(settings);
    }
    
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, 
                                  PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            // Показать сообщение что сундук заперт
            // player.sendMessage(Text.translatable("millenaire.chest.locked"), true);
        }
        return ActionResult.SUCCESS;
    }
}
