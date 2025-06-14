package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.block.*;
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
    public static final FeatureTileType<TileAlvearyMoon> ALVEARY_MOON = REGISTRY.tile(TileAlvearyMoon::new, "alveary_moon", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MOON).collect());
    public static final FeatureTileType<TileAlvearyRainShield> ALVEARY_RAINSHIELD = REGISTRY.tile(TileAlvearyRainShield::new, "alveary_rainshield", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.RAINSHIELD).collect());
    public static final FeatureTileType<TileAlvearyMutator> ALVEARY_MUTATOR = REGISTRY.tile(TileAlvearyMutator::new, "alveary_mutator", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MUTATOR).collect());
    public static final FeatureTileType<TileAlvearyFrameHousing> FRAME_HOUSING = REGISTRY.tile(TileAlvearyFrameHousing::new, "alveary_frame_housing", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.FRAME_HOUSING).collect());
    public static final FeatureTileType<TileAlvearyFlowerBox> FLOWER_BOX = REGISTRY.tile(TileAlvearyFlowerBox::new, "alveary_flower_box", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.FLOWER_BOX).collect());
    public static final FeatureTileType<TileAlvearyBroodBox> BROOD_BOX = REGISTRY.tile(TileAlvearyBroodBox::new, "alveary_brood_box", () -> MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.BROOD_BOX).collect());

}
