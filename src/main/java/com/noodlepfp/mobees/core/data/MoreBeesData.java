package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.MoBeesModCompat;
import forestry.core.data.ForestryRecipeProvider;
import forestry.core.data.models.ForestryItemModelProvider;
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

        generator.addProvider(event.includeClient(), new MoreBeesItemModelProvider(output, existingFileHelper));
    }
}
