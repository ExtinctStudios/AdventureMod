package com.korp.adventuremod.entity.client.Mossling;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.GooberEntity;
import com.korp.adventuremod.entity.MosslingEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class MosslingModel<T extends MosslingEntity> extends EntityModel<MosslingEntity> {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Identifier.of(AdventureMod.MOD_ID, "mossling"), "main");
	private final ModelPart bb_main;
	public MosslingModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 32).cuboid(-7.0F, -18.0F, -7.0F, 14.0F, 14.0F, 14.0F, new Dilation(0.0F))
		.uv(56, 32).cuboid(6.0F, -6.0F, 6.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(56, 42).cuboid(6.0F, -6.0F, -10.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(56, 52).cuboid(-10.0F, -6.0F, 6.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 60).cuboid(-10.0F, -6.0F, -10.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-8.0F, -19.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(MosslingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		bb_main.render(matrices, vertexConsumer, light, overlay, color);
	}
}