package nudelauflauch.curd_mod.world;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import nudelauflauch.curd_mod.common.blocks.CuddlyCactus;
import nudelauflauch.curd_mod.core.init.BlockInit;

public class OreGeneration {

	private static final BlockClusterFeatureConfig CONFIG = (new BlockClusterFeatureConfig.Builder(
			(new WeightedBlockStateProvider()).addWeightedBlockstate(
					BlockInit.OPUNTIEN_CACTUS.get().getDefaultState().with(CuddlyCactus.AGE, Integer.valueOf(6)), 2),
			SimpleBlockPlacer.PLACER)).tries(64).build();

	public static void Oregeneration(BiomeLoadingEvent event) {

		if (!event.getCategory().equals(Biome.Category.NETHER) && !event.getCategory().equals(Biome.Category.THEEND)) {
			oregeneration(event.getGeneration(), BlockInit.LOST_CCP_ORE.get(), 256, 45, 6, 10);

			if (event.getCategory().equals(Biome.Category.DESERT)) {
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
						.add(() -> Feature.FLOWER.withConfiguration(CONFIG)
								.withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(1));
			}
		}
	}

	private static void oregeneration(BiomeGenerationSettingsBuilder biomeGenSettings, Block oreBlock, int maxHeight,
			int minHeight, int veinSize, int veinsPerChunk) {

		ConfiguredFeature<?, ?> feature = Feature.ORE
				.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						oreBlock.getDefaultState(), veinSize))
				.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
				.func_242731_b(veinsPerChunk);

		biomeGenSettings.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> feature);
	}

}