package com.github.happy66dev.betterrails.listeners;

import com.github.happy66dev.betterrails.BetterRail;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class BetterRailListener implements Listener {
    private static final double BASE_MAX_SPEED = 0.4D;
    private static final double BASE_ACCELERATION = 0.1D;

    @EventHandler(ignoreCancelled = true)
    private void onRailUse(@Nonnull VehicleMoveEvent e) {
        if (e.getVehicle() instanceof Minecart cart) {
            Block b = cart.getLocation().getBlock();

            if (b.getType() == Material.POWERED_RAIL) {
                if (StorageCacheUtils.getSfItem(b.getLocation()) instanceof BetterRail rail) {
                    boolean powered = b.getBlockPower() > 0 || b.isBlockIndirectlyPowered();

                    if (powered) {
                        cart.setMaxSpeed(rail.getMaxSpeed());

                        double tier = rail.getMaxSpeed() / BASE_MAX_SPEED;
                        Vector velocity = cart.getVelocity();

                        if (velocity.lengthSquared() > 0.0001D) {
                            Vector direction = velocity.normalize();
                            double extraAccel = (tier - 1.0D) * BASE_ACCELERATION;
                            Vector boosted = velocity.add(direction.multiply(extraAccel));

                            if (boosted.length() > rail.getMaxSpeed()) {
                                boosted = boosted.normalize().multiply(rail.getMaxSpeed());
                            }

                            cart.setVelocity(boosted);
                        }
                    } else {
                        double currentSpeed = cart.getVelocity().length();
                        cart.setMaxSpeed(Math.max(currentSpeed, BASE_MAX_SPEED));
                    }
                } else {
                    cart.setMaxSpeed(BASE_MAX_SPEED);
                }
            }
        }
    }
}
