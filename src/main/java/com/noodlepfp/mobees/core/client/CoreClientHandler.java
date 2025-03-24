package com.noodlepfp.mobees.core.client;

import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.feature.MoreBeesCrateItems;
import forestry.api.ForestryConstants;
import forestry.api.apiculture.genetics.BeeLifeStage;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.client.IClientModuleHandler;
import forestry.api.client.IForestryClientApi;
import forestry.api.client.apiculture.IBeeClientManager;
import forestry.apiculture.features.ApicultureItems;
import forestry.apiimpl.client.ForestryClientApiImpl;
import forestry.core.features.CoreBlocks;
import forestry.core.models.ClientManager;
import forestry.core.utils.SpeciesUtil;
import forestry.modules.ModuleUtil;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;

public class CoreClientHandler implements IClientModuleHandler {

	@Override
	public void registerEvents(IEventBus modBus) {
		modBus.addListener(CoreClientHandler::onClientSetup);
		modBus.addListener(CoreClientHandler::additionalBakedModels);
		modBus.addListener(CoreClientHandler::bakeModels);
		modBus.addListener(CoreClientHandler::registerItemColors);
		modBus.addListener(CoreClientHandler::registerBlockColors);

		ModuleUtil.getModBus(ForestryConstants.MOD_ID).addListener(EventPriority.HIGHEST, ((ForestryClientApiImpl) IForestryClientApi.INSTANCE)::initializeTextureManager);
	}

	private static void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			CoreBlocks.BASE.getBlocks().forEach((block) -> ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutoutMipped()));
		});
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

	private static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
		// Apiculture
		event.register(ClientManager.FORESTRY_BLOCK_COLOR, MoreBeesApicultureBlocks.BEE_COMB.blockArray());
	}

	private static void registerItemColors(RegisterColorHandlersEvent.Item event) {
		// Apiculture
		event.register(ClientManager.FORESTRY_ITEM_COLOR,
				ApicultureItems.BEE_QUEEN.item(),
				ApicultureItems.BEE_DRONE.item(),
				ApicultureItems.BEE_PRINCESS.item(),
				ApicultureItems.BEE_LARVAE.item()
		);

		event.register(ClientManager.FORESTRY_ITEM_COLOR, MoreBeesApicultureBlocks.BEE_COMB.blockArray());
		event.register(ClientManager.FORESTRY_ITEM_COLOR, MoreBeesCrateItems.CRATED_BEE_COMBS.itemArray());
		event.register(ClientManager.FORESTRY_ITEM_COLOR, MoreBeesApicultureItems.BEE_COMBS.itemArray());
	}
}
