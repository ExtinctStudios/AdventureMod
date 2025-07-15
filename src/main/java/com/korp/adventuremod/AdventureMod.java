package com.korp.adventuremod;

import com.korp.adventuremod.registries.*;
import net.fabricmc.api.ModInitializer;

public class AdventureMod implements ModInitializer {

    public static final String MOD_ID = "adventuremod";

    @Override
    public void onInitialize() {
        ModEntity.initialize();
        ModBlocks.initialize();
        ModItem.initialize();
        ModItemGroup.initialize();
        ModArmorMaterials.initialize();
    }
}
