package com.rosemods.windswept_delights.core.data.server.tags;

import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.registry.WDBlocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class WDBlockTagsProvider extends BlockTagsProvider {

    public WDBlockTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, ExistingFileHelper helper) {
        super(output, lookupProvider, WindsweptDelights.MOD_ID, helper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(WDBlocks.HOLLY_CABINET.get(), WDBlocks.CHESTNUT_CABINET.get(), WDBlocks.PINE_CABINET.get());
        this.tag(ModTags.Blocks.MINEABLE_WITH_KNIFE).add(WindsweptBlocks.CHRISTMAS_PUDDING.get());
    }
}