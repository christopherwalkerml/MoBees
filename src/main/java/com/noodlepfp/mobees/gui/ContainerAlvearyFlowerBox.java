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

import java.util.Set;

public class ContainerAlvearyFlowerBox extends ContainerTile<TileAlvearyFlowerBox> {

    private Set<Integer> flowersGrown;
    private Set<Integer> flowersDry;
    private int flowerGrowthProgress;
    private boolean isActive = false;

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
        Set<Integer> flowersGrown = this.tile.getFlowersGrown();
        Set<Integer> flowersDry = this.tile.getFlowersGrown();
        int flowerGrowthProgress = this.tile.getFlowerGrowthProgress();
        boolean isActive = this.tile.isActive();

        if (this.flowersGrown != flowersGrown || this.flowersDry != flowersDry || this.isActive != isActive || this.flowerGrowthProgress != flowerGrowthProgress) {
            this.flowersGrown = flowersGrown;
            this.flowersDry = flowersDry;
            this.isActive = isActive;
            IForestryPacketClient packet = new PacketGuiStream(this.tile);
            this.sendPacketToListeners(packet);
        }
    }
}
