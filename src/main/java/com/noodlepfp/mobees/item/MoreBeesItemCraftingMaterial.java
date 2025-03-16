package com.noodlepfp.mobees.item;

import forestry.core.items.ItemForestry;

public class MoreBeesItemCraftingMaterial extends ItemForestry {

    private final MoreBeesEnumCraftingMaterial type;

    public MoreBeesItemCraftingMaterial(MoreBeesEnumCraftingMaterial type) {
        this.type = type;
    }

    public MoreBeesEnumCraftingMaterial getType() {
        return this.type;
    }

}
