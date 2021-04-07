package nudelauflauch.curd_mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nudelauflauch.curd_mod.core.init.BlockInit;
import nudelauflauch.curd_mod.core.init.ItemInit;
import nudelauflauch.curd_mod.world.OreGeneration;
//seed 628362910163464401

@Mod(Curd_mod.MOD_ID)
public class Curd_mod {

	public static final String MOD_ID = "curd_mod";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup CURD_MOD_FOOD_GROUP = new Curd_modFoodGorup("curd_food_tab");
	public static final ItemGroup CURD_MOD_MATERIALS_GROUP = new Curd_modMaterialsGorup("curd_materials_tab");
	IEventBus forgeBus = MinecraftForge.EVENT_BUS;

	public Curd_mod() {

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		/*
		 * PotionList.EFFECTS.register(bus); PotionList.POTIONS.register(bus);
		 * PotionList.addBrewingRecipies();
		 */

		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generatedOres);

		MinecraftForge.EVENT_BUS.register(this);

		// For events that happen after initialization. This is probably going to be use
		// a lot.

	}

	private void clientstuff(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInit.KEFIR_JAR.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CURD_POT.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CUDDLY_CACTUS.get(), RenderType.getCutout());
	}

	// Creative Tabs
	public static class Curd_modFoodGorup extends ItemGroup {

		public Curd_modFoodGorup(String label) {
			super(label);

		}

		@Override
		public ItemStack createIcon() {
			return ItemInit.CCP.get().getDefaultInstance();
		}

	}

	public static class Curd_modMaterialsGorup extends ItemGroup {

		public Curd_modMaterialsGorup(String label) {
			super(label);

		}

		@Override
		public ItemStack createIcon() {
			return ItemInit.CURD.get().getDefaultInstance();
		}

	}
}
