package com.korp.adventuremod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class GooberEntity extends HostileEntity {
    public GooberEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        {
            int p = 0;
            this.goalSelector.add(p++, new SwimGoal(this));
            this.goalSelector.add(p++, new MeleeAttackGoal(this, 1F, false));
            this.goalSelector.add(p++, new WanderAroundFarGoal(this, 1F));
            this.goalSelector.add(p++, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
            //this.goalSelector.add(p++, new LookAroundGoal(this));

        }

        {
            int p = 0;
            this.targetSelector.add(p++, new ActiveTargetGoal(this, PlayerEntity.class, true));
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes().add(
                EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0F);
    }
}
