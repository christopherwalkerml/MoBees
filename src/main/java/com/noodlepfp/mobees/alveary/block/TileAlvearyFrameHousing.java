package com.noodlepfp.mobees.alveary.block;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlveary;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileAlveary;
import com.noodlepfp.mobees.gui.ContainerAlvearyFrameHousing;
import com.noodlepfp.mobees.gui.InventoryAlvearyFrameHousing;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.apiculture.hives.IHiveFrame;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutation;
import forestry.api.multiblock.IAlvearyComponent;
import forestry.apiculture.multiblock.MultiblockLogicAlveary;
import forestry.core.inventory.IInventoryAdapter;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TileAlvearyFrameHousing extends MoreBeesTileAlveary implements IAlvearyComponent.BeeModifier<MultiblockLogicAlveary> {

    private final InventoryAlvearyFrameHousing inventory;

    private final IBeeModifier MODIFIER = new IBeeModifier() {
        @Override
        public float modifyMutationChance(IGenome genome, IGenome mate, IMutation<IBeeSpecies> mutation, float currentChance) {
            return getFrameModifier().modifyMutationChance(genome, mate, mutation, currentChance);
        }

        @Override
        public float modifyAging(IGenome genome, @Nullable IGenome mate, float currentAging) {
            return getFrameModifier().modifyAging(genome, mate, currentAging);
        }

        @Override
        public float modifyProductionSpeed(IGenome genome, float currentSpeed) {
            return getFrameModifier().modifyProductionSpeed(genome, currentSpeed);
        }

        @Override
        public float modifyPollination(IGenome genome, float currentPollination) {
            return getFrameModifier().modifyPollination(genome, currentPollination);
        }

        @Override
        public float modifyGeneticDecay(IGenome genome, float currentDecay) {
            return getFrameModifier().modifyGeneticDecay(genome, currentDecay);
        }

        @Override
        public boolean isSealed() {
            return getFrameModifier().isSealed();
        }

        @Override
        public boolean isSunlightSimulated() {
            return getFrameModifier().isSunlightSimulated();
        }

        @Override
        public boolean isHellish() {
            return getFrameModifier().isHellish();
        }
    };

    public TileAlvearyFrameHousing(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.FRAME_HOUSING, pos, state);
        this.inventory = new InventoryAlvearyFrameHousing(this);
    }

    public IBeeModifier getFrameModifier() {
        Tuple<IHiveFrame, ItemStack> frame = inventory.getFrame();
        if (frame != null) {
            IHiveFrame hiveFrame = frame.getA();
            ItemStack stack = frame.getB();
            return hiveFrame.getBeeModifier(stack);
        }

        return new IBeeModifier() {
        };
    }

    public ISlotPickupWatcher getCrafter() {
        return this.inventory;
    }

    public Direction getDirection() {
        return this.getBlockState().getValue(MoreBeesBlockAlveary.FACING);
    }

    @Override
    public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
        return new ContainerAlvearyFrameHousing(windowId, inv, this);
    }

    @Override
    public IInventoryAdapter getInternalInventory() {
        return this.inventory;
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return MODIFIER;
    }
}
