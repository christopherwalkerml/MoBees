package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlveary;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.hive.MoreBeesBlockBeeHive;
import com.noodlepfp.mobees.hive.MoreBeesBlockHiveType;
import forestry.core.items.ItemBlockForestry;
import forestry.modules.features.FeatureBlockGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;
import net.minecraft.world.item.Item;

@FeatureProvider
public class MoreBeesApicultureBlocks {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));

    public static final FeatureBlockGroup<MoreBeesBlockBeeHive, MoreBeesBlockHiveType> BEEHIVE = REGISTRY.blockGroup(MoreBeesBlockBeeHive::new, MoreBeesBlockHiveType.values()).itemWithType((block, type) -> new ItemBlockForestry<>(block, new Item.Properties())).identifier("beehive").create();

    public static final FeatureBlockGroup<MoreBeesBlockAlveary, MoreBeesBlockAlvearyType> ALVEARY = REGISTRY.blockGroup(MoreBeesBlockAlveary::new, MoreBeesBlockAlvearyType.values()).item(blockAlveary -> new ItemBlockForestry<>(blockAlveary, new Item.Properties())).identifier("alveary").create();

}
