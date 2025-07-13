package com.korp.adventuremod.entity.client;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.GooberEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GooberRenderer extends MobEntityRenderer<GooberEntity, GooberModel<GooberEntity>> {
    public GooberRenderer(EntityRendererFactory.Context context) {
        super(context, new GooberModel<>(context.getPart(GooberModel.MODEL_LAYER)), 0.75f);
    }

    @Override
    public Identifier getTexture(GooberEntity entity) {
        return Identifier.of(AdventureMod.MOD_ID, "textures/entity/goober/goober.png");
    }


    @Override
    public void render(GooberEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
