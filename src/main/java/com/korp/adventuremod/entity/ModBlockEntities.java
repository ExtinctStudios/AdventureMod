package com.korp.adventuremod.entity;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.registries.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ArcaneExtractorBlockEntity> ARCANE_EXTRACTOR =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(AdventureMod.MOD_ID, "growth_chamber_be"),
                    BlockEntityType.Builder.create(ArcaneExtractorBlockEntity::new, ModBlocks.ARCANE_EXTRACTOR).build(null));


    public static void initialize() {}
}
