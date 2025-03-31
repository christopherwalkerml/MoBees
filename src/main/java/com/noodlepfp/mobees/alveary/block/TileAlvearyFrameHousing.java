package com.noodlepfp.mobees.alveary.block;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlveary;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileAlveary;
import com.noodlepfp.mobees.gui.InventoryAlvearyFrameHousing;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class TileAlvearyFrameHousing extends MoreBeesTileAlveary implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final InventoryAlvearyFrameHousing inventory;

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public boolean isSealed() {
            return true;
        }
    };

    public TileAlvearyFrameHousing(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.FRAME_HOUSING, pos, state);
        this.inventory = new InventoryAlvearyFrameHousing(this);
    }

    public ISlotPickupWatcher getCrafter() {
        return this.inventory;
    }

    public Direction getDirection() {
        return this.getBlockState().getValue(MoreBeesBlockAlveary.FACING);
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }
}
