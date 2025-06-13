package com.noodlepfp.mobees.alveary.block;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileActivatable;
import com.noodlepfp.mobees.alveary.MoreBeesTilePowerable;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.genetics.BeeLifeStage;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IIndividual;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.capability.IIndividualHandlerItem;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import static com.noodlepfp.mobees.alveary.MoreBeesBlockAlveary.LIGHT_LEVEL;
import static forestry.api.genetics.alleles.ForestryAlleles.ACTIVITY_DIURNAL;
import static forestry.api.genetics.alleles.ForestryAlleles.ACTIVITY_NOCTURNAL;

public class TileAlvearySun extends MoreBeesTilePowerable implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final BlockState state;
    private final BlockPos pos;

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public boolean isAlwaysActive(IGenome genome) {
            if (isActiveBeeDiurnal()) {
                // if active bee is diurnal, sun lamp will make bee always active
                return getWorkingTime() > 0;
            }
            return false;
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

    private boolean isActiveBeeDiurnal() {
        IIndividualHandlerItem handler = IIndividualHandlerItem.get(getBeeInventory().getQueen());

        if (handler != null && handler.getStage() == BeeLifeStage.QUEEN) {
            IIndividual queen = handler.getIndividual();
            IGenome genome = queen.getGenome();

            return genome.getActiveAllele(BeeChromosomes.ACTIVITY) == ACTIVITY_DIURNAL;
        }
        return false;
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }
}
