package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.alveary.block.TileAlvearyBroodBox;
import com.noodlepfp.mobees.feature.MoreBeesApicultureMenuTypes;
import forestry.api.modules.IForestryPacketClient;
import forestry.core.gui.ContainerTile;
import forestry.core.gui.slots.SlotFiltered;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import forestry.core.network.packets.PacketGuiStream;
import forestry.core.tiles.TileUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

public class ContainerAlvearyBroodBox extends ContainerTile<TileAlvearyBroodBox> {

    private int mutagenStorage = -1;
    private int mutagenReserve = -1;
    private boolean isActive = false;
    private int energyStored = -1;

    public static ContainerAlvearyBroodBox fromNetwork(int windowId, Inventory inv, FriendlyByteBuf data) {
        TileAlvearyBroodBox tile = TileUtil.getTile(inv.player.level(), data.readBlockPos(), TileAlvearyBroodBox.class);
        return new ContainerAlvearyBroodBox(windowId, inv, tile);
    }

    public ContainerAlvearyBroodBox(int windowId, Inventory player, TileAlvearyBroodBox tile) {
        super(windowId, MoreBeesApicultureMenuTypes.ALVEARY_BROOD_BOX.menuType(), player, tile, 8, 87);

        ISlotPickupWatcher crafter = tile.getCrafter();

        this.addSlot(new SlotFiltered(this.tile, InventoryAlvearyBroodBox.SLOT_MUTAGEN, 47, 39).setPickupWatcher(crafter));
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        int mutagenStorage = this.tile.getMutagenStorage();
        int mutagenReserve = this.tile.getMutagenReserve();
        boolean isActive = this.tile.isActive();
        int energyStored = this.tile.getEnergyStorage().getEnergyStored();
        if (this.mutagenStorage != mutagenStorage || this.mutagenReserve != mutagenReserve || this.isActive != isActive || this.energyStored != energyStored) {
            this.mutagenStorage = mutagenStorage;
            this.mutagenReserve = mutagenReserve;
            this.isActive = isActive;
            this.energyStored = energyStored;
            IForestryPacketClient packet = new PacketGuiStream(this.tile);
            this.sendPacketToListeners(packet);
        }
    }
}
