package org.millenaire.client.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.millenaire.Millenaire;

/**
 * Регистрация экранов/GUI Millénaire
 */
@Environment(EnvType.CLIENT)
public class MillScreens {
    
    public static void register() {
        Millenaire.LOGGER.info("[{}] Регистрация экранов...", Millenaire.MOD_ID);
        
        // TODO: Зарегистрировать HandledScreens
        // HandledScreens.register(MillScreenHandlers.TRADE, TradeScreen::new);
        // HandledScreens.register(MillScreenHandlers.VILLAGE_INFO, VillageInfoScreen::new);
        
        Millenaire.LOGGER.info("[{}] Экраны зарегистрированы", Millenaire.MOD_ID);
    }
}
