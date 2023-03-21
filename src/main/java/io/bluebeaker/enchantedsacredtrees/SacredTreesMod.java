package io.bluebeaker.enchantedsacredtrees;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("sacred_trees")
public class SacredTreesMod
{
    static final String MODID = "sacred_trees";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    
    public SacredTreesMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        ArrayList<SaplingBlocks.SaplingVariant> saplingList = new ArrayList<SaplingBlocks.SaplingVariant>();
        saplingList.add(SaplingBlocks.OAK);
        saplingList.add(SaplingBlocks.BIRCH);
        saplingList.add(SaplingBlocks.SPRUCE);
        saplingList.add(SaplingBlocks.JUNGLE);
        saplingList.add(SaplingBlocks.ACACIA);
        saplingList.add(SaplingBlocks.DARK_OAK);
        saplingList.add(SaplingBlocks.CRIMSON);
        saplingList.add(SaplingBlocks.WARPED);
        for (SaplingBlocks.SaplingVariant sapling: saplingList){
            RenderTypeLookup.setRenderLayer(sapling.MASSIVE,RenderType.cutout());
            RenderTypeLookup.setRenderLayer(sapling.MEGA,RenderType.cutout());
            RenderTypeLookup.setRenderLayer(sapling.SACRED,RenderType.cutout());
        }
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
        }
    }
}
