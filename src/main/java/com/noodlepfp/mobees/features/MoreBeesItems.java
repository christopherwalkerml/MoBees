package com.noodlepfp.mobees.features;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.item.MoreBeesItemBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesEnumBeeProduce;
import forestry.core.items.ItemCraftingMaterial;
import forestry.modules.features.FeatureItemGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class MoreBeesItems {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));

    public static final FeatureItemGroup<MoreBeesItemBeeProduce, MoreBeesEnumBeeProduce> CRAFTING_MATERIALS = REGISTRY.itemGroup(MoreBeesItemBeeProduce::new, MoreBeesEnumBeeProduce.values()).create();

}
