package nudelauflauch.curd_mod.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class FruitItem extends Item {
	public FruitItem(Item.Properties builder) {
		super(builder);
	}

	/**
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not
	 * called when the player stops using the Item before the action is complete.
	 */
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		if (entityLiving instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
			serverplayerentity.addStat(Stats.ITEM_USED.get(this));
		}
		if (stack.isEmpty()) {
			return new ItemStack(ItemInit.PIT.get());
		} else {
			if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
				ItemStack itemstack = new ItemStack(ItemInit.PIT.get());
				PlayerEntity playerentity = (PlayerEntity) entityLiving;
				if (!playerentity.inventory.addItemStackToInventory(itemstack)) {
					playerentity.dropItem(itemstack, false);
				}
			}

			return stack;
		}
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getUseDuration(ItemStack stack) {
		return 40;
	}

	/**
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.EAT;
	}

	public SoundEvent getEatSound() {
		return SoundEvents.ENTITY_GENERIC_EAT;
	}

	public SoundEvent getDrinkSound() {
		return SoundEvents.ENTITY_GENERIC_EAT;
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when
	 * this item is used on a Block, see {@link #onItemUse}.
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (this.isFood()) {
			ItemStack itemstack = playerIn.getHeldItem(handIn);
			if (playerIn.canEat(this.getFood().canEatWhenFull())) {
				playerIn.setActiveHand(handIn);
				return ActionResult.resultConsume(itemstack);
			} else {
				return ActionResult.resultFail(itemstack);
			}
		} else {
			return ActionResult.resultPass(playerIn.getHeldItem(handIn));
		}
	}
}
