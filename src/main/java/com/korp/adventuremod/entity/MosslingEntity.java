package com.korp.adventuremod.entity;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class MosslingEntity extends HostileEntity {
    public final AnimationState walkingAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public MosslingEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        {
            this.goalSelector.add(0, new SwimGoal(this));
            this.goalSelector.add(2, new MeleeAttackGoal(this, 0.5F, false));
            this.goalSelector.add(7, new WanderAroundFarGoal(this, 0.5F));
            this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
            this.goalSelector.add(8, new LookAroundGoal(this));
        }

        {
            this.targetSelector.add(3, new ActiveTargetGoal(this, PlayerEntity.class, true));
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.walkingAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes().add(
                        EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1F);
    }
}
