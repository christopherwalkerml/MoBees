package com.noodlepfp.mobees.core.data.loot;

import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class LootTableHandler {

    public static LootTable.Builder alvearyMutatorLootTable() {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1)) // Rolls = 1
                        .add(LootItem.lootTableItem(MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MUTATOR).item())
                                .apply(LootItemNbtSync.builder())
                        )
                );
    }
}
