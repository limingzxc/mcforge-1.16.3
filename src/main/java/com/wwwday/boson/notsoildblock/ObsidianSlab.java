package com.wwwday.boson.notsoildblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ObsidianSlab extends SlabBlock {

    public static final EnumProperty<SlabType> TYPE;
    protected static final VoxelShape TOP_SHAPE;
    protected static final VoxelShape BOTTOM_SHAPE;

    static {
        TYPE = BlockStateProperties.SLAB_TYPE;
        BOTTOM_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
        TOP_SHAPE = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    }

    public ObsidianSlab() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
        this.setDefaultState((BlockState)((BlockState)this.getDefaultState().with(TYPE, SlabType.BOTTOM)));
    }

    @Override
    public boolean isTransparent(BlockState p_220074_1_) {
        return p_220074_1_.get(TYPE) != SlabType.DOUBLE;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        SlabType type = (SlabType)state.get(TYPE);
        switch(type) {
            case DOUBLE:
                return VoxelShapes.fullCube();
            case TOP:
                return TOP_SHAPE;
            default:
                return BOTTOM_SHAPE;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos pos = context.getPos();
        BlockState state = context.getWorld().getBlockState(pos);

        if (state.matchesBlock(this)) {
            return (BlockState)((BlockState)state.with(TYPE, SlabType.DOUBLE));

        } else {
            BlockState blockState = (BlockState)((BlockState)this.getDefaultState().with(TYPE, SlabType.BOTTOM));
            Direction direction = context.getFace();
            return direction != Direction.DOWN && (direction == Direction.UP || !(context.getHitVec().y - (double)pos.getY() > 0.5D)) ? blockState : (BlockState)blockState.with(TYPE, SlabType.TOP);
        }
    }

    public boolean isReplaceable(BlockState state, BlockItemUseContext context) {
        ItemStack stack = context.getItem();
        SlabType type = (SlabType)state.get(TYPE);
        if (type != SlabType.DOUBLE && stack.getItem() == this.asItem()) {
            if (context.replacingClickedOnBlock()) {
                boolean lvt_5_1_ = context.getHitVec().y - (double)context.getPos().getY() > 0.5D;
                Direction lvt_6_1_ = context.getFace();
                if (type == SlabType.BOTTOM) {
                    return lvt_6_1_ == Direction.UP || lvt_5_1_ && lvt_6_1_.getAxis().isHorizontal();
                } else {
                    return lvt_6_1_ == Direction.DOWN || !lvt_5_1_ && lvt_6_1_.getAxis().isHorizontal();
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
