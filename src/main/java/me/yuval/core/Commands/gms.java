package me.yuval.core.Commands;

import me.yuval.core.Utils.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gms implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)) {
            if(args.length == 0) {
                System.out.println("You didn't choose a player.");
                return false;
            }
            if(args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target == null) {
                    System.out.println(target + " is offline.");
                    return false;
                }
                target.setGameMode(GameMode.SURVIVAL);
                target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "Your Game Mode has been changed to &c&lSURVIVAL by console."));
                return true;
            }
        }
        Player player = (Player) sender;
        if(args.length == 0) {
            String permName = "primecore.gm";
            Permissions perms = new Permissions();
            if(!perms.PermissionCheck(player, permName, command.getName())) {
                return false;
            }
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "Your Game Mode has been changed to &e&lSURVIVAL."));
            return true;
        }
        if(args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target == null) {
                System.out.println(target + " is offline.");
                return false;
            }
            target.setGameMode(GameMode.SURVIVAL);
            target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "Your Game Mode has been changed to &c&lSURVIVAL by console."));
            player.sendMessage("Successfully changed " + target.getName() + "'s game mode to SURVIVAL.");
        }

        return true;
    }
}
