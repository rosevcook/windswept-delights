package com.rosemods.windswept_delights.core.data.client;

import com.google.common.collect.Lists;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.registry.WDBlocks;
import com.rosemods.windswept_delights.core.registry.WDItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.codehaus.plexus.util.StringUtils;

import java.util.List;

public class WDLanguageProvider extends LanguageProvider {
    private final List<String> keys = Lists.newArrayList();

    public WDLanguageProvider(PackOutput output) {
        super(output, WindsweptDelights.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(WDItems.CHRISTMAS_PUDDING_SLICE.get(), "Slice of Christmas Pudding");
        this.add(WDItems.GOAT_SHANKS.get(), "Raw Chevon Shanks");
        this.add(WDItems.COOKED_GOAT_SHANKS.get(), "Cooked Chevon Shanks");

        this.translateBlocks();
        this.translateItems();
    }

    private void translateBlocks() {
        for (DeferredHolder<Block, ? extends Block> holder : WDBlocks.BLOCKS.getDeferredRegister().getEntries()) {
            Block block = holder.get();
            this.add(block.getDescriptionId(), toUpper(BuiltInRegistries.BLOCK.getKey(block).getPath()));
        }
    }

    private void translateItems() {
        for (DeferredHolder<Item, ? extends Item> holder : WDItems.ITEMS.getDeferredRegister().getEntries()) {
            Item item = holder.get();
            this.add(item.getDescriptionId(), toUpper(BuiltInRegistries.ITEM.getKey(item).getPath()));
        }
    }

    @Override
    public void add(String key, String value) {
        if (!this.keys.contains(key)) {
            super.add(key, value);
            this.keys.add(key);
        }
    }

    private static String toUpper(String string) {
        return StringUtils.capitaliseAllWords(string.replace('_', ' '));
    }
}