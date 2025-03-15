package com.noodlepfp.mobees.core.client.tab;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.bee.MoreBeesSpecies;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.feature.MoreBeesItems;
import com.noodlepfp.mobees.hive.MoreBeesBlockHiveType;
import forestry.api.apiculture.genetics.BeeLifeStage;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.genetics.ILifeStage;
import forestry.core.tab.ForestryCreativeTabs;
import forestry.core.utils.SpeciesUtil;
import forestry.modules.features.FeatureCreativeTab;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;
import net.minecraft.world.item.CreativeModeTab;

@FeatureProvider
public class MoBeesCreativeTab {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));

    public static final FeatureCreativeTab MOBEES = REGISTRY.creativeTab("mobees", tab -> {
        tab.icon(() -> SpeciesUtil.BEE_TYPE.get().createStack(MoreBeesSpecies.CRYSTALLINE, BeeLifeStage.QUEEN));
        tab.displayItems(MoBeesCreativeTab::addApicultureItems);
        tab.withTabsBefore(ForestryCreativeTabs.FORESTRY.getKey());
        tab.withTabsAfter(ForestryCreativeTabs.ARBORICULTURE.getKey());
    });

    private static void addApicultureItems(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output items) {
        // Frames
        items.accept(MoreBeesApicultureItems.STURDY_FRAME);

        // Hives
        MoreBeesApicultureBlocks.BASE.getItems().forEach(items::accept);
        for (MoreBeesBlockHiveType type : MoreBeesBlockHiveType.values()) {
            if (type.getSpeciesId().toString().contains("mobees")) {
                items.accept(MoreBeesApicultureBlocks.BEEHIVE.get(type));
            }
        }

        // Misc items
        MoreBeesApicultureItems.BEE_COMBS.getItems().forEach(items::accept);

        for (ILifeStage stage : SpeciesUtil.BEE_TYPE.get().getLifeStages()) {
            for (IBeeSpecies species : SpeciesUtil.getAllBeeSpecies()) {
                if (species.id().toString().contains("mobees")) {
                    items.accept(species.createStack(stage));
                }
            }
        }

        MoreBeesItems.CRAFTING_MATERIALS.getItems().forEach(items::accept);
    }
}
