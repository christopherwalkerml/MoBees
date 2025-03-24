package com.noodlepfp.mobees.core.client;

import com.mojang.logging.LogUtils;
import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.MoBeesEnumModCompat;
import com.noodlepfp.mobees.MoBeesModCompat;
import com.noodlepfp.mobees.bee.MoreBeesSpecies;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.feature.MoreBeesCrateItems;
import com.noodlepfp.mobees.feature.MoreBeesItems;
import com.noodlepfp.mobees.hive.MoreBeesBlockHiveType;
import com.noodlepfp.mobees.item.MoreBeesBlockHoneyComb;
import com.noodlepfp.mobees.item.MoreBeesItemBeeProduce;
import com.noodlepfp.mobees.item.MoreBeesItemHoneyComb;
import forestry.api.apiculture.genetics.BeeLifeStage;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.genetics.ILifeStage;
import forestry.core.tab.ForestryCreativeTabs;
import forestry.core.utils.SpeciesUtil;
import forestry.modules.features.*;
import forestry.storage.items.ItemCrated;
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

        MoreBeesItems.CRAFTING_MATERIALS.getItems().forEach(items::accept);

        for (MoreBeesItemBeeProduce produce : MoreBeesItems.BEE_PRODUCE_MATERIALS.getItems()) {
            MoBeesEnumModCompat modCompat = EnumUtils.getEnum(MoBeesEnumModCompat.class, produce.getType().name().toUpperCase().replace("_BIT", ""));
            registerModCompatItem(items, new ItemStack(produce), modCompat, false);
        }

        // Misc items
        LOGGER.info("Mo' Bees - Checking for Mod Compatible Resources...");
        for (MoreBeesItemHoneyComb comb : MoreBeesApicultureItems.BEE_COMBS.getItems()) {
            MoBeesEnumModCompat modCompat = EnumUtils.getEnum(MoBeesEnumModCompat.class, comb.getType().name.toUpperCase());
            registerModCompatItem(items, new ItemStack(comb), modCompat, true);
        }

        for (ILifeStage stage : SpeciesUtil.BEE_TYPE.get().getLifeStages()) {
            for (IBeeSpecies species : SpeciesUtil.getAllBeeSpecies()) {
                if (species.id().toString().contains("mobees")) {
                    MoBeesEnumModCompat modCompat = EnumUtils.getEnum(MoBeesEnumModCompat.class, species.getSpeciesName().toUpperCase());
                    registerModCompatItem(items, species.createStack(stage), modCompat, false);
                }
            }
        }

        for (MoreBeesBlockHoneyComb blockHoneyComb : MoreBeesApicultureBlocks.BEE_COMB.getBlocks()) {
            MoBeesEnumModCompat modCompat = EnumUtils.getEnum(MoBeesEnumModCompat.class, blockHoneyComb.getType().name().toUpperCase());
            registerModCompatItem(items, new ItemStack(blockHoneyComb), modCompat, false);
        }

        for (FeatureItem<ItemCrated> crate : MoreBeesCrateItems.getCrates()) {
            MoBeesEnumModCompat modCompat = EnumUtils.getEnum(MoBeesEnumModCompat.class, crate.getName().toUpperCase().replace("CRATED_BEE_COMB_", ""));
            registerModCompatItem(items, new ItemStack(crate), modCompat, false);
        }
    }

    private static void registerModCompatItem(CreativeModeTab.Output items, ItemStack item, MoBeesEnumModCompat compatEnum, boolean doLog) {
        if (compatEnum == null) {
            items.accept(item);
            return;
        }
        TagKey<Item> compatTag = compatEnum.getModCompatTag();
        if (ForgeRegistries.ITEMS.tags().isKnownTagName(compatTag)) {
            if (doLog) {
                LOGGER.info(compatTag.location() + " : FOUND");
            }
            items.accept(item);
        } else if (doLog) {
            LOGGER.info(compatTag.location() + " : NOT FOUND");
        }
    }
}
