package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DEFAULT = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AdventureMod.MOD_ID, "default"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.GLOW_ITEM_FRAME))
                    .displayName(Text.translatable("itemgroup.adventuremod.default"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItem.LEAF_HELMET);
                        entries.add(ModItem.LEAF_CHESTPLATE);
                        entries.add(ModItem.LEAF_LEGGINGS);
                        entries.add(ModItem.LEAF_BOOTS);

                        entries.add(ModItem.STEELEAF_INGOT);
                    }))
                    .build()
    );

    public static void initialize(){}
}
