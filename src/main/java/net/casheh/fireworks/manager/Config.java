package net.casheh.fireworks.manager;

import net.casheh.fireworks.Fireworks;

public class Config {

    private Fireworks plugin;

    private boolean useOptionOne;

    public Config(Fireworks plugin) {
        this.plugin = plugin;
    }

    public void assign() {
        plugin.reloadConfig();
        this.useOptionOne = plugin.getConfig().getBoolean("use-option-one");
    }

    public boolean getUseOptionOne() {
        return this.useOptionOne;
    }

}