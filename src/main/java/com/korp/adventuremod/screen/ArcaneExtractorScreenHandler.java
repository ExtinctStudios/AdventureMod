package com.korp.adventuremod.screen;

import com.korp.adventuremod.entity.ArcaneExtractorBlockEntity;
import com.korp.adventuremod.registries.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class ArcaneExtractorScreenHandler extends ScreenHandler {
    final Inventory inventory;
    final PropertyDelegate propertyDelegate;
    final ArcaneExtractorBlockEntity blockEntity;

    public ArcaneExtractorScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(2));
    }

    public ArcaneExtractorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate propertyDelegate){
        super(ModScreenHandlers.ARCANE_EXTRACTOR_SCREEN_HANDLER, syncId);
        this.inventory = (Inventory) blockEntity;
        this.blockEntity = (ArcaneExtractorBlockEntity) blockEntity;
        this.propertyDelegate = propertyDelegate;

        this.addSlot(new Slot(inventory, 0, 54, 17));
        //this.addSlot(new Slot(inventory, 1, 106, 17));
        this.addSlot(new Slot(inventory, 1, 54, 37));

        this.addSlot(new Slot(inventory, 2, 83, 51));
        this.addSlot(new Slot(inventory, 3, 106, 58));
        this.addSlot(new Slot(inventory, 4, 129, 51));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(propertyDelegate);
    }
    public boolean isCrafting() {
        return propertyDelegate.get(ArcaneExtractorBlockEntity.PROPERTY_DELEGATE_PROGRESS) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.propertyDelegate.get(ArcaneExtractorBlockEntity.PROPERTY_DELEGATE_PROGRESS);
        int maxProgress = this.propertyDelegate.get(ArcaneExtractorBlockEntity.PROPERTY_DELEGATE_MAX_PROGRESS);
        int arrowPixelSize = 32;

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotId) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotId);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (slotId < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        slot.onTakeItem(player, slot.getStack());

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
