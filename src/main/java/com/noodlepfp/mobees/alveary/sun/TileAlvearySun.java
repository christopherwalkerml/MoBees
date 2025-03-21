package com.noodlepfp.mobees.alveary.sun;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileActivatable;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.genetics.IGenome;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.energy.EnergyHelper;
import forestry.energy.EnergyTransferMode;
import forestry.energy.ForestryEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileAlvearySun extends MoreBeesTileActivatable implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public boolean isAlwaysActive(IGenome genome) {
            if (getWorkingTime() > 0) {
                return true;
            }
            return false;
        }
    };

    public TileAlvearySun(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.SUN, pos, state, "Shining", 1, 300);
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }
}
