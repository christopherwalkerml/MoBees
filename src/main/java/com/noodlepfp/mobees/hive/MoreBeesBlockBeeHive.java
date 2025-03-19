/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges, Chris Walker (noodlepfp)
 ******************************************************************************/

package com.noodlepfp.mobees.hive;

import com.noodlepfp.mobees.feature.MoreBeesApicultureTiles;
import forestry.apiculture.blocks.BlockBeeHive;
import forestry.apiculture.features.ApicultureTiles;
import forestry.apiculture.tiles.TileHive;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class MoreBeesBlockBeeHive extends BlockBeeHive {

    public MoreBeesBlockBeeHive(MoreBeesBlockHiveType type) {
        super(type.getSpeciesId());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> actualType) {
        return actualType != MoreBeesApicultureTiles.HIVE.tileType() ? null : (level1, pos, state1, t) -> ((MoreBeesTileHive) t).tick(level1);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreBeesTileHive(pos, state);
    }
}
