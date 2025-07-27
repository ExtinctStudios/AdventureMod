package com.korp.adventuremod.mixin;

import com.korp.adventuremod.registries.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BoatEntity.class)
public class BoatEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    void tick(CallbackInfo ci){
        BoatEntity boatEntity = (BoatEntity)(Object)this;

        // check if in water

        final double PIRATE_HELMET_BOAT_SPEED = 12.0;
        final double PIRATE_HELMET_BOAT_ACCELERATION_MULTIPLIER = 1.05;
        final double CURSED_PIRATE_HELMET_BOAT_SPEED = 18.0;
        final double CURSED_PIRATE_HELMET_BOAT_ACCELERATION_MULTIPLIER = 1.08;

        if(boatEntity.getControllingPassenger() instanceof PlayerEntity playerEntity){
            if(playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.PIRATE_HELMET) {// Set to pirate hat
                if(boatEntity.getVelocity().length() <= PIRATE_HELMET_BOAT_SPEED){
                    Vec3d velocity = boatEntity.getVelocity().multiply(PIRATE_HELMET_BOAT_ACCELERATION_MULTIPLIER);
                    if(velocity.length() > PIRATE_HELMET_BOAT_SPEED){
                        velocity = velocity.normalize().multiply(PIRATE_HELMET_BOAT_SPEED);
                    }
                    boatEntity.setVelocity(velocity);
                }
            } else if(playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.CURSED_PIRATE_HELMET) {// Set to pirate hat
                if(boatEntity.getVelocity().length() <= CURSED_PIRATE_HELMET_BOAT_SPEED){
                    Vec3d velocity = boatEntity.getVelocity().multiply(CURSED_PIRATE_HELMET_BOAT_ACCELERATION_MULTIPLIER);
                    if(velocity.length() > CURSED_PIRATE_HELMET_BOAT_SPEED){
                        velocity = velocity.normalize().multiply(CURSED_PIRATE_HELMET_BOAT_SPEED);
                    }
                    boatEntity.setVelocity(velocity);
                }
            }
        }
    }
}
