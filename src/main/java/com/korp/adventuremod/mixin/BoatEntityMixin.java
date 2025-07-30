package com.korp.adventuremod.mixin;

import com.korp.adventuremod.registries.ModItems;
import com.korp.adventuremod.util.InventoryUtil;
import com.korp.adventuremod.util.PlayerUtil;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
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

        if(boatEntity.getControllingPassenger() instanceof PlayerEntity playerEntity){
            applyConditionalVelocityMultiplierAndAcceleration(playerEntity, boatEntity, ModItems.PIRATE_HELMET, 12.0, 1.05);
            applyConditionalVelocityMultiplierAndAcceleration(playerEntity, boatEntity, ModItems.CURSED_PIRATE_HELMET, 18.0, 1.08);
        }
    }

    void applyConditionalVelocityMultiplierAndAcceleration(
            PlayerEntity playerEntity,
            BoatEntity boatEntity,
            Item requiredItem,
            double velocityMultiplier,
            double accelerationMultiplier) {
        if(InventoryUtil.isWearingArmorItemInDesignatedSlot(playerEntity, requiredItem)){
            if(boatEntity.getVelocity().length() <= velocityMultiplier){
                Vec3d velocity = boatEntity.getVelocity().multiply(accelerationMultiplier);
                if(velocity.length() > velocityMultiplier){
                    velocity = velocity.normalize().multiply(velocityMultiplier);
                }
                boatEntity.setVelocity(velocity);
            }
        }
    }
}
