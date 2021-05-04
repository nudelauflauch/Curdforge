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

public class Jam_maker extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_S = Stream
			.of(Block.makeCuboidShape(3, 2.3000000000000003, 15, 4, 3.3000000000000003, 16),
					Block.makeCuboidShape(1, 0, 1.0000000000000036, 15, 4, 15),
					Block.makeCuboidShape(2, 1, 13.600000000000001, 7, 4.5, 15.600000000000001),
					Block.makeCuboidShape(5, 2.3000000000000003, 15, 6, 3.3000000000000003, 16),
					Block.makeCuboidShape(4, 4, 4, 12, 5, 12),
					Block.makeCuboidShape(5, 4, 3.099999999999998, 11, 5, 4.099999999999998),
					Block.makeCuboidShape(5, 4, 11.900000000000002, 11, 5, 12.900000000000002),
					Block.makeCuboidShape(3.099999999999998, 4, 5, 4.099999999999998, 5, 11),
					Block.makeCuboidShape(11.899999999999999, 4, 5, 12.899999999999999, 5, 11),
					Block.makeCuboidShape(2, 6, 2, 14, 13, 14), Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13),
					Block.makeCuboidShape(9, 14, 7.400000000000002, 10, 15, 8.400000000000002),
					Block.makeCuboidShape(6, 15, 7.400000000000002, 10, 16, 8.400000000000002),
					Block.makeCuboidShape(6, 14, 7.400000000000002, 7, 15, 8.400000000000002))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream
			.of(Block.makeCuboidShape(0, 2.3000000000000003, 3, 1, 3.3000000000000003, 4),
					Block.makeCuboidShape(1, 0, 1, 14.999999999999996, 4, 15),
					Block.makeCuboidShape(0.3999999999999986, 1, 2, 2.3999999999999986, 4.5, 7),
					Block.makeCuboidShape(0, 2.3000000000000003, 5, 1, 3.3000000000000003, 6),
					Block.makeCuboidShape(4, 4, 4, 12, 5, 12),
					Block.makeCuboidShape(11.900000000000002, 4, 5, 12.900000000000002, 5, 11),
					Block.makeCuboidShape(3.099999999999998, 4, 5, 4.099999999999998, 5, 11),
					Block.makeCuboidShape(5, 4, 3.099999999999998, 11, 5, 4.099999999999998),
					Block.makeCuboidShape(5, 4, 11.899999999999999, 11, 5, 12.899999999999999),
					Block.makeCuboidShape(2, 6, 2, 14, 13, 14), Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13),
					Block.makeCuboidShape(7.599999999999998, 14, 9, 8.599999999999998, 15, 10),
					Block.makeCuboidShape(7.599999999999998, 15, 6, 8.599999999999998, 16, 10),
					Block.makeCuboidShape(7.599999999999998, 14, 6, 8.599999999999998, 15, 7))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(0, 2.3000000000000003, 3.000000000000001, 1, 3.3000000000000003, 4.000000000000001),
			Block.makeCuboidShape(1, 0, 1, 14.999999999999996, 4, 15),
			Block.makeCuboidShape(0.3999999999999986, 1, 2.000000000000001, 2.3999999999999986, 4.5, 7.000000000000001),
			Block.makeCuboidShape(0, 2.3000000000000003, 5.000000000000001, 1, 3.3000000000000003, 6.000000000000001),
			Block.makeCuboidShape(4, 4, 4.000000000000001, 12, 5, 12),
			Block.makeCuboidShape(11.900000000000002, 4, 5.000000000000001, 12.900000000000002, 5, 11),
			Block.makeCuboidShape(3.099999999999998, 4, 5.000000000000001, 4.099999999999998, 5, 11),
			Block.makeCuboidShape(5, 4, 3.0999999999999988, 11, 5, 4.099999999999999),
			Block.makeCuboidShape(5, 4, 11.899999999999999, 11, 5, 12.899999999999999),
			Block.makeCuboidShape(2, 6, 2, 14, 13, 14), Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
			Block.makeCuboidShape(3, 5, 3, 13, 6, 13),
			Block.makeCuboidShape(7.599999999999998, 14, 9, 8.599999999999998, 15, 10),
			Block.makeCuboidShape(7.599999999999998, 15, 6.000000000000001, 8.599999999999998, 16, 10),
			Block.makeCuboidShape(7.599999999999998, 14, 6.000000000000001, 8.599999999999998, 15, 7.000000000000001))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(3, 2.3000000000000003, 15, 4, 3.3000000000000003, 16),
					Block.makeCuboidShape(1, 0, 1.0000000000000036, 15, 4, 15),
					Block.makeCuboidShape(2, 1, 13.600000000000001, 7, 4.5, 15.600000000000001),
					Block.makeCuboidShape(5, 2.3000000000000003, 15, 6, 3.3000000000000003, 16),
					Block.makeCuboidShape(4, 4, 4, 12, 5, 12),
					Block.makeCuboidShape(5, 4, 3.099999999999998, 11, 5, 4.099999999999998),
					Block.makeCuboidShape(5, 4, 11.900000000000002, 11, 5, 12.900000000000002),
					Block.makeCuboidShape(3.099999999999998, 4, 5, 4.099999999999998, 5, 11),
					Block.makeCuboidShape(11.899999999999999, 4, 5, 12.899999999999999, 5, 11),
					Block.makeCuboidShape(2, 6, 2, 14, 13, 14), Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13),
					Block.makeCuboidShape(9, 14, 7.400000000000002, 10, 15, 8.400000000000002),
					Block.makeCuboidShape(6, 15, 7.400000000000002, 10, 16, 8.400000000000002),
					Block.makeCuboidShape(6, 14, 7.400000000000002, 7, 15, 8.400000000000002))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public Jam_maker(Properties config) {
		super(config);

		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case EAST:
			return SHAPE_E;
		case SOUTH:
			return SHAPE_S;
		case WEST:
			return SHAPE_W;
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

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	/*
	 * @Override public TileEntity createTileEntity(BlockState state, IBlockReader
	 * world) { return new TileEntityTypesInit(); }
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Override public ActionResultType onBlockActivated(BlockState state, World
	 * worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult
	 * hit) { if (!worldIn.isRemote()) { TileEntity te = worldIn.getTileEntity(pos);
	 * if (te instanceof JamMakerTileEntity) { INamedContainerProvider
	 * containerProvider = new INamedContainerProvider() {
	 * 
	 * @Override public ITextComponent getDisplayName() { return new
	 * TranslationTextComponent("screen.curd_mod.JamMaker"); }
	 * 
	 * @Override public Container createMenue(int i, PlayerInventory playerInv,
	 * PlayerEntity plyerEntity) { return new JamMakerConatainer(i, world, pos,
	 * playerInv, playerEntity); } }; NetworkHooks.openGui((ServerPlayerEntity)
	 * player, (JamMakerTileEntity) te, pos); } else { throw new
	 * IllegalStateException("Jam Maker container provider is missing!"); } } return
	 * ActionResultType.SUCCESS; }
	 */

}