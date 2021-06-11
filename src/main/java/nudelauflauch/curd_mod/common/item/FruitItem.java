package nudelauflauch.curd_mod.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class FruitItem extends Item {
	public FruitItem(Item.Properties builder) {
		super(builder);
	}

	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		super.finishUsingItem(stack, worldIn, entityLiving);
		if (entityLiving instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
		}
		if (stack.isEmpty()) {
			return new ItemStack(ItemInit.PIT.get());
		} else {
			if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.instabuild) {
				ItemStack itemstack = new ItemStack(ItemInit.PIT.get());
				PlayerEntity playerentity = (PlayerEntity) entityLiving;
				if (!playerentity.inventory.add(itemstack)) {
					playerentity.drop(itemstack, false);
				}
			}

			return stack;
		}
	}

	public int getUseDuration(ItemStack stack) {
		return 40;
	}

	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.EAT;
	}

	public SoundEvent getEatingSound() {
		return SoundEvents.GENERIC_EAT;
	}

	public SoundEvent getDrinkingSound() {
		return SoundEvents.GENERIC_EAT;
	}

	public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
		return DrinkHelper.useDrink(p_77659_1_, p_77659_2_, p_77659_3_);
	}
}
