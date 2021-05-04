package nudelauflauch.curd_mod.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class Duff_raisin extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(12, 0, 5, 13, 1, 11),
			Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(5, 0, 3, 11, 1, 4),
			Block.makeCuboidShape(3, 0, 5, 4, 1, 11), Block.makeCuboidShape(5, 0, 12, 11, 1, 13),
			Block.makeCuboidShape(5, 0.2, 5, 6, 1.2, 6), Block.makeCuboidShape(11, 0.2, 6, 12, 1.2, 7),
			Block.makeCuboidShape(6, 0.2, 8, 7, 1.2, 9), Block.makeCuboidShape(9, 0.2, 7, 10, 1.2, 8),
			Block.makeCuboidShape(4, 0.2, 9, 5, 1.2, 10), Block.makeCuboidShape(10, 0.2, 9, 11, 1.2, 10),
			Block.makeCuboidShape(8, 0.2, 10, 9, 1.2, 11), Block.makeCuboidShape(7, 0.2, 4, 8, 1.2, 5),
			Block.makeCuboidShape(5.999999999999999, 0.2, 11, 7, 1.2, 12)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public Duff_raisin(Properties baum) {
		super(baum);

		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		default:
			return SHAPE_N;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
		return state.with(FACING, direction.rotate(state.get(FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(FACING);
	}

}
