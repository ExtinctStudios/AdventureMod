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

                        entries.add(ModItems.IRON_ROD);

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
                    }))
                    .build()
    );

    public static void initialize(){}
}
