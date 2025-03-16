package com.noodlepfp.mobees.core.data;

import forestry.api.ForestryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import thedarkcolour.modkit.data.MKTagsProvider;

public class MoreBeesBlockTagsProvider {

    public static void addTags(MKTagsProvider<Block> tags, HolderLookup.Provider lookup) {
        tags.tag(MoreBeesTags.Blocks.ROCKY_BEE_WALL).add(Blocks.STONE).add(Blocks.GRANITE).add(Blocks.ANDESITE).add(Blocks.DIORITE);
        tags.tag(MoreBeesTags.Blocks.ROCKY_CAVE_REPLACEABLE).add(Blocks.STONE).add(Blocks.GRANITE).add(Blocks.ANDESITE).add(Blocks.DIORITE).add(Blocks.DIRT);

        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_STONE).add(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.COBBLESTONE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_COAL).add(Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_COPPER).add(Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_IRON).add(Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_GOLD).add(Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_LAPIS).add(Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_REDSTONE).add(Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_AMETHYST).add(Blocks.SMALL_AMETHYST_BUD, Blocks.MEDIUM_AMETHYST_BUD, Blocks.LARGE_AMETHYST_BUD, Blocks.AMETHYST_CLUSTER);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_DIAMOND).add(Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_EMERALD).add(Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE);
    }

}
