package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.alveary.mutator.TileAlvearyMutator;
import com.noodlepfp.mobees.feature.MoreBeesApicultureMenuTypes;
import forestry.api.modules.IForestryPacketClient;
import forestry.core.gui.ContainerTile;
import forestry.core.gui.slots.SlotFiltered;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import forestry.core.network.packets.PacketGuiStream;
import forestry.core.tiles.TileUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

public class ContainerAlvearyMutator extends ContainerTile<TileAlvearyMutator> {

    private int mutagenStorage = -1;
    private int mutagenReserve = -1;
    private boolean isActive = false;

    public static ContainerAlvearyMutator fromNetwork(int windowId, Inventory inv, FriendlyByteBuf data) {
        TileAlvearyMutator tile = TileUtil.getTile(inv.player.level(), data.readBlockPos(), TileAlvearyMutator.class);
        return new ContainerAlvearyMutator(windowId, inv, tile);
    }

    public ContainerAlvearyMutator(int windowId, Inventory player, TileAlvearyMutator tile) {
        super(windowId, MoreBeesApicultureMenuTypes.ALVEARY_MUTATOR.menuType(), player, tile, 8, 87);

        ISlotPickupWatcher crafter = tile.getCrafter();

        this.addSlot(new SlotFiltered(this.tile, InventoryAlvearyMutator.SLOT_MUTAGEN, 47, 39).setPickupWatcher(crafter));
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        int mutagenStorage = this.tile.getMutagenStorage();
        int mutagenReserve = this.tile.getMutagenReserve();
        boolean isActive = this.tile.isActive();
        if (this.mutagenStorage != mutagenStorage || this.mutagenReserve != mutagenReserve || this.isActive != isActive) {
            this.mutagenStorage = mutagenStorage;
            this.mutagenReserve = mutagenReserve;
            this.isActive = isActive;
            IForestryPacketClient packet = new PacketGuiStream(this.tile);
            this.sendPacketToListeners(packet);
        }
    }
}
