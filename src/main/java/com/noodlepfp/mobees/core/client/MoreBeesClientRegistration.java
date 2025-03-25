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
    }
}
