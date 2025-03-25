package com.noodlepfp.mobees.core.client;

import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.bee.MoreBeesSpecies;
import forestry.api.apiculture.genetics.BeeLifeStage;
import forestry.api.client.plugin.IClientRegistration;

import java.util.function.Consumer;

public class MoreBeesClientRegistration implements Consumer<IClientRegistration> {
    @Override
    public void accept(IClientRegistration client) {
        registerApiculture(client);
    }

    private static void registerApiculture(IClientRegistration client) {
        client.setCustomBeeModel(MoreBeesSpecies.WITHERED, BeeLifeStage.DRONE, MoBeesModule.mobees("item/bee_drone_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.WITHERED, BeeLifeStage.PRINCESS, MoBeesModule.mobees("item/bee_princess_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.WITHERED, BeeLifeStage.QUEEN, MoBeesModule.mobees("item/bee_queen_fuzzy"));

        client.setCustomBeeModel(MoreBeesSpecies.DIVINE, BeeLifeStage.DRONE, MoBeesModule.mobees("item/bee_drone_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.DIVINE, BeeLifeStage.PRINCESS, MoBeesModule.mobees("item/bee_princess_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.DIVINE, BeeLifeStage.QUEEN, MoBeesModule.mobees("item/bee_queen_fuzzy"));

        client.setCustomBeeModel(MoreBeesSpecies.WITCHY, BeeLifeStage.DRONE, MoBeesModule.mobees("item/bee_drone_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.WITCHY, BeeLifeStage.PRINCESS, MoBeesModule.mobees("item/bee_princess_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.WITCHY, BeeLifeStage.QUEEN, MoBeesModule.mobees("item/bee_queen_fuzzy"));

        client.setCustomBeeModel(MoreBeesSpecies.CURSED, BeeLifeStage.DRONE, MoBeesModule.mobees("item/bee_drone_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.CURSED, BeeLifeStage.PRINCESS, MoBeesModule.mobees("item/bee_princess_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.CURSED, BeeLifeStage.QUEEN, MoBeesModule.mobees("item/bee_queen_fuzzy"));

        client.setCustomBeeModel(MoreBeesSpecies.BEE_BEE, BeeLifeStage.DRONE, MoBeesModule.mobees("item/bee_drone_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.BEE_BEE, BeeLifeStage.PRINCESS, MoBeesModule.mobees("item/bee_princess_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.BEE_BEE, BeeLifeStage.QUEEN, MoBeesModule.mobees("item/bee_queen_fuzzy"));

        client.setCustomBeeModel(MoreBeesSpecies.SAGE, BeeLifeStage.DRONE, MoBeesModule.mobees("item/bee_drone_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.SAGE, BeeLifeStage.PRINCESS, MoBeesModule.mobees("item/bee_princess_fuzzy"));
        client.setCustomBeeModel(MoreBeesSpecies.SAGE, BeeLifeStage.QUEEN, MoBeesModule.mobees("item/bee_queen_fuzzy"));
    }
}
