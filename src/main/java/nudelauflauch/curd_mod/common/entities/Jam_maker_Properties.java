package nudelauflauch.curd_mod.common.entities;

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;

public class Jam_maker_Properties extends BlockStateProperties{
	public final static BooleanProperty HAS_SUGAR = BooleanProperty.create("has_sugar");
	public final static BooleanProperty HAS_FRUIT = BooleanProperty.create("has_fruit");
	public final static BooleanProperty HAS_FUEL = BooleanProperty.create("has_fuel");
}
