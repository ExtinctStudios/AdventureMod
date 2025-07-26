package com.korp.adventuremod.util;

import com.korp.adventuremod.registries.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class InventoryUtil {
    /**
     * Replaces a specified item in the players inventory
     * @param playerEntity The player whose inventory is accessed
     * @param oldItem The item to replace
     * @param newItem The item that replaces old item
     */
    public static boolean replaceItem(
            PlayerEntity playerEntity,
            ItemConvertible oldItem,
            ItemConvertible newItem){
        return replaceItem(playerEntity, oldItem, newItem, playerEntity, 1);
    }

    /**
     *
     * @param playerEntity The player whose inventory is accessed
     * @param oldItem The item to replace
     * @param newItem The item that replaces old item
     * @param droppedItemEntitySource The source of the dropped item
     */
    public static boolean replaceItem(
            PlayerEntity playerEntity,
            ItemConvertible oldItem,
            ItemConvertible newItem,
            Entity droppedItemEntitySource){
        return replaceItem(playerEntity, oldItem, newItem, droppedItemEntitySource, 1);
    }

    /**
     *
     * @param playerEntity The player whose inventory is accessed
     * @param oldItem The item to replace
     * @param newItem The item that replaces old item
     * @param oldItemReplaced The amount of old items that are replaced
     */
    public static boolean replaceItem(
            PlayerEntity playerEntity,
            ItemConvertible oldItem,
            ItemConvertible newItem,
            int oldItemReplaced){
        return replaceItem(playerEntity, oldItem, newItem, playerEntity, oldItemReplaced);
    }

    /**
     *
     * @param playerEntity The player whose inventory is accessed
     * @param oldItem The item to replace
     * @param newItem The item that replaces old item
     * @param droppedItemEntitySource The source of the dropped item
     * @param oldItemReplaced The amount of old items that are replaced
     */
    public static boolean replaceItem(
            PlayerEntity playerEntity,
            ItemConvertible oldItem,
            ItemConvertible newItem,
            Entity droppedItemEntitySource,
            int oldItemReplaced){
        PlayerInventory inventory = playerEntity.getInventory();

        // Ifall spelaren har åtminstone 1 stack adventuremod:bloodstone_empty
        ItemStack oldItemStack = new ItemStack(oldItem);
        if(inventory.contains(oldItemStack)){
            int oldItemSlot = inventory.getSlotWithStack(oldItemStack);
            oldItemStack = inventory.getStack(oldItemSlot);
            oldItemStack.decrement(oldItemReplaced);



            // Ifall spelaren redan har åtminstone 1 stack bloodstone och stacken inte är full lägg till ett föremål i stacken,
            // annars, ifall det finns åtminstone 1 tom slot skapa en ny stack med 1 bloodstone
            // annars, skapa en bloodstone item entity
            ItemStack newItemStack = new ItemStack(newItem);
            ItemStack targetSlot = inventory.getStack(inventory.getSlotWithStack(newItemStack));
            if(inventory.contains(newItemStack) && targetSlot.getCount() < targetSlot.getMaxCount()){
                int newItemSlot = inventory.getSlotWithStack(newItemStack);
                newItemStack = inventory.getStack(newItemSlot);
                newItemStack.increment(1);
            } else {
                int emptySlot = inventory.getEmptySlot();
                if(emptySlot == -1){
                    World world = playerEntity.getWorld();
                    Vec3d pos = droppedItemEntitySource.getPos();

                    ItemEntity itemEntity = new ItemEntity(world, pos.x, pos.y, pos.z, newItemStack);
                    world.spawnEntity(itemEntity);
                }

                inventory.setStack(emptySlot, newItemStack);
            }

            return true;
        }
        else {
            return false;
        }
    }
}
