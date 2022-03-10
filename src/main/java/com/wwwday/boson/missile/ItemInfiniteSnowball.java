package com.wwwday.boson.missile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.SnowballEntity;

import javax.annotation.Nonnull;


public class ItemInfiniteSnowball extends Item {
    public ItemInfiniteSnowball() {
        super(new Properties().group(ItemGroup.MISC));
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack item = player.getHeldItem(hand);
        world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!world.isRemote) {
            SnowballEntity snowball = new SnowballEntity(world, player);
            snowball.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.addEntity(snowball);
        }

            return new ActionResult<>(ActionResultType.SUCCESS, item);
    }
}
