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

    @EventHandler(ignoreCancelled = true)
    private void onRailUse(@Nonnull VehicleMoveEvent e) {
        if (e.getVehicle() instanceof Minecart cart) {
            Block b = cart.getLocation().getBlock();

            if (b.getType() == Material.POWERED_RAIL) {
                if (StorageCacheUtils.getSfItem(b.getLocation()) instanceof BetterRail rail) {
                    boolean powered = b.getBlockPower() > 0 || b.isBlockIndirectlyPowered();

                    if (powered) {
                        // 设置矿车最大速度上限喵~
                        cart.setMaxSpeed(rail.getMaxSpeed());

                        Vector velocity = cart.getVelocity();

                        if (velocity.lengthSquared() > 0.0001D) {
                            // 获取方向并施加铁轨定义的额外加速度喵~
                            Vector direction = velocity.clone().normalize();
                            Vector boosted = velocity.add(direction.multiply(rail.getExtraAccel()));

                            // 钳位到maxSpeed喵~
                            if (boosted.length() > rail.getMaxSpeed()) {
                                boosted = boosted.normalize().multiply(rail.getMaxSpeed());
                            }

                            cart.setVelocity(boosted);
                        }
                    } else {
                        // 无红石：平滑减速喵~
                        double currentSpeed = cart.getVelocity().length();
                        cart.setMaxSpeed(Math.max(currentSpeed, BASE_MAX_SPEED));
                    }
                } else {
                    // 普通动力铁轨：恢复原版速度上限喵~
                    cart.setMaxSpeed(BASE_MAX_SPEED);
                }
            }
        }
    }
}
