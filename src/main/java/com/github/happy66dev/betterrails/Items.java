package com.github.happy66dev.betterrails;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public final class Items {
    public static final NestedItemGroup MAIN_ITEM_GROUP = new NestedItemGroup(
            new NamespacedKey(BetterRails.getInstance(), "better_rails"),
            new CustomItemStack(Material.MINECART, "&b更好的铁轨")
    );

    public static final SubItemGroup VANILLA_ITEM_GROUP = new SubItemGroup(
            new NamespacedKey(BetterRails.getInstance(), "vanilla"),
            MAIN_ITEM_GROUP,
            new CustomItemStack(Material.POWERED_RAIL, "&a更好的铁轨（原版）")
    );

    public static final SubItemGroup SLIMEFUN_ITEM_GROUP = new SubItemGroup(
            new NamespacedKey(BetterRails.getInstance(), "slimefun"),
            MAIN_ITEM_GROUP,
            new CustomItemStack(Material.POWERED_RAIL, "&b更好的铁轨（合金）")
    );

    // 铜质：目标4b/s喵~
    public static final SlimefunItemStack COPPER_POWERED_RAIL = poweredRail("COPPER_POWERED_RAIL", "&6铜质动力铁轨", "4");
    // 铁质：目标6b/s喵~
    public static final SlimefunItemStack IRON_POWERED_RAIL = poweredRail("IRON_POWERED_RAIL", "&f铁质动力铁轨", "6");
    // 金质：目标12b/s喵~
    public static final SlimefunItemStack GOLD_POWERED_RAIL = poweredRail("GOLD_POWERED_RAIL", "&e金质动力铁轨", "12");
    // 钻石：目标30b/s，超过20b/s有警告喵~
    public static final SlimefunItemStack DIAMOND_POWERED_RAIL = poweredRailWithWarning("DIAMOND_POWERED_RAIL", "&b钻石动力铁轨", "30");
    // 钢制：目标10b/s喵~
    public static final SlimefunItemStack STEEL_POWERED_RAIL = poweredRail("STEEL_POWERED_RAIL", "&7钢制动力铁轨", "10");
    // 大马士革钢：目标14b/s喵~
    public static final SlimefunItemStack DAMASCUS_STEEL_POWERED_RAIL = poweredRail("DAMASCUS_STEEL_POWERED_RAIL", "&7大马士革钢动力铁轨", "14");
    // 硬化金属：目标24b/s，超过20b/s有警告喵~
    public static final SlimefunItemStack HARDENED_METAL_POWERED_RAIL = poweredRailWithWarning("HARDENED_METAL_POWERED_RAIL", "&8硬化金属动力铁轨", "24");
    // 强化合金：目标30b/s，超过20b/s有警告喵~
    public static final SlimefunItemStack REINFORCED_ALLOY_POWERED_RAIL = poweredRailWithWarning("REINFORCED_ALLOY_POWERED_RAIL", "&9强化合金动力铁轨", "30");

    private Items() {}

    // 生成动力铁轨物品，speed为显示用的速度文本(b/s)喵~
    private static SlimefunItemStack poweredRail(String id, String name, String speed) {
        return new SlimefunItemStack(
                id,
                Material.POWERED_RAIL,
                name,
                "",
                "&7目标速度 " + speed + " b/s"
        );
    }

    // 生成带警告的高速动力铁轨物品喵~
    private static SlimefunItemStack poweredRailWithWarning(String id, String name, String speed) {
        return new SlimefunItemStack(
                id,
                Material.POWERED_RAIL,
                name,
                "",
                "&7目标速度 " + speed + " b/s",
                "",
                "&c拐弯处会脱轨",
                "&c上坡时可能导致穿模"
        );
    }
}
