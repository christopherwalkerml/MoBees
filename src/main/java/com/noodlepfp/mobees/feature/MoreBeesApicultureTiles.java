package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.drain.TileAlvearyDrain;
import com.noodlepfp.mobees.alveary.mutator.TileAlvearyMutator;
import com.noodlepfp.mobees.alveary.sun.TileAlvearySun;
import com.noodlepfp.mobees.hive.MoreBeesTileHive;
import forestry.apiculture.features.ApicultureBlocks;
import forestry.apiculture.tiles.TileHive;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.FeatureTileType;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class MoreBeesApicultureTiles {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));

    public static final FeatureTileType<MoreBeesTileHive> HIVE = REGISTRY.tile(MoreBeesTileHive::new, "hive", () -> MoreBeesApicultureBlocks.BEEHIVE.getBlocks());
    public static final FeatureTileType<TileAlvearySun> ALVEARY_SUN = REGISTRY.tile(TileAlvearySun::new, "alveary_sun", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.SUN).collect());
    public static final FeatureTileType<TileAlvearyDrain> ALVEARY_DRAIN = REGISTRY.tile(TileAlvearyDrain::new, "alveary_drain", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.DRAIN).collect());
    public static final FeatureTileType<TileAlvearyMutator> ALVEARY_MUTATOR = REGISTRY.tile(TileAlvearyMutator::new, "alveary_mutator", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MUTATOR).collect());

}
