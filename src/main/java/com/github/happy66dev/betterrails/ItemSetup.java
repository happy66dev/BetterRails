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

        // 铜质：0.5x，目标4b/s，extraAccel=0.20喵~
        registerVanilla(Items.COPPER_POWERED_RAIL, new ItemStack(Material.COPPER_INGOT), 0.2D, 0.20D);
        // 铁质：0.8x，目标6.4b/s，extraAccel=0.32喵~
        registerVanilla(Items.IRON_POWERED_RAIL, new ItemStack(Material.IRON_INGOT), 0.32D, 0.32D);
        // 金质：1.1x，目标8.8b/s，extraAccel=0.44喵~
        registerVanilla(Items.GOLD_POWERED_RAIL, new ItemStack(Material.GOLD_INGOT), 0.44D, 0.44D);
        // 钻石：3x，目标24b/s，extraAccel=1.20喵~
        registerVanilla(Items.DIAMOND_POWERED_RAIL, new ItemStack(Material.DIAMOND), 1.2D, 1.20D);
        // 下界合金：10x，目标80b/s，extraAccel=4.00喵~
        registerVanilla(Items.NETHERITE_POWERED_RAIL, new ItemStack(Material.NETHERITE_INGOT), 4.0D, 4.00D);

        // 钢制：1.25x，目标10b/s，extraAccel=0.50喵~
        registerSlimefun(Items.STEEL_POWERED_RAIL, SlimefunItems.STEEL_INGOT, 0.5D, 0.50D);
        // 大马士革钢：2x，目标16b/s，extraAccel=0.80喵~
        registerSlimefun(Items.DAMASCUS_STEEL_POWERED_RAIL, SlimefunItems.DAMASCUS_STEEL_INGOT, 0.8D, 0.80D);
        // 硬化金属：4x，目标32b/s，extraAccel=1.60喵~
        registerSlimefun(Items.HARDENED_METAL_POWERED_RAIL, SlimefunItems.HARDENED_METAL_INGOT, 1.6D, 1.60D);
        // 强化合金：6x，目标48b/s，extraAccel=2.40喵~
        registerSlimefun(Items.REINFORCED_ALLOY_POWERED_RAIL, SlimefunItems.REINFORCED_ALLOY_INGOT, 2.4D, 2.40D);
        // 黑金刚石：10x，目标80b/s，extraAccel=4.00喵~
        registerSlimefun(Items.CARBONADO_POWERED_RAIL, SlimefunItems.CARBONADO, 4.0D, 4.00D);
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
