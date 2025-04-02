package com.noodlepfp.mobees.alveary;

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

public class MoreBeesTileActivatable extends MoreBeesTileAlveary implements IActivatable, IAlvearyComponent.Active<MultiblockLogicAlveary> {

    private final ForestryEnergyStorage energyStorage;
    private final LazyOptional<ForestryEnergyStorage> energyCap;

    private int workingTime = 0;
    private int ticksPerOp;
    private int fePerOp;
    private final String actionVerb;

    public MoreBeesTileActivatable(MoreBeesBlockAlvearyType blockType, BlockPos pos, BlockState state, String actionVerb, int ticksPerOp, int fePerOp) {
        super(blockType, pos, state);

        this.ticksPerOp = ticksPerOp;
        this.fePerOp = fePerOp;
        this.actionVerb = actionVerb;
        this.energyStorage = new ForestryEnergyStorage(1000, 2000, EnergyTransferMode.RECEIVE);
        this.energyCap = LazyOptional.of(() -> this.energyStorage);
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public ForestryEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    @Override
    public void updateServer(int tickCount) {
        if (workingTime < 20 && EnergyHelper.consumeEnergyToDoWork(getEnergyStorage(), ticksPerOp, fePerOp)) {
            // one tick of work for every 20 RF
            workingTime += fePerOp / 10;
        }
        if (workingTime > 0) {
            workingTime--;
            setActive(true);
        } else {
            setActive(false);
        }
    }

    @Override
    public void updateClient(int tickCount) {
    }

    /* LOADING & SAVING */
    @Override
    public void load(CompoundTag compoundNBT) {
        super.load(compoundNBT);
        energyStorage.read(compoundNBT);
        workingTime = compoundNBT.getInt(actionVerb);
    }

    @Override
    public void saveAdditional(CompoundTag compoundNBT) {
        super.saveAdditional(compoundNBT);
        energyStorage.write(compoundNBT);
        compoundNBT.putInt(actionVerb, workingTime);
    }

    public void saveNbt(CompoundTag compoundNBT) {
        energyStorage.write(compoundNBT);
        compoundNBT.putInt(actionVerb, workingTime);
        this.getInternalInventory().write(compoundNBT);
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
