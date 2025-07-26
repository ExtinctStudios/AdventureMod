package com.korp.adventuremod.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Items;
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
            if(playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Items.IRON_HELMET) {// Set to pirate hat
                if(boatEntity.getVelocity().length() <= 16.0){
                    boatEntity.setVelocity(boatEntity.getVelocity().multiply(1.05));
                }
            }
        }
    }
}
