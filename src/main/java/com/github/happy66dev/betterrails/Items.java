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

    public static final SlimefunItemStack COPPER_POWERED_RAIL = poweredRail("COPPER_POWERED_RAIL", "&6铜质动力铁轨", 2);
    public static final SlimefunItemStack IRON_POWERED_RAIL = poweredRail("IRON_POWERED_RAIL", "&f铁质动力铁轨", 3);
    public static final SlimefunItemStack GOLD_POWERED_RAIL = poweredRail("GOLD_POWERED_RAIL", "&e金质动力铁轨", 4);
    public static final SlimefunItemStack DIAMOND_POWERED_RAIL = poweredRail("DIAMOND_POWERED_RAIL", "&b钻石动力铁轨", 5);
    public static final SlimefunItemStack NETHERITE_POWERED_RAIL = poweredRail("NETHERITE_POWERED_RAIL", "&8下界合金动力铁轨", 6);
    public static final SlimefunItemStack STEEL_POWERED_RAIL = poweredRail("STEEL_POWERED_RAIL", "&7钢制动力铁轨", 2);
    public static final SlimefunItemStack DAMASCUS_STEEL_POWERED_RAIL = poweredRail("DAMASCUS_STEEL_POWERED_RAIL", "&7大马士革钢动力铁轨", 3);
    public static final SlimefunItemStack HARDENED_METAL_POWERED_RAIL = poweredRail("HARDENED_METAL_POWERED_RAIL", "&8硬化金属动力铁轨", 4);
    public static final SlimefunItemStack REINFORCED_ALLOY_POWERED_RAIL = poweredRail("REINFORCED_ALLOY_POWERED_RAIL", "&9强化合金动力铁轨", 5);
    public static final SlimefunItemStack CARBONADO_POWERED_RAIL = poweredRail("CARBONADO_POWERED_RAIL", "&8黑金动力铁轨", 6);

    private Items() {}

    private static SlimefunItemStack poweredRail(String id, String name, int speed) {
        return new SlimefunItemStack(
                id,
                Material.POWERED_RAIL,
                name,
                "",
                "&7支持 " + speed + "x 速度"
        );
    }
}
