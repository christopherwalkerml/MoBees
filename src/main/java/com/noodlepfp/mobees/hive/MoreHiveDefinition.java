package com.noodlepfp.mobees.hive;

import com.noodlepfp.mobees.bee.MoreBeesSpecies;
import com.noodlepfp.mobees.core.data.tag.MoreBeesTags;
import com.noodlepfp.mobees.feature.MoreBeesApicultureBlocks;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.apiculture.hives.IHiveDefinition;
import forestry.api.apiculture.hives.IHiveGen;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.core.ToleranceType;
import forestry.api.genetics.ClimateHelper;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.core.utils.SpeciesUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;

public enum MoreHiveDefinition implements IHiveDefinition {

    ROCKY(MoreBeesApicultureBlocks.BEEHIVE.get(MoreBeesBlockHiveType.ROCKY).defaultState(), 4.0F, MoreBeesSpecies.ROCKY, new MoreHiveGenCaveWall(MoreBeesTags.Blocks.ROCKY_BEE_WALL, MoreBeesTags.Blocks.ROCKY_CAVE_REPLACEABLE)) {
        @Override
        public boolean isGoodBiome(Holder<Biome> biome) {
            return true;
        }

        @Override
        public boolean isGoodHumidity(HumidityType humidity) {
            return true;
        }

        @Override
        public boolean isGoodTemperature(TemperatureType temperature) {
            return true;
        }
    },
    ALPINE(MoreBeesApicultureBlocks.BEEHIVE.get(MoreBeesBlockHiveType.ALPINE).defaultState(), 3.0F, MoreBeesSpecies.ALPINE, new MoreHiveGenMountain(MoreBeesTags.Blocks.ALPINE_HIVE_GROUNDS)) {
        @Override
        public boolean isGoodBiome(Holder<Biome> biome) {
            return biome.is(BiomeTags.IS_MOUNTAIN);
        }

        @Override
        public boolean isGoodHumidity(HumidityType humidity) {
            return true;
        }

        @Override
        public boolean isGoodTemperature(TemperatureType temperature) {
            return true;
        }
    };

    private final BlockState blockState;
    private final float genChance;
    private final ResourceLocation speciesId;
    private final IHiveGen hiveGen;

    MoreHiveDefinition(BlockState hiveState, float genChance, ResourceLocation beeTemplate, IHiveGen hiveGen) {
        this.blockState = hiveState;
        this.genChance = genChance;
        this.speciesId = beeTemplate;
        this.hiveGen = hiveGen;
    }

    @Override
    public IHiveGen getHiveGen() {
        return hiveGen;
    }

    @Override
    public BlockState getBlockState() {
        return blockState;
    }

    @Override
    public boolean isGoodBiome(Holder<Biome> biome) {
        return !biome.is(BiomeTags.IS_NETHER);
    }

    @Override
    public boolean isGoodHumidity(HumidityType humidity) {
        IBeeSpecies species = SpeciesUtil.getBeeSpecies(this.speciesId);
        HumidityType idealHumidity = species.getHumidity();
        ToleranceType humidityTolerance = species.getDefaultGenome().getActiveValue(BeeChromosomes.HUMIDITY_TOLERANCE);
        return ClimateHelper.isWithinLimits(humidity, idealHumidity, humidityTolerance);
    }

    @Override
    public boolean isGoodTemperature(TemperatureType temperature) {
        IBeeSpecies species = SpeciesUtil.getBeeSpecies(this.speciesId);
        TemperatureType idealTemperature = species.getTemperature();
        ToleranceType temperatureTolerance = species.getDefaultGenome().getActiveValue(BeeChromosomes.TEMPERATURE_TOLERANCE);
        return ClimateHelper.isWithinLimits(temperature, idealTemperature, temperatureTolerance);
    }

    @Override
    public float getGenChance() {
        return genChance;
    }

    @Override
    public void postGen(WorldGenLevel level, RandomSource rand, BlockPos pos) {
    }
}
