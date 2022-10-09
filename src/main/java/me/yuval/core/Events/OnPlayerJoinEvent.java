package me.yuval.core.Events;

import me.yuval.core.Core;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import static me.yuval.core.Core.getPlugin;

public class OnPlayerJoinEvent implements Listener {

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Plugin plugin = Core.getPlugin();
        String welcomeMsg = plugin.getConfig().getString("join-message");
        if(welcomeMsg.contains("%player%")) {
            welcomeMsg = welcomeMsg.replace("%player%", player.getName());
        }

        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', welcomeMsg));
        player.sendTitle("Welcome to our server!", "Hope you will enjoy here.");


    }
}
