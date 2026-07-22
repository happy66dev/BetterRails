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

        // 铜质动力铁轨：0.5倍速，maxSpeed = 0.5 * 0.4 = 0.2 喵~
        registerVanilla(Items.COPPER_POWERED_RAIL, new ItemStack(Material.COPPER_INGOT), 0.2D);
        // 铁质动力铁轨：0.8倍速，maxSpeed = 0.8 * 0.4 = 0.32 喵~
        registerVanilla(Items.IRON_POWERED_RAIL, new ItemStack(Material.IRON_INGOT), 0.32D);
        // 金质动力铁轨：1.1倍速，maxSpeed = 1.1 * 0.4 = 0.44 喵~
        registerVanilla(Items.GOLD_POWERED_RAIL, new ItemStack(Material.GOLD_INGOT), 0.44D);
        // 钻石动力铁轨：3倍速，maxSpeed = 3 * 0.4 = 1.2 喵~
        registerVanilla(Items.DIAMOND_POWERED_RAIL, new ItemStack(Material.DIAMOND), 1.2D);
        // 下界合金动力铁轨：10倍速，maxSpeed = 10 * 0.4 = 4.0 喵~
        registerVanilla(Items.NETHERITE_POWERED_RAIL, new ItemStack(Material.NETHERITE_INGOT), 4.0D);

        // 钢制动力铁轨：1.25倍速，maxSpeed = 1.25 * 0.4 = 0.5 喵~
        registerSlimefun(Items.STEEL_POWERED_RAIL, SlimefunItems.STEEL_INGOT, 0.5D);
        // 大马士革钢动力铁轨：2倍速，maxSpeed = 2 * 0.4 = 0.8 喵~
        registerSlimefun(Items.DAMASCUS_STEEL_POWERED_RAIL, SlimefunItems.DAMASCUS_STEEL_INGOT, 0.8D);
        // 硬化金属动力铁轨：4倍速，maxSpeed = 4 * 0.4 = 1.6 喵~
        registerSlimefun(Items.HARDENED_METAL_POWERED_RAIL, SlimefunItems.HARDENED_METAL_INGOT, 1.6D);
        // 强化合金动力铁轨：6倍速，maxSpeed = 6 * 0.4 = 2.4 喵~
        registerSlimefun(Items.REINFORCED_ALLOY_POWERED_RAIL, SlimefunItems.REINFORCED_ALLOY_INGOT, 2.4D);
        // 黑金动力铁轨：10倍速，maxSpeed = 10 * 0.4 = 4.0 喵~
        registerSlimefun(Items.CARBONADO_POWERED_RAIL, SlimefunItems.CARBONADO, 4.0D);
    }

    private void registerVanilla(SlimefunItemStack item, ItemStack material, double maxSpeed) {
        new BetterRail(Items.VANILLA_ITEM_GROUP, item, new ItemStack[] {
                material, material, material,
                material, new ItemStack(Material.POWERED_RAIL), material,
                material, material, material
        }, 4, maxSpeed).register(BetterRails.getInstance());
    }

    private void registerSlimefun(SlimefunItemStack item, ItemStack material, double maxSpeed) {
        new BetterRail(Items.SLIMEFUN_ITEM_GROUP, item, new ItemStack[] {
                material, SlimefunItems.COPPER_WIRE, material,
                material, SlimefunItems.ELECTRO_MAGNET, material,
                material, SlimefunItems.COPPER_WIRE, material
        }, 4, maxSpeed).register(BetterRails.getInstance());
    }
}
