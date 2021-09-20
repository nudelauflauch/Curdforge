package nudelauflauch.curd_mod.core.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nudelauflauch.curd_mod.Curd_mod;
import nudelauflauch.curd_mod.common.blocks.CuddlyCactus;
import nudelauflauch.curd_mod.common.blocks.CurdPot;
import nudelauflauch.curd_mod.common.blocks.Duff;
import nudelauflauch.curd_mod.common.blocks.Duff_raisin;
import nudelauflauch.curd_mod.common.blocks.Jam_maker;
import nudelauflauch.curd_mod.common.blocks.Kefir;
import nudelauflauch.curd_mod.common.blocks.Kefir_crystallizer;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Curd_mod.MOD_ID);

	// Blocks
	public static final RegistryObject<Kefir_crystallizer> KEFIR_CRYSTALLIZER = BLOCKS.register("kefir_crystallizer",
			() -> new Kefir_crystallizer(AbstractBlock.Properties.of(Material.WOOD).strength(0.8f, 1.5f)
					.sound(SoundType.WOOD).harvestLevel(2).harvestTool(ToolType.AXE).air()));

	public static final RegistryObject<CurdPot> CURD_POT = BLOCKS
			.register("curd_pot",
					() -> new CurdPot(AbstractBlock.Properties.of(Material.SPONGE).strength(1.0f, 2f)
							.harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)
							.requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> LOST_CCP_ORE = BLOCKS.register("lost_ccp_ore",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.COAL_ORE).harvestLevel(2)));

	public static final RegistryObject<Block> LOST_CCP_BLOCK = BLOCKS.register("lost_ccp_block",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.COAL_ORE).harvestLevel(2).sound(SoundType.METAL)));

	public static final RegistryObject<Block> TILE = BLOCKS.register("tile",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.COAL_ORE).harvestLevel(2).sound(SoundType.METAL)));

	public static final RegistryObject<Block> STOVE = BLOCKS.register("stove",
			() -> new Jam_maker(AbstractBlock.Properties.of(Material.METAL).strength(15f, 30f)
					.sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));

	public static final RegistryObject<Duff> DUFF = BLOCKS.register("duff",
			() -> new Duff(AbstractBlock.Properties.of(Material.CAKE).harvestTool(ToolType.SHOVEL).harvestLevel(0)
					.strength(1f, 1f).sound(SoundType.FUNGUS).air()));

	public static final RegistryObject<Duff_raisin> DUFF_RAISINS = BLOCKS.register("duff_raisins",
			() -> new Duff_raisin((AbstractBlock.Properties.of(Material.CAKE).strength(1f, 1f)
					.sound(SoundType.FUNGUS).air())));

	public static final RegistryObject<Kefir> KEFIR_JAR = BLOCKS.register("kefir_jar", () -> new Kefir(
			AbstractBlock.Properties.of(Material.GLASS).strength(1f, 2f).sound(SoundType.GLASS)));

	public static final RegistryObject<CuddlyCactus> OPUNTIEN_CACTUS = BLOCKS.register("opuntien_cactus",
			() -> new CuddlyCactus(AbstractBlock.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH)
					.air().instabreak().randomTicks().noCollission()));

}
