package com.noodlepfp.mobees.item;

import forestry.core.items.ItemForestry;
import forestry.core.items.definitions.IColoredItem;
import net.minecraft.world.item.ItemStack;

public class MoreBeesItemHoneyComb extends ItemForestry implements IColoredItem {
    private final MBEnumHoneyComb type;

    public MoreBeesItemHoneyComb(MBEnumHoneyComb type) {
        this.type = type;
    }



    @Override
    public int getColorFromItemStack(ItemStack itemstack, int tintIndex) {
        MBEnumHoneyComb honeyComb = this.type;

        if (tintIndex == 1) {
            return honeyComb.primaryColor;
        } else {
            return honeyComb.secondaryColor;
        }
    }
}
