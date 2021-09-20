package nudelauflauch.curd_mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlclient.registry.RenderingRegistry;
import nudelauflauch.curd_mod.core.init.BlockInit;
import nudelauflauch.curd_mod.core.init.EntityInit;
import nudelauflauch.curd_mod.core.init.ItemInit;
import nudelauflauch.curd_mod.core.init.TileEntityTypesInit;
import nudelauflauch.curd_mod.world.OreGeneration;

@Mod(Curd_mod.MOD_ID)
public class Curd_mod {
	// seed 628362910163464401
	public static MOD_ID = "curd_mod";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup CURD_MOD_FOOD_GROUP = new Curd_modFoodGorup("curd_food_tab");
	public static final ItemGroup CURD_MOD_MATERIALS_GROUP = new Curd_modMaterialsGorup("curd_materials_tab");
	IEventBus forgeBus = MinecraftForge.EVENT_BUS;

	public Curd_mod() {

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		EntityInit.ENTITIES.register(bus);
		TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGHEST, OreGeneration::Oregeneration);
	}

	private void setup(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInit.KEFIR_JAR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CURD_POT.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.OPUNTIEN_CACTUS.get(), RenderType.cutout());

		registerEntityModels(event.getMinecraftSupplier());

	}

	// Itemrenderer
	private void registerEntityModels(Supplier<Minecraft> minecraft) {
		ItemRenderer renderer = minecraft.get().getItemRenderer();

		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PIT.get(),
				(renderManager) -> new SpriteRenderer<>(renderManager, renderer));
	}

	// Creative Tabs
	public static class Curd_modFoodGorup extends ItemGroup {

		public Curd_modFoodGorup(String label) {
			super(label);

		}

		@Override
		public ItemStack makeIcon() {
			return ItemInit.CCP.get().getDefaultInstance();
		}

	}

	public static class Curd_modMaterialsGorup extends ItemGroup {

		public Curd_modMaterialsGorup(String label) {
			super(label);

		}

		@Override
		public ItemStack makeIcon() {
			return ItemInit.CURD.get().getDefaultInstance();
		}

	}
}
