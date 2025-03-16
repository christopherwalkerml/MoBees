package com.noodlepfp.mobees.alveary.mutator;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileActivatable;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutation;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.energy.EnergyHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileAlvearyMutator extends MoreBeesTileActivatable implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public float modifyMutationChance(IGenome genome, IGenome mate, IMutation<IBeeSpecies> mutation, float currentChance) {
            if (getWorkingTime() > 0) {
                return Math.min(currentChance * 1.5f, 5.0f);
            }
            return 1.0f;
        }
    };

    public TileAlvearyMutator(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.MUTATOR, pos, state, "Mutating", 1, 200);
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }
}
