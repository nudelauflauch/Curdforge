package nudelauflauch.curd_mod.common.blocks;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
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
import nudelauflauch.curd_mod.Funktions;
import nudelauflauch.curd_mod.common.te.CurdModBlockStateProperties;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class Kefir extends Block {
	public static final IntegerProperty LEVEL = CurdModBlockStateProperties.LEVEL_0_15;

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(6, 10, 6, 10, 12, 10), Block.makeCuboidShape(5, 0, 5, 11, 10, 11),
					Block.makeCuboidShape(4, 1, 5, 5, 9, 11), Block.makeCuboidShape(11, 1, 5, 12, 9, 11),
					Block.makeCuboidShape(5, 1, 4, 11, 9, 5), Block.makeCuboidShape(5, 1, 11, 11, 9, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public Kefir(Properties config) {
		super(config);

		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_N;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	public void setKefirLevel(World worldIn, BlockPos pos, BlockState state, int level) {
		worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(level, 0, 13))), 2);
		worldIn.updateComparatorOutputLevel(pos, this);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		int i = state.get(LEVEL);
		ItemStack itemstack = player.getHeldItem(handIn);
		Item item = itemstack.getItem();
		if (!worldIn.isRemote) {
			if (i == 0 && item == ItemInit.WHEY.get()) {
				itemstack.shrink(1);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, Items.GLASS_BOTTLE);
				this.setKefirLevel(worldIn, pos, state, i += 1);
			} else if (i == 1 && item == ItemInit.KEFIR_CRYSTAL.get()) {
				itemstack.shrink(1);
				this.setKefirLevel(worldIn, pos, state, 3);
			} else if (i == 2 && item == ItemInit.RAISINS.get()) {
				itemstack.shrink(1);
				this.setKefirLevel(worldIn, pos, state, i += 1);
			} else if (i == 3) {
				if (item == ItemInit.PLUM.get()) {
					itemstack.shrink(1);
					this.setKefirLevel(worldIn, pos, state, 4);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(5, 0, 13))));
						}
					}, 10000);
				} else if (item == ItemInit.APRICOT.get()) {
					itemstack.shrink(1);
					this.setKefirLevel(worldIn, pos, state, 6);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(7, 0, 13))));
						}
					}, 10000);
				} else if (item == ItemInit.LEMON.get()) {
					itemstack.shrink(1);
					this.setKefirLevel(worldIn, pos, state, 8);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(9, 0, 13))));
						}
					}, 10000);
				} else if (item == ItemInit.CHERRY.get()) {
					itemstack.shrink(1);
					this.setKefirLevel(worldIn, pos, state, 10);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(11, 0, 13))));
						}
					}, 10000);
				} else if (item == Items.SWEET_BERRIES) {
					itemstack.shrink(1);
					worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(14, 0, 15))));
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(15, 0, 15))));
						}
					}, 10000);
				} else if (item == Items.APPLE) {
					itemstack.shrink(1);
					this.setKefirLevel(worldIn, pos, state, 12);
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(13, 0, 13))));
						}
					}, 10000);
				}
			} else if (item == ItemInit.KEFIR_TUMBLER.get()) {
				if (i == 5) {
					itemstack.shrink(1);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_PLUM.get());
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 7) {
					itemstack.shrink(1);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_APRICOT.get());
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 9) {
					itemstack.shrink(1);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_LEMON.get());
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 11) {
					itemstack.shrink(1);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_CHERRY.get());
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 13) {
					itemstack.shrink(1);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_APPLE.get());
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 15) {
					itemstack.shrink(1);
					Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_SWEETBERRY.get());
					this.setKefirLevel(worldIn, pos, state, 0);
				}
			}
		}
		return ActionResultType.SUCCESS;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
		builder.add(FACING);
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		int i = stateIn.get(LEVEL);
		if (i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14) {
			double d0 = (double) pos.getX() + 0.5D;
			double d1 = (double) pos.getY() + 0.7D;
			double d2 = (double) pos.getZ() + 0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

}