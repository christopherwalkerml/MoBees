package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.block.TileAlvearyRainShield;
import com.noodlepfp.mobees.alveary.block.TileAlvearyMutator;
import com.noodlepfp.mobees.alveary.block.TileAlvearySun;
import com.noodlepfp.mobees.hive.MoreBeesTileHive;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.FeatureTileType;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class MoreBeesApicultureTiles {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBeesModule.mobees("core"));

    public static final FeatureTileType<MoreBeesTileHive> HIVE = REGISTRY.tile(MoreBeesTileHive::new, "hive", () -> MoreBeesApicultureBlocks.BEEHIVE.getBlocks());
    public static final FeatureTileType<TileAlvearySun> ALVEARY_SUN = REGISTRY.tile(TileAlvearySun::new, "alveary_sun", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.SUN).collect());
    public static final FeatureTileType<TileAlvearyRainShield> ALVEARY_RAINSHIELD = REGISTRY.tile(TileAlvearyRainShield::new, "alveary_rainshield", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.RAINSHIELD).collect());
    public static final FeatureTileType<TileAlvearyMutator> ALVEARY_MUTATOR = REGISTRY.tile(TileAlvearyMutator::new, "alveary_mutator", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MUTATOR).collect());

}
