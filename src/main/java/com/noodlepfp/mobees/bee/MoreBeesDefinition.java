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

        apiculture.registerSpecies(MoreBeesSpecies.STONE, MoreBeesTaxa.GENUS_ROCKY, MoreBeesTaxa.SPECIES_STONE, true, new Color(0xAFAFAF))
                .setBody(new Color(0x9F9F9F))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.5f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.EFFECT, ForestryAlleles.EFFECT_NONE); //TODO add night vision
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
                    mutations.add(MoreBeesSpecies.STONE, ForestryBeeSpecies.STEADFAST, 10);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.COAL, MoreBeesTaxa.GENUS_MINERAL, MoreBeesTaxa.SPECIES_COAL, true, new Color(0x212121))
                .setBody(new Color(0x8A7E75))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COAL), 0.1f)
                .setTemperature(TemperatureType.COLD)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.BOGGY, 10);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.RUSTY, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_RUSTY, true, new Color(0x8F7979))
                .setBody(new Color(0xB6745E))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.MINERAL), 0.08f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.MINERAL, ForestryBeeSpecies.VALIANT, 10);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.COPPER, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_COPPER, true, new Color(0x9F9F9F))
                .setBody(new Color(0xE17C38))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.COPPER), 0.06f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.INDUSTRIOUS, 10);
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.IRON, MoreBeesTaxa.GENUS_METALLIC, MoreBeesTaxa.SPECIES_IRON, true, new Color(0x9F9F9F))
                .setBody(new Color(0xE3E3E3))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.IRON), 0.05f)
                .addMutations(mutations -> {
                    mutations.add(MoreBeesSpecies.RUSTY, ForestryBeeSpecies.INDUSTRIOUS, 10);
                })
                .setAuthority("binnie");

    }

}
