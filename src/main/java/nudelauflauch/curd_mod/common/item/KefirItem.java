package nudelauflauch.curd_mod.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class KefirItem extends Item {
	public KefirItem(Item.Properties builder) {
		super(builder);
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		if (entityLiving instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
			serverplayerentity.addStat(Stats.ITEM_USED.get(this));
		}
		if (!worldIn.isRemote) {
			entityLiving.removePotionEffect(Effects.POISON);
		}
		if (stack.isEmpty()) {
			return new ItemStack(ItemInit.KEFIR_TUMBLER.get());
		} else {
			if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
				ItemStack itemstack = new ItemStack(ItemInit.KEFIR_TUMBLER.get());
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
		return 37;
	}

	/**
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	public SoundEvent getDrinkSound() {
		return SoundEvents.ENTITY_GENERIC_DRINK;
	}

	public SoundEvent getEatSound() {
		return SoundEvents.ENTITY_GENERIC_DRINK;
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when
	 * this item is used on a Block, see {@link #onItemUse}.
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		return DrinkHelper.startDrinking(worldIn, playerIn, handIn);
	}
}
