package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.feature.MoreBeesCrateItems;
import com.noodlepfp.mobees.feature.MoreBeesItems;
import com.noodlepfp.mobees.item.MoreBeesEnumBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesEnumCraftingMaterial;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import com.noodlepfp.mobees.item.MoreBeesItemCraftingMaterial;
import forestry.api.ForestryTags;
import forestry.apiculture.blocks.BlockAlveary;
import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.features.ApicultureBlocks;
import forestry.apiculture.features.ApicultureItems;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.config.Constants;
import forestry.core.data.builder.CarpenterRecipeBuilder;
import forestry.core.data.builder.FabricatorRecipeBuilder;
import forestry.core.features.CoreItems;
import forestry.core.fluids.ForestryFluids;
import forestry.core.items.definitions.EnumCraftingMaterial;
import forestry.core.items.definitions.EnumElectronTube;
import forestry.core.utils.ModUtil;
import forestry.storage.features.CrateItems;
import forestry.storage.items.ItemCrated;
import it.unimi.dsi.fastutil.objects.ObjectIntPair;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.FluidStack;
import thedarkcolour.modkit.data.MKRecipeProvider;

import java.util.Collections;
import java.util.function.Consumer;

public class MoreBeesRecipeProvider {

    public static void addRecipes(Consumer<FinishedRecipe> consumer, MKRecipeProvider recipes) {
        registerApicultureRecipes(recipes);
        registerMaterials(recipes);
        registerCarpenter(consumer);
        registerFabricator(consumer);
    }

    private static void registerApicultureRecipes(MKRecipeProvider recipes) {
        registerCombRecipes(recipes);

        BlockAlveary plain = ApicultureBlocks.ALVEARY.get(BlockAlvearyType.PLAIN).block();
        ItemLike goldElectronTube = CoreItems.ELECTRON_TUBES.get(EnumElectronTube.GOLD);
        ItemLike lapisElectronTube = CoreItems.ELECTRON_TUBES.get(EnumElectronTube.LAPIS);
        ItemLike emeraldElectronTube = CoreItems.ELECTRON_TUBES.get(EnumElectronTube.EMERALD);

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
            recipe.define('G', Items.GLASS);
            recipe.define('C', MoreBeesItems.CRAFTING_MATERIALS.get(MoreBeesEnumCraftingMaterial.MUTATION_CATALYST));
            recipe.define('X', plain);
            recipe.pattern("#X#");
            recipe.pattern("GCG");
            recipe.pattern("#X#");
            recipe.group("alveary");
        });

        recipes.shapedCrafting(RecipeCategory.MISC, MoreBeesApicultureItems.FRAME_PRESERVATION, recipe -> {
            recipe.define('#', Tags.Items.RODS_WOODEN);
            recipe.define('A', ApicultureItems.AMBROSIA);
            recipe.pattern("###");
            recipe.pattern("#A#");
            recipe.pattern("###");
        });
    }

    private static void registerMaterials(MKRecipeProvider recipes) {
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
        // crate(consumer, CrateItems.CRATED_ROYAL_JELLY.get(), Ingredient.of(ApicultureItems.ROYAL_JELLY));

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

    private static ResourceLocation id(String... path) {
        return new ResourceLocation("mobees", String.join("/", path));
    }
}
