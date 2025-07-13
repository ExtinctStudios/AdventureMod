package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(AdventureMod.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }
}
