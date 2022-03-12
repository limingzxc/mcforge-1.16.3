package com.wwwday.boson;

import com.wwwday.boson.block.CubeBlock;
import com.wwwday.boson.block.FirestoneBlock;
import com.wwwday.boson.block.ObsidianBlock;
import com.wwwday.boson.crop.SoybeanBlock;
import com.wwwday.boson.group.ModGroup;
import com.wwwday.boson.notsoildblock.ObsidianFrame;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Boson.MOD_ID);

    public static final RegistryObject<Block> OBSIDIAN_FRAME = BLOCKS.register("obsidian_frame",
            ObsidianFrame::new);

    public static final RegistryObject<Block> OBSIDIAN_BLOCK = BLOCKS.register("obsidian_block",
            ObsidianBlock::new);
    public static final RegistryObject<Block> CUBE_BLOCK = BLOCKS.register("cube_block", CubeBlock::new);

    public static final RegistryObject<Block> SOYBEAN_BLOCK = BLOCKS.register("soybean_block",
            () -> new SoybeanBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> FIRESTONE_BLOCK = BLOCKS.register("firestone_block",
            () -> new FirestoneBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6f)));

    public void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModGroup.itemGroup)));
    }
}
