package com.korp.adventuremod.items;

import net.minecraft.item.ElytraItem;

public class ModElytraItem extends ElytraItem {
    public final float SPEED;

    public ModElytraItem(Settings settings, float speed) {
        super(settings);
        this.SPEED = speed;
    }
}
