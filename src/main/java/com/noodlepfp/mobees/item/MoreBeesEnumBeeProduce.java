package com.noodlepfp.mobees.item;

import forestry.api.core.IItemSubtype;

import java.util.Locale;

public enum MoreBeesEnumBeeProduce implements IItemSubtype {

    DIAMOND_SHARD,
    EMERALD_SHARD,
    COAL_BIT,
    COPPER_BIT,
    TIN_BIT,
    LEAD_BIT,
    NICKEL_BIT,
    ZINC_BIT,
    OSMIUM_BIT,
    PLATINUM_BIT,
    SILVER_BIT,
    YELLORIUM_BIT,
    CERTUS_BIT,
    IRON_BIT,
    GOLD_BIT,
    NETHERITE_BIT,
    APATITE_BIT,
    SOUL_WAX,
    ARCANE_WAX,
    WITHER_SKULL_BIT,
    WITHER_SKULL_PARTIAL;

    private final String name;

    MoreBeesEnumBeeProduce() {
        this.name = toString().toLowerCase(Locale.ENGLISH);
    }

    @Override
    public String getSerializedName() {
        return name;
    }

}
