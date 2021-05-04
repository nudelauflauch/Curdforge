package nudelauflauch.curd_mod.common.entities;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class Curd_mod_Stats extends Stats {
	public static final ResourceLocation INTERACT_WITH_JAMMAKER = registerCustom("interact_with_jammaker",
			IStatFormatter.DEFAULT);
	
	private static ResourceLocation registerCustom(String key, IStatFormatter formatter) {
	      ResourceLocation resourcelocation = new ResourceLocation(key);
	      Registry.register(Registry.CUSTOM_STAT, key, resourcelocation);
	      CUSTOM.get(resourcelocation, formatter);
	      return resourcelocation;
	   }

}
