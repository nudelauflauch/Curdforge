package nudelauflauch.curd_mod.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class Duff_raisin extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(12, 0, 5, 13, 1, 11), Block.box(4, 0, 4, 12, 1, 12), Block.box(5, 0, 3, 11, 1, 4),
					Block.box(3, 0, 5, 4, 1, 11), Block.box(5, 0, 12, 11, 1, 13), Block.box(5, 0.2, 5, 6, 1.2, 6),
					Block.box(11, 0.2, 6, 12, 1.2, 7), Block.box(6, 0.2, 8, 7, 1.2, 9),
					Block.box(9, 0.2, 7, 10, 1.2, 8), Block.box(4, 0.2, 9, 5, 1.2, 10),
					Block.box(10, 0.2, 9, 11, 1.2, 10), Block.box(8, 0.2, 10, 9, 1.2, 11),
					Block.box(7, 0.2, 4, 8, 1.2, 5), Block.box(5.999999999999999, 0.2, 11, 7, 1.2, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.joinUnoptimized(v1, v2, IBooleanFunction.OR);
			}).get();

	public Duff_raisin(Properties properties) {
		super(properties);

		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_N;
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

}
