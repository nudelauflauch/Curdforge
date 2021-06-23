package nudelauflauch.curd_mod.common.blocks;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import nudelauflauch.curd_mod.common.entities.tileentitys.TickEntity;
import nudelauflauch.curd_mod.common.te.CurdModBlockStateProperties;
import nudelauflauch.curd_mod.core.init.ItemInit;
import nudelauflauch.curd_mod.core.init.TileEntityTypesInit;

public class Kefir extends Block {
	public static final IntegerProperty LEVEL = CurdModBlockStateProperties.LEVEL_0_15;

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(6, 10, 6, 10, 12, 10), Block.box(5, 0, 5, 11, 10, 11), Block.box(4, 1, 5, 5, 9, 11),
					Block.box(11, 1, 5, 12, 9, 11), Block.box(5, 1, 4, 11, 9, 5), Block.box(5, 1, 11, 11, 9, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.joinUnoptimized(v1, v2, IBooleanFunction.OR);
			}).get();

	public Kefir(Properties config) {
		super(config);
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_N;
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		int i = state.getValue(LEVEL);
		ItemStack itemstack = player.getItemInHand(handIn);
		Item item = itemstack.getItem();
		if (itemstack.isEmpty()) {
			return ActionResultType.PASS;
		} else if (!worldIn.isClientSide) {
			if (i == 0 && item == ItemInit.WHEY.get()) {
				worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, Items.GLASS_BOTTLE, true, LEVEL, i += 1);
			} else if (i == 1 && item == ItemInit.KEFIR_CRYSTAL.get()) {
				worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BOAT_PADDLE_WATER, SoundCategory.BLOCKS, 1.0F,
						1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 3);
			} else if (i == 2 && item == ItemInit.RAISINS.get()) {
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 3);
			} else if (i == 3) {
				worldIn.playSound((PlayerEntity) null, pos, SoundEvents.VINE_STEP, SoundCategory.BLOCKS, 1.0F, 1.0F);
				if (item == ItemInit.PLUM.get()) {
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 4);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockAndUpdate(pos,
									state.setValue(LEVEL, Integer.valueOf(MathHelper.clamp(5, 0, 13))));
						}
					}, 10000);
				} else if (item == ItemInit.APRICOT.get()) {
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 6);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockAndUpdate(pos,
									state.setValue(LEVEL, Integer.valueOf(MathHelper.clamp(7, 0, 13))));
						}
					}, 10000);
				} else if (item == ItemInit.LEMON.get()) {
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 8);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockAndUpdate(pos,
									state.setValue(LEVEL, Integer.valueOf(MathHelper.clamp(9, 0, 13))));
						}
					}, 10000);
				} else if (item == ItemInit.CHERRY.get()) {
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 10);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockAndUpdate(pos,
									state.setValue(LEVEL, Integer.valueOf(MathHelper.clamp(11, 0, 13))));
						}
					}, 10000);
				} else if (item == Items.APPLE) {
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 12);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockAndUpdate(pos,
									state.setValue(LEVEL, Integer.valueOf(MathHelper.clamp(13, 0, 13))));
						}
					}, 10000);
				} else if (item == Items.SWEET_BERRIES) {
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 14);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockAndUpdate(pos,
									state.setValue(LEVEL, Integer.valueOf(MathHelper.clamp(15, 0, 15))));
						}
					}, 10000);
				} else if (item == Items.APPLE) {
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, item, false, LEVEL, 12);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockAndUpdate(pos,
									state.setValue(LEVEL, Integer.valueOf(MathHelper.clamp(13, 0, 13))));
						}
					}, 10000);
				}
			} else if (item == ItemInit.KEFIR_TUMBLER.get()) {
				if (i == 5) {
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F,
							1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_PLUM.get(), true, LEVEL,
							0);
				} else if (i == 7) {
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F,
							1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_APRICOT.get(), true, LEVEL,
							0);
				} else if (i == 9) {
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F,
							1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_LEMON.get(), true, LEVEL,
							0);
				} else if (i == 11) {
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F,
							1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_CHERRY.get(), true, LEVEL,
							0);
				} else if (i == 13) {
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F,
							1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_APPLE.get(), true, LEVEL,
							0);
				} else if (i == 15) {
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F,
							1.0F);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_SWEETBERRY.get(), true,
							LEVEL, 0);
				}
			}
		}
		return ActionResultType.SUCCESS;
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
		builder.add(FACING);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityTypesInit.TICK_ENTITY.get().create();
	}
	
	public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
	      return new TickEntity();
	   }
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		int i = stateIn.getValue(LEVEL);
		if (i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14) {
			double d0 = (double) pos.getX() + 0.5D;
			double d1 = (double) pos.getY() + 0.7D;
			double d2 = (double) pos.getZ() + 0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

}