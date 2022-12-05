package me.yuval.core.Utils;

import me.yuval.core.Core;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Permissions {
    public Permissions() {

    }
    public boolean PermissionCheck(Player player, String permName, String commandName) {

        if(!player.hasPermission(permName)) {
            sendNoPermMessage(player, permName);
            System.out.println(player.getName() + " tried to use " + commandName.toUpperCase() + " but didn't have the permission " + permName);
            return false;
        }
        return true;
    }

    public void sendNoPermMessage(Player player, String permName) {
        String firstMsg = Core.getPlugin().getConfig().getString("no-perms-message");
        String secondMsg = Core.getPlugin().getConfig().getString("no-perms-next-message");
        if(firstMsg != null) firstMsg = replacePlaceHolders(firstMsg, player, permName);
        if(secondMsg != null) secondMsg = replacePlaceHolders(secondMsg, player, permName);
        if(firstMsg != null) player.sendMessage(ChatColor.translateAlternateColorCodes('&', firstMsg));
        if(secondMsg != null) player.sendMessage(ChatColor.translateAlternateColorCodes('&', secondMsg));
    }

    public String replacePlaceHolders(String message, Player player, String permName) {
        if(message.contains("%player%")) {
            message = message.replace("%player%", player.getName());
        }
        if(message.contains("%permission%")) {
            message = message.replace("%permission%", permName);
        }
        return message;
    }

}
