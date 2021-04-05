package nudelauflauch.curd_mod.common.entities;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;
import java.util.Set;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import nudelauflauch.curd_mod.core.init.BlockInit;
/*
public class TileEntitys<T extends TileEntity>
		extends net.minecraftforge.registries.ForgeRegistryEntry<TileEntityType<?>> {
	private static final Logger LOGGER = LogManager.getLogger();
	public static final TileEntityType<Jam_maker_tile_entity> JAM_MAKER = register("jam_maker",
			TileEntityType.Builder.create(Jam_maker_tile_entity::new, BlockInit.JAM_MAKER.get()));

	@SuppressWarnings("deprecation")
	private static <T extends TileEntity> TileEntityType<T> register(String key, TileEntityType.Builder<T> builder) {
		if (builder.blocks.isEmpty()) {
			LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", (Object) key);
		}

		Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, key);
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, key, builder.build(type));
	}
}
*/