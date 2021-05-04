package nudelauflauch.curd_mod.core.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nudelauflauch.curd_mod.Curd_mod;

public class TileEntityTypesInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, Curd_mod.MOD_ID);
/*
	public static final RegistryObject<TileEntityType<JamMakerTileEntity>> JAM_MAKER_ENTITY_TYPE = TILE_ENTITY_TYPE
			.register("jam_maker", () -> TileEntityType.Builder
					.create(JamMakerTileEntity::new, BlockInit.JAM_MAKER.get()).build(null));
*/
}
