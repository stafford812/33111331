package org.millenaire.common.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.millenaire.Millenaire;

/**
 * Команды Millénaire
 */
public class MillCommands {
    
    public static void register() {
        Millenaire.LOGGER.info("[{}] Регистрация команд...", Millenaire.MOD_ID);
        
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            
            // /millenaire - главная команда
            dispatcher.register(CommandManager.literal("millenaire")
                .then(CommandManager.literal("help")
                    .executes(ctx -> {
                        ctx.getSource().sendFeedback(() -> 
                            Text.literal("§6=== Millénaire Commands ==="), false);
                        ctx.getSource().sendFeedback(() -> 
                            Text.literal("§e/millenaire spawn <culture> §7- Создать деревню"), false);
                        ctx.getSource().sendFeedback(() -> 
                            Text.literal("§e/millenaire list §7- Список активных деревень"), false);
                        ctx.getSource().sendFeedback(() -> 
                            Text.literal("§e/millenaire tp <id> §7- Телепортация к деревне"), false);
                        ctx.getSource().sendFeedback(() -> 
                            Text.literal("§e/millenaire reputation <player> <amount> §7- Изменить репутацию"), false);
                        return 1;
                    }))
                
                // /millenaire spawn <culture>
                .then(CommandManager.literal("spawn")
                    .requires(source -> source.hasPermissionLevel(2))
                    .then(CommandManager.argument("culture", StringArgumentType.word())
                        .executes(ctx -> {
                            String culture = StringArgumentType.getString(ctx, "culture");
                            // TODO: Создать деревню
                            ctx.getSource().sendFeedback(() -> 
                                Text.literal("§aСоздание деревни культуры: " + culture), false);
                            return 1;
                        })))
                
                // /millenaire list
                .then(CommandManager.literal("list")
                    .executes(ctx -> {
                        ctx.getSource().sendFeedback(() -> 
                            Text.literal("§6Активные деревни:"), false);
                        // TODO: Список деревень
                        ctx.getSource().sendFeedback(() -> 
                            Text.literal("§7Деревни пока не созданы"), false);
                        return 1;
                    }))
                
                // /millenaire tp <id>
                .then(CommandManager.literal("tp")
                    .then(CommandManager.argument("id", IntegerArgumentType.integer(0))
                        .executes(ctx -> {
                            int id = IntegerArgumentType.getInteger(ctx, "id");
                            // TODO: Телепортация
                            ctx.getSource().sendFeedback(() -> 
                                Text.literal("§aТелепортация к деревне " + id), false);
                            return 1;
                        })))
                
                // /millenaire reputation <player> <amount>
                .then(CommandManager.literal("reputation")
                    .requires(source -> source.hasPermissionLevel(2))
                    .then(CommandManager.argument("player", StringArgumentType.word())
                        .then(CommandManager.argument("amount", IntegerArgumentType.integer())
                            .executes(ctx -> {
                                String player = StringArgumentType.getString(ctx, "player");
                                int amount = IntegerArgumentType.getInteger(ctx, "amount");
                                ctx.getSource().sendFeedback(() -> 
                                    Text.literal("§aРепутация " + player + " изменена на " + amount), false);
                                return 1;
                            }))))
            );
        });
        
        Millenaire.LOGGER.info("[{}] Команды зарегистрированы", Millenaire.MOD_ID);
    }
}
