package com.noodlepfp.mobees;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public enum MoBeesEnumModCompat {

    ZINC("ingots/zinc", MoBeesModCompat.ZINC_INGOT),
    LEAD("ingots/lead", MoBeesModCompat.LEAD_INGOT),
    NICKEL("ingots/nickel", MoBeesModCompat.NICKEL_INGOT),
    OSMIUM("ingots/osmium", MoBeesModCompat.OSMIUM_INGOT),
    SILVER("ingots/silver", MoBeesModCompat.SILVER_INGOT),
    ALUMINUM("ingots/aluminum", MoBeesModCompat.ALUMINUM_INGOT),
    CERTUS("gems/certus_quartz", MoBeesModCompat.CERTUS_QUARTZ),
    YELLORIUM("ingots/yellorium", MoBeesModCompat.YELLORIUM_INGOT),
    COBALT("ingots/cobalt", MoBeesModCompat.COBALT_INGOT);

    // the forge tag for the item
    private final String modCompatTag;
    private final Map<String, RegistryObject<Item>> itemLibrary;

    MoBeesEnumModCompat(String modCompatTag, Map<String, RegistryObject<Item>> itemLibrary) {
        this.modCompatTag = modCompatTag;
        this.itemLibrary = itemLibrary;
    }

    public TagKey<Item> getModCompatTag() {
        return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath("forge", modCompatTag));
    }

    public Map<String, RegistryObject<Item>> getItemLibrary() { return itemLibrary; }

    public boolean isItemLoadedByAnyMod() {
        for (String modId : itemLibrary.keySet()) {
            if (ModList.get().isLoaded(modId)) {
                return true;
            }
        }
        return false;
    }
}
