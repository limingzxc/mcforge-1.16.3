package com.wwwday.boson.food;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class CloudFruit extends Item {
    private static final Food food = (new Food.Builder())
            .saturation(1)
            .hunger(1)
            .setAlwaysEdible()
            .fastToEat()
            .effect(() -> new EffectInstance(Effects.LEVITATION, 10 * 20, 1), 1)
            .build();
    public CloudFruit() {
        super(new Properties().food(food).group(ItemGroup.FOOD));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.boson.cloud_fruit_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.boson.cloud_fruit"));
        }
        super.addInformation(stack, world, tooltip, flag);
    }

    @Nonnull
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
        if(this.isFood()) {
            if(entity.getActivePotionEffect(Effects.LEVITATION) != null) {
                entity.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1));
            }
            return entity.onFoodEaten(world, stack);
        }
        else {
            return stack;
        }
    }
}
