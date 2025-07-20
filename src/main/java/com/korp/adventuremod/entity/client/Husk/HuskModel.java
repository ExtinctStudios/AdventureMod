package com.korp.adventuremod.entity.client.Husk;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.HuskEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class HuskModel<T extends HuskEntity> extends SinglePartEntityModel<T> {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Identifier.of(AdventureMod.MOD_ID, "husk"), "main");
	private final ModelPart root;
	private final ModelPart torso;
	private final ModelPart head;
	private final ModelPart arm_left;
	private final ModelPart arm_right;
	private final ModelPart leg_left;
	private final ModelPart leg_right;
	public HuskModel(ModelPart root) {
		this.root = root.getChild("root");
		this.torso = this.root.getChild("torso");
		this.head = this.torso.getChild("head");
		this.arm_left = this.torso.getChild("arm_left");
		this.arm_right = this.torso.getChild("arm_right");
		this.leg_left = this.root.getChild("leg_left");
		this.leg_right = this.root.getChild("leg_right");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData torso = root.addChild("torso", ModelPartBuilder.create().uv(0, 24).cuboid(-6.0F, -18.0F, -3.0F, 12.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData arm_left = torso.addChild("arm_left", ModelPartBuilder.create().uv(48, 0).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(9.0F, -16.0F, 0.0F));

		ModelPartData arm_right = torso.addChild("arm_right", ModelPartBuilder.create().uv(24, 48).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.0F, -16.0F, 0.0F));

		ModelPartData leg_left = root.addChild("leg_left", ModelPartBuilder.create().uv(36, 24).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -18.0F, 0.0F));

		ModelPartData leg_right = root.addChild("leg_right", ModelPartBuilder.create().uv(0, 48).cuboid(-9.0F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -18.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(HuskEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(HuskAnimations.WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, HuskAnimations.IDLE, animationProgress, 1f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		root.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return root;
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * MathHelper.RADIANS_PER_DEGREE;
		this.head.pitch = headPitch * MathHelper.RADIANS_PER_DEGREE;
	}
}