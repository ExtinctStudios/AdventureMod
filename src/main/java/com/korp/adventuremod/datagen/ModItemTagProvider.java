package com.korp.adventuremod.datagen;

import com.korp.adventuremod.registries.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.LEAVES)
                .add(Items.ACACIA_LEAVES)
                .add(Items.AZALEA_LEAVES)
                .add(Items.BIRCH_LEAVES)
                .add(Items.CHERRY_LEAVES)
                .add(Items.DARK_OAK_LEAVES)
                .add(Items.FLOWERING_AZALEA_LEAVES)
                .add(Items.JUNGLE_LEAVES)
                .add(Items.MANGROVE_LEAVES)
                .add(Items.OAK_LEAVES)
                .add(Items.SPRUCE_LEAVES);
    }
}
