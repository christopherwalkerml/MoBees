package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.MoBeesModCompat;
import com.noodlepfp.mobees.core.data.loot.MoreBeesLootTableProvider;
import com.noodlepfp.mobees.core.data.tag.MoreBeesBlockTagsProvider;
import com.noodlepfp.mobees.core.data.tag.MoreBeesItemTagsProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import thedarkcolour.modkit.data.DataHelper;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreBeesData {

    static {
        if (DatagenModLoader.isRunningDataGen()) {
            MoBeesModCompat.registerModData();
        }
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        DataHelper dataHelper = new DataHelper(MoBees.MOD_ID, event);

        dataHelper.createRecipes(MoreBeesRecipeProvider::addRecipes);
        dataHelper.createTags(Registries.BLOCK, MoreBeesBlockTagsProvider::addTags);
        dataHelper.createTags(Registries.ITEM, MoreBeesItemTagsProvider::addTags);

        generator.addProvider(event.includeClient(), new MoreBeesItemModelProvider(output, existingFileHelper));

        generator.addProvider(event.includeServer(), new MoreBeesLootTableProvider(output));
    }
}
