package com.noodlepfp.mobees.item;

import forestry.api.core.IBlockSubtype;
import forestry.api.core.IItemSubtype;
import net.minecraft.util.StringRepresentable;

import java.awt.*;
import java.util.Locale;

public enum MoreBeesEnumHoneyComb implements StringRepresentable, IItemSubtype, IBlockSubtype {

    BONE(new Color(12895407), new Color(14606017)),
    ROCKY(new Color(9211025), new Color(13027020)),
    MINERAL(new Color(9211025), new Color(0x91877A)),
    COAL(new Color(10392696), new Color(3682590)),
    COPPER(new Color(0x9F9F9F), new Color(0xE17C38)),
    IRON(new Color(0x9F9F9F), new Color(0xE3E3E3)),
    GOLD(new Color(0x9F9F9F), new Color(0xE5C447)),
    LAPIS(new Color(0x9F9F9F), new Color(0x4A3DF1)),
    REDSTONE(new Color(0x9F9F9F), new Color(0xF33838)),
    AMETHYST(new Color(0x9F9F9F), new Color(0xB373EC)),
    DIAMOND(new Color(0x9F9F9F), new Color(0x78D8EE)),
    EMERALD(new Color(0x9F9F9F), new Color(0x77FF79));
    public static final MoreBeesEnumHoneyComb[] VALUES = values();

    public final String name;
    public final int primaryColor;
    public final int secondaryColor;
    private final boolean unused;

    MoreBeesEnumHoneyComb(Color primary, Color secondary) {
        this(primary, secondary, false);
    }

    MoreBeesEnumHoneyComb(Color primary, Color secondary, boolean unused) {
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

    public static MoreBeesEnumHoneyComb get(int meta) {
        if (meta >= VALUES.length) {
            meta = 0;
        }
        return VALUES[meta];
    }

}
