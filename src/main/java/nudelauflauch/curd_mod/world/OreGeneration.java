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
			(new WeightedBlockStateProvider()).add(
					BlockInit.OPUNTIEN_CACTUS.get().defaultBlockState().setValue(CuddlyCactus.AGE, Integer.valueOf(6)),
					2),
			SimpleBlockPlacer.INSTANCE)).tries(64).build();

	public static void Oregeneration(BiomeLoadingEvent event) {

		if (!event.getCategory().equals(Biome.Category.NETHER) && !event.getCategory().equals(Biome.Category.THEEND)) {
			oregeneration(event.getGeneration(), BlockInit.LOST_CCP_ORE.get(), 256, 45, 6, 10);

			if (event.getCategory().equals(Biome.Category.DESERT)) {
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
						.add(() -> Feature.FLOWER.configured(CONFIG)
								.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(1));
			}
		}
	}

	private static void oregeneration(BiomeGenerationSettingsBuilder biomeGenSettings, Block oreBlock, int maxHeight,
			int minHeight, int veinSize, int veinsPerChunk) {

		ConfiguredFeature<?, ?> feature = Feature.ORE
				.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
						oreBlock.defaultBlockState(), veinSize))
				.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
				.count(veinsPerChunk);

		biomeGenSettings.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> feature);
	}

}