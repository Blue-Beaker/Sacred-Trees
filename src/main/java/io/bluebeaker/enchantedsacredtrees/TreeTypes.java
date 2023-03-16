package io.bluebeaker.enchantedsacredtrees;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeTypes {
	public static boolean generateMegaRubberTree(MassiveTreeGenerator generator, World world, Random random, BlockPos pos, boolean safe)
	{
		return generator.setTreeScale(4 + (random.nextInt(3)), 0.8f, 0.7f).
				setLeafAttenuation(0.6f).setSloped(true).setSafe(safe).
				generate(world, random, pos);
    }
	public static boolean generateSacredSpringRubberTree(MassiveTreeGenerator generator, World world, Random random, BlockPos pos)
	{
		return generator.setTreeScale(6 + (random.nextInt(4)), 1f, 0.9f).
				setLeafAttenuation(0.35f).setSloped(false).setMinTrunkSize(4).
				generate(world, random, pos);
	}
    public static boolean generateMassiveRubberTree(MassiveTreeGenerator generator, World world, Random random, BlockPos pos){
		return generator.setSloped(true).
        setLeafAttenuation(0.45f).setSloped(false).
        generate(world, random, pos);
    }
}
