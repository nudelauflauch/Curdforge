package nudelauflauch.curd_mod.core.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nudelauflauch.curd_mod.Curd_mod;
import nudelauflauch.curd_mod.common.entities.projectile.PitEntity;



public class EntityInit {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			Curd_mod.MOD_ID);

	public static final RegistryObject<EntityType<PitEntity>> PIT = ENTITIES.register("pit",
			() -> EntityType.Builder.<PitEntity>of(PitEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F)
					.clientTrackingRange(4).updateInterval(10).build("pit"));

}