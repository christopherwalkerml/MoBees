package com.noodlepfp.mobees.core.client.tab;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.bee.MoreBeesSpecies;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.feature.MoreBeesCrateItems;
import com.noodlepfp.mobees.feature.MoreBeesItems;
import com.noodlepfp.mobees.hive.MoreBeesBlockHiveType;
import forestry.api.apiculture.genetics.BeeLifeStage;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.genetics.ILifeStage;
import forestry.apiculture.blocks.NaturalistChestBlockType;
import forestry.apiculture.features.ApicultureBlocks;
import forestry.core.features.CoreBlocks;
import forestry.core.features.CoreItems;
import forestry.core.features.FluidsItems;
import forestry.core.fluids.ForestryFluids;
import forestry.core.items.definitions.EnumContainerType;
import forestry.core.items.definitions.FluidHandlerItemForestry;
import forestry.core.tab.ForestryCreativeTabs;
import forestry.core.utils.SpeciesUtil;
import forestry.factory.blocks.BlockTypeFactoryTesr;
import forestry.factory.features.FactoryBlocks;
import forestry.modules.features.*;
import forestry.sorting.features.SortingBlocks;
import forestry.storage.features.BackpackItems;
import forestry.storage.features.CrateItems;
import forestry.storage.items.ItemCrated;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.registries.ForgeRegistries;

@FeatureProvider
public class MoreBeesCreativeTab {

    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));

    public static final FeatureCreativeTab MOBEES = REGISTRY.creativeTab("mobees", tab -> {
        tab.icon(() -> SpeciesUtil.BEE_TYPE.get().createStack(MoreBeesSpecies.CRYSTALLINE, BeeLifeStage.QUEEN));
        tab.displayItems(MoreBeesCreativeTab::addStorageItems);
        tab.displayItems(MoreBeesCreativeTab::addApicultureItems);
        tab.withTabsBefore(ForestryCreativeTabs.FORESTRY.getKey());
        tab.withTabsAfter(ForestryCreativeTabs.ARBORICULTURE.getKey());
    });

    private static void addApicultureItems(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output items) {
        // Frames
        // items.accept(MoreBeesApicultureItems.STURDY_FRAME);

        // Hives
        for (MoreBeesBlockHiveType type : MoreBeesBlockHiveType.values()) {
            if (type.getSpeciesId().toString().contains("mobees")) {
                items.accept(MoreBeesApicultureBlocks.BEEHIVE.get(type));
            }
        }

        // Alveary
        MoreBeesApicultureBlocks.ALVEARY.getItems().forEach(items::accept);

        // Misc items
        MoreBeesApicultureBlocks.BEE_COMB.getItems().forEach(items::accept);
        MoreBeesApicultureItems.BEE_COMBS.getItems().forEach(items::accept);

        for (ILifeStage stage : SpeciesUtil.BEE_TYPE.get().getLifeStages()) {
            for (IBeeSpecies species : SpeciesUtil.getAllBeeSpecies()) {
                if (species.id().toString().contains("mobees")) {
                    items.accept(species.createStack(stage));
                }
            }
        }

        MoreBeesItems.BEE_PRODUCE_MATERIALS.getItems().forEach(items::accept);
        MoreBeesItems.CRAFTING_MATERIALS.getItems().forEach(items::accept);
    }

    private static void addStorageItems(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output items) {
        // Filled crates
        for (FeatureItem<ItemCrated> crate : MoreBeesCrateItems.getCrates()) {
            items.accept(crate);
        }
    }

}
