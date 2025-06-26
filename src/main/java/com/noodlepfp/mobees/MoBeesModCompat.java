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

    public static final Map<String, RegistryObject<Item>>
        ZINC_INGOT = Map.of(ModCompatConstants.createId, item(ModCompatConstants.createId, "zinc_ingot")),
        NICKEL_INGOT = Map.of(ModCompatConstants.thermalId, item(ModCompatConstants.thermalId, "nickel_ingot")),
        LEAD_INGOT = Map.of(ModCompatConstants.thermalId, item(ModCompatConstants.thermalId, "lead_ingot")),
        SILVER_INGOT = Map.of(ModCompatConstants.thermalId, item(ModCompatConstants.thermalId, "silver_ingot")),
        ALUMINUM_INGOT = Map.of(ModCompatConstants.immersiveEngineeringId, item(ModCompatConstants.immersiveEngineeringId, "ingot_aluminum")),
        OSMIUM_INGOT = Map.of(ModCompatConstants.mekanismId, item(ModCompatConstants.mekanismId, "ingot_osmium")),
        YELLORIUM_INGOT = Map.of(ModCompatConstants.bigReactorsId, item(ModCompatConstants.bigReactorsId, "yellorium_ingot")),
        COBALT_INGOT = Map.of(ModCompatConstants.tinkersId, item(ModCompatConstants.tinkersId, "cobalt_ingot")),
        CERTUS_QUARTZ = Map.of(ModCompatConstants.appliedEnergisticsId, item(ModCompatConstants.appliedEnergisticsId, "certus_quartz_crystal"));


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
        public static String immersiveEngineeringId = "immersiveengineering";
    }
}
