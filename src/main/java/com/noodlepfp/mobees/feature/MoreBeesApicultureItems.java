package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.item.*;
import forestry.apiculture.items.ItemHiveFrame;
import forestry.core.items.ItemCraftingMaterial;
import forestry.modules.features.*;

@FeatureProvider
public class MoreBeesApicultureItems {
    public static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));
    public static final FeatureItemGroup<MoreBeesItemHoneyComb, MoreBeesEnumHoneyComb> BEE_COMBS = REGISTRY.itemGroup(MoreBeesItemHoneyComb::new, "bee_comb", MoreBeesEnumHoneyComb.VALUES);
    public static final FeatureItem<MoreBeesItemHiveFrame> FRAME_PRESERVATION = REGISTRY.item(() -> new MoreBeesItemHiveFrame(2.5f, 0.8f, 0.8f, 1, 1,false, false, false), "frame_preservation");
}
