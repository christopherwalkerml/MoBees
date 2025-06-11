package com.noodlepfp.mobees.alveary.block;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileActivatable;
import com.noodlepfp.mobees.alveary.MoreBeesTilePowerable;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileAlvearyRainShield extends MoreBeesTilePowerable implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public boolean isSealed() {
            return getWorkingTime() > 0;
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
