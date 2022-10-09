package me.yuval.core.Commands;

import me.yuval.core.Utils.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)) {
            System.out.println("You're not a player.");
            return false;
        }
        Player player = (Player) sender;
        String permName = "PRIMECORE.ENDER";
        Permissions perms = new Permissions();
        if(!perms.PermissionCheck(player, permName, command.getName())) {
            return false;
        }
        if(args.length == 0) {
            player.openInventory(player.getEnderChest());
            return true;
        }
        if(args.length == 1) {
            String permNameOthers = "PRIMECORE.ENDER";
            if(!perms.PermissionCheck(player, permNameOthers, command.getName())) {
                return false;
            }
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target == null) {
                player.sendMessage("You can't open an offline player's enderchest.");
                return true;
            }
            player.openInventory(target.getEnderChest());
        }

        return true;
    }
}
