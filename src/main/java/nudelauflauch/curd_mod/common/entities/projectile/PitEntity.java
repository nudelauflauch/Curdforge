package nudelauflauch.curd_mod.common.entities.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class PitEntity extends ProjectileItemEntity {

	public PitEntity(LivingEntity entity, World world) {
		super(EntityType.EGG, entity, world);
	}

	public PitEntity(double x, double y, double z, World world) {
		super(EntityType.EGG, x, y, z, world);
	}

	@Override
	protected Item getDefaultItem() {
		return ItemInit.PIT.get().asItem();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.getType() == RayTraceResult.Type.ENTITY) {

			if (!world.isRemote) {
				this.remove();
			}
		}
	}
}