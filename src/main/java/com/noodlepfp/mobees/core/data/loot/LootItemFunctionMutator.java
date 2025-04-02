package com.noodlepfp.mobees.core.data.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.noodlepfp.mobees.alveary.block.TileAlvearyMutator;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class LootItemFunctionMutator implements LootItemFunction {
    public LootItemFunctionMutator() {
    }

    @Override
    public ItemStack apply(ItemStack stack, LootContext context) {
        BlockEntity blockEntity = context.getParamOrNull(LootContextParams.BLOCK_ENTITY);

        if (blockEntity instanceof TileAlvearyMutator mutator) {
            TileAlvearyMutator.modifyItemNBT(mutator, stack);
        }

        return stack;
    }

    @Override
    public LootItemFunctionType getType() {
        return MoreBeesLootFunctions.COPY_MUTATOR_DATA.get();
    }

    public static class LootSerializer implements Serializer<LootItemFunctionMutator> {
        @Override
        public void serialize(JsonObject object, LootItemFunctionMutator function, JsonSerializationContext context) {
        }

        @Override
        public LootItemFunctionMutator deserialize(JsonObject object, JsonDeserializationContext context) {
            return new LootItemFunctionMutator();
        }
    }
}
