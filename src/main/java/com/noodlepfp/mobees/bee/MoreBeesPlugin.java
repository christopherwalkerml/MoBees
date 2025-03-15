package com.noodlepfp.mobees.bee;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.features.MoreBeesApicultureItems;
import com.noodlepfp.mobees.hive.MoreHiveDefinition;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import forestry.api.plugin.IApicultureRegistration;
import forestry.api.plugin.IForestryPlugin;
import forestry.api.plugin.IGeneticRegistration;
import net.minecraft.resources.ResourceLocation;
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

        Supplier<List<ItemStack>> petrifiedComb = getHoneyComb(MoreBeesEnumHoneyComb.ROCKY);
        apiculture.registerHive(MoreBeesSpecies.ROCKY, MoreHiveDefinition.ROCKY)
                .addDrop(0.80, MoreBeesSpecies.ROCKY, petrifiedComb, 0.5F)
                .addDrop(0.20, MoreBeesSpecies.MARBLE, petrifiedComb);
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
