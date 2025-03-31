package com.noodlepfp.mobees.gui.widget;

import com.noodlepfp.mobees.alveary.block.TileAlvearyMutator;
import forestry.api.core.tooltips.ToolTip;
import forestry.core.gui.widgets.Widget;
import forestry.core.gui.widgets.WidgetManager;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PowerIconWidget extends Widget {

    private final TileAlvearyMutator tile;

    public PowerIconWidget(WidgetManager manager, int xPos, int yPos, TileAlvearyMutator tile) {
        super(manager, xPos, yPos);
        this.tile = tile;
        this.width = 6;
        this.height = 6;
    }

    @Override
    public void draw(GuiGraphics graphics, int startX, int startY) {
        if (this.tile.isActive()) {
            graphics.blit(manager.gui.textureFile, 77, 34, 176, 20, 6, 6);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ToolTip getToolTip(int mouseX, int mouseY) {
        return toolTip;
    }

    private final ToolTip toolTip = new ToolTip() {
        @Override
        @OnlyIn(Dist.CLIENT)
        public void refresh() {
            toolTip.clear();
            if (tile.isActive()) {
                toolTip.add(Component.translatable("gui.widget.power.on").withStyle(ChatFormatting.GREEN));
                int stored = tile.getEnergyStorage().getEnergyStored();
                int cap = tile.getEnergyStorage().getMaxEnergyStored();
                toolTip.add(Component.translatable("gui.widget.power.stored").append(":").withStyle(ChatFormatting.GOLD));
                toolTip.add(Component.literal(stored + "/" + cap + " RF").withStyle(ChatFormatting.GRAY));
            } else {
                toolTip.add(Component.translatable("gui.widget.power.off").withStyle(ChatFormatting.GRAY));
            }
        }
    };
}
