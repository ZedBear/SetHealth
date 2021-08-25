package me.ZedBear.SetHealth;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.getCommand("sethealth").setExecutor(new Commands());

    }

    public void onDisable() {

    }
}
