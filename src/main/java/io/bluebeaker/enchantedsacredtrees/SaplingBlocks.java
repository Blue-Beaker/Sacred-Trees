package io.bluebeaker.enchantedsacredtrees;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SaplingBlocks {
    public static SaplingVariant OAK;
    public static SaplingVariant BIRCH;
    public static SaplingVariant SPRUCE;
    public static SaplingVariant JUNGLE;
    public static SaplingVariant ACACIA;
    public static SaplingVariant DARK_OAK;
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        OAK=registerSaplingTypes("oak_sapling",Blocks.OAK_LOG,Blocks.OAK_WOOD,Blocks.OAK_LEAVES);
        BIRCH=registerSaplingTypes("birch_sapling",Blocks.BIRCH_LOG,Blocks.BIRCH_WOOD,Blocks.BIRCH_LEAVES);
        SPRUCE=registerSaplingTypes("spruce_sapling",Blocks.SPRUCE_LOG,Blocks.SPRUCE_WOOD,Blocks.SPRUCE_LEAVES);
        JUNGLE=registerSaplingTypes("jungle_sapling",Blocks.JUNGLE_LOG,Blocks.JUNGLE_WOOD,Blocks.JUNGLE_LEAVES);
        ACACIA=registerSaplingTypes("acacia_sapling",Blocks.ACACIA_LOG,Blocks.ACACIA_WOOD,Blocks.ACACIA_LEAVES);
        DARK_OAK=registerSaplingTypes("dark_oak_sapling",Blocks.DARK_OAK_LOG,Blocks.DARK_OAK_WOOD,Blocks.DARK_OAK_LEAVES);
    }
    private static SaplingVariant registerSaplingTypes(String basename, Block log, Block wood, Block leaves){
        return new SaplingVariant(
        registerBlock("sacred_"+basename, new SacredSapling(log,wood,leaves, 
        AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS),
        SacredSapling.Type.SACRED_SPRING)),
        registerBlock("mega_"+basename, new SacredSapling(log,wood,leaves, 
        AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS),
        SacredSapling.Type.MEGA)),
        registerFoiledBlock("massive_"+basename, new SacredSapling(log,wood,leaves, 
        AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS),
        SacredSapling.Type.MASSIVE)));
    }
    public static Block registerBlock(String name,Block block)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().tab(ItemGroupSacredSaplings.instance));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }
    public static Block registerFoiledBlock(String name,Block block)
    {
        BlockItem itemBlock = new FoiledBlockItem(block, new Item.Properties().tab(ItemGroupSacredSaplings.instance));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }
    public static class SaplingVariant{
        public final Block SACRED;
        public final Block MEGA;
        public final Block MASSIVE;
        public SaplingVariant(Block sacred, Block mega, Block massive){
            SACRED=sacred;
            MEGA=mega;
            MASSIVE=massive;
        }
    }
}
