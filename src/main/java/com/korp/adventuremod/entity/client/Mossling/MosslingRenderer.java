package com.korp.adventuremod.entity.client.Mossling;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.MosslingEntity;
import com.korp.adventuremod.entity.client.goober.GooberModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MosslingRenderer extends MobEntityRenderer<MosslingEntity, MosslingModel<MosslingEntity>> {
    public MosslingRenderer(EntityRendererFactory.Context context) {
        super(context, new MosslingModel<MosslingEntity>(context.getPart(MosslingModel.MODEL_LAYER)), 0.75f);
    }

    @Override
    public Identifier getTexture(MosslingEntity entity) {
        return Identifier.of(AdventureMod.MOD_ID, "textures/entity/mossling/mossling.png");
    }

    @Override
    public void render(MosslingEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
