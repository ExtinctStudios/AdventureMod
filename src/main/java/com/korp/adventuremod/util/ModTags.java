package com.korp.adventuremod.util;

import com.korp.adventuremod.AdventureMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String id){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(AdventureMod.MOD_ID, id));
        }
    }

    public static class Items{
        public static final TagKey<Item> LEAVES = createTag("leaves");

        private static TagKey<Item> createTag(String id){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(AdventureMod.MOD_ID, id));
        }
    }
}
