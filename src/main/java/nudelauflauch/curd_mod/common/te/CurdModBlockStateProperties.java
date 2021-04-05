package nudelauflauch.curd_mod.common.te;

import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;

public class CurdModBlockStateProperties extends BlockStateProperties{
	public static final IntegerProperty LEVEL_0_15 = IntegerProperty.create("level", 0, 15);
}
