package com.rosemods.windswept_delights.core.data.server.tags;

import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.registry.WDItems;
import com.rosemods.windswept_delights.core.registry.WDBlocks;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class WDItemTagsProvider extends ItemTagsProvider {

    public WDItemTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, ExistingFileHelper helper) {
        super(output, lookupProvider, tagLookup, WindsweptDelights.MOD_ID, helper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(ModTags.Items.CABINETS_WOODEN).add(WDBlocks.HOLLY_CABINET.get().asItem(), WDBlocks.CHESTNUT_CABINET.get().asItem(), WDBlocks.PINE_CABINET.get().asItem());
        this.tag(TagUtil.itemTag("c", "raw_meat")).add(WDItems.GOAT_SHANKS.get());
        this.tag(TagUtil.itemTag("c", "raw_goat")).add(WDItems.GOAT_SHANKS.get());
        this.tag(TagUtil.itemTag("c", "cooked_meat")).add(WDItems.COOKED_GOAT_SHANKS.get());
        this.tag(TagUtil.itemTag("c", "cooked_goat")).add(WDItems.COOKED_GOAT_SHANKS.get());
    }
}