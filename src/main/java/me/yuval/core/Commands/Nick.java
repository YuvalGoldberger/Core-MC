package me.yuval.core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Nick implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)) {
            if (args.length == 0) {
                System.out.println("You didn't choose a player!");
                return false;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    System.out.println(args[0] + " is offline.");
                    return false;
                }
            }
        }

        Player player = (Player) sender;
        if(args.length == 0 ) {
            player.sendMessage("No player / nickname has been selected.");
            return true;
        }
        else if(args.length == 1) {
            String nick = args[0];
            player.setDisplayName(ChatColor.translateAlternateColorCodes('&', nick));
            player.sendMessage("Your nickname has been set to " + nick);
            return true;
        }
         else if (args.length == 2) {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                player.sendMessage(args[0] + " is offline.");
                return false;
            } else {
                String nick = args[1];
                target.setDisplayName(ChatColor.translateAlternateColorCodes('&', nick));
            }
        }


        return true;
    }
}
