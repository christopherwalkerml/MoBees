package com.noodlepfp.mobees.core.client;

import com.mojang.logging.LogUtils;
import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.MoBeesModCompat;
import com.noodlepfp.mobees.bee.MoreBeesSpecies;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.feature.MoreBeesCrateItems;
import com.noodlepfp.mobees.feature.MoreBeesItems;
import com.noodlepfp.mobees.hive.MoreBeesBlockHiveType;
import com.noodlepfp.mobees.item.MoreBeesBlockHoneyComb;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import com.noodlepfp.mobees.item.MoreBeesItemBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesItemHoneyComb;
import forestry.api.apiculture.genetics.BeeLifeStage;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.genetics.ILifeStage;
import forestry.core.tab.ForestryCreativeTabs;
import forestry.core.utils.SpeciesUtil;
import forestry.modules.features.*;
import forestry.storage.items.ItemCrated;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;

@FeatureProvider
public class MoreBeesCreativeTab {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBees.loc("core"));

    public static final FeatureCreativeTab MOBEES = REGISTRY.creativeTab("mobees", tab -> {
        tab.icon(() -> SpeciesUtil.BEE_TYPE.get().createStack(MoreBeesSpecies.CRYSTALLINE, BeeLifeStage.QUEEN));
        tab.displayItems(MoreBeesCreativeTab::addApicultureItems);
        tab.withTabsBefore(ForestryCreativeTabs.FORESTRY.getKey());
        tab.withTabsAfter(ForestryCreativeTabs.ARBORICULTURE.getKey());
    });

    private static void addApicultureItems(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output items) {
        // Hives
        for (MoreBeesBlockHiveType type : MoreBeesBlockHiveType.values()) {
            if (type.getSpeciesId().toString().contains("mobees")) {
                items.accept(MoreBeesApicultureBlocks.BEEHIVE.get(type));
            }
        }

        // Alveary
        MoreBeesApicultureBlocks.ALVEARY.getItems().forEach(items::accept);

        // Frames
        items.accept(MoreBeesApicultureItems.FRAME_PRESERVATION);
        items.accept(MoreBeesApicultureItems.FRAME_DESTRUCTION);
        items.accept(MoreBeesApicultureItems.FRAME_MUTATION);
        items.accept(MoreBeesApicultureItems.FRAME_FERTILE);
        items.accept(MoreBeesApicultureItems.FRAME_CRIMSON);
        items.accept(MoreBeesApicultureItems.FRAME_KIND);

        // Misc items
        LOGGER.info("Mo' Bees - Checking for Mod Compatible Resources...");
        for (MoreBeesItemHoneyComb comb : MoreBeesApicultureItems.BEE_COMBS.getItems()) {
            System.out.println(comb.getType().name.toUpperCase());
            MoBeesModCompat modCompat = EnumUtils.getEnum(MoBeesModCompat.class, comb.getType().name.toUpperCase());
            registerModCompatItem(items, new ItemStack(comb), modCompat, true);
        }

        for (ILifeStage stage : SpeciesUtil.BEE_TYPE.get().getLifeStages()) {
            for (IBeeSpecies species : SpeciesUtil.getAllBeeSpecies()) {
                if (species.id().toString().contains("mobees")) {
                    MoBeesModCompat modCompat = EnumUtils.getEnum(MoBeesModCompat.class, species.getSpeciesName().toUpperCase());
                    registerModCompatItem(items, species.createStack(stage), modCompat, false);
                }
            }
        }

        for (MoreBeesItemBeeProduce produce : MoreBeesItems.BEE_PRODUCE_MATERIALS.getItems()) {
            MoBeesModCompat modCompat = EnumUtils.getEnum(MoBeesModCompat.class, produce.getType().name().toUpperCase());
            registerModCompatItem(items, new ItemStack(produce), modCompat, false);
        }

        for (MoreBeesBlockHoneyComb blockHoneyComb : MoreBeesApicultureBlocks.BEE_COMB.getBlocks()) {
            MoBeesModCompat modCompat = EnumUtils.getEnum(MoBeesModCompat.class, blockHoneyComb.getType().name().toUpperCase());
            registerModCompatItem(items, new ItemStack(blockHoneyComb), modCompat, false);
        }

        MoreBeesItems.CRAFTING_MATERIALS.getItems().forEach(items::accept);

        for (FeatureItem<ItemCrated> crate : MoreBeesCrateItems.getCrates()) {
            items.accept(crate);
        }
    }

    private static void registerModCompatItem(CreativeModeTab.Output items, ItemStack item, MoBeesModCompat compatEnum, boolean doLog) {
        if (compatEnum == null) {
            items.accept(item);
            return;
        }
        String compatStr = compatEnum.getModCompatTag();
        if (ForgeRegistries.ITEMS.tags().isKnownTagName(TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("forge", compatStr)))) {
            if (doLog) {
                LOGGER.info(compatStr + " : FOUND");
            }
            items.accept(item);
        } else if (doLog) {
            LOGGER.info(compatStr + " : NOT FOUND");
        }
    }
}
