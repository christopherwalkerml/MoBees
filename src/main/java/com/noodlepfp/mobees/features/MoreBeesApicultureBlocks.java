package com.noodlepfp.mobees.features;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.hive.MoreBeesBlockBeeHive;
import com.noodlepfp.mobees.hive.MoreBeesBlockHiveType;
import forestry.apiculture.blocks.BlockApiculture;
import forestry.apiculture.blocks.BlockTypeApiculture;
import forestry.core.items.ItemBlockForestry;
import forestry.modules.features.FeatureBlockGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;
import net.minecraft.world.item.Item;

@FeatureProvider
public class MoreBeesApicultureBlocks {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));

    public static final FeatureBlockGroup<BlockApiculture, BlockTypeApiculture> BASE = REGISTRY.blockGroup(BlockApiculture::new, BlockTypeApiculture.values()).item((block) -> new ItemBlockForestry<>(block, new Item.Properties())).create();

    public static final FeatureBlockGroup<MoreBeesBlockBeeHive, MoreBeesBlockHiveType> BEEHIVE = REGISTRY.blockGroup(MoreBeesBlockBeeHive::new, MoreBeesBlockHiveType.values()).itemWithType((block, type) -> new ItemBlockForestry<>(block, new Item.Properties())).identifier("beehive").create();

}
