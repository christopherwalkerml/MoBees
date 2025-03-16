package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.item.MoreBeesEnumCraftingMaterial;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import com.noodlepfp.mobees.item.MoreBeesItemHoneyComb;
import com.noodlepfp.mobees.item.MoreBeesItemCraftingMaterial;
import forestry.core.items.ItemCraftingMaterial;
import forestry.modules.features.*;

@FeatureProvider
public class MoreBeesApicultureItems {
    public static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));
    public static final FeatureItemGroup<MoreBeesItemHoneyComb, MoreBeesEnumHoneyComb> BEE_COMBS = REGISTRY.itemGroup(MoreBeesItemHoneyComb::new, "bee_comb", MoreBeesEnumHoneyComb.VALUES);
    // public static final FeatureItem<ItemHiveFrame> STURDY_FRAME = REGISTRY.item(() -> new ItemHiveFrame(2056, 0.75f), "sturdy_frame");
}
