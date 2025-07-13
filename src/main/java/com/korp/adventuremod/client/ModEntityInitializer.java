package com.korp.adventuremod.client;

import com.korp.adventuremod.entity.client.Mossling.MosslingModel;
import com.korp.adventuremod.entity.client.Mossling.MosslingRenderer;
import com.korp.adventuremod.entity.client.goober.GooberModel;
import com.korp.adventuremod.entity.client.goober.GooberRenderer;
import com.korp.adventuremod.registries.ModEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModEntityInitializer {
    public static void initialize(){
        EntityModelLayerRegistry.registerModelLayer(GooberModel.MODEL_LAYER, GooberModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntity.GOOBER, GooberRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MosslingModel.MODEL_LAYER, MosslingModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntity.MOSSLING, MosslingRenderer::new);
    }
}
