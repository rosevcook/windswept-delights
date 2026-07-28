package com.rosemods.windswept_delights.core.other;

import com.rosemods.windswept.core.registry.WindsweptItems;
import com.rosemods.windswept_delights.core.WindsweptDelights;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

@EventBusSubscriber(modid = WindsweptDelights.MOD_ID)
public class WDCompat {

    @SubscribeEvent
    public static void onModifyComponents(ModifyDefaultComponentsEvent event) {
        event.modify(WindsweptItems.CHESTNUT_SOUP.get(), c -> c.set(DataComponents.FOOD, new FoodProperties.Builder().nutrition(7).saturationModifier(.5f).usingConvertsTo(Items.BOWL).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.MEDIUM_DURATION, 0), 1f).build()).set(DataComponents.MAX_STACK_SIZE, 16));
        event.modify(WindsweptItems.GOAT_STEW.get(), c -> c.set(DataComponents.FOOD, new FoodProperties.Builder().nutrition(9).saturationModifier(.9f).usingConvertsTo(Items.BOWL).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0), 1f).build()).set(DataComponents.MAX_STACK_SIZE, 16));
    }
}