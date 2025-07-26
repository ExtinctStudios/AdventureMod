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

        if(boatEntity.getControllingPassenger() instanceof PlayerEntity playerEntity){
            if(playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.PIRATE_HELMET) {// Set to pirate hat
                Vec3d velocity = boatEntity.getVelocity().multiply(1.05);
                if(velocity.length() > 16.0){
                    velocity = velocity.normalize().multiply(16.0);
                }
                boatEntity.setVelocity(velocity);
            } else if(playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.CURSED_PIRATE_HELMET) {// Set to pirate hat
                if(boatEntity.getVelocity().length() <= 18){
                    Vec3d velocity = boatEntity.getVelocity().multiply(1.08);
                    if(velocity.length() > 20.0){
                        velocity = velocity.normalize().multiply(20.0);
                    }
                    boatEntity.setVelocity(velocity);
                }
            }
        }
    }
}
