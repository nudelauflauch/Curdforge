package nudelauflauch.curd_mod.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class Duff extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(12, 0, 5, 13, 1, 11),
			Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(5, 0, 3, 11, 1, 4),
			Block.makeCuboidShape(5, 0, 12, 11, 1, 13), Block.makeCuboidShape(3, 0, 5, 4, 1, 11)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public Duff() {
		super(AbstractBlock.Properties.create(Material.CAKE).hardnessAndResistance(1f, 1f).sound(SoundType.FUNGUS)
				.notSolid());
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
