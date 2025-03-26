package com.noodlepfp.mobees;

import com.noodlepfp.mobees.core.client.CoreClientHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoBees.MOD_ID)
public class MoBees
{
    public static final String MOD_ID = "mobees";

    public MoBees(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        CoreClientHandler ccHandler = new CoreClientHandler();
        ccHandler.registerEvents(modEventBus);
    }
}
