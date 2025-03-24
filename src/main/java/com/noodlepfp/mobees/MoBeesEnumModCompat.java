package com.noodlepfp.mobees;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public enum MoBeesEnumModCompat {

    ZINC("ingots/zinc", MoBeesModCompat.ZIN_INGOT),
    LEAD("ingots/lead", MoBeesModCompat.LEAD_INGOT),
    NICKEL("ingots/nickel", MoBeesModCompat.NICKEL_INGOT),
    OSMIUM("ingots/osmium", MoBeesModCompat.OSMIUM_INGOT),
    SILVER("ingots/silver", MoBeesModCompat.SILVER_INGOT),
    PLATINUM("ingots/platinum", MoBeesModCompat.PLATINUM_INGOT),
    CERTUS("gems/certus_quartz", MoBeesModCompat.CERTUS_QUARTZ),
    YELLORIUM("ingots/yellorium", MoBeesModCompat.YELLORIUM_INGOT),
    COBALT("ingots/cobalt", MoBeesModCompat.COBALT_INGOT),
    ARDITE("ingots/ardite", MoBeesModCompat.ARDITE_INGOT);

    // the forge tag for the item
    private final String modCompatTag;
    // the main mod dependency. (if I *need* to specify an item, this is which mod I will specify from)
    private final RegistryObject<Item> registryObject;

    MoBeesEnumModCompat(String modCompatTag, RegistryObject<Item> registryObject) {
        this.modCompatTag = modCompatTag;
        this.registryObject = registryObject;
    }

    public TagKey<Item> getModCompatTag() {
        return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("forge", modCompatTag));
    }

    public RegistryObject<Item> getRegistryObject() {
        return registryObject;
    }

}
