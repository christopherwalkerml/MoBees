package com.noodlepfp.mobees.core.data.tag;

import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import forestry.api.ForestryTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import thedarkcolour.modkit.data.MKTagsProvider;

public class MoreBeesBlockTagsProvider {

    public static void addTags(MKTagsProvider<Block> tags) {
        tags.tag(MoreBeesTags.Blocks.FROGLIGHT).add(Blocks.OCHRE_FROGLIGHT).add(Blocks.PEARLESCENT_FROGLIGHT).add(Blocks.VERDANT_FROGLIGHT);

        tags.tag(ForestryTags.Blocks.MINEABLE_SCOOP).add(MoreBeesApicultureBlocks.BEEHIVE.blockArray());

        tags.tag(BlockTags.MINEABLE_WITH_AXE).add(MoreBeesApicultureBlocks.ALVEARY.blockArray());

        tags.tag(MoreBeesTags.Blocks.ROCKY_BEE_WALL).add(Blocks.STONE).add(Blocks.GRANITE).add(Blocks.ANDESITE).add(Blocks.DIORITE);
        tags.tag(MoreBeesTags.Blocks.ALPINE_HIVE_GROUNDS).add(Blocks.SNOW_BLOCK).add(Blocks.POWDER_SNOW).add(Blocks.PACKED_ICE);
        tags.tag(MoreBeesTags.Blocks.ROCKY_CAVE_REPLACEABLE).add(Blocks.STONE).add(Blocks.GRANITE).add(Blocks.ANDESITE).add(Blocks.DIORITE).add(Blocks.DIRT);

        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_STONE).addTag(Tags.Blocks.STONE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_COAL).addTag(Tags.Blocks.ORES_COAL);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_COPPER).addTag(Tags.Blocks.ORES_COPPER);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_TIN).addOptionalTag(MoreBeesTags.Blocks.F_ORE_TIN);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_ZINC).addOptionalTag(MoreBeesTags.Blocks.F_ORE_ZINC);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_LEAD).addOptionalTag(MoreBeesTags.Blocks.F_ORE_LEAD);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_NICKEL).addOptionalTag(MoreBeesTags.Blocks.F_ORE_NICKEL);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_OSMIUM).addOptionalTag(MoreBeesTags.Blocks.F_ORE_OSMIUM);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_ARDITE).addOptionalTag(MoreBeesTags.Blocks.F_ORE_ARDITE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_COBALT).addOptionalTag(MoreBeesTags.Blocks.F_ORE_COBALT);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_ALUMINUM).addOptionalTag(MoreBeesTags.Blocks.F_ORE_ALUMINUM);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_SILVER).addOptionalTag(MoreBeesTags.Blocks.F_ORE_SILVER);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_YELLORIUM).addOptionalTag(MoreBeesTags.Blocks.F_ORE_YELLORIUM);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_CERTUS_QUARTZ).addOptionalTag(MoreBeesTags.Blocks.F_ORE_CERTUS_QUARTZ);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_IRON).addTag(Tags.Blocks.ORES_IRON);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_GOLD).addTag(Tags.Blocks.ORES_GOLD);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_LAPIS).addTag(Tags.Blocks.ORES_LAPIS);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_REDSTONE).addTag(Tags.Blocks.ORES_REDSTONE);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_AMETHYST).add(Blocks.SMALL_AMETHYST_BUD, Blocks.MEDIUM_AMETHYST_BUD, Blocks.LARGE_AMETHYST_BUD, Blocks.AMETHYST_CLUSTER);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_DIAMOND).addTag(Tags.Blocks.ORES_DIAMOND);
        tags.tag(MoreBeesTags.Blocks.ROCK_FLOWERS_EMERALD).addTag(Tags.Blocks.ORES_EMERALD);
        tags.tag(MoreBeesTags.Blocks.FLOWERS_READABLE).addTag(Tags.Blocks.BOOKSHELVES).add(Blocks.CHISELED_BOOKSHELF);
    }
}
