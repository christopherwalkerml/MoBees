package com.noodlepfp.mobees.alveary.block;

import com.noodlepfp.mobees.alveary.INBTStorable;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTilePowerable;
import com.noodlepfp.mobees.gui.ContainerAlvearyMutator;
import com.noodlepfp.mobees.gui.InventoryAlvearyMutator;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutation;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.core.inventory.IInventoryAdapter;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import forestry.core.network.IStreamable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

import static com.noodlepfp.mobees.gui.InventoryAlvearyFrameHousing.SLOT_FRAME;

public class TileAlvearyMutator extends MoreBeesTilePowerable implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary>, IStreamable, INBTStorable {
    private final InventoryAlvearyMutator inventory;
    public static final int MUTAGEN_STORAGE_CAP = 5000;
    public static final int MUTAGEN_RESERVE_CAP = 500;
    private final String MUTAGEN_STORAGE_STR = "storedMutagen";
    private final String MUTAGEN_RESERVE_STR = "reservedMutagen";
    public final static String ITEM_NBT_TAG = "MutatorData";
    private int mutagenStorage;
    private int mutagenReserve;
    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public float modifyMutationChance(IGenome genome, IGenome mate, IMutation<IBeeSpecies> mutation, float currentChance) {
            // if the chance is already above the max, ignore it
            if (canConsumeMutagen() && currentChance < 0.5f) {
                setMutagenStorage(getMutagenStorage() - (MUTAGEN_STORAGE_CAP / 2));

                // mult cap is the base mutation chance to the power of 3. ie. 0.06 -> 0.09 -> 0.135 -> 0.203 -> 0.304, capped at 0.5
                float multCap = Math.min((float)(mutation.getChance() * (Math.pow(1.5, 4))), 0.5f);
                return Math.min(currentChance * 1.5f, multCap);
            }
            return currentChance;
        }
    };

    public TileAlvearyMutator(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.MUTATOR, pos, state, "Ingesting", 1, 200);
        this.inventory = new InventoryAlvearyMutator(this);
        this.mutagenStorage = 0;
        this.mutagenReserve = 0;
    }

    @Override
    public void updateServer(int tickCount) {
        // should only consume power if there is mutagen waiting to be ingested
        if (getMutagenReserve() > 0 && getMutagenStorage() < getMutagenStorageCap()) {
            super.updateServer(tickCount);
        }
        // can reserve mutagen without power
        if (getMutagenReserve() == 0 && inventory.canUseMutagen()) {
            inventory.useMutagen();
            setMutagenReserve(MUTAGEN_RESERVE_CAP);
        }
        // only ingests mutagen into storage if powered and in reserve and less than cap
        if (isActive()) {
            if (getMutagenReserve() > 0 && getMutagenStorage() < MUTAGEN_STORAGE_CAP) {
                setMutagenReserve(getMutagenReserve() - 1);
                setMutagenStorage(getMutagenStorage() + 1);
            }
        }
    }

    public int getMutagenReserve() {
        return this.mutagenReserve;
    }

    public void setMutagenReserve(int amt) {
        this.mutagenReserve = amt;
    }

    public static int getMutagenReserveCap() {
        return MUTAGEN_RESERVE_CAP;
    }

    public int getMutagenStorage() {
        return this.mutagenStorage;
    }

    public boolean canConsumeMutagen() {
        return this.mutagenStorage >= MUTAGEN_STORAGE_CAP / 2;
    }

    public void setMutagenStorage(int amt) {
        this.mutagenStorage = amt;
    }

    public static int getMutagenStorageCap() {
        return MUTAGEN_STORAGE_CAP;
    }

    @Override
    public IInventoryAdapter getInternalInventory() {
        return this.inventory;
    }

    public ISlotPickupWatcher getCrafter() {
        return this.inventory;
    }

    public int getAttributeScaled(int val, int maxVal, int pixels) {
        return val == 0 ? 0 : val * pixels / maxVal;
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }

    @Override
    public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
        return new ContainerAlvearyMutator(windowId, inv, this);
    }

    @Override
    public void load(CompoundTag compoundNBT) {
        super.load(compoundNBT);
        this.mutagenStorage = compoundNBT.getInt(MUTAGEN_STORAGE_STR);
        this.mutagenReserve = compoundNBT.getInt(MUTAGEN_RESERVE_STR);
    }

    @Override
    public void saveAdditional(CompoundTag compoundNBT) {
        super.saveAdditional(compoundNBT);
        compoundNBT.putInt(MUTAGEN_STORAGE_STR, this.mutagenStorage);
        compoundNBT.putInt(MUTAGEN_RESERVE_STR, this.mutagenReserve);
    }

    @Override
    public void saveNbt(CompoundTag compoundNBT) {
        super.saveNbt(compoundNBT);
        compoundNBT.putInt(MUTAGEN_STORAGE_STR, this.mutagenStorage);
        compoundNBT.putInt(MUTAGEN_RESERVE_STR, this.mutagenReserve);
    }

    // if the tile has anything in its inventory, or has any mutagen stored or being processed, it should store it when turned into an item.
    // energy should be ignored, it will cause inventory cluttering.
    @Override
    public void modifyItemNBT(ItemStack stack) {
        if (getMutagenReserve() > 0 || getMutagenStorage() > 0 || !getInternalInventory().isEmpty()) {
            CompoundTag tag = new CompoundTag();
            saveNbt(tag); // Save the BlockEntity data into tag
            stack.addTagElement(TileAlvearyMutator.ITEM_NBT_TAG, tag);
        }
    }

    @Override
    public void writeData(FriendlyByteBuf data) {
        data.writeVarInt(this.mutagenStorage);
        data.writeVarInt(this.mutagenReserve);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void readData(FriendlyByteBuf data) {
        this.mutagenStorage = data.readVarInt();
        this.mutagenReserve = data.readVarInt();
    }

    public void writeGuiData(FriendlyByteBuf data) {
        data.writeVarInt(this.mutagenStorage);
        data.writeVarInt(this.mutagenReserve);
        data.writeVarInt(this.getEnergyStorage().getEnergyStored());
    }

    @OnlyIn(Dist.CLIENT)
    public void readGuiData(FriendlyByteBuf data) {
        this.mutagenStorage = data.readVarInt();
        this.mutagenReserve = data.readVarInt();
        this.getEnergyStorage().setEnergyStored(data.readVarInt());
    }

    public static void modifyTooltip(List<Component> tooltip, ItemStack stack) {
        if (stack.hasTag() && stack.getTag().contains(TileAlvearyMutator.ITEM_NBT_TAG)) {
            CompoundTag mutatorData = stack.getTag().getCompound(TileAlvearyMutator.ITEM_NBT_TAG);

            // Extract mutagenReserve and mutagenStorage
            int mutagenStorage = mutatorData.getInt("storedMutagen");
            int storagePercent = (int)(mutagenStorage / (float) TileAlvearyMutator.getMutagenStorageCap() * 100);
            int mutagenCount = 0;
            ListTag items = mutatorData.getList("Items", Tag.TAG_COMPOUND);
            if (!items.isEmpty()) {
                mutagenCount = items.getCompound(SLOT_FRAME).getByte("Count");
            }

            // Add the extracted values to the tooltip
            tooltip.add(1, Component.literal("Mutagen Storage: ").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("[").withStyle(ChatFormatting.WHITE))
                    .append(Component.literal("|".repeat((storagePercent / 10) * 2)).withStyle(Style.EMPTY.withColor(0x79a66c)))
                    .append(Component.literal("|".repeat((10 - (storagePercent / 10)) * 2)).withStyle(ChatFormatting.DARK_GRAY))
                    .append(Component.literal("]").withStyle(ChatFormatting.WHITE))
                    .append(Component.literal(mutagenCount > 0 ? " + " + mutagenCount + "x" : "").withStyle(Style.EMPTY.withColor(0x79a66c))));
            tooltip.add(2, Component.empty());
        }
    }
}
