package com.rosemods.windswept_delights.core.data.server;

import com.rosemods.windswept_delights.core.registry.WDBlocks;
import com.rosemods.windswept_delights.core.registry.WDItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class WDDataMapProvider extends DataMapProvider {

    public WDDataMapProvider(PackOutput output, CompletableFuture<Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void gather(Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(WDBlocks.HOLLY_CABINET.getId(), new FurnaceFuel(300), false)
                .add(WDBlocks.CHESTNUT_CABINET.getId(), new FurnaceFuel(300), false)
                .add(WDBlocks.PINE_CABINET.getId(), new FurnaceFuel(300), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(WDItems.CHRISTMAS_PUDDING_SLICE.getId(), new Compostable(.85f), false);
    }
}