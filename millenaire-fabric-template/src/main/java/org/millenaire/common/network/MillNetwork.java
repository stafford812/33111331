package org.millenaire.common.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import org.millenaire.Millenaire;

/**
 * Сетевое взаимодействие Millénaire
 */
public class MillNetwork {
    
    public static void register() {
        Millenaire.LOGGER.info("[{}] Регистрация сетевых пакетов...", Millenaire.MOD_ID);
        
        // Регистрация пакетов C2S (клиент -> сервер)
        // PayloadTypeRegistry.playC2S().register(...);
        
        // Регистрация пакетов S2C (сервер -> клиент)
        // PayloadTypeRegistry.playS2C().register(...);
        
        // Обработчики пакетов
        // ServerPlayNetworking.registerGlobalReceiver(...);
        
        Millenaire.LOGGER.info("[{}] Сетевые пакеты зарегистрированы", Millenaire.MOD_ID);
    }
    
    // TODO: Реализовать пакеты:
    // - VillageDataPacket: синхронизация данных деревни
    // - TradePacket: торговля с жителями
    // - QuestPacket: синхронизация квестов
    // - GuiOpenPacket: открытие GUI
}
