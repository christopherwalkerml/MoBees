package com.noodlepfp.mobees.core.data;

import forestry.api.ForestryTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import thedarkcolour.modkit.data.MKTagsProvider;

public class MoreBeesBlockTagsProvider {

    public static void addTags(MKTagsProvider<Block> tags) {
        tags.tag(MoreBeesTags.Blocks.ROCKY_BEE_WALL).add(Blocks.MOSS_BLOCK).add(Blocks.ROOTED_DIRT);
        tags.tag(MoreBeesTags.Blocks.ROCKY_CAVE_REPLACEABLE).add(Blocks.STONE).add(Blocks.GRANITE).add(Blocks.ANDESITE).add(Blocks.DIORITE);
    }

}
