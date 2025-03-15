package com.noodlepfp.mobees.item;

import forestry.core.items.ItemForestry;
import net.minecraft.world.item.Item;

public class MoreBeesItemBeeProduce extends ItemForestry {
    private final MoreBeesEnumBeeProduce type;

    public MoreBeesItemBeeProduce(MoreBeesEnumBeeProduce type) {
        super(new Item.Properties());
        this.type = type;
    }

    public MoreBeesEnumBeeProduce getType() {
        return this.type;
    }
}
