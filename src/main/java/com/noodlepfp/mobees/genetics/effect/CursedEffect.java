package com.noodlepfp.mobees.genetics.effect;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;

public class CursedEffect extends ThrottledBeeEffect {

    public CursedEffect() {
        super(true, 160, true, true);
    }

    public IEffectData doEffectThrottled(IGenome genome, IEffectData storedData, IBeeHousing housing) {
        Level world = housing.getWorldObj();
        BlockPos housingCoords = housing.getCoordinates();

        float pitch = world.random.nextInt(200) / (float) 100;
        int soundChoice = world.random.nextInt() % 4; // there's a 25% chance of no sound played
        if (soundChoice == 0) {
            world.playSound(null, housingCoords.getX(), housingCoords.getY(), housingCoords.getZ(), SoundEvents.GHAST_DEATH, SoundSource.BLOCKS, 2.0F, pitch);
        } else if (soundChoice == 1) {
            world.playSound(null, housingCoords.getX(), housingCoords.getY(), housingCoords.getZ(), SoundEvents.GHAST_HURT, SoundSource.BLOCKS, 2.0F, pitch);
        } else if (soundChoice == 2) {
            world.playSound(null, housingCoords.getX(), housingCoords.getY(), housingCoords.getZ(), SoundEvents.GHAST_AMBIENT, SoundSource.BLOCKS, 2.0F, pitch);
        }

        effectPlayers(genome, housing);

        return storedData;
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

                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200 - 50 * count, 1));
            }
        }
    }
}
