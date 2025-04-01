package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.alveary.block.TileAlvearyFrameHousing;
import com.noodlepfp.mobees.core.data.MoreBeesTags;
import forestry.api.apiculture.hives.IHiveFrame;
import forestry.core.inventory.InventoryAdapterTile;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class InventoryAlvearyFrameHousing extends InventoryAdapterTile<TileAlvearyFrameHousing> implements ISlotPickupWatcher {
    public static final int SLOT_FRAME = 0;

    public InventoryAlvearyFrameHousing(TileAlvearyFrameHousing alvearyFrameHousing) {
        super(alvearyFrameHousing, 1, "Items", 1);
    }

    @Override
    public boolean canSlotAccept(int slotIndex, ItemStack stack) {
        for (TagKey<Item> tag : stack.getTags().toList()) {
            if (tag.equals(MoreBeesTags.Items.BEE_FRAME)) {
                return true;
            }
        }
        return false;
    }

    public Tuple<IHiveFrame, ItemStack> getFrame() {
        ItemStack stackInSlot = getItem(SLOT_FRAME);
        Item itemInSlot = stackInSlot.getItem();
        if (itemInSlot instanceof IHiveFrame frame) {
            return new Tuple<>(frame, stackInSlot.copy());
        }
        return null;
    }

    /* ISlotPickupWatcher */
    @Override
    public void onTake(int slotIndex, Player player) {
        setItem(SLOT_FRAME, ItemStack.EMPTY);
    }
}
