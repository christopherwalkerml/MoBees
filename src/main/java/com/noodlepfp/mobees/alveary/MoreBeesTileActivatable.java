package com.noodlepfp.mobees.alveary;

import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.blocks.BlockAlveary;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.core.tiles.IActivatable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;

public class MoreBeesTileActivatable extends MoreBeesTileAlveary implements IActivatable, IAlvearyComponent.Active<MultiblockLogicAlveary> {

    public MoreBeesTileActivatable(MoreBeesBlockAlvearyType blockType, BlockPos pos, BlockState state) {
        super(blockType, pos, state);
    }

    @Override
    public void updateServer(int tickCount) {
    }

    @Override
    public void updateClient(int tickCount) {
    }

    /* LOADING & SAVING */
    @Override
    public void load(CompoundTag compoundNBT) {
        super.load(compoundNBT);
    }

    @Override
    public void saveAdditional(CompoundTag compoundNBT) {
        super.saveAdditional(compoundNBT);
    }

    public void saveNbt(CompoundTag compoundNBT) {
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
}
