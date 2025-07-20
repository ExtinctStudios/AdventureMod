package com.korp.adventuremod.client;

import com.korp.adventuremod.entity.client.Husk.HuskModel;
import com.korp.adventuremod.entity.client.Husk.HuskRenderer;
import com.korp.adventuremod.registries.ModEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModEntityInitializer {
    public static void initialize(){
        EntityModelLayerRegistry.registerModelLayer(HuskModel.MODEL_LAYER, HuskModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.HUSK, HuskRenderer::new);
    }
}
