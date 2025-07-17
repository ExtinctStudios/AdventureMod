package com.korp.adventuremod.datagen;

import com.korp.adventuremod.registries.ModBlocks;
import com.korp.adventuremod.registries.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOODSTONE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.IRON_ROD, Models.GENERATED);

        itemModelGenerator.register(ModItems.LEAF_INGOT, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_BOOTS);

        itemModelGenerator.register(ModItems.LEAF_BOW, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BLOODSTONE_EMPTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTONE, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.BLOODSTONE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BLOODSTONE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BLOODSTONE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BLOODSTONE_BOOTS);

        itemModelGenerator.register(ModItems.BLOODSTONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTONE_HOE, Models.HANDHELD);
    }
}
