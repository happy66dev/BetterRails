package com.github.happy66dev.betterrails;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Placeable;

import javax.annotation.Nonnull;

public class BetterRail extends SlimefunItem implements Placeable {
    // 矿车在此铁轨上的最大速度（blocks/tick）喵~
    private final double maxSpeed;
    // 每tick施加的额外加速度（blocks/tick²）喵~
    private final double extraAccel;

    public BetterRail(@Nonnull ItemGroup itemGroup, @Nonnull SlimefunItemStack item, @Nonnull ItemStack[] recipe, int amount, double maxSpeed, double extraAccel) {
        super(itemGroup, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, new SlimefunItemStack(item, amount));
        this.maxSpeed = maxSpeed;
        this.extraAccel = extraAccel;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    // 获取额外加速度喵~
    public double getExtraAccel() {
        return extraAccel;
    }
}
