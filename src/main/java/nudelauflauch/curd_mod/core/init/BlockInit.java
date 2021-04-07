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
			() -> new Kefir_crystallizer());

	public static final RegistryObject<CurdPot> CURD_POT = BLOCKS.register("curd_pot",
			() -> new CurdPot(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3f, 5f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).setRequiresTool()));

	public static final RegistryObject<Block> LOST_CCP_ORE = BLOCKS.register("lost_ccp_ore",
			() -> new Block(AbstractBlock.Properties.from(Blocks.COAL_ORE).harvestLevel(2)));

	public static final RegistryObject<Block> JAM_MAKER = BLOCKS.register("jam_maker", () -> new Jam_maker());

	public static final RegistryObject<Duff> DUFF = BLOCKS.register("duff", () -> new Duff());

	public static final RegistryObject<Duff_raisin> DUFF_RAISINS = BLOCKS.register("duff_raisins",
			() -> new Duff_raisin());

	public static final RegistryObject<Kefir> KEFIR_JAR = BLOCKS.register("kefir_jar", () -> new Kefir());

	public static final RegistryObject<CuddlyCactus> CUDDLY_CACTUS = BLOCKS.register("cuddly_cactus",
			() -> new CuddlyCactus(
					AbstractBlock.Properties.create(Material.IRON).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
}
