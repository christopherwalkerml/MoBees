package com.noodlepfp.mobees.item;

import forestry.api.core.IBlockSubtype;
import forestry.api.core.IItemSubtype;
import net.minecraft.util.StringRepresentable;

import java.awt.*;
import java.util.Locale;

public enum MoreBeesEnumHoneyComb implements StringRepresentable, IItemSubtype, IBlockSubtype {

    // BONE(new Color(12895407), new Color(14606017)),
    ROCKY(new Color(9211025), new Color(13027020)),
    MINERAL(new Color(9211025), new Color(0x91877A)),
    COAL(new Color(10392696), new Color(3682590)),
    COPPER(new Color(0x9F9F9F), new Color(0xE17C38)),

    // Mod Compat Hives
    TIN(new Color(0x9F9F9F), new Color(0xFFFFFF)),
    ZINC(new Color(0x9F9F9F), new Color(0xDED0A1)),
    LEAD(new Color(0x9F9F9F), new Color(0x5A6680)),
    NICKEL(new Color(0x9F9F9F), new Color(0xEFD797)),
    SILVER(new Color(0x9F9F9F), new Color(0xE8E8E8)),
    OSMIUM(new Color(0x9F9F9F), new Color(0x9BC2EF)),
    ALUMINUM(new Color(0x9F9F9F), new Color(0xC8FFF5)),
    CERTUS(new Color(0x9F9F9F), new Color(0xEAD8FC)),
    YELLORIUM(new Color(0x9F9F9F), new Color(0xFFEA00)),

    // BACK TO REGULAR
    IRON(new Color(0x9F9F9F), new Color(0xD5D5D5)),
    GOLD(new Color(0x9F9F9F), new Color(0xE5AE47)),
    ARDITE(new Color(0x9F9F9F), new Color(0xC26D36)),
    COBALT(new Color(0x9F9F9F), new Color(0x226FFF)),
    LAPIS(new Color(0x9F9F9F), new Color(0x4A3DF1)),
    APATITE(new Color(0x9F9F9F), new Color(0x5978EE)),
    REDSTONE(new Color(0x9F9F9F), new Color(0xF33838)),
    AMETHYST(new Color(0x9F9F9F), new Color(0xB373EC)),
    DIAMOND(new Color(0x9F9F9F), new Color(0x78D8EE)),
    EMERALD(new Color(0x9F9F9F), new Color(0x77FF79)),
    HARMONIC(new Color(0x561E10), new Color(0xE9C1FF)),
    CHROMATIC(new Color(0xFFFFFF), new Color(0xFFFFFF)),
    GLOWING(new Color(0x754141), new Color(0xDABF54)),
    SCRAPPED(new Color(0x754141), new Color(0x484848)),
    FUNGAL(new Color(0x6B589F), new Color(0xA0A0B9)),
    SOULFUL(new Color(0xE394AE), new Color(0x92DEE5)),
    ARCANE(new Color(0x92DEE5), new Color(0xC494E1)),
    DECAYED(new Color(0xD2D2D2), new Color(0xAD8484)),
    PAPER(new Color(0x8A7070), new Color(0x9373B0));
    public static final MoreBeesEnumHoneyComb[] VALUES = values();

    public final String name;
    public final int primaryColor;
    public final int secondaryColor;

    MoreBeesEnumHoneyComb(Color primary, Color secondary) {
        this(primary, secondary, null);
    }

    MoreBeesEnumHoneyComb(Color primary, Color secondary, String compatName) {
        this.name = toString().toLowerCase(Locale.ENGLISH);
        this.primaryColor = primary.getRGB();
        this.secondaryColor = secondary.getRGB();
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
