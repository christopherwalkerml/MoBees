package com.noodlepfp.mobees.alveary.block;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileActivatable;
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
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileAlvearyMutator extends MoreBeesTileActivatable implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary>, IStreamable {
    private final InventoryAlvearyMutator inventory;
    private final int MUTAGEN_STORAGE_CAP = 5000;
    private final int MUTAGEN_RESERVE_CAP = 500;
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
        super.updateServer(tickCount);
        if (isActive()) {
            if (getMutagenReserve() == 0 && inventory.canUseMutagen()) {
                inventory.useMutagen();
                setMutagenReserve(MUTAGEN_RESERVE_CAP);
            } else {
                if (getMutagenReserve() > 0 && getMutagenStorage() < MUTAGEN_STORAGE_CAP) {
                    setMutagenReserve(getMutagenReserve() - 1);
                    setMutagenStorage(getMutagenStorage() + 1);
                }
            }
        }
    }

    public int getMutagenReserve() {
        return this.mutagenReserve;
    }

    public void setMutagenReserve(int amt) {
        this.mutagenReserve = amt;
    }

    public int getMutagenReserveCap() {
        return MUTAGEN_RESERVE_CAP;
    }

    public int getMutagenStorage() {
        return this.mutagenStorage;
    }

    public boolean canConsumeMutagen() {
        return this.mutagenStorage >= this.MUTAGEN_STORAGE_CAP / 2;
    }

    public void setMutagenStorage(int amt) {
        this.mutagenStorage = amt;
    }

    public int getMutagenStorageCap() {
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
    public static void modifyItemNBT(TileAlvearyMutator mutator, ItemStack stack) {
        if (mutator.getMutagenReserve() > 0 || mutator.getMutagenStorage() > 0 || !mutator.getInternalInventory().isEmpty()) {
            CompoundTag tag = new CompoundTag();
            mutator.saveNbt(tag); // Save the BlockEntity data into tag
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
}
