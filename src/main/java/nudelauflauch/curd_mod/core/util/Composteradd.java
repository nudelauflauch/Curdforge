package nudelauflauch.curd_mod.core.util;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.util.IItemProvider;
import nudelauflauch.curd_mod.core.init.ItemInit;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;

public class Composteradd {

	public static final Object2FloatMap<IItemProvider> CHANCES = new Object2FloatOpenHashMap<>();

	public static void registerCompostables() {
		DataUtil.registerCompostable(0.3F, ItemInit.OPUNTIEN_BLOSSOM.get());
	}

}
