package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import forestry.apiculture.features.ApicultureItems;
import forestry.core.data.builder.FilledCrateModelBuilder;
import forestry.core.utils.ModUtil;
import forestry.modules.features.FeatureItem;
import forestry.storage.features.CrateItems;
import forestry.storage.items.ItemCrated;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MoreBeesItemModelProvider extends ItemModelProvider {

    public MoreBeesItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoBees.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (FeatureItem<ItemCrated> featureCrated : CrateItems.getCrates()) {
            Item containedItem = featureCrated.get().getContained().getItem();
            String id = featureCrated.getName();

            if (ApicultureItems.BEE_COMBS.itemEqual(containedItem)) {
                filledCrateModelLayered(id, modLoc("item/bee_combs.0"), modLoc("item/bee_combs.1"));
            }
        }

        // 2d items
        basicItem(MoreBeesApicultureItems.FRAME_PRESERVATION.get());
    }

    private static String path(Item block) {
        return ModUtil.getRegistryName(block).getPath();
    }

    private void filledCrateModelLayered(String id, ResourceLocation layer1, ResourceLocation layer2) {
        getBuilder(id)
                .customLoader(FilledCrateModelBuilder::begin)
                .layer1(layer1)
                .layer2(layer2)
                .end();
    }

}
