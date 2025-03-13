package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.MoBees;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import thedarkcolour.modkit.data.DataHelper;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreBeesData {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataHelper dataHelper = new DataHelper(MoBees.MOD_ID, event);

        dataHelper.createTags(Registries.BLOCK, MoreBeesBlockTagsProvider::addTags);
    }
}
