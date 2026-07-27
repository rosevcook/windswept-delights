package com.rosemods.windswept_delights.core.data.client;

import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.rosemods.windswept_delights.core.registry.WDBlocks.*;
import static com.rosemods.windswept_delights.core.registry.WDItems.*;

public class WDModelProvider extends BlueprintBlockStateProvider {

    public WDModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WindsweptDelights.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.generatedItem(GOAT_SHANKS);
        this.generatedItem(COOKED_GOAT_SHANKS);
        this.generatedItem(CHRISTMAS_PUDDING_SLICE);
        this.generatedItem(CHESTNUT_RISOTTO);
        this.generatedItem(WILD_BERRY_POPSICLE);
        this.generatedItem(LAVENDER_SALAD);
        this.generatedItem(SNOW_CONE);
        this.generatedItem(MELON_SNOW_CONE);
        this.generatedItem(PUMPKIN_SNOW_CONE);
        this.generatedItem(CHOCOLATE_SNOW_CONE);
        this.generatedItem(CHORUS_SNOW_CONE);
        this.generatedItem(RAINBOW_SNOW_CONE);
        this.generatedItem(MIMOSA_SOUP);
        this.generatedItem(WILD_BERRY_JUICE);

        this.cabinet(HOLLY_CABINET);
        this.cabinet(CHESTNUT_CABINET);
        this.cabinet(PINE_CABINET);
    }

    private void itemModel(DeferredHolder<Block, ? extends Block> block) {
        this.itemModels().withExistingParent(getName(block.get()), this.blockTexture(block.get()));
    }

    private void generatedItem(DeferredHolder<? extends ItemLike, ? extends ItemLike> item) {
        String name = getName(item.get());
        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", WindsweptDelights.location("item/" + name));
    }

    private void cabinet(DeferredHolder<Block, ? extends Block> cabinet) {
        String name = getName(cabinet.get());
        ModelFile model = this.models().orientable(name, this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_front"), this.modLoc("block/" + name + "_end"));
        ModelFile model_open = this.models().orientable(name + "_open", this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_front_open"), this.modLoc("block/" + name + "_end"));

        this.horizontalBlock(cabinet.get(), s -> s.getValue(BlockStateProperties.OPEN) ? model_open : model);
        this.itemModel(cabinet);
    }

    private static String getName(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }

}