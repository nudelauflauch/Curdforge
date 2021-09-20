package nudelauflauch.curd_mod.common.te;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.MathHelper;
import nudelauflauch.curd_mod.common.blocks.Kefir_crystallizer;
import nudelauflauch.curd_mod.core.init.BlockInit;
import nudelauflauch.curd_mod.core.init.TileEntityTypesInit;

public class KefirKrystallizerTileEntity extends TileEntity implements ITickableTileEntity {
	public static final String TIMER = "timer";

	public int tick = 0;

	public KefirKrystallizerTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public KefirKrystallizerTileEntity() {
		this(TileEntityTypesInit.KEFIR_CRYSTALLIZER_TICK_ENTITY.get());
	}

	@Override
	public void load(BlockState state, CompoundNBT compound) {
		super.load(state, compound);
		this.tick = compound.getInt(TIMER);
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		compound.putInt(TIMER, this.tick);
		return compound;
	}

	@Override
	public void tick() {
		if (!level.isClientSide) {
			Integer value = this.getBlockState().getValue(Kefir_crystallizer.LEVEL);
			if (value == 2) {
				tick++;
			}
			if (value == 2 && tick == 200) {
				this.level.setBlockAndUpdate(this.worldPosition, BlockInit.KEFIR_CRYSTALLIZER.get().defaultBlockState()
						.setValue(Kefir_crystallizer.LEVEL, Integer.valueOf(MathHelper.clamp(3, 3, 3))));
				tick = 0;
			}
		}
	}
}
