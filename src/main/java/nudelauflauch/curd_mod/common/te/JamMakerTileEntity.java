package nudelauflauch.curd_mod.common.te;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.electronwill.nightconfig.core.Config;

import java.util.concurrent.atomic.AtomicInteger;
import nudelauflauch.curd_mod.Curd_mod;
import nudelauflauch.curd_mod.core.init.ItemInit;
import nudelauflauch.curd_mod.core.init.TileEntityTypesInit;
/*
public class JamMakerTileEntity extends TileEntity implements ITickableTileEntity {

	private ItemStackHandler itemHandler = createHandler();

	private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

	private int counter;

	public JamMakerTileEntity() {
		super(FIRSTBLOCK_TILE.get());
	}

	@Override
	public void remove() {
		super.remove();
		handler.invalidate();
	}

	@Override
	public void tick() {
		if (world.isRemote) {
			return;
		}

		if (counter > 0) {
			counter--;
			markDirty();
		}

		if (counter <= 0) {
			ItemStack stack = itemHandler.getStackInSlot(0);
			if (stack.getItem() == ItemInit.PLUM.get()) {
				itemHandler.extractItem(0, 1, false);
				counter = Config.FIRSTBLOCK_TICKS.get();
				markDirty();
			}
		}

		BlockState blockState = world.getBlockState(pos);
		if (blockState.get(BlockStateProperties.POWERED) != counter > 0) {
			world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, counter > 0),
					Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
		}
	}

	public void read(CompoundNBT tag, BlockState state) {
        itemHandler.deserializeNBT(tag.getCompound("inv"));
        counter = tag.getInt("counter");
        super.read(state, tag);
    }

	@Override
	public CompoundNBT write(CompoundNBT tag) {
		tag.put("inv", itemHandler.serializeNBT());
		tag.putInt("counter", counter);
		return super.write(tag);
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(1) {

			@Override
			protected void onContentsChanged(int slot) {
				// To make sure the TE persists when the chunk is saved later we need to
				// mark it dirty every time the item handler changes
				markDirty();
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return stack.getItem() == ItemInit.PLUM.get();
			}

			@Nonnull
			@Override
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				if (stack.getItem() != ItemInit.PLUM.get()) {
					return stack;
				}
				return super.insertItem(slot, stack, simulate);
			}
		};
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		return super.getCapability(cap, side);
	}
}*/
