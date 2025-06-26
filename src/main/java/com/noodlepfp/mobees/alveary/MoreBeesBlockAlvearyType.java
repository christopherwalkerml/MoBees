package com.noodlepfp.mobees.alveary;

import com.noodlepfp.mobees.feature.MoreBeesApicultureTiles;
import forestry.api.core.IBlockSubtype;
import forestry.modules.features.FeatureTileType;

import java.util.Locale;

public enum MoreBeesBlockAlvearyType implements IBlockSubtype {

    SUN(true),
    MOON(true),
    MUTATOR(true),
    RAINSHIELD(true),
    FRAME_HOUSING(false),
    FLOWER_BOX(false),
    BROOD_BOX(false);

    public final boolean activatable;

    MoreBeesBlockAlvearyType(boolean activatable) {
        this.activatable = activatable;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase(Locale.ENGLISH);
    }

    @Override
    public String getSerializedName() {
        return super.toString().toLowerCase(Locale.ENGLISH);
    }

    public FeatureTileType<?> getTileType() {
        return switch (this) {
            case SUN -> MoreBeesApicultureTiles.ALVEARY_SUN;
            case MOON -> MoreBeesApicultureTiles.ALVEARY_MOON;
            case MUTATOR -> MoreBeesApicultureTiles.ALVEARY_MUTATOR;
            case RAINSHIELD -> MoreBeesApicultureTiles.ALVEARY_RAINSHIELD;
            case FRAME_HOUSING -> MoreBeesApicultureTiles.FRAME_HOUSING;
            case FLOWER_BOX -> MoreBeesApicultureTiles.FLOWER_BOX;
            case BROOD_BOX -> MoreBeesApicultureTiles.BROOD_BOX;
        };
    }

}
