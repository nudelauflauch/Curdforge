package nudelauflauch.curd_mod.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class PitItem extends Item{
	public PitItem(Properties properties) {
		super(properties);
	}
	
	public void setHeadingFromThrower(ItemEntity entityItem, Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy) {
        float f = -MathHelper.sin(rotationYawIn * ((float)Math.PI / 180F)) * MathHelper.cos(rotationPitchIn * ((float)Math.PI / 180F));
        float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * ((float)Math.PI / 180F));
        float f2 = MathHelper.cos(rotationYawIn * ((float)Math.PI / 180F)) * MathHelper.cos(rotationPitchIn * ((float)Math.PI / 180F));
        this.setThrowableHeading(entityItem, f, f1, f2, velocity, inaccuracy);
        Vector3d vec3d = entityThrower.getMotion();
        entityItem.setMotion(entityItem.getMotion().add(vec3d.x, entityThrower.isOnGround() ? 0.0D : vec3d.y, vec3d.z));
    }
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStackIn = playerIn.getHeldItem(handIn);

        worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            ItemStack stack = itemStackIn.copy();
            stack.setCount(1);
            ItemEntity entityitem = new ItemEntity(playerIn.world, playerIn.getPosX(), (playerIn.getPosY() - 0.30000001192092896D) + playerIn.getEyeHeight(), playerIn.getPosZ(), stack);
            entityitem.setPickupDelay(20);
            this.setHeadingFromThrower(entityitem, playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.2F, 1.0F);
            worldIn.addEntity(entityitem);
        }

        if (!playerIn.abilities.isCreativeMode)
            itemStackIn.shrink(1);

        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemStackIn);

    }
	
	public void setThrowableHeading(ItemEntity entityItem, double x, double y, double z, float velocity, float inaccuracy) {
        Vector3d vec3d = (new Vector3d(x, y, z)).normalize().add(random.nextGaussian() * 0.0075F * inaccuracy, random.nextGaussian() * 0.0075F * inaccuracy, random.nextGaussian() * 0.0075F * inaccuracy).scale(velocity);
        entityItem.setMotion(vec3d);
        float f = MathHelper.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
        entityItem.rotationYaw = (float)(MathHelper.atan2(vec3d.x, vec3d.z) * (180F / (float)Math.PI));
        entityItem.rotationPitch = (float)(MathHelper.atan2(vec3d.y, f) * (180F / (float)Math.PI));
        entityItem.prevRotationYaw =  entityItem.rotationYaw;
        entityItem.prevRotationPitch = entityItem.rotationPitch;
    }

}
