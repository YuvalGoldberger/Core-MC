package me.yuval.core;

import me.yuval.core.Commands.*;
import me.yuval.core.Events.OnPlayerJoinEvent;
import me.yuval.core.Events.PlayerInteractEvent;
import me.yuval.core.Utils.Permissions;
import org.bukkit.plugin.java.JavaPlugin;


public final class Core extends JavaPlugin {

    private static Core instance;
    private Permissions perms;
    @Override
    public void onEnable() {
        instance = this;
        perms = new Permissions();
        System.out.println(this.getName() + " has been enabled.");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new OnPlayerJoinEvent(), instance);
        getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), instance);
        getCommand("god").setExecutor(new God());
        getCommand("feed").setExecutor(new Feed());
        getCommand("heal").setExecutor(new Heal());
        getCommand("enderchest").setExecutor(new EnderChest());
        getCommand("gmc").setExecutor(new gmc());
        getCommand("gms").setExecutor(new gms());
        getCommand("nick").setExecutor(new Nick());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Core getPlugin() {
        return instance;
    }

    public Permissions getPerms() { return perms; }
}
