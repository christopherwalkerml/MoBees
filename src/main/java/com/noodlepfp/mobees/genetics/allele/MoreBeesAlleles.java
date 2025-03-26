package com.noodlepfp.mobees.genetics.allele;

import com.noodlepfp.mobees.core.data.MoreBeesEffect;
import com.noodlepfp.mobees.core.data.MoreBeesFlowerType;
import forestry.api.IForestryApi;
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
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_TIN = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_TIN, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_LEAD = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_LEAD, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_ZINC = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_ZINC, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_NICKEL = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_NICKEL, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_SILVER = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_SILVER, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_ALUMINUM = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_ALUMINUM, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_OSMIUM = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_OSMIUM, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_ARDITE = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_ARDITE, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_COBALT = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_COBALT, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_YELLORIUM = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_YELLORIUM, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_CERTUS_QUARTZ = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_CERTUS_QUARTZ, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_IRON = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_IRON, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_GOLD = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_GOLD, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_LAPIS = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_LAPIS, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_REDSTONE = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_REDSTONE, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_AMETHYST = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_AMETHYST, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_DIAMOND = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_DIAMOND, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_EMERALD = REGISTRY.registryAllele(MoreBeesFlowerType.ROCK_EMERALD, BeeChromosomes.FLOWER_TYPE);
    public static final IRegistryAllele<IFlowerType> FLOWER_TYPE_READABLE = REGISTRY.registryAllele(MoreBeesFlowerType.READABLE, BeeChromosomes.FLOWER_TYPE);

    // EFFECTS
    public static final IRegistryAllele<IBeeEffect> EFFECT_CAVE_SIGHT = REGISTRY.registryAllele(MoreBeesEffect.CAVE_SIGHT, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_DARK = REGISTRY.registryAllele(MoreBeesEffect.DARK, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_WITHERED = REGISTRY.registryAllele(MoreBeesEffect.WITHERED, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_VANISHING = REGISTRY.registryAllele(MoreBeesEffect.VANISHING, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_MELODIC_CHIME = REGISTRY.registryAllele(MoreBeesEffect.MELODIC_CHIME, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_WITCHING = REGISTRY.registryAllele(MoreBeesEffect.WITCHING, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_CURSED = REGISTRY.registryAllele(MoreBeesEffect.CURSED, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_ARCANE = REGISTRY.registryAllele(MoreBeesEffect.ARCANE, BeeChromosomes.EFFECT);
    public static final IRegistryAllele<IBeeEffect> EFFECT_LIBRARIAN = REGISTRY.registryAllele(MoreBeesEffect.LIBRARIAN, BeeChromosomes.EFFECT);
}
