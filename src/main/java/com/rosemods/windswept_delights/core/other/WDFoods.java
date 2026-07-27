package com.rosemods.windswept_delights.core.other;

import com.mojang.datafixers.util.Pair;
import com.rosemods.windswept.core.other.WindsweptFoods;
import com.rosemods.windswept.core.registry.WindsweptEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

public final class WDFoods {
    public static final FoodProperties GOAT_SHANKS = new FoodProperties.Builder().nutrition(1).saturationModifier(.1f).build();
    public static final FoodProperties COOKED_GOAT_SHANKS = new FoodProperties.Builder().nutrition(3).saturationModifier(.3f).build();
    public static final FoodProperties WILD_BERRY_POPSICLE = new FoodProperties.Builder().nutrition(4).saturationModifier(.7f).alwaysEdible().effect(() -> new MobEffectInstance(WindsweptEffects.FROST_RESISTANCE, 300, 0), 1f).build();
    public static final FoodProperties LAVENDER_SALAD = new FoodProperties.Builder().nutrition(6).saturationModifier(.6f).build();
    public static final FoodProperties MIMOSA_SOUP = new FoodProperties.Builder().nutrition(7).saturationModifier(.5f).effect(() -> new MobEffectInstance(ModEffects.COMFORT, FoodValues.MEDIUM_DURATION, 0), 1f).build();
    public static final FoodProperties CHESTNUT_RISOTTO = new FoodProperties.Builder().nutrition(13).saturationModifier(.75f).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0), 1f).build();
    public static final FoodProperties SNOW_CONE = new FoodProperties.Builder().nutrition(15).saturationModifier(.6f).build();
    public static final FoodProperties MELON_SNOW_CONE = new FoodProperties.Builder().nutrition(15).alwaysEdible().saturationModifier(.6f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1f).build();
    public static final FoodProperties CHORUS_SNOW_CONE = new FoodProperties.Builder().nutrition(15).alwaysEdible().saturationModifier(.6f).effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 300, 0), 1f).build();
    public static final FoodProperties PUMPKIN_SNOW_CONE = new FoodProperties.Builder().nutrition(15).alwaysEdible().saturationModifier(.6f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0), 1f).build();
    public static final FoodProperties CHOCOLATE_SNOW_CONE = new FoodProperties.Builder().nutrition(15).alwaysEdible().saturationModifier(.6f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0), 1f).build();
    public static final FoodProperties WILD_BERRY_JUICE = new FoodProperties.Builder().alwaysEdible().effect(() -> new MobEffectInstance(WindsweptEffects.FROST_RESISTANCE, 1200, 0), 1f).build();

    }
