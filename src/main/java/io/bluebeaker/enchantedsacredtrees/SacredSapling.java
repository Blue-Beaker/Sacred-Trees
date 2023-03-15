package io.bluebeaker.enchantedsacredtrees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.OakTree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SacredSapling extends SaplingBlock {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    private BlockState log;
    private BlockState wood;
    private BlockState leaves;
    enum Type{
        MEGA,MASSIVE,SACRED_SPRING
    }
    private Type type;
    public SacredSapling(BlockState log, BlockState wood, BlockState leaves, Properties properties, Type type) {
        super(new OakTree(), properties);
        this.log=log;
        this.wood=wood;
        this.leaves=leaves;
        this.type=type;
    }
    public SacredSapling(Block log, Block wood, Block leaves, Properties properties, Type type){
        super(new OakTree(), properties);
        this.log=log.defaultBlockState();
        this.wood=wood.defaultBlockState();
        this.leaves=leaves.defaultBlockState();
        this.type=type;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    }
    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient)
    {
    return true;
    }
    @Override
    public boolean isBonemealSuccess(World world, Random random, BlockPos pos, BlockState state){
        return (double)world.random.nextFloat() < 0.45D;
    }

    @Override
    public void performBonemeal(ServerWorld world, Random random, BlockPos pos, BlockState state){
        this.advanceTree(world, pos, state, random);
    }
    public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if (state.getValue(STAGE) == 0) {
           world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, random, pos)) return;
            switch (type) {
                case SACRED_SPRING:
                    TreeTypes.generateSacredSpringRubberTree(log, wood, leaves, world, random, pos);
                    break;
                case MEGA:
                    TreeTypes.generateMegaRubberTree(log, wood, leaves, world, random, pos, dynamicShape);
                    break;
                case MASSIVE:
                    TreeTypes.generateMassiveRubberTree(log, wood, leaves, world, random, pos);
                    break;
                default:
                    break;
            }
        }
    }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos,
            ISelectionContext context) {
        return super.getShape(state, reader, pos, context);
    }
}
