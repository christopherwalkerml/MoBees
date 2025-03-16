package com.noodlepfp.mobees.alveary.rainshield;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileActivatable;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileAlvearyRainShield extends MoreBeesTileActivatable implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public boolean isSealed() {
            if (getWorkingTime() > 0) {
                return true;
            }
            return false;
        }
    };

    public TileAlvearyRainShield(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.RAINSHIELD, pos, state, "Rainproofing", 1, 200);
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }
}
