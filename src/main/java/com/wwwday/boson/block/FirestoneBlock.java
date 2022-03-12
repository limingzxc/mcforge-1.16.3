package com.wwwday.boson.block;

import com.wwwday.boson.item.Firestone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class FirestoneBlock extends Block {

    public FirestoneBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public ActionResultType onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        if(!world.isRemote) {
            if(hand == Hand.MAIN_HAND) {
                System.out.println("I right-click a FirestoneBlock. Called for the Main Hand!");
            }
            if(hand == Hand.OFF_HAND) {
                System.out.println("I left-click a FirestoneBlock. Called for the Off Hand!");
            }
        }
        return super.onBlockActivated(blockState, world, blockPos, playerEntity, hand, blockRayTraceResult);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity) {
        if(!world.isRemote) {
            System.out.println("I light-click a FirestoneBlock!");
        }
    }

    @Override
    public void onEntityWalk(World world, BlockPos blockPos, Entity entity) {
        Firestone.lightEntityOnFire(entity, 5);
        super.onEntityWalk(world, blockPos, entity);
    }
}
