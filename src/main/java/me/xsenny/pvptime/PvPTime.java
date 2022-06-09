package me.xsenny.pvptime;

import me.xsenny.pvptime.command.reload;
import me.xsenny.pvptime.listeners.PvpListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PvPTime extends JavaPlugin {

    public static PvPTime plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new PvpListener(), this);
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        getCommand("pvptime").setExecutor(new reload());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
