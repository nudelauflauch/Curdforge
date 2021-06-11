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
import nudelauflauch.curd_mod.Funktions;
import nudelauflauch.curd_mod.common.te.CurdModBlockStateProperties;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class Kefir_crystallizer extends Block {

	public static final IntegerProperty LEVEL = CurdModBlockStateProperties.LEVEL_0_2;

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_0 = Stream.of(Block.makeCuboidShape(15, 0, 0, 16, 16, 16),
			Block.makeCuboidShape(0, 0, 0, 1, 16, 16), Block.makeCuboidShape(1, 0, 0, 15, 16, 1),
			Block.makeCuboidShape(1, 0, 15, 15, 16, 16), Block.makeCuboidShape(1, 15, 0, 15, 16, 1),
			Block.makeCuboidShape(0, 15, 1, 1, 16, 15), Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
			Block.makeCuboidShape(15, 15, 1, 16, 16, 15), Block.makeCuboidShape(15, 7, 15, 16, 16, 16),
			Block.makeCuboidShape(15, 7, 0, 16, 16, 1), Block.makeCuboidShape(0, 7, 15, 1, 16, 16),
			Block.makeCuboidShape(0, 7, 0, 1, 16, 1), Block.makeCuboidShape(0, 0, 0, 16, 7, 16)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_1 = Stream.of(Block.makeCuboidShape(15, 0, 0, 16, 16, 16),
			Block.makeCuboidShape(0, 0, 0, 1, 16, 16), Block.makeCuboidShape(1, 0, 0, 15, 16, 1),
			Block.makeCuboidShape(1, 0, 15, 15, 16, 16), Block.makeCuboidShape(1, 15, 0, 15, 16, 1),
			Block.makeCuboidShape(0, 15, 1, 1, 16, 15), Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
			Block.makeCuboidShape(15, 15, 1, 16, 16, 15), Block.makeCuboidShape(15, 7, 15, 16, 16, 16),
			Block.makeCuboidShape(15, 7, 0, 16, 16, 1), Block.makeCuboidShape(0, 7, 15, 1, 16, 16),
			Block.makeCuboidShape(0, 7, 0, 1, 16, 1), Block.makeCuboidShape(0, 0, 0, 16, 7, 16)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_2 = Stream.of(
			Block.makeCuboidShape(0.4999999999999999, 3, 0.5, 15.500000000000002, 10.600000000000001,
					15.500000000000002),
			Block.makeCuboidShape(7, 10.600000000000001, 7, 9, 11.600000000000001, 9),
			Block.makeCuboidShape(6, 10, 6, 10, 11, 10), Block.makeCuboidShape(0, 0, 0, 1, 16, 16),
			Block.makeCuboidShape(1, 0, 0, 15, 16, 1), Block.makeCuboidShape(15, 0, 0, 16, 16, 16),
			Block.makeCuboidShape(1, 0, 15, 15, 16, 16), Block.makeCuboidShape(0, 0, 0, 16, 7, 16)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public Kefir_crystallizer(Properties config) {
		super(config);

		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(LEVEL)) {
		case 1:
			return SHAPE_1;
		case 2:
			return SHAPE_2;
		default:
			return SHAPE_0;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	public void setSugarLevel(World worldIn, BlockPos pos, BlockState state, int level) {
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
			if (i == 0 && item == ItemInit.TIBICOS.get()) {
				itemstack.shrink(1);
				this.setSugarLevel(worldIn, pos, state, 1);
			} else if (i == 1 && item == Items.SUGAR) {
				itemstack.shrink(1);
				this.setSugarLevel(worldIn, pos, state, 2);
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						if (i == 1) {
							worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(0, 0, 13))),
									2);
							Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.KEFIR_CRYSTAL.get());
						}
					}
				}, 10000);
			}
		}
		return ActionResultType.SUCCESS;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
		builder.add(FACING);
	}

	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		int i = stateIn.get(LEVEL);
		if (i == 2) {
			double d0 = (double) pos.getX() + 0.5D;
			double d1 = (double) pos.getY() + 1.2D;
			double d2 = (double) pos.getZ() + 0.5D;
			worldIn.addParticle(ParticleTypes.CLOUD, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

}