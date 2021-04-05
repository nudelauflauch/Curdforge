package nudelauflauch.curd_mod.core.enums;

import com.google.common.base.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import nudelauflauch.curd_mod.Curd_mod;
import nudelauflauch.curd_mod.core.init.ItemInit;

public enum ModArmorMaterial implements IArmorMaterial {
	LOST_CCP(Curd_mod.MOD_ID + ":lost_ccp", 20, new int[] { 2, 5, 7, 2 }, 50, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			2.0F, () -> {
				return Ingredient.fromItems(ItemInit.LOST_CCP_ITEM.get());
			});

	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;

	private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn,
			SoundEvent equipSoundIn, float toughnessIn, Supplier<Ingredient> repairMaterialSupplier) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountsIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = equipSoundIn;
		this.toughness = toughnessIn;
		this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
	}

	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return 0;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
