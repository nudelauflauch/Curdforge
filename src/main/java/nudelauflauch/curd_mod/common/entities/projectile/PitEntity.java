package nudelauflauch.curd_mod.common.entities.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import nudelauflauch.curd_mod.core.init.EntityInit;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class PitEntity extends ProjectileItemEntity implements IRendersAsItem {

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public PitEntity(EntityType<PitEntity> type, World world) {
		super(type, world);
	}

	public PitEntity(LivingEntity entity, World world) {
		super(EntityInit.PIT.get(), entity, world);
	}

	public PitEntity(double x, double y, double z, World world) {
		super(EntityInit.PIT.get(), x, y, z, world);
	}

	@Override
	protected Item getDefaultItem() {
		return ItemInit.PIT.get().asItem();
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte p_70103_1_) {
		if (p_70103_1_ == 3) {

			for (int i = 0; i < 8; ++i) {
				this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getX(),
						this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5D) * 0.08D,
						((double) this.random.nextFloat() - 0.5D) * 0.08D,
						((double) this.random.nextFloat() - 0.5D) * 0.08D);
			}
		}

	}

	@Override
	protected void onHit(RayTraceResult result) {
		if (result.getType() == RayTraceResult.Type.ENTITY) {
			Entity entity = ((EntityRayTraceResult) result).getEntity();
			entity.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 1.25143F);
		}
		this.level.broadcastEntityEvent(this, (byte) 3);
		this.remove();
	}
}