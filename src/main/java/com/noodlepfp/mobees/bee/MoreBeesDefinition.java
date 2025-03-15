package com.noodlepfp.mobees.bee;

import com.noodlepfp.mobees.features.MoreBeesApicultureItems;
import com.noodlepfp.mobees.features.MoreBeesItems;
import com.noodlepfp.mobees.item.MoreBeesEnumBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import com.noodlepfp.mobees.item.MoreBeesItemBeeProduce;
import forestry.api.apiculture.ForestryBeeSpecies;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.ForestryAlleles;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.plugin.IApicultureRegistration;
import forestry.core.items.definitions.EnumCraftingMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.awt.*;

public class MoreBeesDefinition {

    public static void defineNewBees(IApicultureRegistration apiculture) {

        /* ROCKY BEES */
        apiculture.registerSpecies(MoreBeesSpecies.ROCKY, MoreBeesTaxa.GENUS_ROCKY, MoreBeesTaxa.SPECIES_ROCKY, true, new Color(0x888888))
                .setBody(new Color(0x757575))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.3f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.EFFECT, ForestryAlleles.EFFECT_NONE); //TODO add night vision
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.STONE, MoreBeesTaxa.GENUS_ROCKY, MoreBeesTaxa.SPECIES_STONE, false, new Color(0xAFAFAF))
                .setBody(new Color(0x9F9F9F))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.5f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.EFFECT, ForestryAlleles.EFFECT_NONE);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.ROCKY, ForestryBeeSpecies.COMMON, 10);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.MINERAL, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_MINERAL, true, new Color(0xBEB3A4))
                .setBody(new Color(0x91877A))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.MINERAL), 0.3f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.STONE, ForestryBeeSpecies.STEADFAST, 8);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.COAL, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_COAL, true, new Color(0x212121))
                .setBody(new Color(0x8A7E75))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COAL), 0.1f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COAL), 0.05f)
                .addSpecialty(MoreBeesItems.CRAFTING_MATERIALS.stack(MoreBeesEnumBeeProduce.COPPER_BIT), 0.05f)
                .setTemperature(TemperatureType.COLD)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.BOGGY, 6);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.RUSTY, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_RUSTY, false, new Color(0x8F7979))
                .setBody(new Color(0xB6745E))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.MINERAL), 0.1f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.VALIANT, 10);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.COPPER, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_COPPER, true, new Color(0x9F9F9F))
                .setBody(new Color(0xE17C38))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COPPER), 0.06f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COPPER), 0.03f)
                .addSpecialty(MoreBeesItems.CRAFTING_MATERIALS.stack(MoreBeesEnumBeeProduce.COPPER_BIT), 0.03f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.INDUSTRIOUS, 6);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.IRON, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_IRON, false, new Color(0x9F9F9F))
                .setBody(new Color(0xE3E3E3))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.IRON), 0.05f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.IRON), 0.025f)
                .addSpecialty(MoreBeesItems.CRAFTING_MATERIALS.stack(MoreBeesEnumBeeProduce.IRON_BIT), 0.025f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.INDUSTRIOUS, 4);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.GOLD, MoreBeesTaxa.GENUS_PRECIOUSMETALLIC, MoreBeesTaxa.SPECIES_GOLD, true, new Color(0x9F9F9F))
                .setBody(new Color(0xE5AE47))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.GOLD), 0.07f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.GOLD), 0.035f)
                .addSpecialty(MoreBeesItems.CRAFTING_MATERIALS.stack(MoreBeesEnumBeeProduce.IRON_BIT), 0.035f)
                .addMutations(mutations -> {
                    mutations.add(ForestryBeeSpecies.IMPERIAL, MoreBeesSpecies.IRON, 4);
                    mutations.add(ForestryBeeSpecies.IMPERIAL, MoreBeesSpecies.COPPER, 4);
                    // mutations.add(ForestryBeeSpecies.IMPERIAL, MoreBeesSpecies.NICKEL, 4);
                })
                .setGlint(true)
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.LAPIS, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_LAPIS, true, new Color(0x9F9F9F))
                .setBody(new Color(0x4A3DF1))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.LAPIS), 0.8f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.LAPIS), 0.4f)
                .addSpecialty(new ItemStack(Items.LAPIS_LAZULI, 1), 0.25f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.AQUATIC, 5);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.REDSTONE, MoreBeesTaxa.GENUS_REDSTONE, MoreBeesTaxa.SPECIES_REDSTONE, true, new Color(0x9F9F9F))
                .setBody(new Color(0xF33838))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.4f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.2f)
                .addSpecialty(new ItemStack(Items.REDSTONE, 1), 0.2f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.VALIANT, 5);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.BUDDING, MoreBeesTaxa.GENUS_BUDDING, MoreBeesTaxa.SPECIES_BUDDING, false, new Color(0x9F9F9F))
                .setBody(new Color(0xE9C1FF))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.05f)
                .addSpecialty(new ItemStack(Items.AMETHYST_SHARD, 1), 0.005f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGlint(true)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, MoreBeesSpecies.LAPIS, 5);
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.PRISMATIC, 5);
                })
                .setAuthority("binnie");
        // TODO flowers must be amethyst cluster / buds

        apiculture.registerSpecies(MoreBeesSpecies.AMETHYST, MoreBeesTaxa.GENUS_CRYSTALLINE, MoreBeesTaxa.SPECIES_AMETHYST, false, new Color(0xE9C1FF))
                .setBody(new Color(0xB373EC))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.AMETHYST), 0.02f)
                .addSpecialty(new ItemStack(Items.AMETHYST_SHARD, 1), 0.01f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.BUDDING, MoreBeesSpecies.MINERAL, 5);
                })
                .setAuthority("binnie");
        // TODO flowers must be amethyst cluster / buds

        apiculture.registerSpecies(MoreBeesSpecies.CRYSTALLINE, MoreBeesTaxa.GENUS_CRYSTALLINE, MoreBeesTaxa.SPECIES_CRYSTALLINE, true, new Color(0xE9C1FF))
                .setBody(new Color(0xA1FDD0))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.AMETHYST), 0.01f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGlint(true)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.AMETHYST, MoreBeesSpecies.BUDDING, 5);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.EMERALD, MoreBeesTaxa.GENUS_CRYSTALLINE, MoreBeesTaxa.SPECIES_EMERALD, true, new Color(0xE9C1FF))
                .setBody(new Color(0x77FF79))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.EMERALD), 0.02f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.EMERALD), 0.01f)
                .addSpecialty(MoreBeesItems.CRAFTING_MATERIALS.stack(MoreBeesEnumBeeProduce.EMERALD_SHARD), 0.01f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .addMutations(mutations -> {
                    // TODO - replace --- mutations.add(MoreBeesSpecies.CRYSTALLINE, MoreBeesSpecies.CHROMATIC, 3);
                    mutations.add(MoreBeesSpecies.CRYSTALLINE, MoreBeesSpecies.ROCKY, 3);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.DIAMOND, MoreBeesTaxa.GENUS_CRYSTALLINE, MoreBeesTaxa.SPECIES_DIAMOND, true, new Color(0xE9C1FF))
                .setBody(new Color(8371706))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.DIAMOND), 0.01f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.DIAMOND), 0.005f)
                .addSpecialty(MoreBeesItems.CRAFTING_MATERIALS.stack(MoreBeesEnumBeeProduce.DIAMOND_SHARD), 0.005f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .addMutations(mutations -> {
                    // TODO - replace --- mutations.add(MoreBeesSpecies.CRYSTALLINE, MoreBeesSpecies.CHROMATIC, 3);
                    mutations.add(MoreBeesSpecies.CRYSTALLINE, MoreBeesSpecies.ROCKY, 3);
                })
                .setAuthority("binnie");

    }

}
