package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.alveary.block.TileAlvearyMutator;
import com.noodlepfp.mobees.feature.MoreBeesItems;
import com.noodlepfp.mobees.item.MoreBeesEnumCraftingMaterial;
import forestry.core.inventory.InventoryAdapterTile;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import forestry.core.utils.ItemStackUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class InventoryAlvearyMutator extends InventoryAdapterTile<TileAlvearyMutator> implements ISlotPickupWatcher {
    public static final int SLOT_MUTAGEN = 0;

    public InventoryAlvearyMutator(TileAlvearyMutator alvearyMutator) {
        super(alvearyMutator, 1, "Items", 64);
    }

    @Override
    public boolean canSlotAccept(int slotIndex, ItemStack stack) {
        return ItemStackUtil.isIdenticalItem(MoreBeesItems.CRAFTING_MATERIALS.stack(MoreBeesEnumCraftingMaterial.MUTAGEN, 1), stack);
    }

    /* ISlotPickupWatcher */
    @Override
    public void onTake(int slotIndex, Player player) {
        setItem(SLOT_MUTAGEN, ItemStack.EMPTY);
    }

    public boolean canUseMutagen() {
        if (getItem(SLOT_MUTAGEN).isEmpty()) {
            return false;
        }

        return getItem(SLOT_MUTAGEN).getCount() > 0;
    }

    public void useMutagen() {
        ItemStack mutagenStack = getItem(SLOT_MUTAGEN);
        mutagenStack.setCount(mutagenStack.getCount() - 1);
        setItem(SLOT_MUTAGEN, mutagenStack);
    }
}
