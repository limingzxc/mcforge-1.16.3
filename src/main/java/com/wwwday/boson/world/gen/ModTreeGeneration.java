package com.wwwday.boson.world.gen;

import com.wwwday.boson.trees.PoplarTree;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Random;
import java.util.Set;

public class ModTreeGeneration {

    public static void generateTrees(final BiomeLoadingEvent event) {
        PoplarTree poplarTree = new PoplarTree();
        Random random = new Random();

        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());


    }

}
