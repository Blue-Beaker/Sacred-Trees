package io.bluebeaker.enchantedsacredtrees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class ItemGroupSacredSaplings extends ItemGroup{
    public static final ItemGroupSacredSaplings instance = new ItemGroupSacredSaplings(ItemGroup.TABS.length, "sacred_trees");
    public static final RegistryObject<Block> ICON_REGISTRY = RegistryObject.of(new ResourceLocation("sacred_trees", "sacred_oak_sapling"), () -> Block.class); 
    private ItemGroupSacredSaplings(int index, String label)
    {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon()
    {
        return new ItemStack(SaplingBlocks.OAK.MASSIVE);
    }
}