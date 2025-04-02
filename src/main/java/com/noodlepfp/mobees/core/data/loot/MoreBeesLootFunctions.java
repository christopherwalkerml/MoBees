package com.noodlepfp.mobees.core.data.loot;

import com.noodlepfp.mobees.MoBees;
import forestry.api.ForestryConstants;
import forestry.modules.ModuleUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MoreBeesLootFunctions {

    public static final DeferredRegister<LootItemFunctionType> LOOT_FUNCTIONS =
            DeferredRegister.create(BuiltInRegistries.LOOT_FUNCTION_TYPE.key(), MoBees.MOD_ID);

    public static final RegistryObject<LootItemFunctionType> COPY_MUTATOR_DATA =
            LOOT_FUNCTIONS.register("copy_mutator_data", () ->
                    new LootItemFunctionType(new LootItemFunctionMutator.LootSerializer()));

    public static void register() {
        LOOT_FUNCTIONS.register(ModuleUtil.getModBus(ForestryConstants.MOD_ID));
    }
}
