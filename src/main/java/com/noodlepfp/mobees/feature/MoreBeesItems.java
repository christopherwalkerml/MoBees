package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.item.MoreBeesEnumCraftingMaterial;
import com.noodlepfp.mobees.item.MoreBeesItemBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesEnumBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesItemCraftingMaterial;
import forestry.core.items.ItemCraftingMaterial;
import forestry.core.items.definitions.EnumCraftingMaterial;
import forestry.modules.features.FeatureItemGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class MoreBeesItems {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));

    public static final FeatureItemGroup<MoreBeesItemBeeProduce, MoreBeesEnumBeeProduce> BEE_PRODUCE_MATERIALS = REGISTRY.itemGroup(MoreBeesItemBeeProduce::new, MoreBeesEnumBeeProduce.values()).create();
    public static final FeatureItemGroup<MoreBeesItemCraftingMaterial, MoreBeesEnumCraftingMaterial> CRAFTING_MATERIALS = REGISTRY.itemGroup(MoreBeesItemCraftingMaterial::new, MoreBeesEnumCraftingMaterial.values()).create();

}
