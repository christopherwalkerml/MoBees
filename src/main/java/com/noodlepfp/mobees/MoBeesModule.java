package com.noodlepfp.mobees;

import forestry.api.modules.ForestryModule;
import forestry.api.modules.IForestryModule;
import net.minecraft.resources.ResourceLocation;

@ForestryModule
public class MoBeesModule implements IForestryModule {

    @Override
    public ResourceLocation getId() {
        return MoBeesModule.mobees("core");
    }

    public static ResourceLocation mobees(String path) {
        return new ResourceLocation(MoBees.MOD_ID, path);
    }
}
