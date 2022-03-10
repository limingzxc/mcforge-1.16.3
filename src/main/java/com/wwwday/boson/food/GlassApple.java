package com.wwwday.boson.food;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class GlassApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturation(1)
            .hunger(1)
            .setAlwaysEdible()
            .fastToEat()
            .effect(() -> new EffectInstance(Effects.LEVITATION, 10 * 20, 1), 1)
            .effect(() -> new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1), 0.1F)
            .build();
    public GlassApple() {
        super(new Properties().food(food).group(ItemGroup.FOOD));
    }
}
