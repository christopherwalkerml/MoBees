package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.gui.ContainerAlvearyMutator;
import forestry.modules.features.FeatureMenuType;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class MoreBeesApicultureMenuTypes {
	private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBeesModule.mobees("core"));

	public static final FeatureMenuType<ContainerAlvearyMutator> ALVEARY_MUTATOR = REGISTRY.menuType(ContainerAlvearyMutator::fromNetwork, "alveary_mutator");
}
