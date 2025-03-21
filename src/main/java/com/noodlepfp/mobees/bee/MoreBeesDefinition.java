package com.noodlepfp.mobees.bee;

import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.feature.MoreBeesItems;
import com.noodlepfp.mobees.genetics.allele.MoreBeesAlleles;
import com.noodlepfp.mobees.item.MoreBeesEnumBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import forestry.api.apiculture.ForestryBeeSpecies;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.ForestryAlleles;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.plugin.IApicultureRegistration;
import forestry.apiculture.features.ApicultureItems;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.features.CoreItems;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static forestry.apiculture.features.ApicultureItems.BEE_COMBS;

public class MoreBeesDefinition {

    public static void defineNewBees(IApicultureRegistration apiculture) {

        /* ROCKY BEES */
        apiculture.registerSpecies(MoreBeesSpecies.ROCKY, MoreBeesTaxa.GENUS_ROCKY, MoreBeesTaxa.SPECIES_ROCKY, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0x757575))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.3f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.EFFECT, MoreBeesAlleles.EFFECT_CAVE_SIGHT);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.STONE, MoreBeesTaxa.GENUS_ROCKY, MoreBeesTaxa.SPECIES_STONE, false, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xC5C5C5))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.5f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.ROCKY, ForestryBeeSpecies.COMMON, 10);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.TOLERANT, MoreBeesTaxa.GENUS_ROCKY, MoreBeesTaxa.SPECIES_TOLERANT, false, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xC5C5C5))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.5f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_BOTH_1);
                    genome.set(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_BOTH_1);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.STONE, ForestryBeeSpecies.CULTIVATED, 10);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.MINERAL, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_MINERAL, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0x91877A))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.MINERAL), 0.3f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_ROCK);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.TOLERANT, ForestryBeeSpecies.STEADFAST, 8);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.RESILIENT, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_RESILIENT, false, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xC5C5C5))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.5f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_BOTH_2);
                    genome.set(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_BOTH_2);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.DILIGENT, 10);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.COAL, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_COAL, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0x212121))
                .setStripes(TextColor.fromRgb(0x8A7E75))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COAL), 0.1f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COAL), 0.05f)
                .addSpecialty(MoreBeesItems.BEE_PRODUCE_MATERIALS.stack(MoreBeesEnumBeeProduce.COPPER_BIT), 0.05f)
                .setTemperature(TemperatureType.COLD)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_COAL);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.BOGGY, 6);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.RUSTY, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_RUSTY, false, TextColor.fromRgb(0x8F7979))
                .setBody(TextColor.fromRgb(0xB6745E))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.MINERAL), 0.1f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.VALIANT, 10);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.COPPER, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_COPPER, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xE17C38))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COPPER), 0.06f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COPPER), 0.03f)
                .addSpecialty(MoreBeesItems.BEE_PRODUCE_MATERIALS.stack(MoreBeesEnumBeeProduce.COPPER_BIT), 0.03f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_COPPER);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.MODEST, 6);
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.WINTRY, 6);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.TIN, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_TIN, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xFFFFFF))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.TIN), 0.06f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.TIN), 0.03f)
                .setGenome(genome -> {
                    // TODO genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_COPPER);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.MARSHY, 6);
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.TROPICAL, 6);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.NICKEL, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_NICKEL, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xEFD797))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.NICKEL), 0.05f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.NICKEL), 0.025f)
                .setGenome(genome -> {
                    // TODO genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_COPPER);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.FOREST, 6);
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.MARSHY, 6);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.IRON, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_IRON, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xD5D5D5))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.IRON), 0.05f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.IRON), 0.025f)
                .addSpecialty(MoreBeesItems.BEE_PRODUCE_MATERIALS.stack(MoreBeesEnumBeeProduce.IRON_BIT), 0.025f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_IRON);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.MEADOWS, 4);
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.FOREST, 4);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.GOLD, MoreBeesTaxa.GENUS_PRECIOUSMETALLIC, MoreBeesTaxa.SPECIES_GOLD, false, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xE5AE47))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.GOLD), 0.07f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.GOLD), 0.035f)
                .addSpecialty(MoreBeesItems.BEE_PRODUCE_MATERIALS.stack(MoreBeesEnumBeeProduce.IRON_BIT), 0.035f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_GOLD);
                })
                .addMutations(mutations -> {
                    mutations.add(ForestryBeeSpecies.IMPERIAL, MoreBeesSpecies.IRON, 4);
                    mutations.add(ForestryBeeSpecies.IMPERIAL, MoreBeesSpecies.COPPER, 4);
                    mutations.add(ForestryBeeSpecies.IMPERIAL, MoreBeesSpecies.NICKEL, 4);
                })
                .setGlint(true)
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.LAPIS, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_LAPIS, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0x4A3DF1))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.LAPIS), 0.08f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.LAPIS), 0.04f)
                .addSpecialty(new ItemStack(Items.LAPIS_LAZULI, 1), 0.25f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_LAPIS);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.AQUATIC, 5);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.APATITE, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_APATITE, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0x5978EE))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.APATITE), 0.15f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.APATITE), 0.075f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, ForestryAlleles.FLOWER_TYPE_WHEAT);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.FARMERLY, 5);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.REDSTONE, MoreBeesTaxa.GENUS_REDSTONE, MoreBeesTaxa.SPECIES_REDSTONE, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xF33838))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.2f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.04f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.02f)
                .addSpecialty(new ItemStack(Items.REDSTONE, 1), 0.02f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_REDSTONE);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.VALIANT, 5);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.BUDDING, MoreBeesTaxa.GENUS_BUDDING, MoreBeesTaxa.SPECIES_BUDDING, false, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xE9C1FF))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.05f)
                .addSpecialty(new ItemStack(Items.AMETHYST_SHARD, 1), 0.005f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_AMETHYST);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, MoreBeesSpecies.LAPIS, 5);
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.PRISMATIC, 5);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.AMETHYST, MoreBeesTaxa.GENUS_CRYSTALLINE, MoreBeesTaxa.SPECIES_AMETHYST, false, TextColor.fromRgb(0xE9C1FF))
                .setBody(TextColor.fromRgb(0xB373EC))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.AMETHYST), 0.02f)
                .addSpecialty(new ItemStack(Items.AMETHYST_SHARD, 1), 0.01f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_AMETHYST);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.BUDDING, MoreBeesSpecies.MINERAL, 5);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.CRYSTALLINE, MoreBeesTaxa.GENUS_CRYSTALLINE, MoreBeesTaxa.SPECIES_CRYSTALLINE, true, TextColor.fromRgb(0xE9C1FF))
                .setBody(TextColor.fromRgb(0xA1FDD0))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.AMETHYST), 0.01f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGlint(true)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_AMETHYST);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.AMETHYST, MoreBeesSpecies.BUDDING, 5);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.EMERALD, MoreBeesTaxa.GENUS_CRYSTALLINE, MoreBeesTaxa.SPECIES_EMERALD, true, TextColor.fromRgb(0xE9C1FF))
                .setBody(TextColor.fromRgb(0x77FF79))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.EMERALD), 0.02f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.EMERALD), 0.01f)
                .addSpecialty(MoreBeesItems.BEE_PRODUCE_MATERIALS.stack(MoreBeesEnumBeeProduce.EMERALD_SHARD), 0.01f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_EMERALD);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.CRYSTALLINE, MoreBeesSpecies.CHROMATIC, 2);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.DIAMOND, MoreBeesTaxa.GENUS_CRYSTALLINE, MoreBeesTaxa.SPECIES_DIAMOND, true, TextColor.fromRgb(0xE9C1FF))
                .setBody(TextColor.fromRgb(8371706))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.DIAMOND), 0.01f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.DIAMOND), 0.005f)
                .addSpecialty(MoreBeesItems.BEE_PRODUCE_MATERIALS.stack(MoreBeesEnumBeeProduce.DIAMOND_SHARD), 0.005f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_DIAMOND);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.CRYSTALLINE, MoreBeesSpecies.CHROMATIC, 3);
                })
                .setAuthority("noodlepfp");

        // MARBLE LINE
        apiculture.registerSpecies(MoreBeesSpecies.MARBLE, MoreBeesTaxa.GENUS_MARBLE, MoreBeesTaxa.SPECIES_MARBLE, true, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xFFFFFF))
                .setStripes(TextColor.fromRgb(0x9D8864))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.3f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.ARID)
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.SCULPTED, MoreBeesTaxa.GENUS_MARBLE, MoreBeesTaxa.SPECIES_SCULPTED, false, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xFFFFFF))
                .setStripes(TextColor.fromRgb(0xDCBA83))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.3f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.ARID)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWER);
                    genome.set(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_DOWN_1);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MARBLE, ForestryBeeSpecies.DILIGENT, 8);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.CLASSICAL, MoreBeesTaxa.GENUS_CLASSICAL, MoreBeesTaxa.SPECIES_CLASSICAL, false, TextColor.fromRgb(0x9F9F9F))
                .setBody(TextColor.fromRgb(0xFFD084))
                .setStripes(TextColor.fromRgb(0x561E10))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.3f)
                .setTemperature(TemperatureType.NORMAL)
                .setHumidity(HumidityType.NORMAL)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.SCULPTED, ForestryBeeSpecies.IMPERIAL, 6);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.HARMONIC, MoreBeesTaxa.GENUS_CLASSICAL, MoreBeesTaxa.SPECIES_HARMONIC, true, TextColor.fromRgb(0xFFFFFF))
                .setBody(TextColor.fromRgb(0xE9C1FF))
                .setStripes(TextColor.fromRgb(0x561E10))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.STRINGY), 0.1f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.HARMONIC), 0.2f)
                .setTemperature(TemperatureType.NORMAL)
                .setHumidity(HumidityType.NORMAL)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOW);
                    genome.set(BeeChromosomes.SPEED, ForestryAlleles.SPEED_NORMAL);
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_AMETHYST);
                    genome.set(BeeChromosomes.EFFECT, MoreBeesAlleles.EFFECT_MELODIC_CHIME);
                    genome.set(BeeChromosomes.TERRITORY, ForestryAlleles.TERRITORY_LARGEST);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.CLASSICAL, ForestryBeeSpecies.HERMITIC, 4);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.DIVINE, MoreBeesTaxa.GENUS_DIVINE, MoreBeesTaxa.SPECIES_DIVINE, true, TextColor.fromRgb(0xFFFFFF))
                .setBody(TextColor.fromRgb(0xFFF1A1))
                .setStripes(TextColor.fromRgb(0xD083F1))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.AMETHYST), 0.01f)
                .setTemperature(TemperatureType.NORMAL)
                .setHumidity(HumidityType.NORMAL)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.CLASSICAL, MoreBeesSpecies.AMETHYST, 4);
                })
                .setGlint(true)
                .setAuthority("noodlepfp");

        // RGBEE LINE
        apiculture.registerSpecies(MoreBeesSpecies.CHROMATIC, MoreBeesTaxa.GENUS_CHROMATIC, MoreBeesTaxa.SPECIES_CHROMATIC, true, TextColor.fromRgb(0xFFFFFF))
                .setBody(TextColor.fromRgb(0x87C9FF))
                .setStripes(TextColor.fromRgb(0xF37C7C))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.CHROMATIC), 0.2f)
                .setTemperature(TemperatureType.NORMAL)
                .setHumidity(HumidityType.NORMAL)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.CRYSTALLINE, MoreBeesSpecies.DIVINE, 5);
                })
                .setGlint(true)
                .setAuthority("noodlepfp");

        // EXCITED LINE
        apiculture.registerSpecies(MoreBeesSpecies.LIVELY, MoreBeesTaxa.GENUS_REDSTONE, MoreBeesTaxa.SPECIES_LIVELY, true, TextColor.fromRgb(0xFF7878))
                .setBody(TextColor.fromRgb(0xC7AA4C))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.1f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.06f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.03f)
                .addSpecialty(new ItemStack(Items.REDSTONE, 1), 0.03f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_REDSTONE);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.REDSTONE, ForestryBeeSpecies.DILIGENT, 5);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.EXCITED, MoreBeesTaxa.GENUS_EXCITED, MoreBeesTaxa.SPECIES_EXCITED, false, TextColor.fromRgb(0xFF5959))
                .setBody(TextColor.fromRgb(0xFFDD74))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.05f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.08f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.04f)
                .addSpecialty(new ItemStack(Items.REDSTONE, 1), 0.04f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_REDSTONE);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.REDSTONE, ForestryBeeSpecies.DILIGENT, 4);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.ENERGETIC, MoreBeesTaxa.GENUS_EXCITED, MoreBeesTaxa.SPECIES_ENERGETIC, true, TextColor.fromRgb(0xFF4847))
                .setBody(TextColor.fromRgb(0xFFDA35))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.1f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.REDSTONE), 0.05f)
                .addSpecialty(new ItemStack(Items.REDSTONE, 1), 0.05f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_REDSTONE);
                    genome.set(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FASTEST);
                })
                .setGlint(true)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.REDSTONE, ForestryBeeSpecies.DILIGENT, 2);
                })
                .setAuthority("noodlepfp");

        // EXTRA NETHER LINE
        apiculture.registerSpecies(MoreBeesSpecies.CRIMSON, MoreBeesTaxa.GENUS_CRIMSON, MoreBeesTaxa.SPECIES_CRIMSON, false, TextColor.fromRgb(0x754141))
                .setBody(TextColor.fromRgb(0xDA5454))
                .addProduct(BEE_COMBS.stack(EnumHoneyComb.SIMMERING), 0.15f)
                .addProduct(BEE_COMBS.stack(EnumHoneyComb.PARCHED), 0.1f)
                .setTemperature(TemperatureType.HELLISH)
                .setHumidity(HumidityType.ARID)
                .addMutations(mutations -> {
                    mutations.add(ForestryBeeSpecies.DEMONIC, ForestryBeeSpecies.SPITEFUL, 8);
                    mutations.add(ForestryBeeSpecies.DEMONIC, ForestryBeeSpecies.EMBITTERED, 8);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.GLOWSTONE, MoreBeesTaxa.GENUS_CRIMSON, MoreBeesTaxa.SPECIES_GLOWSTONE, true, TextColor.fromRgb(0x754141))
                .setBody(TextColor.fromRgb(0xDABF54))
                .addProduct(BEE_COMBS.stack(EnumHoneyComb.SIMMERING), 0.35f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.GLOWING), 0.1f)
                .setTemperature(TemperatureType.HELLISH)
                .setHumidity(HumidityType.ARID)
                .setGlint(true)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FAST);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.CRIMSON, ForestryBeeSpecies.DEMONIC, 6);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.DESOLATE, MoreBeesTaxa.GENUS_DESOLATE, MoreBeesTaxa.SPECIES_DESOLATE, true, TextColor.fromRgb(0x754141))
                .setBody(TextColor.fromRgb(0xC4B6B6))
                .addProduct(BEE_COMBS.stack(EnumHoneyComb.PARCHED), 0.2f)
                .addProduct(CoreItems.ASH.stack(), 0.2f)
                .setTemperature(TemperatureType.HELLISH)
                .setHumidity(HumidityType.ARID)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.CRIMSON, ForestryBeeSpecies.DEMONIC, 7);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.DEVASTATED, MoreBeesTaxa.GENUS_DESOLATE, MoreBeesTaxa.SPECIES_DEVASTATED, true, TextColor.fromRgb(0x754141))
                .setBody(TextColor.fromRgb(0x939393))
                .addProduct(BEE_COMBS.stack(EnumHoneyComb.PARCHED), 0.25f)
                .addProduct(CoreItems.ASH.stack(), 0.3f)
                .setTemperature(TemperatureType.HELLISH)
                .setHumidity(HumidityType.ARID)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.DESOLATE, ForestryBeeSpecies.INDUSTRIOUS, 6);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.SCRAP, MoreBeesTaxa.GENUS_SCRAP, MoreBeesTaxa.SPECIES_SCRAP, false, TextColor.fromRgb(0x754141))
                .setBody(TextColor.fromRgb(0x796161))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.SCRAPPED), 0.01f)
                .addProduct(CoreItems.ASH.stack(), 0.1f)
                .setTemperature(TemperatureType.HELLISH)
                .setHumidity(HumidityType.ARID)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.DEVASTATED, MoreBeesSpecies.RUSTY, 2);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.NETHERITE, MoreBeesTaxa.GENUS_SCRAP, MoreBeesTaxa.SPECIES_NETHERITE, true, TextColor.fromRgb(0x754141))
                .setBody(TextColor.fromRgb(0x484848))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.SCRAPPED), 0.03f)
                .addProduct(CoreItems.ASH.stack(), 0.05f)
                .setTemperature(TemperatureType.HELLISH)
                .setHumidity(HumidityType.ARID)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.FLOWER_TYPE, ForestryAlleles.FLOWER_TYPE_NETHER);
                    genome.set(BeeChromosomes.EFFECT, ForestryAlleles.EFFECT_IGNITION);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.DEVASTATED, MoreBeesSpecies.SCRAP, 1);
                })
                .setAuthority("noodlepfp");

        // EXTRA SWAMPY LINE
        apiculture.registerSpecies(MoreBeesSpecies.SPORE, MoreBeesTaxa.GENUS_SPORE, MoreBeesTaxa.SPECIES_SPORE, true, TextColor.fromRgb(0x546626))
                .setBody(TextColor.fromRgb(0x6B589F))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.MOSSY), 0.2f)
                .setHumidity(HumidityType.DAMP)
                .addMutations(mutations -> {
                    mutations.add(ForestryBeeSpecies.MARSHY, ForestryBeeSpecies.CULTIVATED, 20);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.GERMINATED, MoreBeesTaxa.GENUS_SPORE, MoreBeesTaxa.SPECIES_GERMINATED, false, TextColor.fromRgb(0x6B589F))
                .setBody(TextColor.fromRgb(0xAAA9AF))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.MOSSY), 0.3f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.FUNGAL), 0.05f)
                .setHumidity(HumidityType.DAMP)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.SPORE, ForestryBeeSpecies.LUSH, 12);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.FUNGAL, MoreBeesTaxa.GENUS_FUNGAL, MoreBeesTaxa.SPECIES_FUNGAL, true, TextColor.fromRgb(0x6B589F))
                .setBody(TextColor.fromRgb(0x9989E5))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.MOSSY), 0.2f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.FUNGAL), 0.08f)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.EFFECT, ForestryAlleles.EFFECT_MYCOPHILIC);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.GERMINATED, ForestryBeeSpecies.BOGGY, 8);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.WITCHY, MoreBeesTaxa.GENUS_FUNGAL, MoreBeesTaxa.SPECIES_WITCHY, true, TextColor.fromRgb(0x6B589F))
                .setBody(TextColor.fromRgb(0x333154))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.MOSSY), 0.3f)
                .addSpecialty(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.FUNGAL), 0.12f)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.EFFECT, MoreBeesAlleles.EFFECT_WITCHING);
                    genome.set(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.FUNGAL, ForestryBeeSpecies.SECLUDED, 5);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.CURSED, MoreBeesTaxa.GENUS_CURSED, MoreBeesTaxa.SPECIES_CURSED, true, TextColor.fromRgb(0x6B589F))
                .setBody(TextColor.fromRgb(0x983232))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.MYSTERIOUS), 0.02f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.FUNGAL), 0.04f)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.EFFECT, MoreBeesAlleles.EFFECT_CURSED);
                    genome.set(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                })
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.WITCHY, ForestryBeeSpecies.DEMONIC, 4);
                })
                .setAuthority("noodlepfp");

        // BEEBEE LINE
        apiculture.registerSpecies(MoreBeesSpecies.CAMOUFLAGED, MoreBeesTaxa.GENUS_CAMOUFLAGED, MoreBeesTaxa.SPECIES_CAMOUFLAGED, false, TextColor.fromRgb(0x66A94E))
                .setBody(TextColor.fromRgb(0x5B7C4E))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.SILKY), 0.1f)
                .addMutations(mutations -> {
                    mutations.add(ForestryBeeSpecies.STEADFAST, ForestryBeeSpecies.TROPICAL, 10);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.DISGUISED, MoreBeesTaxa.GENUS_CAMOUFLAGED, MoreBeesTaxa.SPECIES_DISGUISED, false, TextColor.fromRgb(0x5E934E))
                .setBody(TextColor.fromRgb(0xF1D65F))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.SILKY), 0.15f)
                .setHumidity(HumidityType.DAMP)
                .setTemperature(TemperatureType.WARM)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.CAMOUFLAGED, ForestryBeeSpecies.SINISTER, 8);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.BEE_BEE, MoreBeesTaxa.GENUS_BEE, MoreBeesTaxa.SPECIES_BEE, true, TextColor.fromRgb(0xF1D65F))
                .setBody(TextColor.fromRgb(0xF1D65F))
                .addProduct(new ItemStack(Items.HONEYCOMB, 1), 0.1f)
                .addSpecialty(new ItemStack(Items.HONEY_BOTTLE, 1), 0.1f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.DISGUISED, ForestryBeeSpecies.NOBLE, 6);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.ALPINE, MoreBeesTaxa.GENUS_ALPINE, MoreBeesTaxa.SPECIES_ALPINE, true, TextColor.fromRgb(0x92DEE5))
                .setBody(TextColor.fromRgb(0x317547))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.FROZEN), 0.30f)
                .setTemperature(TemperatureType.ICY)
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.HIKER, MoreBeesTaxa.GENUS_ALPINE, MoreBeesTaxa.SPECIES_HIKER, true, TextColor.fromRgb(0x92DEE5))
                .setBody(TextColor.fromRgb(0x9F9F9F))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.FROZEN), 0.30f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.10f)
                .setTemperature(TemperatureType.COLD)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.ALPINE, MoreBeesSpecies.ROCKY, 15);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.PILGRIM, MoreBeesTaxa.GENUS_ALPINE, MoreBeesTaxa.SPECIES_PILGRIM, true, TextColor.fromRgb(0x92DEE5))
                .setBody(TextColor.fromRgb(0xECBD8A))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.FROZEN), 0.15f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.15f)
                .setTemperature(TemperatureType.COLD)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.ALPINE, MoreBeesSpecies.HIKER, 12);
                })
                .setAuthority("noodlepfp");

        apiculture.registerSpecies(MoreBeesSpecies.SPIRITED, MoreBeesTaxa.GENUS_SPIRITED, MoreBeesTaxa.SPECIES_SPIRITED, true, TextColor.fromRgb(0x92DEE5))
                .setBody(TextColor.fromRgb(0xC494E1))
                .addProduct(ApicultureItems.BEE_COMBS.stack(EnumHoneyComb.FROZEN), 0.15f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.15f)
                .setTemperature(TemperatureType.COLD)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.ALPINE, MoreBeesSpecies.HIKER, 12);
                })
                .setAuthority("noodlepfp");
    }
}
