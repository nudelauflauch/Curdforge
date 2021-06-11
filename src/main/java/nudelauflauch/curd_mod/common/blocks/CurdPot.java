package nudelauflauch.curd_mod.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import nudelauflauch.curd_mod.common.te.CurdModBlockStateProperties;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class CurdPot extends Block {
	public static final IntegerProperty LEVEL = CurdModBlockStateProperties.LEVEL_0_3;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(14, 4, 2, 16, 16, 14), Block.box(0, 0, 14, 2, 2, 16), Block.box(14, 0, 14, 16, 2, 16),
					Block.box(14, 0, 0, 16, 2, 2), Block.box(0, 0, 0, 2, 2, 2), Block.box(0, 2, 0, 16, 4, 16),
					Block.box(0, 4, 0, 16, 16, 2), Block.box(0, 4, 14, 16, 16, 16), Block.box(0, 4, 2, 2, 16, 14))
			.reduce((v1, v2) -> {
				return VoxelShapes.joinUnoptimized(v1, v2, IBooleanFunction.OR);
			}).get();

	public CurdPot(Properties properties) {
		super(properties);
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
		if (!worldIn.isClientSide) {
			if (i < 3 && item == Items.MILK_BUCKET) {
				worldIn.playSound(player, pos, SoundEvents.BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, Items.BUCKET, true, LEVEL, i += 1);
			} else if (i == 2 && item == ItemInit.SIEVE.get()) {
				worldIn.playSound(player, pos, SoundEvents.BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.SIEVE.get(), true, LEVEL, 3);
			} else if (i == 3 && item == Items.GLASS_BOTTLE) {
				worldIn.playSound(player, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				Funktions.dropp(state, worldIn, pos, player, handIn, hit, ItemInit.WHEY.get(), true, LEVEL, 0);
			}
		}
		return ActionResultType.SUCCESS;
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
	}
}