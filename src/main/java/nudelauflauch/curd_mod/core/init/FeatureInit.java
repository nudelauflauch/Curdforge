package nudelauflauch.curd_mod.core.init;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import nudelauflauch.curd_mod.common.blocks.CuddlyCactus;

public class FeatureInit{
	/* This just gets the BlockState for the frostberry bush, and returns the highest age, so we can call it easily */
	public static final BlockState BUSH = BlockInit.OPUNTIEN_CACTUS.get().getDefaultState()
			.with(CuddlyCactus.AGE, 6);

	/* This is a vanilla like BlockCluserFeatureConfig, used just like vanilla to call */
	public static final BlockClusterFeatureConfig BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(BUSH), new SimpleBlockPlacer()).tries(64)
					//whitelist
					.whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock()))).func_227317_b_().build();

}
