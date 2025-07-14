package com.korp.adventuremod.datagen;

import com.korp.adventuremod.registries.ModItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.registerArmor((ArmorItem) ModItem.LEAF_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.LEAF_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.LEAF_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItem.LEAF_BOOTS);
    }
}
