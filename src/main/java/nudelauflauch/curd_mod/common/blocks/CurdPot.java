package nudelauflauch.curd_mod.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
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

public class CurdPot extends Block {
	public static final IntegerProperty LEVEL = CurdModBlockStateProperties.LEVEL_0_3;

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(14, 4, 2, 16, 16, 14),
			Block.makeCuboidShape(0, 0, 14, 2, 2, 16), Block.makeCuboidShape(14, 0, 14, 16, 2, 16),
			Block.makeCuboidShape(14, 0, 0, 16, 2, 2), Block.makeCuboidShape(0, 0, 0, 2, 2, 2),
			Block.makeCuboidShape(0, 2, 0, 16, 4, 16), Block.makeCuboidShape(0, 4, 0, 16, 16, 2),
			Block.makeCuboidShape(0, 4, 14, 16, 16, 16), Block.makeCuboidShape(0, 4, 2, 2, 16, 14)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public CurdPot(Properties properties) {
		super(properties);
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_N;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	public void setMilkLevel(World worldIn, BlockPos pos, BlockState state, int level) {
		worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(level, 0, 13))), 2);
		worldIn.updateComparatorOutputLevel(pos, this);
	}

	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		int i = state.get(LEVEL);
		float f = (float) pos.getY() + (6.0F + (float) (3 * i)) / 16.0F;
		if (!worldIn.isRemote && entityIn.isBurning() && i > 0 && entityIn.getPosY() <= (double) f) {
			entityIn.extinguish();
			this.setMilkLevel(worldIn, pos, state, i - 1);
		}

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		int i = state.get(LEVEL);
		ItemStack itemstack = player.getHeldItem(handIn);
		Item item = itemstack.getItem();
		if (!worldIn.isRemote) {
			if (i < 3 && item == Items.MILK_BUCKET) {
				itemstack.shrink(1);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, Items.BUCKET);
				this.setMilkLevel(worldIn, pos, state, i + 1);
			} else if (i == 2 && item == ItemInit.SIEVE.get()) {
				itemstack.shrink(1);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.CURD.get());
				this.setMilkLevel(worldIn, pos, state, i += 1);
			} else if (i == 3 && item == Items.GLASS_BOTTLE) {
				itemstack.shrink(1);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.WHEY.get());
				this.setMilkLevel(worldIn, pos, state, 0);
			}
		}
		return ActionResultType.SUCCESS;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
		builder.add(FACING);
	}
}