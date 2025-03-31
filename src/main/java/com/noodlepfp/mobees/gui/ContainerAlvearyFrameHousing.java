package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.alveary.block.TileAlvearyFrameHousing;
import com.noodlepfp.mobees.feature.MoreBeesApicultureMenuTypes;
import forestry.core.gui.ContainerTile;
import forestry.core.gui.slots.SlotFiltered;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import forestry.core.tiles.TileUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

public class ContainerAlvearyFrameHousing extends ContainerTile<TileAlvearyFrameHousing> {

    public static ContainerAlvearyFrameHousing fromNetwork(int windowId, Inventory inv, FriendlyByteBuf data) {
        TileAlvearyFrameHousing tile = TileUtil.getTile(inv.player.level(), data.readBlockPos(), TileAlvearyFrameHousing.class);
        return new ContainerAlvearyFrameHousing(windowId, inv, tile);
    }

    public ContainerAlvearyFrameHousing(int windowId, Inventory player, TileAlvearyFrameHousing tile) {
        super(windowId, MoreBeesApicultureMenuTypes.ALVEARY_FRAME_HOUSING.menuType(), player, tile, 8, 87);

        ISlotPickupWatcher crafter = tile.getCrafter();

        this.addSlot(new SlotFiltered(this.tile, InventoryAlvearyFrameHousing.SLOT_FRAME, 79, 39).setPickupWatcher(crafter));
    }
}
