package com.noodlepfp.mobees.core.data.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class MoreBeesLootTableProvider extends LootTableProvider {
	public MoreBeesLootTableProvider(PackOutput pOutput) {
		super(pOutput, Set.of(), List.of(
				new SubProviderEntry(MoreBeesBlockLootTables::new, LootContextParamSets.BLOCK)
		));
	}
}
