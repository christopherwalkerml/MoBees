package com.noodlepfp.mobees;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class MoBeesModCompat {
    private static final Map<String, DeferredRegister<Item>> itemRegistries = new HashMap<>();
    public static final RegistryObject<Item>
        ZINC_INGOT = item(ModCompatConstants.createId, "zinc_ingot"),
        LEAD_INGOT = item(ModCompatConstants.thermalId, "lead_ingot"),
        NICKEL_INGOT = item(ModCompatConstants.thermalId, "nickel_ingot"),
        SILVER_INGOT = item(ModCompatConstants.thermalId, "silver_ingot"),
        ALUMINUM_INGOT = item(ModCompatConstants.thermalId, "aluminum_ingot"),
        OSMIUM_INGOT = item(ModCompatConstants.mekanismId, "ingot_osmium"),
        YELLORIUM_INGOT = item(ModCompatConstants.bigReactorsId, "yellorium_ingot"),
        COBALT_INGOT = item(ModCompatConstants.tinkersId, "cobalt_ingot"),
        ARDITE_INGOT = item(ModCompatConstants.tinkersId, "ardite_ingot"),
        CERTUS_QUARTZ = item(ModCompatConstants.appliedEnergisticsId, "certus_quartz");

    private static RegistryObject<Item> item(String modid, String name) {
        if (DatagenModLoader.isRunningDataGen()) {
            DeferredRegister<Item> registry = itemRegistries.computeIfAbsent(modid, key -> DeferredRegister.create(Registries.ITEM, key));
            return registry.register(name, () -> new Item(new Item.Properties()));
        } else {
            return null;
        }
    }

    public static void registerModData() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();

        for (var registry : itemRegistries.values()) {
            registry.register(modBus);
        }
    }

    public static class ModCompatConstants {
        public static String thermalId = "thermal";
        public static String appliedEnergisticsId = "ae2";
        public static String mekanismId = "mekanism";
        public static String bigReactorsId = "bigreactors";
        public static String createId = "create";
        public static String tinkersId = "tconstruct";
    }
}
