package nudelauflauch.curd_mod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class CuddlyCactus extends SweetBerryBushBlock {
	private static final VoxelShape BUSHLING_SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	private static final VoxelShape GROWING_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public CuddlyCactus(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ItemInit.KEFIR_CRYSTAL.get());
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if (state.get(AGE) == 0) {
			return BUSHLING_SHAPE;
		} else {
			return state.get(AGE) < 3 ? GROWING_SHAPE : super.getShape(state, worldIn, pos, context);
		}
	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		int i = state.get(AGE);
		boolean flag = i == 3;
		System.out.println(i);
		if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
			return ActionResultType.PASS;
		} else if (i == 3) {
			int j = 1 + worldIn.rand.nextInt(2);
			spawnAsEntity(worldIn, pos, new ItemStack(ItemInit.KEFIR_CRYSTAL.get(), j + (flag ? 1 : 0)));
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(1)), 2);
			return ActionResultType.func_233537_a_(worldIn.isRemote);
		} else {
			return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
		}
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityCollision(state, worldIn, pos, entityIn);
	}

}
