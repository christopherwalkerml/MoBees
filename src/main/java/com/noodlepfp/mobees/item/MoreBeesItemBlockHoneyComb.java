package com.noodlepfp.mobees.item;

import forestry.core.items.ItemBlockForestry;
import forestry.core.items.definitions.IColoredItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MoreBeesItemBlockHoneyComb extends ItemBlockForestry<MoreBeesBlockHoneyComb> implements IColoredItem {

    public MoreBeesItemBlockHoneyComb(MoreBeesBlockHoneyComb block) {
        super(block, new Item.Properties());
    }

    public int getColorFromItemStack(ItemStack stack, int tintIndex) {
        MoreBeesEnumHoneyComb honeyComb = ((MoreBeesBlockHoneyComb)this.getBlock()).getType();
        return tintIndex == 1 ? honeyComb.primaryColor : honeyComb.secondaryColor;
    }
}
