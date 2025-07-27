package com.korp.adventuremod.mod;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntry;

public class ModArmorEffect {
    final RegistryEntry<StatusEffect> statusEffect;

    final int amplifier;

    final Item helmet;
    final Item chestplate;
    final Item leggings;
    final Item boots;

    public ModArmorEffect(RegistryEntry<StatusEffect> statusEffect, int amplifier, Item helmet, Item chestplate, Item leggings, Item boots){
        this.statusEffect = statusEffect;

        this.amplifier = amplifier;

        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
    }

    public boolean hasRequiredArmorEquipped(PlayerEntity playerEntity){
        return  helmet == null || playerEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == helmet &&
                chestplate == null || playerEntity.getEquippedStack(EquipmentSlot.CHEST).getItem() == chestplate &&
                leggings == null || playerEntity.getEquippedStack(EquipmentSlot.LEGS).getItem() == leggings &&
                boots    == null || playerEntity.getEquippedStack(EquipmentSlot.FEET).getItem() == boots;
    }

    public void applyArmorEffect(PlayerEntity playerEntity){
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(statusEffect, 1, amplifier);
        playerEntity.addStatusEffect(statusEffectInstance);
    }
}
