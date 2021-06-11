package nudelauflauch.curd_mod.core.util;

import net.minecraft.block.ComposterBlock;
import net.minecraft.util.IItemProvider;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class Composter {
	public static void registerCompat() {
		registerCompostables();
	}

	private static void registerCompostables() {
		registerCompostable(0.3F, ItemInit.OPUNTIEN_BLOSSOM.get());
	}

	private static void registerCompostable(float chance, IItemProvider itemIn) {
		ComposterBlock.COMPOSTABLES.put(itemIn.asItem(), chance);
	}
}
