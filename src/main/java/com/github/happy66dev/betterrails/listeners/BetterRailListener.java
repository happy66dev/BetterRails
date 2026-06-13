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
import java.util.Set;

public class BetterRailListener implements Listener {
    private static final double BASE_MAX_SPEED = 0.4D;
    private static final double BASE_ACCELERATION = 0.1D;
    private static final Set<Material> PASSIVE_RAILS = Set.of(
            Material.RAIL, Material.ACTIVATOR_RAIL, Material.DETECTOR_RAIL
    );

    @EventHandler(ignoreCancelled = true)
    private void onRailUse(@Nonnull VehicleMoveEvent e) {
        if (e.getVehicle() instanceof Minecart cart) {
            Block b = cart.getLocation().getBlock();
            Material type = b.getType();

            if (type == Material.POWERED_RAIL) {
                boolean powered = b.getBlockPower() > 0 || b.isBlockIndirectlyPowered();

                if (StorageCacheUtils.getSfItem(b.getLocation()) instanceof BetterRail rail) {
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
                } else if (powered) {
                    double currentSpeed = cart.getVelocity().length();
                    if (currentSpeed > BASE_MAX_SPEED) {
                        cart.setMaxSpeed(currentSpeed);
                    } else {
                        cart.setMaxSpeed(BASE_MAX_SPEED);
                    }
                } else {
                    cart.setMaxSpeed(BASE_MAX_SPEED);
                }
            } else if (PASSIVE_RAILS.contains(type)) {
                double currentSpeed = cart.getVelocity().length();
                cart.setMaxSpeed(Math.max(currentSpeed, BASE_MAX_SPEED));
            }
        }
    }
}
