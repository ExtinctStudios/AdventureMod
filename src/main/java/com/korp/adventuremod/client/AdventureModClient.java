package com.korp.adventuremod.client;

import com.korp.adventuremod.entity.GooberEntity;
import com.korp.adventuremod.entity.client.GooberModel;
import com.korp.adventuremod.entity.client.GooberRenderer;
import com.korp.adventuremod.registries.ModEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class AdventureModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(GooberModel.MODEL_LAYER, GooberModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntity.GOOBER, GooberRenderer::new);
    }
}
