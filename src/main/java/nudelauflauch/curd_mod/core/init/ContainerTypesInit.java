package nudelauflauch.curd_mod.core.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nudelauflauch.curd_mod.Curd_mod;

public class ContainerTypesInit {
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, Curd_mod.MOD_ID);
/*
	public static final RegistryObject<ContainerType<JamMakerConatainer>> JAM_MAKER_CONTAINER_TYPE = CONTAINER_TYPES
			.register("jam_maker_case", () -> IForgeContainerType.create(JamMakerConatainer::new));
*/}
