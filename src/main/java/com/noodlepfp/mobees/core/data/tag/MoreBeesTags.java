package com.noodlepfp.mobees.core.data.tag;

import com.noodlepfp.mobees.MoBeesModule;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

public class MoreBeesTags {

    @ApiStatus.Internal
    public static TagKey<Block> blockTag(String name) {
        return BlockTags.create(MoBeesModule.mobees(name));
    }

    @ApiStatus.Internal
    public static TagKey<Item> itemTag(String name) {
        return ItemTags.create(MoBeesModule.mobees(name));
    }

    private static TagKey<Item> forgeItemTag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }

    private static TagKey<Block> forgeBlockTag(String name) {
        return BlockTags.create(new ResourceLocation("forge", name));
    }

    public static class Blocks {
        public static final TagKey<Block> FROGLIGHT = blockTag("froglight");
        public static final TagKey<Block> ROCKY_BEE_WALL = blockTag("hive_grounds/rocky");
        public static final TagKey<Block> ROCKY_CAVE_REPLACEABLE = blockTag("hive_grounds/rocky_cave_replaceable");
        public static final TagKey<Block> ALPINE_HIVE_GROUNDS = blockTag("hive_grounds/alpine");

        // Flowers
        public static final TagKey<Block> ROCK_FLOWERS_STONE = blockTag("flowers/rock");
        public static final TagKey<Block> ROCK_FLOWERS_COAL = blockTag("flowers/coal");
        public static final TagKey<Block> ROCK_FLOWERS_COPPER = blockTag("flowers/copper");
        public static final TagKey<Block> ROCK_FLOWERS_TIN = blockTag("flowers/tin");
        public static final TagKey<Block> ROCK_FLOWERS_LEAD = blockTag("flowers/lead");
        public static final TagKey<Block> ROCK_FLOWERS_ZINC = blockTag("flowers/zinc");
        public static final TagKey<Block> ROCK_FLOWERS_NICKEL = blockTag("flowers/nickel");
        public static final TagKey<Block> ROCK_FLOWERS_ALUMINUM = blockTag("flowers/aluminum");
        public static final TagKey<Block> ROCK_FLOWERS_SILVER = blockTag("flowers/silver");
        public static final TagKey<Block> ROCK_FLOWERS_OSMIUM = blockTag("flowers/osmium");
        public static final TagKey<Block> ROCK_FLOWERS_COBALT = blockTag("flowers/cobalt");
        public static final TagKey<Block> ROCK_FLOWERS_YELLORIUM = blockTag("flowers/yellorium");
        public static final TagKey<Block> ROCK_FLOWERS_CERTUS_QUARTZ = blockTag("flowers/certus_quartz");
        public static final TagKey<Block> ROCK_FLOWERS_IRON = blockTag("flowers/iron");
        public static final TagKey<Block> ROCK_FLOWERS_GOLD = blockTag("flowers/gold");
        public static final TagKey<Block> ROCK_FLOWERS_LAPIS = blockTag("flowers/lapis");
        public static final TagKey<Block> ROCK_FLOWERS_REDSTONE = blockTag("flowers/redstone");
        public static final TagKey<Block> ROCK_FLOWERS_AMETHYST = blockTag("flowers/amethyst");
        public static final TagKey<Block> ROCK_FLOWERS_DIAMOND = blockTag("flowers/diamond");
        public static final TagKey<Block> ROCK_FLOWERS_EMERALD = blockTag("flowers/emerald");
        public static final TagKey<Block> FLOWERS_READABLE = blockTag("flowers/readable");

        // Mod Compat Ores
        public static final TagKey<Block> F_ORE_TIN = forgeBlockTag("ores/tin");
        public static final TagKey<Block> F_ORE_NICKEL = forgeBlockTag("ores/nickel");
        public static final TagKey<Block> F_ORE_LEAD = forgeBlockTag("ores/lead");
        public static final TagKey<Block> F_ORE_ZINC = forgeBlockTag("ores/zinc");
        public static final TagKey<Block> F_ORE_OSMIUM = forgeBlockTag("ores/osmium");
        public static final TagKey<Block> F_ORE_COBALT = forgeBlockTag("ores/cobalt");
        public static final TagKey<Block> F_ORE_ALUMINUM = forgeBlockTag("ores/aluminum");
        public static final TagKey<Block> F_ORE_SILVER = forgeBlockTag("ores/silver");
        public static final TagKey<Block> F_ORE_CERTUS_QUARTZ = forgeBlockTag("ores/certus_quartz");
        public static final TagKey<Block> F_ORE_YELLORIUM = forgeBlockTag("ores/yellorium");
    }

    public static class Items {
        public static final TagKey<Item> FROGLIGHT = itemTag("froglight");

        public static final TagKey<Item> BEE_FRAME = itemTag("bee_frame");
    }
}
