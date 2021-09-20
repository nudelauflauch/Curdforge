package nudelauflauch.curd_mod.core.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nudelauflauch.curd_mod.Curd_mod;
import nudelauflauch.curd_mod.common.te.KefirJarTickEntity;
import nudelauflauch.curd_mod.common.te.KefirKrystallizerTileEntity;

public class TileEntityTypesInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, Curd_mod.MOD_ID);

	public static final RegistryObject<TileEntityType<KefirJarTickEntity>> KEFIR_JAR_TICK_ENTITY = TILE_ENTITY_TYPE.register(
			"kefir_jar_tick_entity",
			() -> TileEntityType.Builder.of(KefirJarTickEntity::new, BlockInit.KEFIR_JAR.get()).build(null));

	public static final RegistryObject<TileEntityType<KefirKrystallizerTileEntity>> KEFIR_CRYSTALLIZER_TICK_ENTITY = TILE_ENTITY_TYPE
			.register("kefir_crystallizer_tick_entity",
					() -> TileEntityType.Builder.of(KefirKrystallizerTileEntity::new, BlockInit.KEFIR_CRYSTALLIZER.get()).build(null));

}
