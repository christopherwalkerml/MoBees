package com.noodlepfp.mobees.core.data.loot;

import com.noodlepfp.mobees.MoBeesModule;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@FeatureProvider
public class MoreBeesLootFunctions {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBeesModule.mobees("core"));
    private static final DeferredRegister<LootItemFunctionType> LOOT_FUNCTIONS = REGISTRY.getRegistry(Registries.LOOT_FUNCTION_TYPE);

    public static final RegistryObject<LootItemFunctionType> NBT_SYNC = LOOT_FUNCTIONS.register("nbt_sync", () -> new LootItemFunctionType(new LootItemNbtSync.Serializer()));

}
