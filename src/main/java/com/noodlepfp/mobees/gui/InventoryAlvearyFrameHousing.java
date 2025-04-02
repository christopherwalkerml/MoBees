package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.alveary.IInventoryHolder;
import com.noodlepfp.mobees.alveary.block.TileAlvearyFrameHousing;
import com.noodlepfp.mobees.core.data.tag.MoreBeesTags;
import forestry.api.apiculture.hives.IHiveFrame;
import forestry.core.inventory.InventoryAdapterTile;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class InventoryAlvearyFrameHousing extends InventoryAdapterTile<TileAlvearyFrameHousing> implements ISlotPickupWatcher, IInventoryHolder {
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

    public void damageFrame(int wear) {
        ItemStack frameStack = getItem(SLOT_FRAME);
        Item frameItem = frameStack.getItem();

        if (frameItem instanceof IHiveFrame hiveFrame) {
            ItemStack usedFrame = hiveFrame.frameUsed(tile, frameStack, null, wear);
            setItem(SLOT_FRAME, usedFrame);
        }
    }

    /* ISlotPickupWatcher */
    @Override
    public void onTake(int slotIndex, Player player) {
        setItem(SLOT_FRAME, ItemStack.EMPTY);
    }

    @Override
    public List<ItemStack> getDrops() {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(getItem(SLOT_FRAME));
        return drops;
    }
}
