package com.github.happy66dev.betterrails;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Placeable;

import javax.annotation.Nonnull;

public class BetterRail extends SlimefunItem implements Placeable {
    private final double maxSpeed;

    public BetterRail(@Nonnull ItemGroup itemGroup, @Nonnull SlimefunItemStack item, @Nonnull ItemStack[] recipe, int amount, double maxSpeed) {
        super(itemGroup, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, new SlimefunItemStack(item, amount));
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
}
