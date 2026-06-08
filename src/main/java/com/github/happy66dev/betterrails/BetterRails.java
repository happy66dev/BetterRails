package com.github.happy66dev.betterrails;

import com.github.happy66dev.betterrails.listeners.BetterRailListener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

import javax.annotation.Nonnull;

public class BetterRails extends JavaPlugin implements SlimefunAddon {
    private static BetterRails instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new BetterRailListener(), this);
        ItemSetup.INSTANCE.init();
        ResearchSetup.INSTANCE.init();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    @Nonnull
    public static BetterRails getInstance() {
        return instance;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/happy66dev/BetterRails/issues";
    }
}
