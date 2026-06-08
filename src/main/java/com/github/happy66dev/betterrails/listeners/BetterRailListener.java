package com.github.happy66dev.betterrails.listeners;

import com.github.happy66dev.betterrails.BetterRail;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

import javax.annotation.Nonnull;

public class BetterRailListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    private void onRailUse(@Nonnull VehicleMoveEvent e) {
        if (e.getVehicle() instanceof Minecart cart) {
            Block b = cart.getLocation().getBlock();
            if (b.getType() == Material.POWERED_RAIL) {
                if (StorageCacheUtils.getSfItem(b.getLocation()) instanceof BetterRail rail) {
                    cart.setMaxSpeed(rail.getMaxSpeed());
                } else {
                    cart.setMaxSpeed(.4D);
                }
            }
        }
    }
}
