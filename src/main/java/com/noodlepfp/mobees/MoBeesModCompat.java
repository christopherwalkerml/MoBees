package com.noodlepfp.mobees;

public enum MoBeesModCompat {

    TIN("ingots/tin"),
    ZINC("ingots/zinc"),
    LEAD("ingots/lead"),
    NICKEL("ingots/nickel"),
    OSMIUM("ingots/osmium"),
    SILVER("ingots/silver"),
    PLATINUM("ingots/platinum"),
    CERTUS("gems/certus_quartz"),
    YELLORIUM("ingots/yellorium");

    private final String modCompatTag;
    MoBeesModCompat(String modCompatTag) {
        this.modCompatTag = modCompatTag;
    }

    public String getModCompatTag() {
        return modCompatTag;
    }
}
