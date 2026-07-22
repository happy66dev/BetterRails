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

        // 铜质：目标5b/s，extraAccel=0.25喵~
        registerVanilla(Items.COPPER_POWERED_RAIL, new ItemStack(Material.COPPER_INGOT), 0.25D, 0.25D);
        // 铁质：目标8b/s，extraAccel=0.40喵~
        registerVanilla(Items.IRON_POWERED_RAIL, new ItemStack(Material.IRON_INGOT), 0.40D, 0.40D);
        // 金质：目标18b/s，extraAccel=0.90喵~
        registerVanilla(Items.GOLD_POWERED_RAIL, new ItemStack(Material.GOLD_INGOT), 0.90D, 0.90D);
        // 钻石：目标40b/s，extraAccel=2.00喵~
        registerVanilla(Items.DIAMOND_POWERED_RAIL, new ItemStack(Material.DIAMOND), 2.0D, 2.00D);
        // 下界合金：目标108b/s，extraAccel=5.40喵~
        registerVanilla(Items.NETHERITE_POWERED_RAIL, new ItemStack(Material.NETHERITE_INGOT), 5.4D, 5.40D);

        // 钢制：目标16b/s，extraAccel=0.80喵~
        registerSlimefun(Items.STEEL_POWERED_RAIL, SlimefunItems.STEEL_INGOT, 0.80D, 0.80D);
        // 大马士革钢：目标24b/s，extraAccel=1.20喵~
        registerSlimefun(Items.DAMASCUS_STEEL_POWERED_RAIL, SlimefunItems.DAMASCUS_STEEL_INGOT, 1.2D, 1.20D);
        // 硬化金属：目标48b/s，extraAccel=2.40喵~
        registerSlimefun(Items.HARDENED_METAL_POWERED_RAIL, SlimefunItems.HARDENED_METAL_INGOT, 2.4D, 2.40D);
        // 强化合金：目标60b/s，extraAccel=3.00喵~
        registerSlimefun(Items.REINFORCED_ALLOY_POWERED_RAIL, SlimefunItems.REINFORCED_ALLOY_INGOT, 3.0D, 3.00D);
        // 黑金刚石：目标100b/s，extraAccel=5.00喵~
        registerSlimefun(Items.CARBONADO_POWERED_RAIL, SlimefunItems.CARBONADO, 5.0D, 5.00D);
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
