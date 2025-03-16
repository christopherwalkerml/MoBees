package com.noodlepfp.mobees.alveary;

import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import forestry.apiculture.multiblock.TileAlveary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class MoreBeesTileAlveary extends TileAlveary {

    public MoreBeesTileAlveary(MoreBeesBlockAlvearyType type, BlockPos pos, BlockState state) {
        super(type.getTileType().tileType(), MoreBeesApicultureBlocks.ALVEARY.get(type).getTranslationKey(), pos, state);
    }

}
