package me.yuval.core.Commands;

import me.yuval.core.Utils.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class God implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(command.getName().equalsIgnoreCase("god")) {
            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                    System.out.println("You didn't choose a player.");
                }
                if (args.length == 1) {
                    Player player = Bukkit.getPlayerExact(args[0]);
                    if (player == null) {
                        System.out.println(ChatColor.GOLD + args[0] + ChatColor.RESET + " is offline.");
                        return true;
                    }
                    if (player.isInvulnerable()) {
                        player.setInvulnerable(false);
                        player.sendMessage("God mode has been toggled " + ChatColor.RED + ChatColor.BOLD + "off" + ChatColor.RESET + " by Console.");
                    } else {
                        player.setInvulnerable(true);
                        player.sendMessage("God mode has been toggled " + ChatColor.GOLD + ChatColor.BOLD + "on" + ChatColor.RESET + " by Console.");
                    }
                    return true;
                }
            }
            Player player = (Player) sender;
            String permName = "primecore.god";
            Permissions perms = new Permissions();
            if(!perms.PermissionCheck(player, permName, command.getName())) {
                return true;
            }
                if (args.length == 0) {
                    if (player.isInvulnerable()) {
                        player.setInvulnerable(false);
                        player.sendMessage("God mode has been toggled " + ChatColor.RED + ChatColor.BOLD + "off.");
                    } else {
                        player.setInvulnerable(true);
                        player.sendMessage("God mode has been toggled " + ChatColor.GOLD + ChatColor.BOLD + "on.");
                    }
                    return true;
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.GOLD + args[0] + ChatColor.RESET + " is offline.");
                        return true;
                    }
                    if (target.isInvulnerable()) {
                        target.setInvulnerable(false);
                        target.sendMessage("God mode has been toggled " + ChatColor.RED + ChatColor.BOLD + "off" +
                                ChatColor.RESET + " by " + ChatColor.BLUE + player.getName());
                        player.sendMessage("Successfully toggled God mode " + ChatColor.RED + ChatColor.BOLD + "off" +
                                ChatColor.RESET + " for " + ChatColor.BLUE + target.getName());
                    } else {
                        target.setInvulnerable(true);
                        target.sendMessage("God mode has been toggled " + ChatColor.GOLD + ChatColor.BOLD + "on" +
                                ChatColor.RESET + " by " + ChatColor.BLUE + player.getName());
                        player.sendMessage("Successfully toggled God mode " + ChatColor.RED + ChatColor.BOLD + "on" +
                                ChatColor.RESET + " for " + ChatColor.BLUE + target.getName());
                    }
                }
        }
        return true;

    }
}

