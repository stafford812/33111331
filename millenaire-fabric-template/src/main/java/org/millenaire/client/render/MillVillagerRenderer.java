package org.millenaire.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import org.millenaire.Millenaire;
import org.millenaire.common.entity.MillVillager;

/**
 * Рендерер жителей Millénaire
 */
@Environment(EnvType.CLIENT)
public class MillVillagerRenderer extends BipedEntityRenderer<MillVillager, BipedEntityModel<MillVillager>> {
    
    public MillVillagerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BipedEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER)), 0.5f);
    }
    
    @Override
    public Identifier getTexture(MillVillager entity) {
        // Текстура зависит от культуры и пола
        String culture = entity.getCulture();
        String gender = entity.isMale() ? "male" : "female";
        
        return Millenaire.id("textures/entity/villager/" + culture + "_" + gender + ".png");
    }
}
