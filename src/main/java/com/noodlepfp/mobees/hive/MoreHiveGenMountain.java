package com.noodlepfp.mobees.hive;

import forestry.api.apiculture.hives.IHiveGen;
import forestry.core.utils.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MoreHiveGenMountain implements IHiveGen {
    private final TagKey<Block> blocks;

    public MoreHiveGenMountain(TagKey<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public BlockPos getPosForHive(WorldGenLevel level, int posX, int posZ) {
        // get to the ground
        int groundY = level.getHeight(getHeightmapType(), posX, posZ);
        int minBuildHeight = level.getMinBuildHeight();

        if (groundY == minBuildHeight) {
            return null;
        }

        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(posX, groundY, posZ);

        BlockState blockState = level.getBlockState(pos);
        while (canReplace(blockState, level, pos)) {
            pos.move(Direction.DOWN);
            if (pos.getY() < 128) {
                return null;
            }
            blockState = level.getBlockState(pos);
        }
        return pos.above();
    }

    public Heightmap.Types getHeightmapType() {
        return Heightmap.Types.WORLD_SURFACE_WG;
    }

    @Override
    public boolean canReplace(BlockState blockState, WorldGenLevel world, BlockPos pos) {
        return IHiveGen.isTreeBlock(blockState) || BlockUtil.canReplace(blockState, world, pos);
    }

    @Override
    public boolean isValidLocation(WorldGenLevel world, BlockPos pos) {
        BlockState groundBlockState = world.getBlockState(pos.below());
        return groundBlockState.is(blocks);
    }
}
