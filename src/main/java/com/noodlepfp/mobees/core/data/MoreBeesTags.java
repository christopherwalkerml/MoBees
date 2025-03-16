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

        // Flowers
        public static final TagKey<Block> ROCK_FLOWERS_STONE = blockTag("flowers/rock");
        public static final TagKey<Block> ROCK_FLOWERS_COAL = blockTag("flowers/coal");
        public static final TagKey<Block> ROCK_FLOWERS_COPPER = blockTag("flowers/copper");
        public static final TagKey<Block> ROCK_FLOWERS_IRON = blockTag("flowers/iron");
        public static final TagKey<Block> ROCK_FLOWERS_GOLD = blockTag("flowers/gold");
        public static final TagKey<Block> ROCK_FLOWERS_LAPIS = blockTag("flowers/lapis");
        public static final TagKey<Block> ROCK_FLOWERS_REDSTONE = blockTag("flowers/redstone");
        public static final TagKey<Block> ROCK_FLOWERS_AMETHYST = blockTag("flowers/amethyst");
        public static final TagKey<Block> ROCK_FLOWERS_DIAMOND = blockTag("flowers/diamond");
        public static final TagKey<Block> ROCK_FLOWERS_EMERALD = blockTag("flowers/emerald");
    }
}
