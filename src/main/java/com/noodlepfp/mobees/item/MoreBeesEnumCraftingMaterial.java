package com.noodlepfp.mobees.item;

import forestry.api.core.IItemSubtype;

import java.util.Locale;

public enum MoreBeesEnumCraftingMaterial implements IItemSubtype {

    MUTATION_CATALYST,
    MUTAGEN;

    private final String name;

    private MoreBeesEnumCraftingMaterial() {
        this.name = this.toString().toLowerCase(Locale.ENGLISH);
    }

    public String getSerializedName() {
        return this.name;
    }

}
