package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.MoBeesModule;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

public class MoreBeesTags {

    @ApiStatus.Internal
    public static TagKey<Block> blockTag(String name) {
        return BlockTags.create(MoBeesModule.mobees(name));
    }

    public static class Blocks {
        public static final TagKey<Block> ROCKY_BEE_WALL = blockTag("hive_grounds/rocky");
        public static final TagKey<Block> ROCKY_CAVE_REPLACEABLE = blockTag("hive_grounds/rocky_cave_replaceable");
    }
}
