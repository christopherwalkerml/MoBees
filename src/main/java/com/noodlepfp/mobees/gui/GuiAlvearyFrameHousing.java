package com.noodlepfp.mobees.gui;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.alveary.block.TileAlvearyFrameHousing;
import forestry.core.gui.GuiForestryTitled;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class GuiAlvearyFrameHousing extends GuiForestryTitled<ContainerAlvearyFrameHousing> {
    private final TileAlvearyFrameHousing tile;

    public GuiAlvearyFrameHousing(ContainerAlvearyFrameHousing container, Inventory inventory, Component title) {
        super(MoBeesModule.mobees("textures/gui/alveary_frame_housing.png"), container, inventory, title);
        this.tile = container.getTile();
    }

    @Override
    protected void addLedgers() {
    }
}
