package com.rosemods.windswept_delights.core.registry;

import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class WDBlocks {
    public static final BlockSubRegistryHelper BLOCKS = WindsweptDelights.REGISTRY_HELPER.getBlockSubHelper();

    public static final DeferredBlock<Block> HOLLY_CABINET = BLOCKS.createBlock("holly_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.5f).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> CHESTNUT_CABINET = BLOCKS.createBlock("chestnut_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.5f).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> PINE_CABINET = BLOCKS.createBlock("pine_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.5f).sound(SoundType.WOOD).ignitedByLava()));
}