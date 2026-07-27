package com.rosemods.windswept_delights.core.data.server;

import com.google.common.collect.ImmutableList;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.registry.WDBlocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class WDLootTableProvider extends LootTableProvider {

    public WDLootTableProvider(PackOutput output, CompletableFuture<Provider> provider) {
        super(output, BuiltInLootTables.all(), ImmutableList.of(new LootTableProvider.SubProviderEntry(BlockProvider::new, LootContextParamSets.BLOCK)), provider);
    }

    @Override
    protected void validate(WritableRegistry<LootTable> registry, ValidationContext context, ProblemReporter.Collector collector) {
    }

    private static class BlockProvider extends VanillaBlockLoot {

        protected BlockProvider(Provider provider) {
            super(provider);
        }

        @Override
        protected void generate() {
            this.add(WDBlocks.HOLLY_CABINET.get(), this::createNameableBlockEntityTable);
            this.add(WDBlocks.CHESTNUT_CABINET.get(), this::createNameableBlockEntityTable);
            this.add(WDBlocks.PINE_CABINET.get(), this::createNameableBlockEntityTable);
        }

        @Override
        public Iterable<Block> getKnownBlocks() {
            return BuiltInRegistries.BLOCK.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(WindsweptDelights.MOD_ID)).collect(Collectors.toSet());
        }
    }
}