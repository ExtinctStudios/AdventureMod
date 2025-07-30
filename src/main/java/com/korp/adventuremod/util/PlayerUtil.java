package com.korp.adventuremod.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class PlayerUtil {
    public static Vec3d getViewDirection(PlayerEntity player) {
        float yaw = player.getYaw();
        float pitch = player.getPitch();

        double yawRad = Math.toRadians(-yaw);
        double pitchRad = Math.toRadians(-pitch);

        double x = Math.cos(pitchRad) * Math.sin(yawRad);
        double y = Math.sin(pitchRad);
        double z = Math.cos(pitchRad) * Math.cos(yawRad);

        return new Vec3d(x, y, z).normalize();
    }
}
