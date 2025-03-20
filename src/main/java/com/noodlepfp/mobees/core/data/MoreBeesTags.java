package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.MoBeesModCompat;
import com.noodlepfp.mobees.MoBeesModule;
import forestry.api.ForestryConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MoreBeesTags {

    private static final Random random = new Random();

    @ApiStatus.Internal
    public static TagKey<Block> blockTag(String name) {
        return BlockTags.create(MoBeesModule.mobees(name));
    }

    @ApiStatus.Internal
    public static TagKey<Item> itemTag(String name) {
        return ItemTags.create(MoBeesModule.mobees(name));
    }

    private static TagKey<Item> forgeTag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }

    public static class Blocks {
        public static final TagKey<Block> ROCKY_BEE_WALL = blockTag("hive_grounds/rocky");
        public static final TagKey<Block> ROCKY_CAVE_REPLACEABLE = blockTag("hive_grounds/rocky_cave_replaceable");
        public static final TagKey<Block> ALPINE_HIVE_GROUNDS = blockTag("hive_grounds/alpine");

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

    public static class Items {
        public static final TagKey<Item> FROGLIGHT = itemTag("froglight");

        public static final TagKey<Item> INGOTS_ZINC = forgeTag(MoBeesModCompat.ZINC.getModCompatTag());
        public static final TagKey<Item> INGOTS_TIN = forgeTag(MoBeesModCompat.TIN.getModCompatTag());
        public static final TagKey<Item> INGOTS_NICKEL = forgeTag(MoBeesModCompat.NICKEL.getModCompatTag());
        public static final TagKey<Item> INGOTS_SILVER = forgeTag(MoBeesModCompat.SILVER.getModCompatTag());
        public static final TagKey<Item> INGOTS_LEAD = forgeTag(MoBeesModCompat.LEAD.getModCompatTag());
        public static final TagKey<Item> INGOTS_OSMIUM = forgeTag(MoBeesModCompat.OSMIUM.getModCompatTag());
        public static final TagKey<Item> INGOTS_PLATINUM = forgeTag(MoBeesModCompat.PLATINUM.getModCompatTag());
        public static final TagKey<Item> INGOTS_YELLORIUM = forgeTag(MoBeesModCompat.YELLORIUM.getModCompatTag());
        public static final TagKey<Item> GEMS_CERTUS = forgeTag(MoBeesModCompat.CERTUS.getModCompatTag());
    }

    public static Item getRandomItemFromTag(String tagId) {
        TagKey<Item> tagKey = TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("forge", tagId));

        // Get all items under this tag
        Optional<List<Item>> tagItems = ForgeRegistries.ITEMS.tags().stream()
                .filter(tag -> tag.getKey().location().equals(tagKey.location()))
                .findFirst()
                .map(tag -> tag.stream().toList());

        // Select the first item if found
        if (tagItems.isPresent() && !tagItems.get().isEmpty()) {
            return tagItems.get().get(0);
        }

        // Default to air if no valid item found
        return ItemStack.EMPTY.getItem();
    }
}
