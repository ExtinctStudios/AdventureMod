package com.korp.adventuremod.mixin;

import com.korp.adventuremod.registries.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "checkFallFlying", at = @At(value = "TAIL"), locals = LocalCapture.NO_CAPTURE, cancellable = true)
    public void checkFallFlyingMixin(CallbackInfoReturnable<Boolean> info) {
        //PlayerEntity self = (PlayerEntity)(Object)this;
//
        //if (!self.isOnGround() && !self.isFallFlying() && !self.isTouchingWater() && !self.hasStatusEffect(StatusEffects.LEVITATION)) {
        //    ItemStack itemStack = self.getEquippedStack(EquipmentSlot.CHEST);
        //    if (itemStack.isOf(ModItems.LEATHER_ELYTRA)) {
        //        self.startFallFlying();
        //        info.setReturnValue(true);
        //    }
        //}
//
        //info.setReturnValue(false);
    }
}
