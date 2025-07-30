package com.korp.adventuremod.entity;

import com.korp.adventuremod.block.entity.ImplementedInventory;
import com.korp.adventuremod.registries.ModItems;
import com.korp.adventuremod.screen.ArcaneExtractorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ArcaneExtractorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    public static final int PROPERTY_DELEGATE_PROGRESS = 0;
    public static final int PROPERTY_DELEGATE_MAX_PROGRESS = 1;

    final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    static final int INPUT_SLOT = 0;
    static final int OUTPUT_SLOT = 1;
    static final int SUBSTRATE_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    int progress = 0;
    int maxProgress = 110;

    public ArcaneExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANE_EXTRACTOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case PROPERTY_DELEGATE_PROGRESS -> ArcaneExtractorBlockEntity.this.progress;
                    case PROPERTY_DELEGATE_MAX_PROGRESS -> ArcaneExtractorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PROPERTY_DELEGATE_PROGRESS: ArcaneExtractorBlockEntity.this.progress = value;
                    case PROPERTY_DELEGATE_MAX_PROGRESS: ArcaneExtractorBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.adventuremod.arcane_extractor");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ArcaneExtractorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("arcane_extractor.progress", progress);
        nbt.putInt("arcane_extractor.max_progress", maxProgress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("arcane_extractor.progress");
        maxProgress = nbt.getInt("arcane_extractor.max_progress");
        super.readNbt(nbt, registryLookup);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(hasRecipe()){
            increaseProgress();
            markDirty(world, pos, state);

            if(isProgressFinished()){
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        ItemStack output = new ItemStack(ModItems.WARP_ESSENCE, 1);

        this.removeStack(INPUT_SLOT, 1);
        this.removeStack(SUBSTRATE_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(ModItems.WARP_ESSENCE, this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private boolean isProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseProgress() {
        this.progress++;
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = 110;
    }

    private boolean hasRecipe() {
        Item input = Items.ENDER_PEARL;
        Item substrate = ModItems.ARCANE_DUST;
        ItemStack output = new ItemStack(ModItems.WARP_ESSENCE);

        return this.getStack(INPUT_SLOT).isOf(input) &&
                this.getStack(SUBSTRATE_SLOT).isOf(substrate) &&
                canInsertAmountIntoOutputSlot(output.getCount()) &&
                canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() + count <= this.getStack(OUTPUT_SLOT).getItem().getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
