package nudelauflauch.curd_mod.common.te;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.MathHelper;
import nudelauflauch.curd_mod.common.blocks.Kefir;
import nudelauflauch.curd_mod.common.blocks.Kefir_crystallizer;
import nudelauflauch.curd_mod.core.init.BlockInit;
import nudelauflauch.curd_mod.core.init.TileEntityTypesInit;

public class KefirJarTickEntity extends TileEntity implements ITickableTileEntity {
	public static final String TIMER = "timer";

	public int tick = 0;

	public KefirJarTickEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public KefirJarTickEntity() {
		this(TileEntityTypesInit.KEFIR_JAR_TICK_ENTITY.get());
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
			Integer value = this.getBlockState().getValue(Kefir.LEVEL);
			if (value == 4 || value == 6 || value == 8 || value == 10 || value == 12 || value == 14) {
				tick++;
			}
			if (value == 4 && tick == 200) {
				this.level.setBlockAndUpdate(this.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(MathHelper.clamp(6, 0, 5))));
				tick = 0;
			} else if (value == 6 && tick == 200) {
				this.level.setBlockAndUpdate(this.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(MathHelper.clamp(8, 0, 7))));
				tick = 0;
			} else if (value == 8 && tick == 200) {
				this.level.setBlockAndUpdate(this.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(MathHelper.clamp(8, 0, 9))));
				tick = 0;
			} else if (value == 10 && tick == 200) {
				this.level.setBlockAndUpdate(this.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(MathHelper.clamp(8, 0, 11))));
				tick = 0;
			} else if (value == 12 && tick == 200) {
				this.level.setBlockAndUpdate(this.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(MathHelper.clamp(8, 0, 13))));
				tick = 0;
			} else if (value == 14 && tick == 200) {
				this.level.setBlockAndUpdate(this.worldPosition, BlockInit.KEFIR_JAR.get().defaultBlockState()
						.setValue(Kefir.LEVEL, Integer.valueOf(MathHelper.clamp(8, 0, 15))));
				tick = 0;
			} else if (value == 2 && tick == 200) {
				this.level.setBlockAndUpdate(this.worldPosition, BlockInit.KEFIR_CRYSTALLIZER.get().defaultBlockState()
						.setValue(Kefir_crystallizer.LEVEL, Integer.valueOf(MathHelper.clamp(8, 0, 3))));
				tick = 0;
			}
		}
	}
}
