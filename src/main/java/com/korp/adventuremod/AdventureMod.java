package com.korp.adventuremod;

import com.korp.adventuremod.registries.ModArmorMaterials;
import com.korp.adventuremod.registries.ModEntity;
import com.korp.adventuremod.registries.ModItem;
import com.korp.adventuremod.registries.ModItemGroup;
import net.fabricmc.api.ModInitializer;

public class AdventureMod implements ModInitializer {

    public static final String MOD_ID = "adventuremod";

    @Override
    public void onInitialize() {
        ModEntity.initialize();
        ModItem.initialize();
        ModItemGroup.initialize();
        ModArmorMaterials.initialize();
    }
}
