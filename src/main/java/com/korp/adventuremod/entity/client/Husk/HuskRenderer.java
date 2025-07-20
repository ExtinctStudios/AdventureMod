package com.korp.adventuremod.entity.client.Husk;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.HuskEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HuskRenderer extends MobEntityRenderer<HuskEntity, HuskModel<HuskEntity>> {
    public HuskRenderer(EntityRendererFactory.Context context) {
        super(context, new HuskModel<>(context.getPart(HuskModel.MODEL_LAYER)), 0.75f);
    }

    @Override
    public Identifier getTexture(HuskEntity entity) {
        return Identifier.of(AdventureMod.MOD_ID, "textures/entity/husk.png");
    }

    @Override
    public void render(HuskEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
