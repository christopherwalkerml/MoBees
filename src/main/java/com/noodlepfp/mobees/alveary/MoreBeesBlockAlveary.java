package com.noodlepfp.mobees.alveary;

import com.noodlepfp.mobees.alveary.block.TileAlvearyFrameHousing;
import com.noodlepfp.mobees.alveary.block.TileAlvearyMutator;
import com.noodlepfp.mobees.alveary.block.TileAlvearyRainShield;
import com.noodlepfp.mobees.alveary.block.TileAlvearySun;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import forestry.api.farming.HorizontalDirection;
import forestry.apiculture.blocks.BlockAlveary;
import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.multiblock.TileAlveary;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class MoreBeesBlockAlveary extends BlockAlveary {
    public static final IntegerProperty LIGHT_LEVEL = IntegerProperty.create("light_level", 0, 15);
    public static final EnumProperty<Direction> FACING = EnumProperty.create("facing", Direction.class, HorizontalDirection.VALUES);

    private final MoreBeesBlockAlvearyType type;
    public MoreBeesBlockAlveary(MoreBeesBlockAlvearyType type) {
        super(BlockAlvearyType.PLAIN);
        this.type = type;

        BlockState defaultState = this.getStateDefinition().any();
        defaultState = defaultState.setValue(STATE, State.OFF);
        if (type == MoreBeesBlockAlvearyType.SUN) {
            defaultState = defaultState.setValue(LIGHT_LEVEL, 0);
        }
        if (type == MoreBeesBlockAlvearyType.FRAME_HOUSING) {
            defaultState = defaultState.setValue(STATE, State.ON);
            defaultState = defaultState.setValue(FACING, Direction.NORTH);
        }
        this.registerDefaultState(defaultState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIGHT_LEVEL, FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        Direction facing = state.getValue(FACING);
        return state.setValue(FACING, rot.rotate(facing));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return switch (type) {
            case SUN -> new TileAlvearySun(pos, state);
            case RAINSHIELD -> new TileAlvearyRainShield(pos, state);
            case MUTATOR -> new TileAlvearyMutator(pos, state);
            case FRAME_HOUSING -> new TileAlvearyFrameHousing(pos, state);
        };
    }

    @Override
    public BlockState getNewState(TileAlveary tile) {
        BlockState state = super.getNewState(tile);

        if (tile instanceof TileAlvearySun sun) {
            state = state.setValue(LIGHT_LEVEL, sun.getLightLevel());
        }

        if (tile instanceof TileAlvearyFrameHousing frameHousing) {
            state = state.setValue(FACING, frameHousing.getDirection());
            state = state.setValue(STATE, State.ON);
        }

        return state;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.hasProperty(LIGHT_LEVEL)) {
            return state.getValue(LIGHT_LEVEL);
        }
        return super.getLightEmission(state, world, pos);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (Screen.hasShiftDown()) {
            if (stack.getItem().equals(MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MUTATOR).item())) {
                tooltip.add(Component.empty());
                String[] ttSplitMsg = Component.translatable("block.mobees.alveary_mutator_tooltip").getString().split("%MUTAGEN");
                Component ttMsg = Component.literal(ttSplitMsg[0]).withStyle(ChatFormatting.GRAY)
                        .append(Component.translatable("block.mobees.alveary_mutator_mutagen_key").withStyle(Style.EMPTY.withColor(0x79a66c)))
                        .append(ttSplitMsg[1]).withStyle(ChatFormatting.GRAY);
                tooltip.add(ttMsg);
            } else if (stack.getItem().equals(MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.SUN).item())) {
                tooltip.add(Component.empty());
                tooltip.add(Component.translatable("block.mobees.alveary_sun_lamp_tooltip").withStyle(ChatFormatting.GRAY));
            }
        }
    }
}
