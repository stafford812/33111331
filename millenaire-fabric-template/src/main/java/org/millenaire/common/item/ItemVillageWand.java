package org.millenaire.common.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * Жезл деревни - для создания новых деревень
 */
public class ItemVillageWand extends Item {
    
    public ItemVillageWand(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        
        if (!world.isClient) {
            // Открыть GUI выбора культуры для создания деревни
            // user.openHandledScreen(new VillageCreationScreenHandler());
        }
        
        return TypedActionResult.success(stack, world.isClient);
    }
}
