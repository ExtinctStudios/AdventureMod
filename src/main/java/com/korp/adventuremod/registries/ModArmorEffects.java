package com.korp.adventuremod.registries;

import com.korp.adventuremod.mod.ModArmorEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

import java.util.HashMap;

public class ModArmorEffects {
    public static final HashMap<Item, ModArmorEffect> TABLE = new HashMap<>() {
        {
            put(ModItems.BLOODSTONE_HELMET, new ModArmorEffect(
                    StatusEffects.STRENGTH,
                    2,
                    ModItems.BLOODSTONE_HELMET,
                    ModItems.BLOODSTONE_CHESTPLATE,
                    null,
                    null
            ));
        }
    };
}
