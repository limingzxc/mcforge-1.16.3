package com.wwwday.boson.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ObsidianBlock extends Block {
    public ObsidianBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }
}
