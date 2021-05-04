package nudelauflauch.curd_mod;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class Funktions {

	public static void dropp(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit, IItemProvider item) {
		ItemStack itemstack = player.getHeldItem(handIn);
		if (!player.abilities.isCreativeMode) {
			itemstack.shrink(1);
			if (itemstack.isEmpty()) {
				player.setHeldItem(handIn, new ItemStack(item));
			} else if (!player.inventory.addItemStackToInventory(new ItemStack(item))) {
				player.dropItem(new ItemStack(item), false);
			}
		}
	}

}
