package com.noodlepfp.mobees.hive;

import com.noodlepfp.mobees.feature.MoreBeesApicultureTiles;
import forestry.apiculture.features.ApicultureTiles;
import forestry.apiculture.tiles.TileHive;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MoreBeesTileHive extends TileHive {

    public MoreBeesTileHive(BlockPos pos, BlockState state) {
        super(MoreBeesApicultureTiles.HIVE.tileType(), pos, state);
    }

    @Override
    public void tick(Level level) {
        super.tick(level);
    }
}
