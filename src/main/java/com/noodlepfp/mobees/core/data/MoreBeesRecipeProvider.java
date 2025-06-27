package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.MoBeesEnumModCompat;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.core.data.tag.MoreBeesTags;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.feature.MoreBeesCrateItems;
import com.noodlepfp.mobees.feature.MoreBeesItems;
import com.noodlepfp.mobees.item.*;
import forestry.apiculture.blocks.BlockAlveary;
import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.features.ApicultureBlocks;
import forestry.apiculture.features.ApicultureItems;
import forestry.core.config.Constants;
import forestry.core.data.builder.CarpenterRecipeBuilder;
import forestry.core.data.builder.CentrifugeRecipeBuilder;
import forestry.core.data.builder.FabricatorRecipeBuilder;
import forestry.core.features.CoreItems;
import forestry.core.fluids.ForestryFluids;
import forestry.core.items.definitions.EnumCraftingMaterial;
import forestry.core.items.definitions.EnumElectronTube;
import forestry.core.utils.ModUtil;
import forestry.modules.features.FeatureItem;
import forestry.storage.features.CrateItems;
import forestry.storage.items.ItemCrated;
import it.unimi.dsi.fastutil.objects.ObjectIntPair;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.RegistryObject;
import thedarkcolour.modkit.data.MKRecipeProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MoreBeesRecipeProvider {

    public static void addRecipes(Consumer<FinishedRecipe> consumer, MKRecipeProvider recipes) {
        registerApicultureRecipes(recipes);
        registerMaterials(recipes);
        registerModCompatRecipes(recipes);
        registerCarpenter(consumer);
        registerFabricator(consumer);
        registerCentrifuge(consumer);
    }

    private static void registerApicultureRecipes(MKRecipeProvider recipes) {
        registerCombRecipes(recipes);

        BlockAlveary plain = ApicultureBlocks.ALVEARY.get(BlockAlvearyType.PLAIN).block();
        ItemLike goldElectronTube = CoreItems.ELECTRON_TUBES.get(EnumElectronTube.GOLD);
        ItemLike lapisElectronTube = CoreItems.ELECTRON_TUBES.get(EnumElectronTube.LAPIS);
        ItemLike emeraldElectronTube = CoreItems.ELECTRON_TUBES.get(EnumElectronTube.EMERALD);
        ItemLike diamondElectronTube = CoreItems.ELECTRON_TUBES.get(EnumElectronTube.DIAMOND);

        recipes.shapedCrafting(RecipeCategory.BUILDING_BLOCKS, MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.SUN).block(), recipe -> {
            recipe.define('#', goldElectronTube);
            recipe.define('G', Items.GLASS);
            recipe.define('F', Ingredient.of(MoreBeesTags.Items.FROGLIGHT));
            recipe.define('X', plain);
            recipe.pattern("#X#");
            recipe.pattern("GFG");
            recipe.pattern("#X#");
            recipe.group("alveary");
        });

        recipes.shapedCrafting(RecipeCategory.BUILDING_BLOCKS, MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.RAINSHIELD).block(), recipe -> {
            recipe.define('#', lapisElectronTube);
            recipe.define('G', Items.GLASS);
            recipe.define('S', Items.SPONGE);
            recipe.define('X', plain);
            recipe.pattern("#X#");
            recipe.pattern("GSG");
            recipe.pattern("#X#");
            recipe.group("alveary");
        });

        recipes.shapedCrafting(RecipeCategory.BUILDING_BLOCKS, MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MUTATOR).block(), recipe -> {
            recipe.define('#', emeraldElectronTube);
            recipe.define('R', Items.REDSTONE_BLOCK);
            recipe.define('C', MoreBeesItems.CRAFTING_MATERIALS.get(MoreBeesEnumCraftingMaterial.MUTATION_CATALYST));
            recipe.define('X', plain);
            recipe.pattern("#X#");
            recipe.pattern("RCR");
            recipe.pattern("#X#");
            recipe.group("alveary");
        });

        recipes.shapedCrafting(RecipeCategory.BUILDING_BLOCKS, MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.FRAME_HOUSING).block(), recipe -> {
            recipe.define('#', diamondElectronTube);
            recipe.define('W', CoreItems.CRAFTING_MATERIALS.get(EnumCraftingMaterial.SCENTED_PANELING));
            recipe.define('C', ApicultureItems.FRAME_IMPREGNATED);
            recipe.define('X', plain);
            recipe.pattern("#X#");
            recipe.pattern("WCW");
            recipe.pattern("#X#");
            recipe.group("alveary");
        });

        recipes.shapedCrafting(RecipeCategory.MISC, MoreBeesApicultureItems.FRAME_PRESERVATION, recipe -> {
            recipe.define('#', MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.ARCANE_WAX));
            recipe.define('X', ApicultureItems.ROYAL_JELLY);
            recipe.define('A', ApicultureItems.FRAME_UNTREATED);
            recipe.pattern("#X#");
            recipe.pattern("XAX");
            recipe.pattern("#X#");
        });

        recipes.shapedCrafting(RecipeCategory.MISC, MoreBeesApicultureItems.FRAME_CRIMSON, recipe -> {
            recipe.define('#', MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.ARCANE_WAX));
            recipe.define('X', Tags.Items.CROPS_NETHER_WART);
            recipe.define('A', ApicultureItems.FRAME_UNTREATED);
            recipe.pattern("#X#");
            recipe.pattern("XAX");
            recipe.pattern("#X#");
        });

        recipes.shapedCrafting(RecipeCategory.MISC, MoreBeesApicultureItems.FRAME_MUTATION, recipe -> {
            recipe.define('#', CoreItems.CRAFTING_MATERIALS.get(EnumCraftingMaterial.BEESWAX));
            recipe.define('X', MoreBeesItems.CRAFTING_MATERIALS.get(MoreBeesEnumCraftingMaterial.MUTAGEN));
            recipe.define('A', ApicultureItems.FRAME_UNTREATED);
            recipe.pattern("#X#");
            recipe.pattern("XAX");
            recipe.pattern("#X#");
        });

        recipes.shapedCrafting(RecipeCategory.MISC, MoreBeesApicultureItems.FRAME_DESTRUCTION, recipe -> {
            recipe.define('#', MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.SOUL_WAX));
            recipe.define('X', Tags.Items.OBSIDIAN);
            recipe.define('A', ApicultureItems.FRAME_UNTREATED);
            recipe.pattern("#X#");
            recipe.pattern("XAX");
            recipe.pattern("#X#");
        });

        recipes.shapedCrafting(RecipeCategory.MISC, MoreBeesApicultureItems.FRAME_FERTILE, recipe -> {
            recipe.define('#', MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.SOUL_WAX));
            recipe.define('X', ApicultureItems.ROYAL_JELLY);
            recipe.define('A', ApicultureItems.FRAME_UNTREATED);
            recipe.pattern("#X#");
            recipe.pattern("XAX");
            recipe.pattern("#X#");
        });

        recipes.shapedCrafting(RecipeCategory.MISC, MoreBeesApicultureItems.FRAME_KIND, recipe -> {
            recipe.define('#', MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.SOUL_WAX));
            recipe.define('X', ApicultureItems.HONEY_DROP);
            recipe.define('A', ApicultureItems.FRAME_UNTREATED);
            recipe.pattern("#X#");
            recipe.pattern("XAX");
            recipe.pattern("#X#");
        });
    }

    private static void registerMaterials(MKRecipeProvider recipes) {
        recipes.shapelessCrafting("mutagen_crafting", RecipeCategory.MISC, MoreBeesItems.CRAFTING_MATERIALS.get(MoreBeesEnumCraftingMaterial.MUTAGEN), 2,
                Tags.Items.DUSTS_GLOWSTONE, MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.ARCANE_WAX), Tags.Items.CROPS);

        recipes.shapelessCrafting("copper_ingot_from_bits", RecipeCategory.MISC, Items.COPPER_INGOT, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.COPPER_BIT), 8));

        recipes.shapelessCrafting("coal_from_bits", RecipeCategory.MISC, Items.COAL, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.COAL_BIT), 8));

        recipes.shapelessCrafting("iron_ingot_from_bits", RecipeCategory.MISC, Items.IRON_INGOT, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.IRON_BIT), 8));

        recipes.shapelessCrafting("gold_ingot_from_bits", RecipeCategory.MISC, Items.GOLD_INGOT, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.GOLD_BIT), 8));

        recipes.shapelessCrafting("emerald_shard_from_bits", RecipeCategory.MISC, Items.EMERALD, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.EMERALD_SHARD), 8));

        recipes.shapelessCrafting("diamond_shard_from_bits", RecipeCategory.MISC, Items.DIAMOND, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.DIAMOND_SHARD), 8));

        recipes.shapelessCrafting("netherite_scrap_from_bits", RecipeCategory.MISC, Items.NETHERITE_SCRAP, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.NETHERITE_BIT), 8));

        recipes.shapelessCrafting("apatite_from_bits", RecipeCategory.MISC, CoreItems.APATITE, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.APATITE_BIT), 8));

        recipes.shapelessCrafting("tin_from_bits", RecipeCategory.MISC, CoreItems.INGOT_TIN, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.TIN_BIT), 8));

        recipes.shapelessCrafting("wither_partial_from_bits", RecipeCategory.MISC, MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.WITHER_SKULL_PARTIAL), 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.WITHER_SKULL_BIT), 8));

        recipes.shapelessCrafting("wither_skull_from_bits", RecipeCategory.MISC, Items.WITHER_SKELETON_SKULL, 1,
                ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(MoreBeesEnumBeeProduce.WITHER_SKULL_PARTIAL), 8));
    }

    private static void registerModCompatRecipes(MKRecipeProvider recipes) {
        registerModCompatBitRecipe(recipes, "lead_from_bits", MoBeesEnumModCompat.LEAD, MoreBeesEnumBeeProduce.LEAD_BIT);

        registerModCompatBitRecipe(recipes, "nickel_from_bits", MoBeesEnumModCompat.NICKEL, MoreBeesEnumBeeProduce.NICKEL_BIT);

        registerModCompatBitRecipe(recipes, "zinc_from_bits", MoBeesEnumModCompat.ZINC, MoreBeesEnumBeeProduce.ZINC_BIT);

        registerModCompatBitRecipe(recipes, "silver_from_bits", MoBeesEnumModCompat.SILVER, MoreBeesEnumBeeProduce.SILVER_BIT);

        registerModCompatBitRecipe(recipes, "osmium_from_bits", MoBeesEnumModCompat.OSMIUM, MoreBeesEnumBeeProduce.OSMIUM_BIT);

        registerModCompatBitRecipe(recipes, "aluminum_from_bits", MoBeesEnumModCompat.ALUMINUM, MoreBeesEnumBeeProduce.ALUMINUM_BIT);

        registerModCompatBitRecipe(recipes, "yellorium_from_bits", MoBeesEnumModCompat.YELLORIUM, MoreBeesEnumBeeProduce.YELLORIUM_BIT);

        registerModCompatBitRecipe(recipes, "certus_from_bits", MoBeesEnumModCompat.CERTUS, MoreBeesEnumBeeProduce.CERTUS_BIT);

        registerModCompatBitRecipe(recipes, "cobalt_from_bits", MoBeesEnumModCompat.COBALT, MoreBeesEnumBeeProduce.COBALT_BIT);
    }

    private static void registerModCompatBitRecipe(MKRecipeProvider recipes, String recipeId, MoBeesEnumModCompat compatItem, MoreBeesEnumBeeProduce produce) {
        Map<String, RegistryObject<Item>> itemLibrary = compatItem.getItemLibrary();

        for (String modKey : itemLibrary.keySet()) {
            RegistryObject<Item> result = itemLibrary.get(modKey);
            if (result != null && result.isPresent()) {
                recipes.shapelessCrafting(recipeId + "_" + modKey, RecipeCategory.MISC, itemLibrary.get(modKey).get(), 1,
                        ObjectIntPair.of(MoreBeesItems.BEE_PRODUCE_MATERIALS.item(produce), 8));
            }
        }
    }

    private static void registerCombRecipes(MKRecipeProvider recipes) {
        for (MoreBeesEnumHoneyComb honeyComb : MoreBeesEnumHoneyComb.VALUES) {
            ItemLike comb = MoreBeesApicultureItems.BEE_COMBS.get(honeyComb);
            Block combBlock = MoreBeesApicultureBlocks.BEE_COMB.get(honeyComb).block();
            recipes.grid2x2(RecipeCategory.BUILDING_BLOCKS, combBlock, 1, Ingredient.of(comb), "combs");
        }
    }

    private static void crate(Consumer<FinishedRecipe> consumer, ItemCrated crated, Ingredient ingredient) {
        ItemStack contained = crated.getContained();
        ResourceLocation name = ModUtil.getRegistryName(contained.getItem());

        new CarpenterRecipeBuilder()
                .setPackagingTime(Constants.CARPENTER_CRATING_CYCLES)
                .setLiquid(new FluidStack(Fluids.WATER, Constants.CARPENTER_CRATING_LIQUID_QUANTITY))
                .setBox(Ingredient.of(CrateItems.CRATE))
                .recipe(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, crated, 1)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ingredient))
                .build(consumer, id("carpenter", "crates", "pack", name.getNamespace(), name.getPath()));
        new CarpenterRecipeBuilder()
                .setPackagingTime(Constants.CARPENTER_UNCRATING_CYCLES)
                .setBox(Ingredient.EMPTY)
                .recipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, contained.getItem(), 9).requires(crated))
                .build(consumer, id("carpenter", "crates", "unpack", name.getNamespace(), name.getPath()));
    }

    private static void registerCarpenter(Consumer<FinishedRecipe> consumer) {
        for (MoreBeesEnumHoneyComb comb : MoreBeesEnumHoneyComb.VALUES) {
            crate(consumer, MoreBeesCrateItems.CRATED_BEE_COMBS.get(comb).get(), Ingredient.of(MoreBeesApicultureItems.BEE_COMBS.get(comb)));
        }
    }

    private static void registerFabricator(Consumer<FinishedRecipe> consumer) {
        FluidStack liquidGlass = ForestryFluids.GLASS.getFluid(500);

        new FabricatorRecipeBuilder()
                .setPlan(Ingredient.EMPTY)
                .setMolten(liquidGlass)
                .recipe(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MoreBeesItems.CRAFTING_MATERIALS.get(MoreBeesEnumCraftingMaterial.MUTATION_CATALYST), 1)
                        .pattern("PPP")
                        .pattern("PAP")
                        .pattern("PPP")
                        .define('P', CoreItems.CRAFTING_MATERIALS.get(EnumCraftingMaterial.PULSATING_MESH))
                        .define('A', Items.AMETHYST_SHARD))
                .build(consumer, id("fabricator", "materials", "mutation_catalyst"));
    }

    private static void registerCentrifuge(Consumer<FinishedRecipe> consumer) {
        // Register Metal Comb centrifuge processing
        Map<FeatureItem<MoreBeesItemHoneyComb>, FeatureItem<MoreBeesItemBeeProduce>> combToProduceMap = new HashMap<>() {{
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.COPPER),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.COPPER_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.IRON),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.IRON_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.TIN),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.TIN_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.LEAD),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.LEAD_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.NICKEL),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.NICKEL_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.OSMIUM),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.OSMIUM_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.SILVER),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.SILVER_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.GOLD),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.GOLD_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.COBALT),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.COBALT_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.ALUMINUM),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.ALUMINUM_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.ZINC),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.ZINC_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.YELLORIUM),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.YELLORIUM_BIT));
            put(MoreBeesApicultureItems.BEE_COMBS.get(MoreBeesEnumHoneyComb.CERTUS),
                    MoreBeesItems.BEE_PRODUCE_MATERIALS.get(MoreBeesEnumBeeProduce.CERTUS_BIT));
        }};

        for (FeatureItem<MoreBeesItemHoneyComb> comb : combToProduceMap.keySet()) {
            new CentrifugeRecipeBuilder()
                    .setProcessingTime(20)
                    .setInput(Ingredient.of(comb))
                    .product(0.8f, CoreItems.CRAFTING_MATERIALS.get(EnumCraftingMaterial.BEESWAX).stack())
                    .product(0.5f, ApicultureItems.HONEY_DROP.stack())
                    .product(1.0F, combToProduceMap.get(comb).stack(1))
                    .product(0.3F, combToProduceMap.get(comb).stack(2))
                    .product(0.1F, combToProduceMap.get(comb).stack(3))
                    .build(consumer, id("centrifuge", comb.getName()));
        }
    }

    private static ResourceLocation id(String... path) {
        return ResourceLocation.fromNamespaceAndPath("mobees", String.join("/", path));
    }
}
