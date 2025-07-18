package com.korp.adventuremod;

import com.korp.adventuremod.registries.*;
import com.korp.adventuremod.util.InventoryUtil;
import com.korp.adventuremod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AdventureMod implements ModInitializer {

    public static final String MOD_ID = "adventuremod";

    @Override
    public void onInitialize() {
        ModEntities.initialize();
        ModBlocks.initialize();
        ModItems.initialize();
        ModItemGroups.initialize();
        ModArmorMaterials.initialize();
        ModWorldGeneration.initialize();
        ModModelPredicates.initialize();

        UseEntityCallback.EVENT.register((
                PlayerEntity player,
                World world,
                Hand hand,
                Entity entity,
                EntityHitResult entityHitResult) -> {
            ItemStack handItemStack = player.getStackInHand(hand);

            boolean isHoldingEmptyBottle = handItemStack.getItem() == Items.GLASS_BOTTLE;

            if(isHoldingEmptyBottle && entity instanceof EndermanEntity endermanEntity){
                RegistryEntry<DamageType> damageType = world.getRegistryManager()
                        .getWrapperOrThrow(RegistryKeys.DAMAGE_TYPE)
                        .getOptional(DamageTypes.GENERIC)
                        .orElseThrow(() -> new IllegalStateException("Missing damage type: generic"));

                DamageSource damageSource = new DamageSource(damageType);
                endermanEntity.damage(damageSource, 0.5F);

                endermanEntity.setTarget(player);

                InventoryUtil.replaceItem(player, Items.GLASS_BOTTLE, ModItems.WARP_ESSENCE);
            }

            return ActionResult.SUCCESS;
        });

        RegisterConvertBloodstoneOnKillEvent();
    }

    static void RegisterConvertBloodstoneOnKillEvent(){
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            if (entity.getWorld().isClient()) {
                return;
            }

            if (damageSource.getAttacker() instanceof PlayerEntity player) {
                PlayerInventory inventory = player.getInventory();

                // Ifall spelaren har åtminstone 1 stack adventuremod:bloodstone_empty
                ItemStack emptyBloodstoneStack = new ItemStack(ModItems.BLOODSTONE_EMPTY);
                if(inventory.contains(emptyBloodstoneStack)){
                    int emptyBloodstoneSlot = inventory.getSlotWithStack(emptyBloodstoneStack);
                    emptyBloodstoneStack = inventory.getStack(emptyBloodstoneSlot);
                    emptyBloodstoneStack.decrement(1);

                    // Ifall spelaren redan har åtminstone 1 stack bloodstone och stacken inte är full lägg till ett föremål i stacken,
                    // annars, ifall det finns åtminstone 1 tom slot skapa en ny stack med 1 bloodstone
                    // annars, skapa en bloodstone item entity
                    ItemStack bloodstoneStack = new ItemStack(ModItems.BLOODSTONE);
                    if(inventory.contains(bloodstoneStack) && inventory.getStack(inventory.getSlotWithStack(bloodstoneStack)).getCount() < 64){
                        int bloodstoneSlot = inventory.getSlotWithStack(bloodstoneStack);
                        bloodstoneStack = inventory.getStack(bloodstoneSlot);
                        bloodstoneStack.increment(1);
                    } else {
                        int emptySlot = inventory.getEmptySlot();
                        if(emptySlot == -1){
                            World world = player.getWorld();
                            Vec3d pos = entity.getPos();

                            ItemEntity bloodstoneItemEntity = new ItemEntity(world, pos.x, pos.y, pos.z, bloodstoneStack);
                            world.spawnEntity((bloodstoneItemEntity));
                        }

                        inventory.setStack(emptySlot, bloodstoneStack);
                    }
                }
            }
        });
    }
}
