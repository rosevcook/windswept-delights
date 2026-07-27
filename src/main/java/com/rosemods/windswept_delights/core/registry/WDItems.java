package com.rosemods.windswept_delights.core.registry;

import com.rosemods.windswept.common.item.DrinkableBottleItem;
import com.rosemods.windswept.common.item.FoodRemainderItem;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import com.rosemods.windswept_delights.core.other.WDFoods;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.FoodValues;

public class WDItems {
    public static final ItemSubRegistryHelper ITEMS = WindsweptDelights.REGISTRY_HELPER.getItemSubHelper();

    public static final DeferredItem<Item> GOAT_SHANKS = ITEMS.createItem("goat_shanks", () -> new Item(PropertyUtil.food(WDFoods.GOAT_SHANKS)));
    public static final DeferredItem<Item> COOKED_GOAT_SHANKS = ITEMS.createItem("cooked_goat_shanks", () -> new Item(PropertyUtil.food(WDFoods.COOKED_GOAT_SHANKS)));
    public static final DeferredItem<Item> CHRISTMAS_PUDDING_SLICE = ITEMS.createItem("christmas_pudding_slice", () -> new Item(new Item.Properties().food(FoodValues.CAKE_SLICE)));
    public static final DeferredItem<Item> CHESTNUT_RISOTTO = ITEMS.createItem("chestnut_risotto", () -> new Item(PropertyUtil.food(WDFoods.CHESTNUT_RISOTTO).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final DeferredItem<Item> MIMOSA_SOUP = ITEMS.createItem("mimosa_soup", () -> new Item(PropertyUtil.food(WDFoods.MIMOSA_SOUP).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final DeferredItem<Item> WILD_BERRY_POPSICLE = ITEMS.createItem("wild_berry_popsicle", () -> new Item(PropertyUtil.food(WDFoods.WILD_BERRY_POPSICLE)));
    public static final DeferredItem<Item> WILD_BERRY_JUICE = ITEMS.createItem("wild_berry_juice", () -> new DrinkableBottleItem(WDFoods.WILD_BERRY_JUICE));
    public static final DeferredItem<Item> LAVENDER_SALAD = ITEMS.createItem("lavender_salad", () -> new Item(PropertyUtil.food(WDFoods.LAVENDER_SALAD).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final DeferredItem<Item> SNOW_CONE = ITEMS.createItem("snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.SNOW_CONE)));
    public static final DeferredItem<Item> MELON_SNOW_CONE = ITEMS.createItem("melon_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.MELON_SNOW_CONE)));
    public static final DeferredItem<Item> PUMPKIN_SNOW_CONE = ITEMS.createItem("pumpkin_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.PUMPKIN_SNOW_CONE)));
    public static final DeferredItem<Item> CHOCOLATE_SNOW_CONE = ITEMS.createItem("chocolate_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.CHOCOLATE_SNOW_CONE)));
    public static final DeferredItem<Item> CHORUS_SNOW_CONE = ITEMS.createItem("chorus_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.CHORUS_SNOW_CONE)));
    public static final DeferredItem<Item> RAINBOW_SNOW_CONE = ITEMS.createItem("rainbow_snow_cone", () -> new FoodRemainderItem(WindsweptBlocks.PINECONE::get, PropertyUtil.food(WDFoods.SNOW_CONE).rarity(Rarity.UNCOMMON)));
}