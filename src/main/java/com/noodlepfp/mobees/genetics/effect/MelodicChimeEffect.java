package com.noodlepfp.mobees.genetics.effect;

import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.api.genetics.IGenome;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;

public class MelodicChimeEffect extends ThrottledBeeEffect {

    public MelodicChimeEffect() {
        super(true, 300, true, true);
    }

    public IEffectData doEffectThrottled(IGenome genome, IEffectData storedData, IBeeHousing housing) {
        Level world = housing.getWorldObj();
        BlockPos housingCoords = housing.getCoordinates();

        float pitch = world.random.nextInt(200) / (float) 100;
        world.playSound(null, housingCoords.getX(), housingCoords.getY(), housingCoords.getZ(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 2.0F, pitch);

        return storedData;
    }
}
