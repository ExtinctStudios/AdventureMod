package com.korp.adventuremod.entity.client.goober;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.GooberEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class GooberModel<T extends GooberEntity> extends EntityModel<GooberEntity> {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Identifier.of(AdventureMod.MOD_ID, "goober"), "main");
	private final ModelPart bb_main;
	public GooberModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(0, 12).cuboid(-2.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r2 = bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(16, 4).cuboid(-5.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -3.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r3 = bb_main.addChild("cube_r3", ModelPartBuilder.create().uv(16, 18).cuboid(-5.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -3.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r4 = bb_main.addChild("cube_r4", ModelPartBuilder.create().uv(8, 12).cuboid(-5.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r5 = bb_main.addChild("cube_r5", ModelPartBuilder.create().uv(16, 11).cuboid(-5.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r6 = bb_main.addChild("cube_r6", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r7 = bb_main.addChild("cube_r7", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 1.0F, 0.0F, 1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		bb_main.render(matrices, vertexConsumer, light, overlay, color);
	}
	@Override
	public void setAngles(GooberEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}