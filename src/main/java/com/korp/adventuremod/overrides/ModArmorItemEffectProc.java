package com.korp.adventuremod.overrides;

import com.korp.adventuremod.mod.ModArmorEffect;
import com.korp.adventuremod.registries.ModArmorEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class ModArmorItemEffectProc extends ArmorItem {
    public ModArmorItemEffectProc(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity playerEntity){
                if(ModArmorEffects.TABLE.containsKey(this)){
                    ModArmorEffect armorEffect = ModArmorEffects.TABLE.get(this);

                    if(armorEffect.hasRequiredArmorEquipped(playerEntity)){
                        armorEffect.applyArmorEffect(playerEntity);
                    }
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
