package com.korp.adventuremod.mixin;

import com.korp.adventuremod.items.LeatherElytraItem;
import com.korp.adventuremod.items.ModElytraItem;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "travel", at = @At("HEAD"), cancellable = true)
    private void customElytraFlight(Vec3d movementInput, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        if (player.isFallFlying()) {
            ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);

            if (chest.getItem() instanceof ModElytraItem modElytraItem) {

                // 🚀 Apply your custom flight physics here
                Vec3d direction = player.getRotationVector();
                Vec3d velocity = player.getVelocity();

                // Basic gliding thrust boost based on tier
                double speed = modElytraItem.SPEED;

                Vec3d boosted = velocity.add(direction.multiply(speed * 0.05));
                player.setVelocity(boosted);

                // Move player manually
                player.move(MovementType.SELF, player.getVelocity());

                // Apply drag
                player.setVelocity(player.getVelocity().multiply(0.99, 0.98, 0.99));

                // Prevent vanilla travel logic
                ci.cancel();
            }
        }
    }
}
