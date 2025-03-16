package com.noodlepfp.mobees.alveary.mutator;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileAlveary;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutation;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.apiculture.multiblock.TileAlveary;
import forestry.core.tiles.IActivatable;
import forestry.energy.EnergyTransferMode;
import forestry.energy.ForestryEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;

public class TileAlvearyMutator extends MoreBeesTileAlveary implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final ForestryEnergyStorage energyStorage;
    private final LazyOptional<ForestryEnergyStorage> energyCap;


    private static final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public float modifyMutationChance(IGenome genome, IGenome mate, IMutation<IBeeSpecies> mutation, float currentChance) {
            return currentChance * 2;
        }
    };

    public TileAlvearyMutator(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.MUTATOR, pos, state);

        this.energyStorage = new ForestryEnergyStorage(1000, 2000, EnergyTransferMode.RECEIVE);
        this.energyCap = LazyOptional.of(() -> this.energyStorage);
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }
}
