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
    public static final FeatureItem<MoreBeesItemHiveFrame> FRAME_PRESERVATION = REGISTRY.item(() -> new MoreBeesItemHiveFrame
            .MoreBeesItemHiveFrameBuilder(256)
            .setAgeMult(2.0f)
            .setSpeedMult(0.8f)
            .setPollinationMult(0.8f)
            .build(), "frame_preservation");

    public static final FeatureItem<MoreBeesItemHiveFrame> FRAME_DESTRUCTION = REGISTRY.item(() -> new MoreBeesItemHiveFrame
            .MoreBeesItemHiveFrameBuilder(256)
            .setAgeMult(0.2f)
            .setSpeedMult(1.25f)
            .setPollinationMult(1.25f)
            .build(), "frame_destruction");

    public static final FeatureItem<MoreBeesItemHiveFrame> FRAME_MUTATION = REGISTRY.item(() -> new MoreBeesItemHiveFrame
            .MoreBeesItemHiveFrameBuilder(256)
            .setSpeedMult(0.8f)
            .setPollinationMult(0.8f)
            .setMutationMult(2.0f)
            .build(), "frame_mutation");
}
