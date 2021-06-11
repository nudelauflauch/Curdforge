package nudelauflauch.curd_mod.common.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import nudelauflauch.curd_mod.common.entities.projectile.PitEntity;

public class PitItem extends Item {
	public PitItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemStack = playerIn.getItemInHand(handIn);
		worldIn.playSound((PlayerEntity) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.EGG_THROW,
				SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		if (!worldIn.isClientSide) {
			PitEntity pit = new PitEntity(playerIn, worldIn);
			pit.setItem(itemStack);
			pit.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 1.5F, 1.0F);
			worldIn.addFreshEntity(pit);
		}

		if (!playerIn.abilities.instabuild)
			itemStack.shrink(1);

		return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemStack);

	}

}
