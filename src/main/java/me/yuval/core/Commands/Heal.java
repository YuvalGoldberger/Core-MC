package me.yuval.core.Commands;

import me.yuval.core.Utils.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("heal")) {
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
                target.setHealth(20);
                System.out.println("Successfully healed " + target.getName());
                target.sendMessage("Console has decided to heal you.");
                return true;
            }
        }
        Player player = (Player) sender;
            String permName = "primecore.heal";
            Permissions perms = new Permissions();
            if(!perms.PermissionCheck(player, permName, command.getName())) {
                return false;
            }
        if (args.length == 0) {
            player.setHealth(20);
            player.sendMessage("Healed yourself.");
            return true;
        }
        if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                player.sendMessage(args[0] + " is offline.");
                return false;
            }
            target.setHealth(20);
            player.sendMessage("Succsessfully healed " + target.getName());
            target.sendMessage(player.getName() + " has decided to heal you.");
        }

    }

        return true;
    }
}
