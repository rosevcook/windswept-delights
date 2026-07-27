package com.rosemods.windswept_delights.core;

import com.rosemods.windswept_delights.core.data.client.WDLanguageProvider;
import com.rosemods.windswept_delights.core.data.client.WDModelProvider;
import com.rosemods.windswept_delights.core.data.server.*;
import com.rosemods.windswept_delights.core.data.server.tags.*;
import com.rosemods.windswept_delights.core.other.WDCreativeTabs;
import com.rosemods.windswept_delights.core.other.WDFoods;
import com.rosemods.windswept_delights.core.registry.WDBlocks;
import com.rosemods.windswept_delights.core.registry.WDItems;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(WindsweptDelights.MOD_ID)
public class WindsweptDelights {
    public static final String MOD_ID = "windswept_delights";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public WindsweptDelights(IEventBus bus, ModContainer container) {
        REGISTRY_HELPER.register(bus);

        WDBlocks.BLOCKS.getClass();
        WDItems.ITEMS.getClass();

        bus.addListener(this::commonSetup);
        bus.addListener(this::dataSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            WDCreativeTabs.setupTabEditors();
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(WDItems.CHRISTMAS_PUDDING_SLICE.get().asItem(), .85f);
        });
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean server = event.includeServer();
        WDBlockTagsProvider blockTags = new WDBlockTagsProvider(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new WDItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(server, new WDRecipeProvider(output, provider));
        generator.addProvider(server, new WDLootTableProvider(output, provider));
        generator.addProvider(server, new WDDataMapProvider(output, provider));

        boolean client = event.includeClient();
        generator.addProvider(client, new WDModelProvider(output, helper));
        generator.addProvider(client, new WDLanguageProvider(output));
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}