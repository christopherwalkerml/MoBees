package com.noodlepfp.mobees.bee;

import forestry.api.genetics.ForestryTaxa;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.ForestryAlleles;
import forestry.api.plugin.IGeneticRegistration;

public class MoreBeesTaxonomy {

    public static void defineTaxa(IGeneticRegistration genetics) {
        genetics.defineTaxon(ForestryTaxa.CLASS_INSECTS, ForestryTaxa.ORDER_HYMNOPTERA, order -> {
            order.defineSubTaxon(ForestryTaxa.FAMILY_BEES, family -> {
                family.defineSubTaxon(MoreBeesTaxa.GENUS_ROCKY, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.CAVE_DWELLING, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWER);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_LONG);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_2);
                    genus.setDefaultChromosome(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_CATHEMERAL);
                    genus.setDefaultChromosome(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_UP_2);
                    // TODO - add flower type stone or ore, ore maybe for other bees
                });
                family.defineSubTaxon(MoreBeesTaxa.GENUS_BARREN, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOW);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORT);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_1);
                    genus.setDefaultChromosome(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_DOWN_1);
                    genus.setDefaultChromosome(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_DOWN_1);
                });
            });
        });
    }

}
