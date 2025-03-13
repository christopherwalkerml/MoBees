package com.noodlepfp.mobees.features;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.item.MBEnumHoneyComb;
import com.noodlepfp.mobees.item.MoreBeesItemHoneyComb;
import forestry.apiculture.items.ItemHiveFrame;
import forestry.modules.features.*;

@FeatureProvider
public class MoreBeesApicultureItems {
    public static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));
    public static final FeatureItemGroup<MoreBeesItemHoneyComb, MBEnumHoneyComb> BEE_COMBS = REGISTRY.itemGroup(MoreBeesItemHoneyComb::new, "bee_comb", MBEnumHoneyComb.VALUES);
    public static final FeatureItem<ItemHiveFrame> STURDY_FRAME = REGISTRY.item(() -> new ItemHiveFrame(2056, 0.75f), "sturdy_frame");
}
