package io.bluebeaker.enchantedsacredtrees;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class FoiledBlockItem extends BlockItem {

    public FoiledBlockItem(Block p_i48527_1_, Properties p_i48527_2_) {
        super(p_i48527_1_, p_i48527_2_);
    }
    public boolean isFoil(ItemStack stack) {
        return true;
     }
}
