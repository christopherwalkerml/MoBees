package com.noodlepfp.mobees.item;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.genetics.IBee;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.apiculture.hives.IHiveFrame;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutation;
import forestry.apiculture.items.ItemCreativeHiveFrame;
import forestry.core.items.ItemForestry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MoreBeesItemHiveFrame extends ItemForestry implements IHiveFrame {

    private final Modifier beeModifier;

    public MoreBeesItemHiveFrame(float ageMult, float speedMult, float pollinationMult, float decayMult, float mutationMult, boolean isRainproof, boolean isAlwaysSunny, boolean isHellish) {
        this.beeModifier = new Modifier(ageMult, speedMult, pollinationMult, decayMult, mutationMult, isRainproof, isAlwaysSunny, isHellish);
    }

    @Override
    public ItemStack frameUsed(IBeeHousing housing, ItemStack frame, IBee queen, int wear) {
        return frame;
    }

    @Override
    public void appendHoverText(ItemStack stack, @org.jetbrains.annotations.Nullable Level world, List<Component> tooltip, TooltipFlag advanced) {
        super.appendHoverText(stack, world, tooltip, advanced);

        if (beeModifier.speedMult != 1) {
            tooltip.add(Component.translatable("item.forestry.bee.modifier.production", beeModifier.speedMult));
        }
        if (beeModifier.decayMult != 1) {
            tooltip.add(Component.translatable("item.forestry.bee.modifier.genetic.decay", beeModifier.decayMult));
        }
        if (beeModifier.pollinationMult != 1) {
            tooltip.add(Component.translatable("item.forestry.bee.modifier.pollination_multiplier", beeModifier.pollinationMult));
        }
        if (beeModifier.mutationMult != 1) {
            tooltip.add(Component.translatable("item.forestry.bee.modifier.mutation_multiplier", beeModifier.mutationMult));
        }
        if (beeModifier.ageMult != 1) {
            tooltip.add(Component.translatable("item.forestry.bee.modifier.lifespan_multiplier", beeModifier.ageMult));
        }
        if (beeModifier.isRainproof) {
            tooltip.add(Component.translatable("item.forestry.bee.modifier.is_rainproof", beeModifier.isRainproof));
        }
        if (beeModifier.isAlwaysSunny) {
            tooltip.add(Component.translatable("item.forestry.bee.modifier.is_always_sunny", beeModifier.isAlwaysSunny));
        }
        if (beeModifier.isHellish) {
            tooltip.add(Component.translatable("item.forestry.bee.modifier.is_hellish", beeModifier.isHellish));
        }
    }

    public IBeeModifier getBeeModifier(ItemStack frame) {
        return this.beeModifier;
    }

    private class Modifier implements IBeeModifier {

        private final float ageMult;
        private final float speedMult;
        private final float pollinationMult;
        private final float decayMult;
        private final float mutationMult;
        private final boolean isRainproof;
        private final boolean isAlwaysSunny;
        private final boolean isHellish;
        public Modifier(float ageMult, float speedMult, float pollinationMult, float decayMult, float mutationMult, boolean isRainproof, boolean isAlwaysSunny, boolean isHellish) {
            this.ageMult = ageMult;
            this.speedMult = speedMult;
            this.pollinationMult = pollinationMult;
            this.decayMult = decayMult;
            this.mutationMult = mutationMult;
            this.isRainproof = isRainproof;
            this.isAlwaysSunny = isAlwaysSunny;
            this.isHellish = isHellish;
        }

        @Override
        public float modifyMutationChance(IGenome genome, IGenome mate, IMutation<IBeeSpecies> mutation, float currentChance) {
            return currentChance * mutationMult;
        }

        @Override
        public float modifyAging(IGenome genome, @Nullable IGenome mate, float currentAging) {
            return currentAging * ageMult;
        }

        @Override
        public float modifyProductionSpeed(IGenome genome, float currentSpeed) {
            return currentSpeed * speedMult;
        }

        @Override
        public float modifyPollination(IGenome genome, float currentPollination) {
            return currentPollination * pollinationMult;
        }

        @Override
        public float modifyGeneticDecay(IGenome genome, float currentDecay) {
            return currentDecay * decayMult;
        }

        @Override
        public boolean isSealed() {
            return isRainproof;
        }

        @Override
        public boolean isSunlightSimulated() {
            return isAlwaysSunny;
        }

        @Override
        public boolean isHellish() {
            return isHellish;
        }
    }
}
