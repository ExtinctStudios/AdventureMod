package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.GooberEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntity {
    public static final EntityType<GooberEntity> GOOBER = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(AdventureMod.MOD_ID, "goober"),
            EntityType.Builder.create(GooberEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2.5f).build()
    );

    public static void initialize(){

    }
}
