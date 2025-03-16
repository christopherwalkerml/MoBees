package com.noodlepfp.mobees.alveary.drain;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileAlveary;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.blocks.BlockAlveary;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.core.tiles.IActivatable;
import forestry.energy.EnergyHelper;
import forestry.energy.EnergyTransferMode;
import forestry.energy.ForestryEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nullable;

public class TileAlvearyDrain extends MoreBeesTileAlveary implements IActivatable, IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {


    private static final int TICKS_PER_CYCLE = 1;
    private static final int FE_PER_OPERATION = 100;

    private final ForestryEnergyStorage energyStorage;
    private final LazyOptional<ForestryEnergyStorage> energyCap;

    private int workingTime = 0;

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public boolean isSealed() {
            if (workingTime < 20 && EnergyHelper.consumeEnergyToDoWork(energyStorage, TICKS_PER_CYCLE, FE_PER_OPERATION)) {
                // one tick of work for every 20 RF
                workingTime += FE_PER_OPERATION / 20;
            }

            if (workingTime > 0) {
                workingTime--;
                return true;
            }
            return false;
        }
    };

    public TileAlvearyDrain(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.SUN, pos, state);

        this.energyStorage = new ForestryEnergyStorage(1000, 2000, EnergyTransferMode.RECEIVE);
        this.energyCap = LazyOptional.of(() -> this.energyStorage);
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }

    /* LOADING & SAVING */
    @Override
    public void load(CompoundTag compoundNBT) {
        super.load(compoundNBT);
        energyStorage.read(compoundNBT);
        workingTime = compoundNBT.getInt("Heating");
    }

    @Override
    public void saveAdditional(CompoundTag compoundNBT) {
        super.saveAdditional(compoundNBT);
        energyStorage.write(compoundNBT);
        compoundNBT.putInt("Heating", workingTime);
    }

    /* Network */
    @Override
    protected void encodeDescriptionPacket(CompoundTag packetData) {
        super.encodeDescriptionPacket(packetData);
    }

    @Override
    protected void decodeDescriptionPacket(CompoundTag packetData) {
        super.decodeDescriptionPacket(packetData);
    }

    /* IActivatable */
    @Override
    public boolean isActive() {
        return getBlockState().getValue(BlockAlveary.STATE) == BlockAlveary.State.ON;
    }

    @Override
    public void setActive(boolean active) {
        if (isActive() != active) {
            this.level.setBlockAndUpdate(this.worldPosition, getBlockState().setValue(BlockAlveary.STATE, active ? BlockAlveary.State.ON : BlockAlveary.State.OFF));
        }
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (!remove && capability == ForgeCapabilities.ENERGY) {
            return energyCap.cast();
        }
        return super.getCapability(capability, facing);
    }
}
