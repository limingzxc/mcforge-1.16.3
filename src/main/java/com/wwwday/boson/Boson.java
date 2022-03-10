package com.wwwday.boson;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.logging.LogManager;
import java.util.logging.Logger;


@Mod(Boson.MOD_ID)
public class Boson {

    public static final String MOD_ID = "boson";

//    private static final Logger LOGGER = LogManager.getLogger();

    public Boson() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);

        eventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.SOYBEAN_BLOCK.get(), RenderType.getCutout());
        });
    }
}
