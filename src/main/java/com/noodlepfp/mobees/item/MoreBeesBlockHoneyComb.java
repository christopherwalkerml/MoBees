package com.noodlepfp.mobees.item;

import forestry.apiculture.blocks.BlockHoneyComb;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.blocks.IColoredBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class MoreBeesBlockHoneyComb extends BlockHoneyComb {
    public final MoreBeesEnumHoneyComb type;

    public MoreBeesBlockHoneyComb(MoreBeesEnumHoneyComb type) {
        super(EnumHoneyComb.HONEY);
        this.type = type;
    }

    public MoreBeesEnumHoneyComb getMoreBeesType() {
        return type;
    }

    @OnlyIn(Dist.CLIENT)
    public int colorMultiplier(BlockState state, @Nullable BlockAndTintGetter level, @Nullable BlockPos pos, int tintIndex) {
        MoreBeesEnumHoneyComb honeyComb = this.type;
        return tintIndex == 1 ? honeyComb.primaryColor : honeyComb.secondaryColor;
    }
}

