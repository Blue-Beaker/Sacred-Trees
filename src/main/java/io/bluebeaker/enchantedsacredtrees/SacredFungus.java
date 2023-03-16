package io.bluebeaker.enchantedsacredtrees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class SacredFungus extends SacredSapling {
    public BlockState lights;
    public BlockState vines;
    public BlockState vines2;
    public SacredFungus(Block log, Block wood, Block leaves, Block lights, Block vines, Block vines2, Properties properties, Type type) {
        super(log, wood, leaves, properties, type);
        if(lights!=null) this.lights=lights.defaultBlockState();
        if(vines!=null) this.vines=vines.defaultBlockState();
        if(vines!=null) this.vines2=vines2.defaultBlockState();
    }
    public SacredFungus(BlockState log, BlockState wood, BlockState leaves, BlockState lights, BlockState vines, BlockState vines2, Properties properties, Type type) {
        super(log, wood, leaves, properties, type);
        this.lights=lights;
        this.vines2=vines2;
    }
    protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
        return state.is(BlockTags.NYLIUM) || state.is(Blocks.MYCELIUM) || state.is(Blocks.SOUL_SOIL) || super.mayPlaceOn(state, reader, pos);
    }
    public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if (state.getValue(STAGE) == 0) {
           world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, random, pos)) return;
            switch (type) {
                case SACRED_SPRING:
                    TreeTypes.generateSacredSpringRubberTree(new MassiveTreeGenerator(log, wood, leaves, lights, vines, vines2), world, random, pos);
                    break;
                case MEGA:
                    TreeTypes.generateMegaRubberTree(new MassiveTreeGenerator(log, wood, leaves, lights, vines, vines2), world, random, pos, dynamicShape);
                    break;
                case MASSIVE:
                    TreeTypes.generateMassiveRubberTree(new MassiveTreeGenerator(log, wood, leaves, lights, vines, vines2), world, random, pos);
                    break;
                default:
                    break;
            }
        }
    }
}
