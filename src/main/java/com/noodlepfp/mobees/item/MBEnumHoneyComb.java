package com.noodlepfp.mobees.item;

import forestry.api.core.IBlockSubtype;
import forestry.api.core.IItemSubtype;
import net.minecraft.util.StringRepresentable;

import java.awt.*;
import java.util.Locale;

public enum MBEnumHoneyComb implements StringRepresentable, IItemSubtype, IBlockSubtype {

    BARREN(new Color(7564356), new Color(12762791)),
    BONE(new Color(12895407), new Color(14606017)),
    COAL(new Color(10392696), new Color(3682590)),
    ROCKY(new Color(9211025), new Color(13027020));

    public static final MBEnumHoneyComb[] VALUES = values();

    public final String name;
    public final int primaryColor;
    public final int secondaryColor;
    private final boolean unused;

    MBEnumHoneyComb(Color primary, Color secondary) {
        this(primary, secondary, false);
    }

    MBEnumHoneyComb(Color primary, Color secondary, boolean unused) {
        this.unused = unused;
        this.name = toString().toLowerCase(Locale.ENGLISH);
        this.primaryColor = primary.getRGB();
        this.secondaryColor = secondary.getRGB();

    }

    public boolean isUnused() {
        return this.unused;
    }

    @Override
    public String getSerializedName() {
        return name;
    }

    public static MBEnumHoneyComb get(int meta) {
        if (meta >= VALUES.length) {
            meta = 0;
        }
        return VALUES[meta];
    }

}
