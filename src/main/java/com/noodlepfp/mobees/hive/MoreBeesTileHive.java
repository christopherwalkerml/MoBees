package com.noodlepfp.mobees.hive;

import forestry.apiculture.features.ApicultureTiles;
import forestry.apiculture.tiles.TileHive;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MoreBeesTileHive extends TileHive {

    public MoreBeesTileHive(BlockPos pos, BlockState state) {
        super(ApicultureTiles.HIVE.tileType(), pos, state);
    }

}
