package com.noodlepfp.mobees.item;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.genetics.IBee;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.apiculture.hives.IHiveFrame;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutation;
import forestry.core.items.ItemForestry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.List;

public class MoreBeesItemHiveFrame extends ItemForestry implements IHiveFrame {

    private final Modifier beeModifier;

    public MoreBeesItemHiveFrame(MoreBeesItemHiveFrameBuilder builder) {
        super((new Item.Properties()).durability(builder.maxDmg));
        this.beeModifier = new Modifier(builder.ageMult,
                builder.speedMult,
                builder.pollinationMult,
                builder.decayMult,
                builder.mutationMult,
                builder.isRainproof,
                builder.isAlwaysSunny,
                builder.isHellish);
    }

    @Override
    public ItemStack frameUsed(IBeeHousing housing, ItemStack frame, IBee queen, int wear) {
        return frame.hurt(wear, housing.getWorldObj().getRandom(), null) ? ItemStack.EMPTY : frame;
    }

    @Override
    public void appendHoverText(ItemStack stack, @org.jetbrains.annotations.Nullable Level world, List<Component> tooltip, TooltipFlag advanced) {
        super.appendHoverText(stack, world, tooltip, advanced);
        DecimalFormat FORMAT = new DecimalFormat("#.##");

        if (beeModifier.speedMult != 1) {
            tooltip.add(Component.translatable("item.mobees.bee.modifier.speed_multiplier")
                    .append(": ")
                    .append(Component.literal(FORMAT.format(beeModifier.speedMult) + "x")
                            .withStyle(beeModifier.speedMult > 1 ? ChatFormatting.GREEN : ChatFormatting.RED)));
        }
        if (beeModifier.decayMult != 1) {
            tooltip.add(Component.translatable("item.mobees.bee.modifier.decay_multiplier")
                    .append(": ")
                    .append(Component.literal(FORMAT.format(beeModifier.decayMult) + "x")
                            .withStyle(beeModifier.decayMult > 1 ? ChatFormatting.RED : ChatFormatting.GREEN)));
        }
        if (beeModifier.pollinationMult != 1) {
            tooltip.add(Component.translatable("item.mobees.bee.modifier.pollination_multiplier")
                    .append(": ")
                    .append(Component.literal(FORMAT.format(beeModifier.pollinationMult) + "x")
                            .withStyle(beeModifier.pollinationMult > 1 ? ChatFormatting.GREEN : ChatFormatting.RED)));
        }
        if (beeModifier.mutationMult != 1) {
            tooltip.add(Component.translatable("item.mobees.bee.modifier.mutation_multiplier")
                    .append(": ")
                    .append(Component.literal(FORMAT.format(beeModifier.mutationMult) + "x")
                            .withStyle(beeModifier.mutationMult > 1 ? ChatFormatting.GREEN : ChatFormatting.RED)));
        }
        if (beeModifier.ageMult != 1) {
            tooltip.add(Component.translatable("item.mobees.bee.modifier.lifespan_multiplier")
                    .append(": ")
                    .append(Component.literal(FORMAT.format(beeModifier.ageMult) + "x")
                            .withStyle(beeModifier.ageMult > 1 ? ChatFormatting.GREEN : ChatFormatting.RED)));
        }
        if (beeModifier.isRainproof) {
            tooltip.add(Component.translatable("item.mobees.bee.modifier.is_rainproof")
                    .append(": ").append(Component.literal("true").withStyle(ChatFormatting.BLUE)));
        }
        if (beeModifier.isAlwaysSunny) {
            tooltip.add(Component.translatable("item.mobees.bee.modifier.is_always_sunny")
                    .append(": ").append(Component.literal("true").withStyle(ChatFormatting.GREEN)));
        }
        if (beeModifier.isHellish) {
            tooltip.add(Component.translatable("item.mobees.bee.modifier.is_hellish")
                    .append(": ").append(Component.literal("true").withStyle(ChatFormatting.GREEN)));
        }
        if (!stack.isDamaged()) {
            tooltip.add(Component.translatable("item.forestry.durability", new Object[]{stack.getMaxDamage()}));
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
            return Math.min(currentChance * mutationMult, 0.5f);
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

    public static class MoreBeesItemHiveFrameBuilder {

        // required params
        private int maxDmg = 64;

        // optional params
        private float ageMult = 1;
        private float speedMult = 1;
        private float pollinationMult = 1;
        private float decayMult = 1;
        private float mutationMult = 1;
        private boolean isRainproof = false;
        private boolean isAlwaysSunny = false;
        private boolean isHellish = false;

        public MoreBeesItemHiveFrameBuilder(int maxDmg) {
            this.maxDmg = maxDmg;
        }

        public MoreBeesItemHiveFrameBuilder setAgeMult(float ageMult) {
            this.ageMult = ageMult;
            return this;
        }

        public MoreBeesItemHiveFrameBuilder setSpeedMult(float speedMult) {
            this.speedMult = speedMult;
            return this;
        }

        public MoreBeesItemHiveFrameBuilder setPollinationMult(float pollinationMult) {
            this.pollinationMult = pollinationMult;
            return this;
        }

        public MoreBeesItemHiveFrameBuilder setDecayMult(float decayMult) {
            this.decayMult = decayMult;
            return this;
        }

        public MoreBeesItemHiveFrameBuilder setMutationMult(float mutationMult) {
            this.mutationMult = mutationMult;
            return this;
        }

        public MoreBeesItemHiveFrameBuilder setIsRainproof(boolean isRainproof) {
            this.isRainproof = isRainproof;
            return this;
        }

        public MoreBeesItemHiveFrameBuilder setIsAlwaysSunny(boolean isAlwaysSunny) {
            this.isAlwaysSunny = isAlwaysSunny;
            return this;
        }

        public MoreBeesItemHiveFrameBuilder setIsHellish(boolean isHellish) {
            this.isHellish = isHellish;
            return this;
        }

        public MoreBeesItemHiveFrame build() {
            return new MoreBeesItemHiveFrame(this);
        }
    }
}
