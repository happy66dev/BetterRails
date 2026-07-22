package com.github.happy66dev.betterrails;

import org.bukkit.NamespacedKey;

import io.github.thebusybiscuit.slimefun4.api.researches.Research;

final class ResearchSetup {
    static final ResearchSetup INSTANCE = new ResearchSetup();
    private boolean initialised;

    private ResearchSetup() {}

    public void init() {
        if (initialised) return;

        initialised = true;

        new Research(new NamespacedKey(BetterRails.getInstance(), "vanilla_powered_rails"),
                6680001, "原版动力升级", 10)
                .addItems(Items.COPPER_POWERED_RAIL, Items.IRON_POWERED_RAIL, Items.GOLD_POWERED_RAIL, Items.DIAMOND_POWERED_RAIL)
                .register();

        new Research(new NamespacedKey(BetterRails.getInstance(), "slimefun_powered_rails"),
                6680002, "合金动力升级", 20)
                .addItems(Items.STEEL_POWERED_RAIL, Items.DAMASCUS_STEEL_POWERED_RAIL, Items.HARDENED_METAL_POWERED_RAIL, Items.REINFORCED_ALLOY_POWERED_RAIL)
                .register();
    }
}
