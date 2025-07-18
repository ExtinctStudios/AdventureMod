package com.korp.adventuremod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MagicMirrorItem extends Item {
    static final int COOLDOWN_IN_SECONDS = 60 * 5;
    static final int COOLDOWN_IN_TICKS = COOLDOWN_IN_SECONDS * 20;

    public MagicMirrorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(playerEntity instanceof ServerPlayerEntity serverPlayerEntity){
            var spawnPointPosition = serverPlayerEntity.getSpawnPointPosition();
            var spawnPointDimension = serverPlayerEntity.getSpawnPointDimension();

            if(spawnPointPosition == null || spawnPointDimension == null){
                return super.use(world, playerEntity, hand);
            }

            MinecraftServer server = playerEntity.getServer();

            if(server == null){
                return super.use(world, playerEntity, hand);
            }

            ServerWorld serverSpawnWorld = server.getWorld(spawnPointDimension);

            int x = spawnPointPosition.getX();
            int y = spawnPointPosition.getY();
            int z = spawnPointPosition.getZ();

            float yaw = serverPlayerEntity.getYaw();
            float pitch = serverPlayerEntity.getPitch();

            serverPlayerEntity.teleport(serverSpawnWorld, x, y, z, yaw, pitch);

            playerEntity.getItemCooldownManager().set(this, COOLDOWN_IN_TICKS);
        }

        return super.use(world, playerEntity, hand);
    }
}
