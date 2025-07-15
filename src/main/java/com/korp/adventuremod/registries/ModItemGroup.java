package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DEFAULT = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AdventureMod.MOD_ID, "default"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItem.LEAF_INGOT))
                    .displayName(Text.translatable("itemgroup.adventuremod.default"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.BLOODSTONE_BLOCK);

                        entries.add(ModItem.IRON_ROD);

                        entries.add(ModItem.LEAF_INGOT);

                        entries.add(ModItem.LEAF_HELMET);
                        entries.add(ModItem.LEAF_CHESTPLATE);
                        entries.add(ModItem.LEAF_LEGGINGS);
                        entries.add(ModItem.LEAF_BOOTS);

                        entries.add(ModItem.STEELEAF_BOW);

                        entries.add(ModItem.BLOODSTONE);
                        entries.add(ModItem.BLOODSTONE_EMPTY);

                        entries.add(ModItem.BLOODSTONE_HELMET);
                        entries.add(ModItem.BLOODSTONE_CHESTPLATE);
                        entries.add(ModItem.BLOODSTONE_LEGGINGS);
                        entries.add(ModItem.BLOODSTONE_BOOTS);

                        entries.add(ModItem.BLOOD_STONE_SWORD);
                        entries.add(ModItem.BLOOD_STONE_PICKAXE);
                        entries.add(ModItem.BLOOD_STONE_AXE);
                        entries.add(ModItem.BLOOD_STONE_SHOVEL);
                        entries.add(ModItem.BLOOD_STONE_HOE);
                    }))
                    .build()
    );

    public static void initialize(){}
}
