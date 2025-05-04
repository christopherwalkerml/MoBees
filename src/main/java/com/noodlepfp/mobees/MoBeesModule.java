package com.noodlepfp.mobees;

import com.noodlepfp.mobees.core.client.CoreClientHandler;
import forestry.api.client.IClientModuleHandler;
import forestry.api.modules.ForestryModule;
import forestry.api.modules.IForestryModule;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

@ForestryModule
public class MoBeesModule implements IForestryModule {

    @Override
    public ResourceLocation getId() {
        return MoBeesModule.mobees("core");
    }

    public static ResourceLocation mobees(String path) {
        return new ResourceLocation(MoBees.MOD_ID, path);
    }

    @Override
    public void registerClientHandler(Consumer<IClientModuleHandler> registrar) {
        registrar.accept(new CoreClientHandler());
    }
}
