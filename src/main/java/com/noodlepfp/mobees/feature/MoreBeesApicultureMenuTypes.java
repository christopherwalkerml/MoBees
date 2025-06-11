package com.noodlepfp.mobees.feature;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.gui.ContainerAlvearyBroodBox;
import com.noodlepfp.mobees.gui.ContainerAlvearyFlowerBox;
import com.noodlepfp.mobees.gui.ContainerAlvearyFrameHousing;
import com.noodlepfp.mobees.gui.ContainerAlvearyMutator;
import forestry.modules.features.FeatureMenuType;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class MoreBeesApicultureMenuTypes {
	private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBeesModule.mobees("core"));

	public static final FeatureMenuType<ContainerAlvearyMutator> ALVEARY_MUTATOR = REGISTRY.menuType(ContainerAlvearyMutator::fromNetwork, "alveary_mutator");
	public static final FeatureMenuType<ContainerAlvearyFrameHousing> ALVEARY_FRAME_HOUSING = REGISTRY.menuType(ContainerAlvearyFrameHousing::fromNetwork, "alveary_frame_housing");
	public static final FeatureMenuType<ContainerAlvearyFlowerBox> ALVEARY_FLOWER_BOX = REGISTRY.menuType(ContainerAlvearyFlowerBox::fromNetwork, "alveary_flower_box");
	public static final FeatureMenuType<ContainerAlvearyBroodBox> ALVEARY_BROOD_BOX = REGISTRY.menuType(ContainerAlvearyBroodBox::fromNetwork, "alveary_brood_box");
}
