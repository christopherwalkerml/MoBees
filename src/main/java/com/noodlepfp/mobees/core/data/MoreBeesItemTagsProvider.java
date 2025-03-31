package com.noodlepfp.mobees.core.data;

import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import forestry.apiculture.features.ApicultureItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import thedarkcolour.modkit.data.MKTagsProvider;

public class MoreBeesItemTagsProvider {

    public static void addTags(MKTagsProvider<Item> tags) {
        tags.tag(MoreBeesTags.Items.FROGLIGHT).add(Items.OCHRE_FROGLIGHT).add(Items.PEARLESCENT_FROGLIGHT).add(Items.VERDANT_FROGLIGHT);

        tags.tag(MoreBeesTags.Items.BEE_FRAME).add(MoreBeesApicultureItems.FRAME_CRIMSON).add(MoreBeesApicultureItems.FRAME_DESTRUCTION)
                .add(MoreBeesApicultureItems.FRAME_FERTILE).add(MoreBeesApicultureItems.FRAME_KIND).add(MoreBeesApicultureItems.FRAME_MUTATION)
                .add(MoreBeesApicultureItems.FRAME_PRESERVATION).add(ApicultureItems.FRAME_UNTREATED).add(ApicultureItems.FRAME_PROVEN)
                .add(ApicultureItems.FRAME_IMPREGNATED).add(ApicultureItems.FRAME_CREATIVE);
    }

}
