package com.noodlepfp.mobees.alveary.block;

import com.noodlepfp.mobees.alveary.INBTStorable;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.alveary.MoreBeesTileActivatable;
import com.noodlepfp.mobees.gui.ContainerAlvearyFlowerBox;
import com.noodlepfp.mobees.gui.InventoryAlvearyFlowerBox;
import forestry.api.multiblock.IMultiblockComponent;
import forestry.core.inventory.IInventoryAdapter;
import forestry.core.inventory.watchers.ISlotPickupWatcher;
import forestry.core.network.IStreamable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.*;
import java.util.stream.Collectors;

import static com.noodlepfp.mobees.gui.InventoryAlvearyFrameHousing.SLOT_FRAME;

public class TileAlvearyFlowerBox extends MoreBeesTileActivatable implements IStreamable, INBTStorable {
    private final InventoryAlvearyFlowerBox inventory;
    public static final Set<Integer> FLOWER_PLOTS = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    public static final int FLOWER_GROWTH_TIME = 288000;
    private final String FLOWERS_GROWN_STR = "flowersGrown";
    private final String FLOWERS_DRY_STR = "flowersDry";
    private final String FLOWER_GROWTH_PROGRESS_STR = "flowerGrowthProgress";
    public final static String ITEM_NBT_TAG = "FlowerBoxData";
    private Set<Integer> flowersGrown;
    private Set<Integer> flowersDry;
    private int flowerGrowthProgress;
    private TileAlvearyBroodBox linkedBroodBox;
    private int flowerBoxUpdateTickRate = 200;

    public TileAlvearyFlowerBox(BlockPos pos, BlockState state) {
        super(MoreBeesBlockAlvearyType.FLOWER_BOX, pos, state);
        this.inventory = new InventoryAlvearyFlowerBox(this);
        this.flowersGrown = new HashSet<>();
        this.flowersDry = new HashSet<>();
        this.flowerGrowthProgress = FLOWER_GROWTH_TIME;
        this.linkedBroodBox = getAlvearyBroodBox();
        if (this.linkedBroodBox != null) {
            setActive(true);
        }
    }

    public Set<Integer> getFlowersGrown() {
        return this.flowersGrown;
    }

    public Set<Integer> getFlowersDry() {
        return this.flowersDry;
    }

    public int getFlowerGrowthProgress() {
        return this.flowerGrowthProgress;
    }

    @Override
    public void updateServer(int tickCount) {
        // if alveary is actively producing, tick flower growth progress
        // isActive should be set when the alveary is built, and a population box is detected.
        if (isActive()) {
            this.tickFlowerBoxGrowth(tickCount);
        }
    }

    private void tickFlowerBoxGrowth(int tickCount) {
        // check canWork every 10 seconds, no need to check more often, save on ticking.
        if (tickCount % this.flowerBoxUpdateTickRate == 0) {
            // if the alveary is working, and has a brood box (isActive), tick flower growth by update rate
            // TODO flower growth time should be decreased by bee population. up to 20% decrease?
            if (getBeekeepingLogic().canWork()) {
                // flower box has to be checked on frequently. any dry flowers will prevent more
                // from growing fully (they will still grow, but max 75% growth)
                if (!this.flowersDry.isEmpty()) {
                    this.flowerGrowthProgress = Math.max((int) (TileAlvearyFlowerBox.FLOWER_GROWTH_TIME * 0.25),
                            this.flowerGrowthProgress - this.flowerBoxUpdateTickRate);
                }

                // if there are no dry flowers in the box... continue growth
                this.flowerGrowthProgress -= flowerBoxUpdateTickRate;
                if (this.flowerGrowthProgress <= 0) {
                    newFlowerGrowthTick();
                }
                // if growth is complete, every flower growth time * 1.75, dry a flower out. max 8 flowers.
                else if (this.flowerGrowthProgress <= (TileAlvearyFlowerBox.FLOWER_GROWTH_TIME * 0.25)) {
                    fullBoxDecayTick();
                }
            }
        }
    }

    private void newFlowerGrowthTick() {
        this.flowerGrowthProgress = TileAlvearyFlowerBox.FLOWER_GROWTH_TIME;

        // if there are still empty plots and growth is complete, add a dry flower.
        if (this.flowersGrown.size() < TileAlvearyFlowerBox.FLOWER_PLOTS.size()) {
            List<Integer> availableFlowers = FLOWER_PLOTS.stream()
                    .filter(flower -> !flowersGrown.contains(flower))
                    .collect(Collectors.toList());

            int randPlot = new Random().nextInt(availableFlowers.size());
            flowersGrown.add(availableFlowers.get(randPlot));
            flowersDry.add(availableFlowers.get(randPlot));
        }
    }

    private void fullBoxDecayTick() {
        if (this.flowersGrown.size() == TileAlvearyFlowerBox.FLOWER_PLOTS.size() &&
                this.flowersDry.size() < 8) {
            this.flowerGrowthProgress = TileAlvearyFlowerBox.FLOWER_GROWTH_TIME * 2;

            List<Integer> availableFlowers = FLOWER_PLOTS.stream()
                    .filter(flower -> !flowersDry.contains(flower))
                    .collect(Collectors.toList());

            int randPlot = new Random().nextInt(availableFlowers.size());
            flowersDry.add(availableFlowers.get(randPlot));
        }
    }

    private TileAlvearyBroodBox getAlvearyBroodBox() {
        final Collection<IMultiblockComponent> components = getMultiblockLogic().getController().getComponents();
        for (IMultiblockComponent comp : components) {
            if (comp instanceof TileAlvearyBroodBox broodBox) {
                return broodBox;
            }
        }
        return null;
    }

    @Override
    public void updateClient(int tickCount) {
    }

    @Override
    public IInventoryAdapter getInternalInventory() {
        return this.inventory;
    }

    public ISlotPickupWatcher getCrafter() {
        return this.inventory;
    }

    @Override
    public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
        return new ContainerAlvearyFlowerBox(windowId, inv, this);
    }

    @Override
    public void load(CompoundTag compoundNBT) {
        super.load(compoundNBT);
        this.flowerGrowthProgress = compoundNBT.getInt(FLOWER_GROWTH_PROGRESS_STR);
        this.flowersGrown = new HashSet(Arrays.asList(compoundNBT.getIntArray(FLOWERS_GROWN_STR)));
        this.flowersDry = new HashSet(Arrays.asList(compoundNBT.getIntArray(FLOWERS_DRY_STR)));
        if (this.isActive()) {
            this.linkedBroodBox = getAlvearyBroodBox();
        }
    }

    @Override
    public void saveAdditional(CompoundTag compoundNBT) {
        super.saveAdditional(compoundNBT);
        compoundNBT.putInt(FLOWER_GROWTH_PROGRESS_STR, this.flowerGrowthProgress);
        compoundNBT.putIntArray(FLOWERS_GROWN_STR, new ArrayList<>(this.flowersGrown));
        compoundNBT.putIntArray(FLOWERS_DRY_STR, new ArrayList<>(this.flowersDry));
    }

    @Override
    public void saveNbt(CompoundTag compoundNBT) {
        super.saveNbt(compoundNBT);
        compoundNBT.putInt(FLOWER_GROWTH_PROGRESS_STR, this.flowerGrowthProgress);
        compoundNBT.putIntArray(FLOWERS_GROWN_STR, new ArrayList<>(this.flowersGrown));
        compoundNBT.putIntArray(FLOWERS_DRY_STR, new ArrayList<>(this.flowersDry));
    }

    // if the tile has anything in its inventory, or has any mutagen stored or being processed, it should store it when turned into an item.
    // energy should be ignored, it will cause inventory cluttering.
    @Override
    public void modifyItemNBT(ItemStack stack) {
        if (this.flowerGrowthProgress < FLOWER_GROWTH_TIME || !flowersGrown.isEmpty() || !flowersDry.isEmpty()) {
            CompoundTag tag = new CompoundTag();
            saveNbt(tag); // Save the BlockEntity data into tag
            stack.addTagElement(TileAlvearyFlowerBox.ITEM_NBT_TAG, tag);
        }
    }

    @Override
    public void writeData(FriendlyByteBuf data) {
        data.writeVarInt(this.flowerGrowthProgress);
        data.writeVarIntArray(this.flowersGrown.stream().mapToInt(Integer::intValue).toArray());
        data.writeVarIntArray(this.flowersDry.stream().mapToInt(Integer::intValue).toArray());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void readData(FriendlyByteBuf data) {
        this.flowerGrowthProgress = data.readVarInt();
        this.flowersGrown = new HashSet(Arrays.asList(data.readVarIntArray()));
        this.flowersDry = new HashSet(Arrays.asList(data.readVarIntArray()));
    }

    public void writeGuiData(FriendlyByteBuf data) {
        data.writeVarInt(this.flowerGrowthProgress);
        data.writeVarIntArray(this.flowersGrown.stream().mapToInt(Integer::intValue).toArray());
        data.writeVarIntArray(this.flowersDry.stream().mapToInt(Integer::intValue).toArray());
    }

    @OnlyIn(Dist.CLIENT)
    public void readGuiData(FriendlyByteBuf data) {
        this.flowerGrowthProgress = data.readVarInt();
        this.flowersGrown = new HashSet(Arrays.asList(data.readVarIntArray()));
        this.flowersDry = new HashSet(Arrays.asList(data.readVarIntArray()));
    }

    public static void modifyTooltip(List<Component> tooltip, ItemStack stack) {
        if (stack.hasTag() && stack.getTag().contains(TileAlvearyFlowerBox.ITEM_NBT_TAG)) {
            CompoundTag flowerBoxData = stack.getTag().getCompound(TileAlvearyFlowerBox.ITEM_NBT_TAG);

            // Extract mutagenReserve and mutagenStorage
            int mutagenStorage = flowerBoxData.getInt("storedMutagen");
            int storagePercent = (int)(mutagenStorage / (float) TileAlvearyMutator.getMutagenStorageCap() * 100);
            int mutagenCount = 0;
            ListTag items = flowerBoxData.getList("Items", Tag.TAG_COMPOUND);
            if (!items.isEmpty()) {
                mutagenCount = items.getCompound(SLOT_FRAME).getByte("Count");
            }

            // Add the extracted values to the tooltip
            tooltip.add(1, Component.literal("Mutagen Storage: ").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("[").withStyle(ChatFormatting.WHITE))
                    .append(Component.literal("|".repeat((storagePercent / 10) * 2)).withStyle(Style.EMPTY.withColor(0x79a66c)))
                    .append(Component.literal("|".repeat((10 - (storagePercent / 10)) * 2)).withStyle(ChatFormatting.DARK_GRAY))
                    .append(Component.literal("]").withStyle(ChatFormatting.WHITE))
                    .append(Component.literal(mutagenCount > 0 ? " + " + mutagenCount + "x" : "").withStyle(Style.EMPTY.withColor(0x79a66c))));
            tooltip.add(2, Component.empty());
        }
    }
}
