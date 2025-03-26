package com.noodlepfp.mobees.alveary;

import com.noodlepfp.mobees.alveary.rainshield.TileAlvearyRainShield;
import com.noodlepfp.mobees.alveary.mutator.TileAlvearyMutator;
import com.noodlepfp.mobees.alveary.sun.TileAlvearySun;
import forestry.apiculture.blocks.BlockAlveary;
import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.multiblock.TileAlveary;
import forestry.core.tiles.IActivatable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nullable;
import java.util.List;

public class MoreBeesBlockAlveary extends BlockAlveary {
    public static final IntegerProperty LIGHT_LEVEL = IntegerProperty.create("light_level", 0, 15);

    private final MoreBeesBlockAlvearyType type;
    public MoreBeesBlockAlveary(MoreBeesBlockAlvearyType type) {
        super(BlockAlvearyType.PLAIN);
        this.type = type;

        BlockState defaultState = this.getStateDefinition().any();
        if (type == MoreBeesBlockAlvearyType.SUN) {
            defaultState = defaultState.setValue(STATE, State.OFF);
            defaultState = defaultState.setValue(LIGHT_LEVEL, 0);
        } else {
            defaultState = defaultState.setValue(STATE, State.OFF);
        }
        this.registerDefaultState(defaultState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIGHT_LEVEL);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return switch (type) {
            case SUN -> new TileAlvearySun(pos, state);
            case RAINSHIELD -> new TileAlvearyRainShield(pos, state);
            case MUTATOR -> new TileAlvearyMutator(pos, state);
        };
    }

    @Override
    public BlockState getNewState(TileAlveary tile) {
        BlockState state = super.getNewState(tile);

        if (tile instanceof TileAlvearySun sun) {
            state = state.setValue(LIGHT_LEVEL, sun.getLightLevel());
        }
        return state;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.hasProperty(LIGHT_LEVEL)) {
            return state.getValue(LIGHT_LEVEL);
        }
        return super.getLightEmission(state, world, pos);
    }
}
