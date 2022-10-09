package me.yuval.core.Commands;

import me.yuval.core.Utils.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(command.getName().equalsIgnoreCase("feed")) {
            if (!(sender instanceof Player)) {
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
                    target.setSaturation(20);
                    System.out.println("Succsessfully fed " + target.getName());
                    target.sendMessage("Console has decided to feed you.");
                    return true;
                }
            }
            Player player = (Player) sender;
            String permName = "PRIMECORE.FEED";
            Permissions perms = new Permissions();
            if(!perms.PermissionCheck(player, permName, command.getName())) {
                return false;
            }
            if (args.length == 0) {
                player.setSaturation(20);
                player.sendMessage("You're too lazy to eat.");
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    player.sendMessage(args[0] + " is offline.");
                    return false;
                }
                target.setSaturation(20);
                player.sendMessage("Succsessfully fed " + target.getName());
                target.sendMessage(player.getName() + " has decided to feed you.");
            }
        }
        return true;
    }
}
