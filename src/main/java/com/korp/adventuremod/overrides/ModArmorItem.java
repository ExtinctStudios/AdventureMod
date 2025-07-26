package com.korp.adventuremod.overrides;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class ModArmorItem extends ArmorItem {
    RegistryEntry<StatusEffect> statusEffect;

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings, RegistryEntry<StatusEffect> statusEffect) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity playerEntity){
                StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.REGENERATION, 1, 999);
                playerEntity.addStatusEffect(statusEffectInstance);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
