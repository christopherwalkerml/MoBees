package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.alveary.mutator.TileAlvearyMutator;
import forestry.core.gui.GuiForestryTitled;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class GuiAlvearyMutator extends GuiForestryTitled<ContainerAlvearyMutator> {
    private final TileAlvearyMutator tile;

    public GuiAlvearyMutator(ContainerAlvearyMutator container, Inventory inventory, Component title) {
        super(MoBeesModule.mobees("textures/gui/alveary_mutator.png"), container, inventory, title);
        this.tile = container.getTile();
    }

    @Override
    protected void drawWidgets(GuiGraphics graphics) {
        int progress = this.tile.getProgressScaled(23);
        graphics.blit(this.textureFile, 69 + (23 - progress), 45, 176 + (23 - progress), 22, progress, 4);

        if (this.tile.isActive()) {
            graphics.blit(this.textureFile, 77, 34, 176, 16, 6, 6);
        }

        super.drawWidgets(graphics);
    }

    @Override
    protected void addLedgers() {
        addErrorLedger(tile);
    }
}
