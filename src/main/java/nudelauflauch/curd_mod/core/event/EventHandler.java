package nudelauflauch.curd_mod.core.event;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent.LoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import nudelauflauch.curd_mod.Curd_mod;
import nudelauflauch.curd_mod.core.init.BlockInit;

@EventBusSubscriber(modid = Curd_mod.MOD_ID, bus = Bus.FORGE)
public class EventHandler {

	@SubscribeEvent
	public static void onStart(final LoggedInEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInit.KEFIR_JAR.get(), RenderType.getTranslucent());
	}
}
