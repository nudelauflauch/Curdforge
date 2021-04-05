package nudelauflauch.curd_mod.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
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
import nudelauflauch.curd_mod.core.init.ItemInit;

public class CurdPot extends Block {

	public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_0_3;
	public static final VoxelShape INSIDE = makeCuboidShape(1.0D, 1.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	protected static final VoxelShape SHAPE = VoxelShapes
			.combineAndSimplify(VoxelShapes.fullCube(),
					VoxelShapes.or(makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D),
							makeCuboidShape(16.0D, 16.0D, 16.0D, 16.0D, 16.0D, 16.0D), INSIDE),
					IBooleanFunction.ONLY_FIRST);

	public CurdPot(AbstractBlock.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(LEVEL, Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return INSIDE;
	}

	public void setMilkLevel(World worldIn, BlockPos pos, BlockState state, int level) {
		worldIn.setBlockState(pos, state.with(LEVEL, Integer.valueOf(MathHelper.clamp(level, 0, 3))), 2);
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

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		int i = state.get(LEVEL);
		Item item = itemstack.getItem();
		if (itemstack.isEmpty()) {
			return ActionResultType.PASS;
		} else {
			if (item == Items.MILK_BUCKET) {
				if (i < 2 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						ItemStack itemstack3 = new ItemStack(Items.BUCKET);
						player.addStat(Stats.USE_CAULDRON);
						player.setHeldItem(handIn, itemstack3);
						if (player instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) player).sendContainerToPlayer(player.container);
						}
					}

					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,
							1.0F, 1.0F);
					this.setMilkLevel(worldIn, pos, state, i + 1);
				}

				return ActionResultType.func_233537_a_(worldIn.isRemote);
			} else if (item == Items.GLASS_BOTTLE) {
				if (i == 3 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							player.setHeldItem(handIn, new ItemStack((IItemProvider) ItemInit.WHEY.get()));
						} else if (!player.inventory
								.addItemStackToInventory(new ItemStack((IItemProvider) ItemInit.WHEY.get()))) {
							player.dropItem(new ItemStack((IItemProvider) ItemInit.WHEY.get()), false);
						}
					}
					player.addStat(Stats.USE_CAULDRON);
					this.setMilkLevel(worldIn, pos, state, 0);
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS,
							1.0F, 1.0F);
				}

				return ActionResultType.func_233537_a_(worldIn.isRemote);
			} else if (item == ItemInit.SIEVE.get()) {
				this.setMilkLevel(worldIn, pos, state, i += 1);
				System.out.println("next blockstate");
				if (i == 2 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						if (itemstack.isEmpty()) {
							player.setHeldItem(handIn, new ItemStack(ItemInit.CURD.get()));
						} else if (!player.inventory.addItemStackToInventory(new ItemStack(ItemInit.CURD.get()))) {
							player.dropItem(new ItemStack(ItemInit.CURD.get()), false);
						}
					}
					player.addStat(Stats.USE_CAULDRON);
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BUCKET_FILL_FISH, SoundCategory.BLOCKS,
							1.0F, 1.0F);
				}
				return ActionResultType.func_233537_a_(worldIn.isRemote);
			} else {
				return ActionResultType.PASS;
			}
		}
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
	}
}
