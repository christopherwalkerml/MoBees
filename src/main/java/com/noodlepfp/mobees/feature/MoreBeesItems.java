package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.item.MoreBeesEnumCraftingMaterial;
import com.noodlepfp.mobees.item.MoreBeesItemBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesEnumBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesItemCraftingMaterial;
import forestry.modules.features.FeatureItemGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class MoreBeesItems {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBeesModule.mobees("core"));

    public static final FeatureItemGroup<MoreBeesItemBeeProduce, MoreBeesEnumBeeProduce> BEE_PRODUCE_MATERIALS = REGISTRY.itemGroup(MoreBeesItemBeeProduce::new, MoreBeesEnumBeeProduce.values()).create();
    public static final FeatureItemGroup<MoreBeesItemCraftingMaterial, MoreBeesEnumCraftingMaterial> CRAFTING_MATERIALS = REGISTRY.itemGroup(MoreBeesItemCraftingMaterial::new, MoreBeesEnumCraftingMaterial.values()).create();

}
