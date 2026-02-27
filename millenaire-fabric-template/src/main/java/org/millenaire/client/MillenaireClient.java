package org.millenaire.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import org.millenaire.Millenaire;
import org.millenaire.client.render.MillVillagerRenderer;
import org.millenaire.client.gui.MillScreens;
import org.millenaire.client.keybind.MillKeybinds;
import org.millenaire.common.entity.MillEntities;

/**
 * Клиентская инициализация мода Millénaire
 */
@Environment(EnvType.CLIENT)
public class MillenaireClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        Millenaire.LOGGER.info("[{}] Инициализация клиента...", Millenaire.MOD_ID);
        
        // Регистрация рендереров сущностей
        registerEntityRenderers();
        
        // Регистрация рендереров блок-сущностей
        registerBlockEntityRenderers();
        
        // Регистрация экранов/GUI
        MillScreens.register();
        
        // Регистрация клавиш
        MillKeybinds.register();
        
        Millenaire.LOGGER.info("[{}] Клиент инициализирован", Millenaire.MOD_ID);
    }
    
    private void registerEntityRenderers() {
        // Регистрация рендерера жителей
        // EntityRendererRegistry.register(MillEntities.VILLAGER, MillVillagerRenderer::new);
        
        // Декорации на стенах
        // EntityRendererRegistry.register(MillEntities.WALL_DECORATION, WallDecorationRenderer::new);
    }
    
    private void registerBlockEntityRenderers() {
        // Рендерер кроватей
        // BlockEntityRendererRegistry.register(MillBlockEntities.BED, MillBedRenderer::new);
        
        // Рендерер сундуков
        // BlockEntityRendererRegistry.register(MillBlockEntities.LOCKED_CHEST, LockedChestRenderer::new);
        
        // Рендерер панелей
        // BlockEntityRendererRegistry.register(MillBlockEntities.PANEL, PanelRenderer::new);
    }
}
