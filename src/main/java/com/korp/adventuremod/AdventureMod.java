package com.korp.adventuremod;

import com.korp.adventuremod.entity.GooberEntity;
import com.korp.adventuremod.registries.ModEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class AdventureMod implements ModInitializer {

    public static final String MOD_ID = "adventuremod";

    @Override
    public void onInitialize() {
        ModEntity.initialize();

        FabricDefaultAttributeRegistry.register(ModEntity.GOOBER, GooberEntity.createHostileAttributes());
    }
}
