package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block MEAT = registerBlock("meat",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.0f)
                    .sounds(BlockSoundGroup.WET_SPONGE)));

    public static final Block BLOODSTONE_ORE = registerBlock("bloodstone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create()
                    .strength(4.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.BONE)));

    public static Block registerBlock(String id, Block block){
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AdventureMod.MOD_ID, id), block);
    }

    public static void registerBlockItem(String id, Block block){
        Registry.register(Registries.ITEM, Identifier.of(AdventureMod.MOD_ID, id), new BlockItem(block, new Item.Settings()));
    }

    public static void initialize(){}
}
