package com.noodlepfp.mobees.gui.widget;

import com.noodlepfp.mobees.alveary.block.TileAlvearyMutator;
import forestry.api.core.tooltips.ToolTip;
import forestry.core.gui.widgets.Widget;
import forestry.core.gui.widgets.WidgetManager;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MutagenStorageWidget extends Widget {

    private final TileAlvearyMutator tile;

    public MutagenStorageWidget(WidgetManager manager, int xPos, int yPos, TileAlvearyMutator tile) {
        super(manager, xPos, yPos);
        this.tile = tile;
        this.width = 59;
        this.height = 16;
    }

    @Override
    public void draw(GuiGraphics graphics, int startX, int startY) {
        int storageProgress = tile.getAttributeScaled(tile.getMutagenStorage(), TileAlvearyMutator.getMutagenStorageCap(), 59);
        graphics.blit(manager.gui.textureFile, 96, 39, 176, 0, storageProgress, 16);
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
            int stored = tile.getMutagenStorage();
            int cap = TileAlvearyMutator.getMutagenStorageCap();
            toolTip.add(Component.translatable("gui.widget.mutagen.stored").withStyle(Style.EMPTY.withColor(0x79a66c)));
            toolTip.add(Component.literal(stored + "/" + cap).withStyle(ChatFormatting.GRAY));
            toolTip.add(Component.empty());
            if (tile.canConsumeMutagen()) {
                toolTip.add(Component.translatable("gui.widget.mutagen.ready").withStyle(ChatFormatting.GREEN));
            } else {
                toolTip.add(Component.translatable("gui.widget.mutagen.insufficient").withStyle(ChatFormatting.RED));
            }
        }
    };
}
