package nudelauflauch.curd_mod.common.entities.tileentitys;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import nudelauflauch.curd_mod.common.blocks.Kefir;
import nudelauflauch.curd_mod.core.init.TileEntityTypesInit;

public class TickEntity extends TileEntity implements ITickableTileEntity {
	public int tick;
	private final LazyOptional<ItemStackHandler> timer = LazyOptional.of(() -> new ItemStackHandler(200));

	public TickEntity(TileEntityType<?> entity) {
		super(entity);
	}

	public TickEntity() {
		this(TileEntityTypesInit.TICK_ENTITY.get());
	}

	@Override
	public void load(BlockState state, CompoundNBT compound) {
		super.load(state, compound);
		timer.ifPresent(handler -> handler.deserializeNBT(compound.getCompound("tick")));
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		timer.ifPresent(handler -> compound.put("tick", handler.serializeNBT()));
		return compound;
	}

	@Override
	public void tick() {
		tick++;
		System.out.println("funktioniert");
		if (!level.isClientSide && this.getBlockState().getValue(Kefir.LEVEL) == 1) {
			tick++;
			if (tick == 200) {
				tick = 0;
				System.out.println("funktioniert2");
				this.setLevelAndPosition(level, worldPosition);
			}
		}
	}

}
