package nudelauflauch.curd_mod.core.init;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nudelauflauch.curd_mod.Curd_mod;

public class EntityInit {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Curd_mod.MOD_ID);

	/*public static final RegistryObject<EntityType<PitEntity>> PIT_PROJECTILE = ENTITES.register("pit_projectile",
			() -> EntityType.Builder.<PitEntity>create(PitEntity::new, EntityClassification.MISC).size(0.5F, 0.5F)
					.build("pit_projectile"));
*/
}