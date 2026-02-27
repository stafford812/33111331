package org.millenaire.client.keybind;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.millenaire.Millenaire;

/**
 * Клавиши управления Millénaire
 */
@Environment(EnvType.CLIENT)
public class MillKeybinds {
    
    public static KeyBinding OPEN_VILLAGE_INFO;
    public static KeyBinding OPEN_TRAVEL_BOOK;
    
    public static void register() {
        Millenaire.LOGGER.info("[{}] Регистрация клавиш...", Millenaire.MOD_ID);
        
        OPEN_VILLAGE_INFO = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.millenaire.village_info",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_M,
            "category.millenaire"
        ));
        
        OPEN_TRAVEL_BOOK = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.millenaire.travel_book",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_B,
            "category.millenaire"
        ));
        
        Millenaire.LOGGER.info("[{}] Клавиши зарегистрированы", Millenaire.MOD_ID);
    }
}
