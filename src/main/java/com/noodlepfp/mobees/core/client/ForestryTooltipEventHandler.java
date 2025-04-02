package com.noodlepfp.mobees.core.client;


import forestry.apiculture.blocks.BlockAlvearyType;
import forestry.apiculture.features.ApicultureBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = "mobees", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForestryTooltipEventHandler {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        if (Screen.hasShiftDown()) {
            if (stack.getItem().equals(ApicultureBlocks.ALVEARY.get(BlockAlvearyType.FAN).item())) {
                tooltip.add(tooltip.size() - 1, Component.empty());
                tooltip.add(tooltip.size() - 1, Component.translatable("block.forestry.alveary_fan_tooltip").withStyle(ChatFormatting.GRAY));
                tooltip.add(tooltip.size() - 1, Component.empty());
            } else if (stack.getItem().equals(ApicultureBlocks.ALVEARY.get(BlockAlvearyType.HEATER).item())) {
                tooltip.add(tooltip.size() - 1, Component.empty());
                tooltip.add(tooltip.size() - 1, Component.translatable("block.forestry.alveary_heater_tooltip").withStyle(ChatFormatting.GRAY));
                tooltip.add(tooltip.size() - 1, Component.empty());
            }
        }
    }

}
