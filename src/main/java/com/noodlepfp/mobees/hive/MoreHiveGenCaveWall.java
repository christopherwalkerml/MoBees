package com.noodlepfp.mobees.hive;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;

import forestry.api.apiculture.hives.IHiveGen;
import forestry.core.utils.BlockUtil;

public class MoreHiveGenCaveWall implements IHiveGen {
    private final TagKey<Block> blocks;
    private final TagKey<Block> extraReplaceable;

    public MoreHiveGenCaveWall(TagKey<Block> blocks, TagKey<Block> extraReplaceable) {
        this.blocks = blocks;
        this.extraReplaceable = extraReplaceable;
    }

    @Override
    public @Nullable BlockPos getPosForHive(WorldGenLevel level, int posX, int posZ) {
        return null;
    }

    @Override
    public @Nullable BlockPos getPosForHive(WorldGenLevel level, RandomSource rand, int posX, int posZ) {
        // get to the ground
        int groundY = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, posX, posZ);
        int minBuildHeight = level.getMinBuildHeight();
        if (groundY == minBuildHeight) {
            return null;
        }

        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(posX, groundY, posZ);
        ArrayList<BlockPos> validPos = new ArrayList<>();

        BlockState blockState = level.getBlockState(pos);
        while (pos.getY() > minBuildHeight) {
            if (blockState.is(blocks) && canReplace(level.getBlockState(pos), level, pos)) {
                List<BlockPos> asides = List.of(pos.east(), pos.west(), pos.north(), pos.south());
                for (BlockPos aside : asides) {
                    if (level.getBlockState(aside).isAir()) {
                        System.out.println("here !");
                        validPos.add(aside);
                        break;
                    }
                }
            }
            pos.move(Direction.DOWN);
            blockState = level.getBlockState(pos);
        }
        final BlockPos hivePos = (!validPos.isEmpty() ? validPos.get(validPos.size() > 1 ? rand.nextInt(validPos.size()) : 0) : null);
        return hivePos;
    }

    @Override
    public boolean isValidLocation(WorldGenLevel level, BlockPos pos) {
        return level.getBlockState(pos.above()).is(blocks);
    }

    @Override
    public boolean canReplace(BlockState blockState, WorldGenLevel level, BlockPos pos) {
        return BlockUtil.canReplace(blockState, level, pos) || blockState.is(extraReplaceable);
    }
}
