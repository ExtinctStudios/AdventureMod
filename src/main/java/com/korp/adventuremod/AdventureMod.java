package com.korp.adventuremod;

import com.korp.adventuremod.entity.HuskEntity;
import com.korp.adventuremod.registries.*;
import com.korp.adventuremod.util.InventoryUtil;
import com.korp.adventuremod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
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
import net.minecraft.recipe.BrewingRecipeRegistry;
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

        FabricDefaultAttributeRegistry.register(ModEntities.HUSK, HuskEntity.createAttributes());

        RegisterHarvestWarpEssenceEvent();
        RegisterConvertBloodstoneOnKillEvent();
    }

    static void RegisterHarvestWarpEssenceEvent(){
        UseEntityCallback.EVENT.register((
                PlayerEntity player,
                World world,
                Hand hand,
                Entity entity,
                EntityHitResult entityHitResult) -> {
            ItemStack handItemStack = player.getStackInHand(hand);

            if (world.isClient()) {
                return ActionResult.SUCCESS;
            }

            boolean isHoldingEmptyBottle = handItemStack.getItem() == Items.GLASS_BOTTLE;

            if(!isHoldingEmptyBottle){
                System.out.println("entity isn't holding glass bottle! returning");
                return ActionResult.FAIL;
            }

            if(entity instanceof EndermanEntity endermanEntity){
                endermanEntity.damage(entity.getDamageSources().generic(), 0.5F);

                endermanEntity.setTarget(player);

                InventoryUtil.replaceItem(player, Items.GLASS_BOTTLE, ModItems.WARP_ESSENCE);

                return ActionResult.SUCCESS;
            }

            return ActionResult.FAIL;
        });
    }

    static void RegisterConvertBloodstoneOnKillEvent(){
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            if (entity.getWorld().isClient()) {
                return;
            }

            if (damageSource.getAttacker() instanceof PlayerEntity player) {
                InventoryUtil.replaceItem(player, ModItems.BLOODSTONE_EMPTY, ModItems.BLOODSTONE, entity);
            }
        });
    }
}
