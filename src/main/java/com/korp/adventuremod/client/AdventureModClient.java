package com.korp.adventuremod.client;

import com.korp.adventuremod.entity.client.goober.GooberModel;
import com.korp.adventuremod.entity.client.goober.GooberRenderer;
import com.korp.adventuremod.registries.ModEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AdventureModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModEntityInitializer.initialize();
    }
}
