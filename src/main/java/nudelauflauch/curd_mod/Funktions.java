package nudelauflauch.curd_mod;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Funktions {

	public static void dropp(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit, IItemProvider item) {
		ItemStack itemstack = player.getItemInHand(handIn);
		if (!player.abilities.instabuild) {
			itemstack.shrink(1);
			if (itemstack.isEmpty()) {
				player.setItemInHand(handIn, new ItemStack(item));
			} else if (!player.inventory.add(new ItemStack(item))) {
				player.drop(new ItemStack(item), false);
			}
		}
		worldIn.setBlockAndUpdate(pos, state.setValue(level, Integer.valueOf(MathHelper.clamp(number, 0, 3))), 2);
	}
	
	
	
	
}
