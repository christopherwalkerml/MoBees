package com.noodlepfp.mobees.genetics.effect;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import forestry.apiculture.genetics.effects.FungificationBeeEffect;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class WitchingEffect extends FungificationBeeEffect {

    public WitchingEffect() {
    }

    @Override
    public IEffectData doEffectThrottled(IGenome genome, IEffectData storedData, IBeeHousing housing) {
        IEffectData sData = super.doEffectThrottled(genome, storedData, housing);

        effectPlayers(genome, housing);

        return sData;
    }

    private void effectPlayers(IGenome genome, IBeeHousing housing) {
        List<Player> list = getEntitiesInRange(genome, housing, Player.class);
        for (Player player : list) {
            if (!player.hasEffect(MobEffects.DIG_SLOWDOWN)) {
                int damage = 4;

                // Entities are not attacked if they wear a full set of apiarist's armor.
                int count = BeeManager.armorApiaristHelper.wearsItems(player, this, true);
                damage -= count;
                if (damage <= 0) {
                    continue;
                }

                player.addEffect(new MobEffectInstance(MobEffects.POISON, 200 - 50 * count, 1));
            }
        }
    }
}
