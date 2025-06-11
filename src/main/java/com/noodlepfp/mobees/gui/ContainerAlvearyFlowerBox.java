package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.alveary.block.TileAlvearyFlowerBox;
import com.noodlepfp.mobees.feature.MoreBeesApicultureMenuTypes;
import forestry.api.modules.IForestryPacketClient;
import forestry.core.gui.ContainerTile;
import forestry.core.gui.slots.SlotFiltered;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import forestry.core.network.packets.PacketGuiStream;
import forestry.core.tiles.TileUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

public class ContainerAlvearyFlowerBox extends ContainerTile<TileAlvearyFlowerBox> {

    private int mutagenStorage = -1;
    private int mutagenReserve = -1;
    private boolean isActive = false;
    private int energyStored = -1;

    public static ContainerAlvearyFlowerBox fromNetwork(int windowId, Inventory inv, FriendlyByteBuf data) {
        TileAlvearyFlowerBox tile = TileUtil.getTile(inv.player.level(), data.readBlockPos(), TileAlvearyFlowerBox.class);
        return new ContainerAlvearyFlowerBox(windowId, inv, tile);
    }

    public ContainerAlvearyFlowerBox(int windowId, Inventory player, TileAlvearyFlowerBox tile) {
        super(windowId, MoreBeesApicultureMenuTypes.ALVEARY_FLOWER_BOX.menuType(), player, tile, 8, 87);

        ISlotPickupWatcher crafter = tile.getCrafter();

        this.addSlot(new SlotFiltered(this.tile, InventoryAlvearyFlowerBox.SLOT_MUTAGEN, 47, 39).setPickupWatcher(crafter));
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
