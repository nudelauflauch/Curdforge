package nudelauflauch.curd_mod.core.init;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import nudelauflauch.curd_mod.common.blocks.CuddlyCactus;

public class FeatureInit {
	public static final BlockState CUDDLY_CACTUS = BlockInit.CUDDLY_CACTUS.get().getDefaultState()
			.with(CuddlyCactus.AGE, 3);

	public static final BlockClusterFeatureConfig BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(CUDDLY_CACTUS), new SimpleBlockPlacer()).tries(64)
					.whitelist(ImmutableSet.of(Blocks.SAND.getBlock())).func_227317_b_().build());
}
