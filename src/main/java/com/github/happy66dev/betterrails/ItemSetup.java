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

        // 铜质动力铁轨：0.75倍速，maxSpeed = 0.75 * 0.4 = 0.3 喵~
        registerVanilla(Items.COPPER_POWERED_RAIL, new ItemStack(Material.COPPER_INGOT), 0.3D);
        // 铁质动力铁轨：1倍速，maxSpeed = 1.0 * 0.4 = 0.4，与原版相同喵~
        registerVanilla(Items.IRON_POWERED_RAIL, new ItemStack(Material.IRON_INGOT), 0.4D);
        // 金质动力铁轨：1.25倍速，maxSpeed = 1.25 * 0.4 = 0.5 喵~
        registerVanilla(Items.GOLD_POWERED_RAIL, new ItemStack(Material.GOLD_INGOT), 0.5D);
        // 钻石动力铁轨：4倍速，maxSpeed = 4 * 0.4 = 1.6 喵~
        registerVanilla(Items.DIAMOND_POWERED_RAIL, new ItemStack(Material.DIAMOND), 1.6D);
        // 下界合金动力铁轨：15倍速，maxSpeed = 15 * 0.4 = 6.0 喵~
        registerVanilla(Items.NETHERITE_POWERED_RAIL, new ItemStack(Material.NETHERITE_INGOT), 6.0D);

        registerSlimefun(Items.STEEL_POWERED_RAIL, SlimefunItems.STEEL_INGOT, 0.8D);
        registerSlimefun(Items.DAMASCUS_STEEL_POWERED_RAIL, SlimefunItems.DAMASCUS_STEEL_INGOT, 1.2D);
        registerSlimefun(Items.HARDENED_METAL_POWERED_RAIL, SlimefunItems.HARDENED_METAL_INGOT, 1.6D);
        registerSlimefun(Items.REINFORCED_ALLOY_POWERED_RAIL, SlimefunItems.REINFORCED_ALLOY_INGOT, 2.0D);
        registerSlimefun(Items.CARBONADO_POWERED_RAIL, SlimefunItems.CARBONADO, 2.4D);
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
