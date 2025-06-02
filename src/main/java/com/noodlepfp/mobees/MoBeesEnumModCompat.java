package com.noodlepfp.mobees;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public enum MoBeesEnumModCompat {

    ZINC("ingots/zinc", MoBeesModCompat.ModCompatConstants.createId, MoBeesModCompat.ZINC_INGOT),
    LEAD("ingots/lead", MoBeesModCompat.ModCompatConstants.thermalId, MoBeesModCompat.LEAD_INGOT),
    NICKEL("ingots/nickel", MoBeesModCompat.ModCompatConstants.thermalId, MoBeesModCompat.NICKEL_INGOT),
    OSMIUM("ingots/osmium", MoBeesModCompat.ModCompatConstants.mekanismId, MoBeesModCompat.OSMIUM_INGOT),
    SILVER("ingots/silver", MoBeesModCompat.ModCompatConstants.thermalId, MoBeesModCompat.SILVER_INGOT),
    ALUMINUM("ingots/aluminum", MoBeesModCompat.ModCompatConstants.immersiveEngineeringId, MoBeesModCompat.ALUMINUM_INGOT),
    CERTUS("gems/certus_quartz", MoBeesModCompat.ModCompatConstants.appliedEnergisticsId, MoBeesModCompat.CERTUS_QUARTZ),
    YELLORIUM("ingots/yellorium", MoBeesModCompat.ModCompatConstants.bigReactorsId, MoBeesModCompat.YELLORIUM_INGOT),
    COBALT("ingots/cobalt", MoBeesModCompat.ModCompatConstants.tinkersId, MoBeesModCompat.COBALT_INGOT);

    // the forge tag for the item
    private final String modCompatTag;
    // the main mod dependency. (if I *need* to specify an item, this is which mod I will specify from)
    private final String modId;
    private final RegistryObject<Item> registryObject;

    MoBeesEnumModCompat(String modCompatTag, String modId, RegistryObject<Item> registryObject) {
        this.modCompatTag = modCompatTag;
        this.registryObject = registryObject;
        this.modId = modId;
    }

    public TagKey<Item> getModCompatTag() {
        return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("forge", modCompatTag));
    }

    public RegistryObject<Item> getRegistryObject() {
        return registryObject;
    }

    public String getModId() {
        return modId;
    }
}
