package com.noodlepfp.mobees.bee;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.core.data.MoreBeesEffect;
import com.noodlepfp.mobees.core.data.MoreBeesFlowerType;
import com.noodlepfp.mobees.core.data.MoreBeesTags;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.hive.MoreHiveDefinition;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import forestry.api.plugin.IApicultureRegistration;
import forestry.api.plugin.IForestryPlugin;
import forestry.api.plugin.IGeneticRegistration;
import forestry.apiculture.FlowerType;
import forestry.apiculture.genetics.effects.PotionBeeEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Supplier;

public class MoreBeesPlugin implements IForestryPlugin {

    @Override
    public ResourceLocation id() {
        return MoBees.loc("core");
    }

    @Override
    public void registerApiculture(@SuppressWarnings("null") IApicultureRegistration apiculture) {
        MoreBeesDefinition.defineNewBees(apiculture);

        // hive tags
        Supplier<List<ItemStack>> petrifiedComb = getHoneyComb(MoreBeesEnumHoneyComb.ROCKY);
        apiculture.registerHive(MoreBeesSpecies.ROCKY, MoreHiveDefinition.ROCKY)
                .addDrop(0.80, MoreBeesSpecies.ROCKY, petrifiedComb, 0.5F)
                .addDrop(0.20, MoreBeesSpecies.MARBLE, petrifiedComb);

        // flower tags
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_STONE, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_STONE, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_COAL, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_COAL, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_COPPER, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_COPPER, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_IRON, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_IRON, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_GOLD, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_GOLD, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_LAPIS, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_LAPIS, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_REDSTONE, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_REDSTONE, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_AMETHYST, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_AMETHYST, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_DIAMOND, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_DIAMOND, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_EMERALD, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_EMERALD, true));

        // effect tags
        apiculture.registerBeeEffect(MoreBeesEffect.CAVE_SIGHT, new PotionBeeEffect(false, MobEffects.NIGHT_VISION, 500));
    }

    @Override
    public void registerGenetics(IGeneticRegistration genetics) {
        // Taxonomy
        MoreBeesTaxonomy.defineTaxa(genetics);
    }

    private static Supplier<List<ItemStack>> getHoneyComb(MoreBeesEnumHoneyComb type) {
        return () -> List.of(MoreBeesApicultureItems.BEE_COMBS.stack(type));
    }
}
