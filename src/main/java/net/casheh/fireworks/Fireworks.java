package net.casheh.fireworks;

import net.casheh.fireworks.commands.FireworkCommand;
import net.casheh.fireworks.events.EggThrow;
import net.casheh.fireworks.events.FireworkFire;
import net.casheh.fireworks.events.TotemListener;
import net.casheh.fireworks.manager.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fireworks extends JavaPlugin {

    public static Fireworks instance;

    private Config config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);

        instance = this;

        config = new Config(this);

        getServer().getPluginManager().registerEvents(new FireworkFire(), this);
        getServer().getPluginManager().registerEvents(new TotemListener(), this);
        getServer().getPluginManager().registerEvents(new EggThrow(), this);
        getCommand("fireworks").setExecutor(new FireworkCommand());
    }

    public Config getCfg() {
        return this.config;
    }
}