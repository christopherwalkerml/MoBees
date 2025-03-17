package com.noodlepfp.mobees.item;

import forestry.api.core.IItemSubtype;

import java.util.Locale;

public enum MoreBeesEnumBeeProduce implements IItemSubtype {

    DIAMOND_SHARD,
    EMERALD_SHARD,
    COAL_BIT,
    COPPER_BIT,
    IRON_BIT,
    GOLD_BIT,
    NETHERITE_BIT;

    private final String name;

    MoreBeesEnumBeeProduce() {
        this.name = toString().toLowerCase(Locale.ENGLISH);
    }

    @Override
    public String getSerializedName() {
        return name;
    }

}
