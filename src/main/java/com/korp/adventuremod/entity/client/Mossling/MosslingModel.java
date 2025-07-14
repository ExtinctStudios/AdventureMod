package com.korp.adventuremod.entity.client.Mossling;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.MosslingEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class MosslingModel<T extends MosslingEntity> extends SinglePartEntityModel<T> {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Identifier.of(AdventureMod.MOD_ID, "mossling"), "main");

	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart leg_front_left;
	private final ModelPart leg_front_right;
	private final ModelPart leg_back_left;
	private final ModelPart leg_back_right;

	public MosslingModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.leg_front_left = this.body.getChild("leg_front_left");
		this.leg_front_right = this.body.getChild("leg_front_right");
		this.leg_back_left = this.body.getChild("leg_back_left");
		this.leg_back_right = this.body.getChild("leg_back_right");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-7.0F, -10.0F, -7.0F, 14.0F, 14.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData body_outer_r1 = body.addChild("body_outer_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -11.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData leg_front_left = body.addChild("leg_front_left", ModelPartBuilder.create().uv(56, 42).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 2.0F, -8.0F));

		ModelPartData leg_front_right = body.addChild("leg_front_right", ModelPartBuilder.create().uv(0, 60).cuboid(-3.0F, -6.0F, -3.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 8.0F, -7.0F));

		ModelPartData leg_back_left = body.addChild("leg_back_left", ModelPartBuilder.create().uv(56, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 2.0F, 8.0F));

		ModelPartData leg_back_right = body.addChild("leg_back_right", ModelPartBuilder.create().uv(56, 52).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 2.0F, 8.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(MosslingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(MosslingAnimation.WALK, limbAngle, limbDistance, 1F, 1F);
		this.updateAnimation(entity.walkingAnimationState, MosslingAnimation.WALK, animationProgress, 1F);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		root.render(matrices, vertexConsumer, light, overlay, color);
	}

	public ModelPart getPart() {
		return root;
	}
}