package com.noodlepfp.mobees.item;

import forestry.core.items.ItemForestry;
import forestry.core.items.definitions.IColoredItem;
import net.minecraft.world.item.ItemStack;

public class MoreBeesItemHoneyComb extends ItemForestry implements IColoredItem {
    private final MoreBeesEnumHoneyComb type;

    public MoreBeesItemHoneyComb(MoreBeesEnumHoneyComb type) {
        this.type = type;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemstack, int tintIndex) {
        MoreBeesEnumHoneyComb honeyComb = this.type;

        if (tintIndex == 1) {
            return honeyComb.primaryColor;
        } else {
            return honeyComb.secondaryColor;
        }
    }
}
