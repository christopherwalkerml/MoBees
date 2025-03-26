package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import forestry.modules.features.*;
import forestry.storage.items.ItemCrated;

import java.util.ArrayList;
import java.util.List;

@FeatureProvider
public class MoreBeesCrateItems {

    private static final List<FeatureItem<ItemCrated>> CRATES = new ArrayList<>();
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBeesModule.mobees("core"));

    // public static final FeatureItem<ItemCrated> CRATED_ROYAL_JELLY = register(ApicultureItems.ROYAL_JELLY, "crated_royal_jelly");
    public static final FeatureItemGroup<ItemCrated, MoreBeesEnumHoneyComb> CRATED_BEE_COMBS = REGISTRY.itemGroup(comb -> new ItemCrated(() -> MoreBeesApicultureItems.BEE_COMBS.get(comb).stack()), "crated_bee_comb", MoreBeesEnumHoneyComb.VALUES);

    static {
        CRATES.addAll(CRATED_BEE_COMBS.getFeatures());
    }

    public static List<FeatureItem<ItemCrated>> getCrates() {
        return CRATES;
    }

}
