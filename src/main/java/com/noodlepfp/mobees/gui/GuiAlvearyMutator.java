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
        int reserveProgress = this.tile.getAttributeScaled(this.tile.getMutagenReserve(), this.tile.getMutagenReserveCap(), 23);
        graphics.blit(this.textureFile, 69 + (23 - reserveProgress), 45, 176 + (23 - reserveProgress), 26, reserveProgress, 4);

        int storageProgress = this.tile.getAttributeScaled(this.tile.getMutagenStorage(), this.tile.getMutagenStorageCap(), 59);
        graphics.blit(this.textureFile, 96, 39, 176, 0, storageProgress, 16);

        if (this.tile.canConsumeMutagen()) {
            graphics.blit(this.textureFile, 124, 57, 204, 18, 3, 2);
        }

        if (this.tile.isActive()) {
            graphics.blit(this.textureFile, 77, 34, 176, 20, 6, 6);
        }

        super.drawWidgets(graphics);
    }

    @Override
    protected void addLedgers() {
        addErrorLedger(tile);
    }
}
