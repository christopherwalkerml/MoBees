package com.noodlepfp.mobees.bee;

import com.noodlepfp.mobees.features.MoreBeesApicultureItems;
import com.noodlepfp.mobees.item.MBEnumHoneyComb;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.ForestryAlleles;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.plugin.IApicultureRegistration;

import java.awt.*;

public class MoreBeesDefinition {

    public static void defineNewBees(IApicultureRegistration apiculture) {
        apiculture.registerSpecies(MoreBeesSpecies.ROCKY, MoreBeesTaxa.GENUS_ROCKY, MoreBeesTaxa.SPECIES_ROCKY, true, new Color(0xa8a8a8))
                .setBody(new Color(0x999999))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MBEnumHoneyComb.ROCKY), 0.3f)
                .setTemperature(TemperatureType.COLD)
                .setHumidity(HumidityType.DAMP)
                .setGenome(genome -> {
                    genome.set(BeeChromosomes.EFFECT, ForestryAlleles.EFFECT_NONE); //TODO add night vision
                })
                .setAuthority("binnie");

        apiculture.registerSpecies(MoreBeesSpecies.BONE, MoreBeesTaxa.GENUS_BARREN, MoreBeesTaxa.SPECIES_BONE, true, new Color(0xe9ede8))
                .setBody(new Color(0xcbe374))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MBEnumHoneyComb.BARREN), 0.3f)
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MBEnumHoneyComb.BONE), 0.1f)
                .setTemperature(TemperatureType.HOT)
                .setHumidity(HumidityType.ARID)
//                .addMutations(mutations -> {
//                    mutations.add(MoreBeesSpecies.ROCKY, MoreBeesSpecies.DESOLATE, 10);
//                })
                .setAuthority("binnie");
    }

}
