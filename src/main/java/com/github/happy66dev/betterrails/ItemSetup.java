package com.github.happy66dev.betterrails;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;

final class ItemSetup {
    static final ItemSetup INSTANCE = new ItemSetup();
    private boolean initialised;

    private ItemSetup() {}

    public void init() {
        if (initialised) return;

        initialised = true;

        // 铜质：目标4b/s，extraAccel=0.20喵~
        registerVanilla(Items.COPPER_POWERED_RAIL, new ItemStack(Material.COPPER_INGOT), 0.20D, 0.20D);
        // 铁质：目标6b/s，extraAccel=0.30喵~
        registerVanilla(Items.IRON_POWERED_RAIL, new ItemStack(Material.IRON_INGOT), 0.30D, 0.30D);
        // 金质：目标12b/s，extraAccel=0.60喵~
        registerVanilla(Items.GOLD_POWERED_RAIL, new ItemStack(Material.GOLD_INGOT), 0.60D, 0.60D);
        // 钻石：目标30b/s，extraAccel=1.50喵~
        registerVanilla(Items.DIAMOND_POWERED_RAIL, new ItemStack(Material.DIAMOND), 1.5D, 1.50D);

        // 钢制：目标10b/s，extraAccel=0.50喵~
        registerSlimefun(Items.STEEL_POWERED_RAIL, SlimefunItems.STEEL_INGOT, 0.50D, 0.50D);
        // 大马士革钢：目标14b/s，extraAccel=0.70喵~
        registerSlimefun(Items.DAMASCUS_STEEL_POWERED_RAIL, SlimefunItems.DAMASCUS_STEEL_INGOT, 0.70D, 0.70D);
        // 硬化金属：目标24b/s，extraAccel=1.20喵~
        registerSlimefun(Items.HARDENED_METAL_POWERED_RAIL, SlimefunItems.HARDENED_METAL_INGOT, 1.2D, 1.20D);
        // 强化合金：目标30b/s，extraAccel=1.50喵~
        registerSlimefun(Items.REINFORCED_ALLOY_POWERED_RAIL, SlimefunItems.REINFORCED_ALLOY_INGOT, 1.5D, 1.50D);
    }

    private void registerVanilla(SlimefunItemStack item, ItemStack material, double maxSpeed, double extraAccel) {
        new BetterRail(Items.VANILLA_ITEM_GROUP, item, new ItemStack[] {
                material, material, material,
                material, new ItemStack(Material.POWERED_RAIL), material,
                material, material, material
        }, 4, maxSpeed, extraAccel).register(BetterRails.getInstance());
    }

    private void registerSlimefun(SlimefunItemStack item, ItemStack material, double maxSpeed, double extraAccel) {
        new BetterRail(Items.SLIMEFUN_ITEM_GROUP, item, new ItemStack[] {
                material, SlimefunItems.COPPER_WIRE, material,
                material, SlimefunItems.ELECTRO_MAGNET, material,
                material, SlimefunItems.COPPER_WIRE, material
        }, 4, maxSpeed, extraAccel).register(BetterRails.getInstance());
    }
}
