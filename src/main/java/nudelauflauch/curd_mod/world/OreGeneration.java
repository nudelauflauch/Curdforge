package nudelauflauch.curd_mod.world;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.common.Mod;
import nudelauflauch.curd_mod.common.blocks.CuddlyCactus;
import nudelauflauch.curd_mod.core.init.BlockInit;

@Mod.EventBusSubscriber
public class OreGeneration {
	public static void generatedOres(final BiomeLoadingEvent event) {
		if (!(event.getCategory().equals(Biome.Category.PLAINS))) {
			generateOres(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
					BlockInit.LOST_CCP_ORE.get().getDefaultState(), 10, 45, 255, 5);

		}
	}

	private static void generateOres(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
			int veinSize, int minHeight, int maxHeight, int amount) {
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
						.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
						.square().func_242731_b(amount));
	}

	public static void generate() {
	}
	/*

	public static final ConfiguredFeature<?, ?> PATCH_CADDLY_CACTUS = register("patch_cuddly_cactus",
			Feature.RANDOM_PATCH.withConfiguration(
					(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Curd_mod_States.CUDDLY_CACUTS),
							new ColumnBlockPlacer(1, 2))).tries(10).func_227317_b_().build()));
	
	public static final class Curd_mod_States {
		public static final BlockState CUDDLY_CACUTS = BlockInit.CUDDLY_CACTUS.get().getDefaultState()
				.with(CuddlyCactus.AGE, Integer.valueOf(3));
	}
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
	      return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
	   }
	   */
}
