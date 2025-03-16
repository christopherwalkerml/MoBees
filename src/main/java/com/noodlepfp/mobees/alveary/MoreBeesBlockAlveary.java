package com.noodlepfp.mobees.alveary;

import com.noodlepfp.mobees.alveary.drain.TileAlvearyDrain;
import com.noodlepfp.mobees.alveary.mutator.TileAlvearyMutator;
import com.noodlepfp.mobees.alveary.sun.TileAlvearySun;
import forestry.apiculture.blocks.BlockAlveary;
import forestry.apiculture.blocks.BlockAlvearyType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class MoreBeesBlockAlveary extends BlockAlveary {

    private final MoreBeesBlockAlvearyType type;
    public MoreBeesBlockAlveary(MoreBeesBlockAlvearyType type) {
        super(BlockAlvearyType.PLAIN);
        this.type = type;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return switch (type) {
            case SUN -> new TileAlvearySun(pos, state);
            case DRAIN -> new TileAlvearyDrain(pos, state);
            case MUTATOR -> new TileAlvearyMutator(pos, state);
        };
    }
}
