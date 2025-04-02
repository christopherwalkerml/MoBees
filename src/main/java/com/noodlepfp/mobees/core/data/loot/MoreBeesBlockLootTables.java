package com.noodlepfp.mobees.core.data.loot;

import com.noodlepfp.mobees.MoBees;
import com.noodlepfp.mobees.alveary.MoreBeesBlockAlvearyType;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import thedarkcolour.modkit.MKUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Data generator class that generates the block drop loot tables for forestry blocks.
 */
public class MoreBeesBlockLootTables extends BlockLootSubProvider {
	private final LinkedHashSet<Block> added = new LinkedHashSet<>();

	protected MoreBeesBlockLootTables() {
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS);
	}

	@Override
	protected void generate() {
		MKUtils.forModRegistry(Registries.BLOCK, MoBees.MOD_ID, (id, block) -> {
			if (block.getLootTable() != BuiltInLootTables.EMPTY && !block.equals(MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MUTATOR).block())) {
				dropSelf(block);
			}
		});

		add(MoreBeesApicultureBlocks.ALVEARY.get(MoreBeesBlockAlvearyType.MUTATOR).block(), LootTableHandler.alvearyMutatorLootTable());
	}

	@Override
	protected void add(Block block, LootTable.Builder builder) {
		super.add(block, builder);
		this.added.add(block);
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return this.added;
	}
}
