package com.noodlepfp.mobees.core.client;

import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import forestry.api.ForestryConstants;
import forestry.api.apiculture.genetics.BeeLifeStage;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.client.IClientModuleHandler;
import forestry.api.client.IForestryClientApi;
import forestry.api.client.apiculture.IBeeClientManager;
import forestry.apiculture.features.ApicultureItems;
import forestry.apiimpl.client.ForestryClientApiImpl;
import forestry.core.models.ClientManager;
import forestry.core.utils.SpeciesUtil;
import forestry.modules.ModuleUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.Map;

public class CoreClientHandler implements IClientModuleHandler {

	@Override
	public void registerEvents(IEventBus modBus) {
		modBus.addListener(CoreClientHandler::additionalBakedModels);
		modBus.addListener(CoreClientHandler::bakeModels);
		modBus.addListener(CoreClientHandler::registerItemColors);

		ModuleUtil.getModBus(ForestryConstants.MOD_ID).addListener(EventPriority.HIGHEST, ((ForestryClientApiImpl) IForestryClientApi.INSTANCE)::initializeTextureManager);
	}

	private static void additionalBakedModels(ModelEvent.RegisterAdditional event) {
		IBeeClientManager beeManager = IForestryClientApi.INSTANCE.getBeeManager();

		for (BeeLifeStage stage : BeeLifeStage.values()) {
			Map<IBeeSpecies, ResourceLocation> models = beeManager.getBeeModels(stage);

			for (IBeeSpecies species : SpeciesUtil.getAllBeeSpecies()) {
				event.register(models.get(species));
			}
		}
	}

	private static void bakeModels(ModelEvent.ModifyBakingResult event) {
		ClientManager.INSTANCE.onBakeModels(event);
	}

	private static void registerItemColors(RegisterColorHandlersEvent.Item event) {
		// Apiculture
		event.register(ClientManager.FORESTRY_ITEM_COLOR,
				ApicultureItems.BEE_QUEEN.item(),
				ApicultureItems.BEE_DRONE.item(),
				ApicultureItems.BEE_PRINCESS.item(),
				ApicultureItems.BEE_LARVAE.item()
		);
		event.register(ClientManager.FORESTRY_ITEM_COLOR, ApicultureItems.HONEY_DROP.item());
		event.register(ClientManager.FORESTRY_ITEM_COLOR, ApicultureItems.PROPOLIS.itemArray());
		event.register(ClientManager.FORESTRY_ITEM_COLOR, ApicultureItems.POLLEN_CLUSTER.itemArray());
		event.register(ClientManager.FORESTRY_ITEM_COLOR, MoreBeesApicultureItems.BEE_COMBS.itemArray());
	}
}
