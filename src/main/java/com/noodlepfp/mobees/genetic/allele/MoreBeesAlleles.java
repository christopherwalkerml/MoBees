package com.noodlepfp.mobees.genetic.allele;

import com.noodlepfp.mobees.core.data.MoreBeesEffect;
import com.noodlepfp.mobees.core.data.MoreBeesFlowerType;
import forestry.api.IForestryApi;
import forestry.api.apiculture.ForestryBeeEffects;
import forestry.api.apiculture.IFlowerType;
import forestry.api.apiculture.genetics.IBeeEffect;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.IAlleleManager;
import forestry.api.genetics.alleles.IRegistryAllele;

public class MoreBeesAlleles {

    public static final IAlleleManager REGISTRY = IForestryApi.INSTANCE.getAlleleManager();

    // FLOWERS
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_ROCK = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_STONE, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_COAL = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_COAL, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_COPPER = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_COPPER, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_IRON = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_IRON, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_GOLD = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_GOLD, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_LAPIS = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_LAPIS, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_REDSTONE = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_REDSTONE, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_AMETHYST = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_AMETHYST, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_DIAMOND = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_DIAMOND, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_EMERALD = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_EMERALD, BeeChromosomes.FLOWER_TYPE);

    // EFFECTS
    public static final IRegistryAllele<IBeeEffect> EFFECT_CAVE_SIGHT = REGISTRY.registryAllele(MoreBeesEffect.CAVE_SIGHT, BeeChromosomes.EFFECT);
}
