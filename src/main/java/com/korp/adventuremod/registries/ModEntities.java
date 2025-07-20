package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.entity.HuskEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<HuskEntity> HUSK = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(AdventureMod.MOD_ID, "husk"),
            EntityType.Builder.create(HuskEntity::new, SpawnGroup.CREATURE).dimensions(1.5F, 2.75F).build()
    );

    public static void initialize(){
        FabricDefaultAttributeRegistry.register(ModEntities.HUSK, HuskEntity.createHostileAttributes());
    }
}
