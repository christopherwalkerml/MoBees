package com.noodlepfp.mobees;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

import static com.noodlepfp.mobees.MoBeesModCompat.ModCompatIds.*;

public class MoBeesModCompat {
    private static final Map<String, DeferredRegister<Item>> itemRegistries = new HashMap<>();

    public static final Map<String, RegistryObject<Item>> ZINC_INGOT = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> NICKEL_INGOT = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> LEAD_INGOT = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> SILVER_INGOT = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> ALUMINUM_INGOT = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> OSMIUM_INGOT = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> YELLORIUM_INGOT = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> COBALT_INGOT = new HashMap<>();
    public static final Map<String, RegistryObject<Item>> CERTUS_QUARTZ = new HashMap<>();

    static {
        ZINC_INGOT.put(create, item(create, "zinc_ingot"));
        ZINC_INGOT.put(allTheOres, item(allTheOres, "zinc_ingot"));
        ZINC_INGOT.put(gregTech, item(gregTech, "zinc_ingot"));

        NICKEL_INGOT.put(thermal, item(thermal, "nickel_ingot"));
        NICKEL_INGOT.put(allTheOres, item(allTheOres, "nickel_ingot"));
        NICKEL_INGOT.put(gregTech, item(gregTech, "nickel_ingot"));
        NICKEL_INGOT.put(railcraft, item(railcraft, "nickel_ingot"));
        NICKEL_INGOT.put(immersiveEngineering, item(immersiveEngineering, "ingot_nickel"));

        LEAD_INGOT.put(thermal, item(thermal, "lead_ingot"));
        LEAD_INGOT.put(allTheOres, item(allTheOres, "lead_ingot"));
        LEAD_INGOT.put(gregTech, item(gregTech, "lead_ingot"));
        LEAD_INGOT.put(mekanism, item(mekanism, "lead_ingot"));
        LEAD_INGOT.put(railcraft, item(railcraft, "lead_ingot"));
        LEAD_INGOT.put(immersiveEngineering, item(immersiveEngineering, "ingot_lead"));

        SILVER_INGOT.put(thermal, item(thermal, "silver_ingot"));
        SILVER_INGOT.put(allTheOres, item(allTheOres, "silver_ingot"));
        SILVER_INGOT.put(railcraft, item(railcraft, "silver_ingot"));
        SILVER_INGOT.put(immersiveEngineering, item(immersiveEngineering, "ingot_silver"));

        ALUMINUM_INGOT.put(immersiveEngineering, item(immersiveEngineering, "ingot_aluminum"));
        ALUMINUM_INGOT.put(allTheOres, item(allTheOres, "aluminum_ingot"));

        OSMIUM_INGOT.put(mekanism, item(mekanism, "ingot_osmium"));
        OSMIUM_INGOT.put(allTheOres, item(allTheOres, "osmium_ingot"));

        YELLORIUM_INGOT.put(bigReactors, item(bigReactors, "yellorium_ingot"));

        COBALT_INGOT.put(tinkers, item(tinkers, "cobalt_ingot"));

        CERTUS_QUARTZ.put(appliedEnergistics, item(appliedEnergistics, "certus_quartz_crystal"));
    }


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

    public static class ModCompatIds {
        public static String thermal = "thermal";
        public static String appliedEnergistics = "ae2";
        public static String mekanism = "mekanism";
        public static String bigReactors = "bigreactors";
        public static String create = "create";
        public static String tinkers = "tconstruct";
        public static String immersiveEngineering = "immersiveengineering";
        public static String allTheOres = "alltheores";
        public static String gregTech = "gtceu";
        public static String railcraft = "railcraft";
    }


}
