package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DEFAULT = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AdventureMod.MOD_ID, "default"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LEAF_INGOT))
                    .displayName(Text.translatable("itemgroup.adventuremod.default"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.MEAT);
                        entries.add(ModBlocks.BLOODSTONE_ORE);

                        entries.add(ModBlocks.ARCANE_EXTRACTOR);

                        entries.add(ModItems.IRON_ROD);
                        entries.add(ModItems.CLOTH);
                        entries.add(ModItems.STEEL_INGOT);

                        entries.add(ModItems.CLOTH_HELMET);
                        entries.add(ModItems.CLOTH_CHESTPLATE);
                        entries.add(ModItems.CLOTH_LEGGINGS);
                        entries.add(ModItems.CLOTH_BOOTS);

                        entries.add(ModItems.STEEL_HELMET);
                        entries.add(ModItems.STEEL_CHESTPLATE);
                        entries.add(ModItems.STEEL_LEGGINGS);
                        entries.add(ModItems.STEEL_BOOTS);

                        entries.add(ModItems.STEEL_SWORD);
                        entries.add(ModItems.STEEL_PICKAXE);
                        entries.add(ModItems.STEEL_AXE);
                        entries.add(ModItems.STEEL_SHOVEL);
                        entries.add(ModItems.STEEL_HOE);
                        entries.add(ModItems.STEEL_HAMMER);

                        entries.add(ModItems.CACTUS_HELMET);
                        entries.add(ModItems.CACTUS_CHESTPLATE);
                        entries.add(ModItems.CACTUS_LEGGINGS);
                        entries.add(ModItems.CACTUS_BOOTS);

                        entries.add(ModItems.CACTUS_SWORD);

                        entries.add(ModItems.LEAF_INGOT);

                        entries.add(ModItems.LEAF_HELMET);
                        entries.add(ModItems.LEAF_CHESTPLATE);
                        entries.add(ModItems.LEAF_LEGGINGS);
                        entries.add(ModItems.LEAF_BOOTS);

                        entries.add(ModItems.LEAF_BOW);

                        entries.add(ModItems.BLOODSTONE);
                        entries.add(ModItems.BLOODSTONE_EMPTY);

                        entries.add(ModItems.BLOODSTONE_HELMET);
                        entries.add(ModItems.BLOODSTONE_CHESTPLATE);
                        entries.add(ModItems.BLOODSTONE_LEGGINGS);
                        entries.add(ModItems.BLOODSTONE_BOOTS);

                        entries.add(ModItems.BLOODSTONE_SWORD);
                        entries.add(ModItems.BLOODSTONE_PICKAXE);
                        entries.add(ModItems.BLOODSTONE_AXE);
                        entries.add(ModItems.BLOODSTONE_SHOVEL);
                        entries.add(ModItems.BLOODSTONE_HOE);

                        entries.add(ModItems.MAGIC_MIRROR);

                        entries.add(ModItems.WARP_ESSENCE);

                        entries.add(ModItems.LEATHER_ELYTRA);

                        entries.add(ModItems.BONE_REINFORCED_CLOTH_HELMET);
                        entries.add(ModItems.BONE_REINFORCED_CLOTH_CHESTPLATE);

                        entries.add(ModItems.SKULLISH_HELMET);

                        entries.add(ModItems.BONE_WAND);

                        entries.add(ModItems.PIRATE_HELMET);
                        entries.add(ModItems.CURSED_PIRATE_HELMET);

                        entries.add(ModItems.ARCANE_DUST);
                    }))
                    .build()
    );

    public static void initialize(){}
}
