package nudelauflauch.curd_mod.core.util;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nudelauflauch.curd_mod.Curd_mod;
import nudelauflauch.curd_mod.core.init.ContainerTypesInit;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*
@Mod.EventBusSubscriber(modid = Curd_mod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ContainerTypesInit.JAM_MAKER_CONTAINER_TYPE.get(), JamMakerScreen::new);
	}
}
*/