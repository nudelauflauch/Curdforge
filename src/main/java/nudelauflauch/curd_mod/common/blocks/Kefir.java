package nudelauflauch.curd_mod.common.blocks;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.IItemProvider;
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
import nudelauflauch.curd_mod.common.te.CurdModBlockStateProperties;
import nudelauflauch.curd_mod.core.init.ItemInit;

public class Kefir extends Block {
	public static final IntegerProperty LEVEL = CurdModBlockStateProperties.LEVEL_0_15;

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(5, 0, 5, 11, 1, 11),
			Block.makeCuboidShape(4, 1, 5, 5, 4, 11), Block.makeCuboidShape(11, 1, 5, 12, 4, 11),
			Block.makeCuboidShape(5, 1, 4, 11, 4, 5), Block.makeCuboidShape(5, 1, 11, 11, 4, 12),
			Block.makeCuboidShape(4, 4, 5, 5, 9, 6), Block.makeCuboidShape(4, 4, 10, 5, 9, 11),
			Block.makeCuboidShape(5, 4, 11, 6, 9, 12), Block.makeCuboidShape(10, 4, 11, 11, 9, 12),
			Block.makeCuboidShape(11, 4, 10, 12, 9, 11), Block.makeCuboidShape(11, 4, 5, 12, 9, 6),
			Block.makeCuboidShape(10, 4, 4, 11, 9, 5), Block.makeCuboidShape(5, 4, 4, 6, 9, 5),
			Block.makeCuboidShape(4, 8, 6, 5, 9, 10), Block.makeCuboidShape(11, 8, 6, 12, 9, 10),
			Block.makeCuboidShape(6, 8, 11, 10, 9, 12), Block.makeCuboidShape(6, 8, 4, 10, 9, 5),
			Block.makeCuboidShape(10, 9, 5, 11, 10, 11), Block.makeCuboidShape(5, 9, 5, 6, 10, 11),
			Block.makeCuboidShape(6, 9, 5, 10, 10, 6), Block.makeCuboidShape(6, 9, 10, 10, 10, 11),
			Block.makeCuboidShape(6, 10, 6, 10, 12, 10), Block.makeCuboidShape(6, 8, 6, 10, 10, 10),
			Block.makeCuboidShape(6, 6, 4, 7, 7, 4), Block.makeCuboidShape(9, 7, 4, 10, 8, 4),
			Block.makeCuboidShape(8, 5, 4, 9, 6, 4), Block.makeCuboidShape(7, 6, 12, 8, 7, 12),
			Block.makeCuboidShape(9, 4, 12, 10, 5, 12), Block.makeCuboidShape(6, 7, 12, 7, 8, 12),
			Block.makeCuboidShape(12, 7, 6, 12, 8, 7), Block.makeCuboidShape(12, 4, 7, 12, 5, 8),
			Block.makeCuboidShape(12, 6, 9, 12, 7, 10), Block.makeCuboidShape(4, 6, 6, 4, 7, 7),
			Block.makeCuboidShape(4, 7, 9, 4, 8, 10), Block.makeCuboidShape(4, 4, 8, 4, 5, 9)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public Kefir() {
		super(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(1.5f)
				.sound(SoundType.METAL));

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

	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		int i = state.get(LEVEL);
		float f = (float) pos.getY() + (6.0F + (float) (3 * i)) / 16.0F;
		if (!worldIn.isRemote && entityIn.isBurning() && i > 0 && entityIn.getPosY() <= (double) f) {
			entityIn.extinguish();
			this.setKefirLevel(worldIn, pos, state, i - 1);
		}

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		int i = state.get(LEVEL);
		if (!worldIn.isRemote) {
			ItemStack itemstack = player.getHeldItem(handIn);
			Item item = itemstack.getItem();
			if (i == 0) {
				if (item == ItemInit.WHEY.get()) {
					itemstack.shrink(1);
					player.dropItem(new ItemStack((IItemProvider) Items.GLASS_BOTTLE), false);
					this.setKefirLevel(worldIn, pos, state, i += 1);
				} else {
					return null;
				}
			}
			if (i == 1) {
				if (item == ItemInit.KEFIR_CRYSTAL.get()) {
					itemstack.shrink(1);
					this.setKefirLevel(worldIn, pos, state, 3);
				}
			} else if (i == 2) {
				if (item == ItemInit.RAISINS.get()) {
					itemstack.shrink(1);
					this.setKefirLevel(worldIn, pos, state, i += 1);
				}
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
			} else if (item == Items.GLASS_BOTTLE) {
				itemstack.shrink(1);
				if (i == 5) {
					player.dropItem(new ItemStack((IItemProvider) ItemInit.KEFIR_PLUM.get()), false);
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 7) {
					player.dropItem(new ItemStack((IItemProvider) ItemInit.KEFIR_APRICOT.get()), false);
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 9) {
					player.dropItem(new ItemStack((IItemProvider) ItemInit.KEFIR_LEMON.get()), false);
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 11) {
					player.dropItem(new ItemStack((IItemProvider) ItemInit.KEFIR_CHERRY.get()), false);
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 13) {
					player.dropItem(new ItemStack((IItemProvider) ItemInit.KEFIR_APPLE.get()), false);
					this.setKefirLevel(worldIn, pos, state, 0);
				} else if (i == 15) {
					player.dropItem(new ItemStack((IItemProvider) ItemInit.KEFIR_SWEETBERRY.get()), false);
					this.setKefirLevel(worldIn, pos, state, 0);
				}
			}
		}
		return ActionResultType.FAIL;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
		builder.add(FACING);
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		int i = stateIn.get(LEVEL);
		if (i == 4) {
			double d0 = (double) pos.getX()+0.5D;
			double d1 = (double) pos.getY()+0.7D;
			double d2 = (double) pos.getZ()+0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (i == 6) {
			double d0 = (double) pos.getX()+0.5D;
			double d1 = (double) pos.getY()+0.7D;
			double d2 = (double) pos.getZ()+0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (i == 8) {
			double d0 = (double) pos.getX()+0.5D;
			double d1 = (double) pos.getY()+0.7D;
			double d2 = (double) pos.getZ()+0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (i == 10) {
			double d0 = (double) pos.getX()+0.5D;
			double d1 = (double) pos.getY()+0.7D;
			double d2 = (double) pos.getZ()+0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (i == 12) {
			double d0 = (double) pos.getX()+0.5D;
			double d1 = (double) pos.getY()+0.7D;
			double d2 = (double) pos.getZ()+0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (i == 14) {
			double d0 = (double) pos.getX()+0.5D;
			double d1 = (double) pos.getY()+0.7D;
			double d2 = (double) pos.getZ()+0.5D;
			worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

}