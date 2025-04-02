package com.noodlepfp.mobees.core.data.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.noodlepfp.mobees.alveary.INBTStorable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import static com.noodlepfp.mobees.core.data.loot.MoreBeesLootFunctions.NBT_SYNC;
import static net.minecraft.world.level.storage.loot.parameters.LootContextParams.BLOCK_ENTITY;

public class LootItemNbtSync extends LootItemConditionalFunction {

    public LootItemNbtSync(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    public LootItemFunctionType getType() {
        return NBT_SYNC.get();
    }

    @Override
    public ItemStack run(ItemStack stack, LootContext context) {
        return applyToStack(stack, context.getParamOrNull(BLOCK_ENTITY));
    }

    public static ItemStack applyToStack(ItemStack stack, BlockEntity tile) {
        if (tile instanceof INBTStorable) {
            ((INBTStorable) tile).modifyItemNBT(stack);
        }
        return stack;
    }

    public static class Serializer extends LootItemConditionalFunction.Serializer<LootItemNbtSync> {
        @Override
        public LootItemNbtSync deserialize(JsonObject object, JsonDeserializationContext context, LootItemCondition[] conditions) {
            return new LootItemNbtSync(conditions);
        }
    }

    public static LootItemConditionalFunction.Builder<?> builder() {
        return simpleBuilder(LootItemNbtSync::new);
    }
}
