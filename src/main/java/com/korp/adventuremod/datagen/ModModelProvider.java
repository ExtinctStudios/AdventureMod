package com.korp.adventuremod.datagen;

import com.korp.adventuremod.registries.ModBlocks;
import com.korp.adventuremod.registries.ModItem;
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
        itemModelGenerator.register(ModItem.IRON_ROD, Models.GENERATED);

        itemModelGenerator.register(ModItem.LEAF_INGOT, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItem.LEAF_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.LEAF_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.LEAF_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.LEAF_BOOTS);

        itemModelGenerator.register(ModItem.LEAF_BOW, Models.HANDHELD);

        itemModelGenerator.register(ModItem.BLOODSTONE_EMPTY, Models.GENERATED);
        itemModelGenerator.register(ModItem.BLOODSTONE, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItem.BLOODSTONE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.BLOODSTONE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.BLOODSTONE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.BLOODSTONE_BOOTS);

        itemModelGenerator.register(ModItem.BLOODSTONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItem.BLOODSTONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItem.BLOODSTONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItem.BLOODSTONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItem.BLOODSTONE_HOE, Models.HANDHELD);
    }
}
