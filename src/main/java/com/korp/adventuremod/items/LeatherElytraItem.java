package com.korp.adventuremod.items;

import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class LeatherElytraItem extends ElytraItem {
    public LeatherElytraItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.LEATHER);
    }
}
