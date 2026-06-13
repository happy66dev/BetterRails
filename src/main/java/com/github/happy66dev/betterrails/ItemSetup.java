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

        registerVanilla(Items.COPPER_POWERED_RAIL, new ItemStack(Material.COPPER_INGOT), 0.8D);
        registerVanilla(Items.IRON_POWERED_RAIL, new ItemStack(Material.IRON_INGOT), 1.2D);
        registerVanilla(Items.GOLD_POWERED_RAIL, new ItemStack(Material.GOLD_INGOT), 1.6D);
        registerVanilla(Items.DIAMOND_POWERED_RAIL, new ItemStack(Material.DIAMOND), 2.0D);
        registerVanilla(Items.NETHERITE_POWERED_RAIL, new ItemStack(Material.NETHERITE_INGOT), 2.4D);

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
