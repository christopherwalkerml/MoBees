package com.noodlepfp.mobees.bee;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.core.data.MoreBeesEffect;
import com.noodlepfp.mobees.core.data.MoreBeesFlowerType;
import com.noodlepfp.mobees.core.data.MoreBeesTags;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.genetics.effect.CursedEffect;
import com.noodlepfp.mobees.genetics.effect.LibrarianEffect;
import com.noodlepfp.mobees.genetics.effect.MelodicChimeEffect;
import com.noodlepfp.mobees.genetics.effect.WitchingEffect;
import com.noodlepfp.mobees.hive.MoreHiveDefinition;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import forestry.api.plugin.IApicultureRegistration;
import forestry.api.plugin.IForestryPlugin;
import forestry.api.plugin.IGeneticRegistration;
import forestry.apiculture.FlowerType;
import forestry.apiculture.features.ApicultureItems;
import forestry.apiculture.genetics.effects.PotionBeeEffect;
import forestry.apiculture.items.EnumHoneyComb;
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

        Supplier<List<ItemStack>> frozenComb = getForestryComb(EnumHoneyComb.FROZEN);
        apiculture.registerHive(MoreBeesSpecies.ALPINE, MoreHiveDefinition.ALPINE)
                .addDrop(0.80, MoreBeesSpecies.ALPINE, frozenComb, 0.5F);

        // flower tags
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_STONE, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_STONE, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_COAL, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_COAL, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_COPPER, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_COPPER, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_TIN, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_TIN, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_LEAD, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_LEAD, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_NICKEL, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_NICKEL, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_ZINC, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_ZINC, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_OSMIUM, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_OSMIUM, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_ARDITE, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_ARDITE, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_COBALT, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_COBALT, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_SILVER, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_SILVER, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_PLATINUM, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_PLATINUM, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_YELLORIUM, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_YELLORIUM, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_CERTUS_QUARTZ, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_CERTUS_QUARTZ, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_IRON, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_IRON, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_GOLD, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_GOLD, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_LAPIS, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_LAPIS, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_REDSTONE, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_REDSTONE, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_AMETHYST, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_AMETHYST, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_DIAMOND, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_DIAMOND, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.ROCK_EMERALD, new FlowerType(MoreBeesTags.Blocks.ROCK_FLOWERS_EMERALD, true));
        apiculture.registerFlowerType(MoreBeesFlowerType.READABLE, new FlowerType(MoreBeesTags.Blocks.FLOWERS_READABLE, true));

        // effect tags
        apiculture.registerBeeEffect(MoreBeesEffect.CAVE_SIGHT, new PotionBeeEffect(false, MobEffects.NIGHT_VISION, 240));
        apiculture.registerBeeEffect(MoreBeesEffect.DARK, new PotionBeeEffect(false, MobEffects.DARKNESS, 240));
        apiculture.registerBeeEffect(MoreBeesEffect.WITHERED, new PotionBeeEffect(false, MobEffects.WITHER, 100));
        apiculture.registerBeeEffect(MoreBeesEffect.VANISHING, new PotionBeeEffect(false, MobEffects.INVISIBILITY, 180));
        apiculture.registerBeeEffect(MoreBeesEffect.MELODIC_CHIME, new MelodicChimeEffect());
        apiculture.registerBeeEffect(MoreBeesEffect.WITCHING, new WitchingEffect());
        apiculture.registerBeeEffect(MoreBeesEffect.CURSED, new CursedEffect());
        apiculture.registerBeeEffect(MoreBeesEffect.ARCANE, new PotionBeeEffect(false, MobEffects.LEVITATION, 40));
        apiculture.registerBeeEffect(MoreBeesEffect.LIBRARIAN, new LibrarianEffect());
    }

    @Override
    public void registerGenetics(IGeneticRegistration genetics) {
        // Taxonomy
        MoreBeesTaxonomy.defineTaxa(genetics);
    }

    private static Supplier<List<ItemStack>> getHoneyComb(MoreBeesEnumHoneyComb type) {
        return () -> List.of(MoreBeesApicultureItems.BEE_COMBS.stack(type));
    }

    private static Supplier<List<ItemStack>> getForestryComb(EnumHoneyComb type) {
        return () -> List.of(ApicultureItems.BEE_COMBS.stack(type));
    }
}
