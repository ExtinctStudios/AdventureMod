package com.korp.adventuremod.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HuskEntity extends HostileEntity {
    static final int IDLE_ANIMATION_LENGTH_IN_TICKS = 40;

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private final ServerBossBar bossBar;

    public HuskEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = (ServerBossBar)(new ServerBossBar(this.getDisplayName(), BossBar.Color.PURPLE, BossBar.Style.PROGRESS)).setDarkenSky(true);
    }

    @Override
    protected void initGoals() {
        {
            this.goalSelector.add(0, new SwimGoal(this));
            this.goalSelector.add(1, new MeleeAttackGoal(this, 1F, false));
            this.goalSelector.add(7, new WanderAroundFarGoal(this, (double)1.0F));
            this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
            this.goalSelector.add(8, new LookAroundGoal(this));
        }

        {
            this.targetSelector.add(0, new ActiveTargetGoal(this, PlayerEntity.class, true));
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0F)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0);
    }

    void resetAnimationStates(){
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = IDLE_ANIMATION_LENGTH_IN_TICKS;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationTimeout--;
        }
    }

    @Override
    public void tick(){
        super.tick();

        if(this.getWorld().isClient()){
            this.resetAnimationStates();
        }
    }

    @Override
    public boolean tryAttack(Entity target) {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return super.tryAttack(target);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.0F, 1.0F);
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }
    
    @Override
    public boolean damage(DamageSource source, float amount) {
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        return super.damage(source, amount);
    }
}
