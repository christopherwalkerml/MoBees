package com.noodlepfp.mobees.alveary.block;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileActivatable;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.genetics.IGenome;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import static com.noodlepfp.mobees.alveary.MoreBeesBlockAlveary.LIGHT_LEVEL;

public class TileAlvearySun extends MoreBeesTileActivatable implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final BlockState state;
    private final BlockPos pos;

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public boolean isAlwaysActive(IGenome genome) {
            return getWorkingTime() > 0;
        }
    };

    public TileAlvearySun(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.SUN, pos, state, "Shining", 1, 300);
        this.state = state;
        this.pos = pos;
    }

    @Override
    public void updateServer(int tickCount) {
        super.updateServer(tickCount);
        if (super.isActive()) {
            if (getLightLevel() == 0) {
                this.level.setBlockAndUpdate(pos, state.setValue(LIGHT_LEVEL, 12));
            }
        } else {
            if (getLightLevel() != 0) {
                this.level.setBlockAndUpdate(pos, state.setValue(LIGHT_LEVEL, 0));
            }
        }
    }

    public int getLightLevel() {
        return getBlockState().getValue(LIGHT_LEVEL);
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }
}
