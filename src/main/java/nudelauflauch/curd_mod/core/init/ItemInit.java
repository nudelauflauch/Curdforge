package nudelauflauch.curd_mod.core.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.EnchantedGoldenAppleItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nudelauflauch.curd_mod.Curd_mod;
import nudelauflauch.curd_mod.common.item.FruitItem;
import nudelauflauch.curd_mod.common.item.KefirItem;
import nudelauflauch.curd_mod.common.item.PitItem;
import nudelauflauch.curd_mod.common.item.WheyItem;
import nudelauflauch.curd_mod.core.enums.ModArmorMaterial;
import nudelauflauch.curd_mod.core.enums.ModItemTier;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Curd_mod.MOD_ID);

	// tools
	public static final RegistryObject<Item> LOST_CCP_ITEM = ITEMS.register("lost_ccp_item",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(1).saturation(0.8f).build())));

	public static final RegistryObject<Item> LOST_CCP_SWORD = ITEMS.register("lost_ccp_sword",
			() -> new SwordItem(ModItemTier.LOST_CCP, 3, -2.4f,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
							.food(new Food.Builder().hunger(4).saturation(0.8f).build())));

	/*
	 * public static final RegistryObject<Item> LOST_CCP_MATTOCK =
	 * ITEMS.register("lost_ccp_mattock", () -> new AxeItem(ModItemTier.LOST_CCP, 1,
	 * -2.F, new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
	 * .food(new Food.Builder().hunger(5).saturation(0.8f).build())));
	 */

	public static final RegistryObject<Item> LOST_CCP_MACE = ITEMS.register("lost_ccp_mace",
			() -> new SwordItem(ModItemTier.LOST_CCP, 6, -2.7F,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
							.food(new Food.Builder().hunger(6).saturation(0.8f).build())));

	public static final RegistryObject<Item> LOST_CCP_AXE = ITEMS.register("lost_ccp_axe",
			() -> new AxeItem(ModItemTier.LOST_CCP, 5, -1.0F,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
							.food(new Food.Builder().hunger(5).saturation(0.8f).build())));

	public static final RegistryObject<Item> LOST_CCP_HOE = ITEMS.register("lost_ccp_hoe",
			() -> new HoeItem(ModItemTier.LOST_CCP, 1, -1.0F,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
							.food(new Food.Builder().hunger(4).saturation(0.8f).build())));

	public static final RegistryObject<Item> LOST_CCP_PICKAXE = ITEMS.register("lost_ccp_pickaxe",
			() -> new PickaxeItem(ModItemTier.LOST_CCP, 1, -1.0F,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
							.food(new Food.Builder().hunger(5).saturation(0.8f).build())));

	public static final RegistryObject<Item> LOST_CCP_SHOVEL = ITEMS.register("lost_ccp_shovel",
			() -> new ShovelItem(ModItemTier.LOST_CCP, 1, -1.0F,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
							.food(new Food.Builder().hunger(4).saturation(0.8f).build())));

	// Ruestung
	public static final RegistryObject<Item> LOST_CCP_HELMET = ITEMS.register("lost_ccp_helmet",
			() -> new ArmorItem(ModArmorMaterial.LOST_CCP, EquipmentSlotType.HEAD,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> LOST_CCP_CHESTPLATE = ITEMS.register("lost_ccp_chestplate",
			() -> new ArmorItem(ModArmorMaterial.LOST_CCP, EquipmentSlotType.CHEST,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> LOST_CCP_LEGGINS = ITEMS.register("lost_ccp_leggins",
			() -> new ArmorItem(ModArmorMaterial.LOST_CCP, EquipmentSlotType.LEGS,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> LOST_CCP_BOOTS = ITEMS.register("lost_ccp_boots",
			() -> new ArmorItem(ModArmorMaterial.LOST_CCP, EquipmentSlotType.FEET,
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	// food
	public static final RegistryObject<Item> WIENER_SCHNITZEL = ITEMS.register("wiener_schnitzel",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(4).saturation(1.7f).build())));

	public static final RegistryObject<Item> WIENER_SCHNITZEL_LEMON = ITEMS.register("wiener_schnitzel_lemon",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(5).saturation(1.9f).build())));

	public static final RegistryObject<Item> WIENER_SCHNITZEL_LEMON_JAM = ITEMS.register("wiener_schnitzel_lemon_jam",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(5).saturation(2.2f).build())));

	public static final RegistryObject<Item> FRIES = ITEMS.register("fries", () -> new Item(new Item.Properties()
			.group(Curd_mod.CURD_MOD_FOOD_GROUP).food(new Food.Builder().hunger(3).saturation(3.0f).build())));

	public static final RegistryObject<Item> LIMONADE = ITEMS.register("limonade",
			() -> new WheyItem(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(2).saturation(0.9f).build()).maxStackSize(32)));

	// CCP
	public static final RegistryObject<Item> CCP = ITEMS.register("ccp", () -> new Item(new Item.Properties()
			.group(Curd_mod.CURD_MOD_FOOD_GROUP).food(new Food.Builder().hunger(5).saturation(2.1f).build())));

	public static final RegistryObject<Item> CCP_RAW = ITEMS.register("ccp_raw", () -> new Item(new Item.Properties()
			.group(Curd_mod.CURD_MOD_FOOD_GROUP).food(new Food.Builder().hunger(1).saturation(0.3f).build())));

	public static final RegistryObject<Item> CCP_SUGARD = ITEMS.register("ccp_sugard",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 3600, 1), (float) 1.0)
							.hunger(5).saturation(1.8f).build())));

	public static final RegistryObject<Item> CCP_WET_OP = ITEMS.register("ccp_wet_op",
			() -> new EnchantedGoldenAppleItem(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder()
							.effect(() -> new EffectInstance(Effects.DOLPHINS_GRACE, 20 * 300), (float) 0.99)
							.effect(() -> new EffectInstance(Effects.WATER_BREATHING, 20 * 180), (float) 0.99)
							.effect(() -> new EffectInstance(Effects.REGENERATION, 20 * 10), (float) 0.99)
							.effect(() -> new EffectInstance(Effects.ABSORPTION, 20 * 300), (float) 0.99).hunger(5)
							.saturation(1.8f).build())));

	public static final RegistryObject<Item> CCP_WET = ITEMS.register("ccp_wet",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder()
							.effect(() -> new EffectInstance(Effects.DOLPHINS_GRACE, 3600), (float) 0.99).hunger(5)
							.saturation(1.8f).build())));

	public static final RegistryObject<Item> CCP_BURNT_OP = ITEMS.register("ccp_burnt_op",
			() -> new EnchantedGoldenAppleItem(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder()
							.effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 20 * 300), (float) 0.99)
							.effect(() -> new EffectInstance(Effects.REGENERATION, 20 * 10), (float) 0.99)
							.effect(() -> new EffectInstance(Effects.ABSORPTION, 20 * 300), (float) 0.99).hunger(5)
							.saturation(1.8f).build())));

	public static final RegistryObject<Item> CCP_BURNT = ITEMS.register("ccp_burnt",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder()
							.effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 20 * 120), (float) 0.99).hunger(5)
							.saturation(1.8f).build())));

	public static final RegistryObject<Item> CCP_AIRY = ITEMS.register("ccp_airy",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder()
							.effect(() -> new EffectInstance(Effects.SLOW_FALLING, 20 * 180), (float) 0.99).hunger(5)
							.saturation(1.8f).build())));

	public static final RegistryObject<Item> CCP_DURTY = ITEMS.register("ccp_dirty",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.HASTE, 20 * 120), (float) 0.99)
							.hunger(5).saturation(1.8f).build())));

	// Strudel
	// apple
	public static final RegistryObject<Item> APPLE_STRUDEL_RAW = ITEMS.register("apple_strudel_raw",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(2).saturation(1.5f).build())));

	public static final RegistryObject<Item> APPLE_STRUDEL = ITEMS.register("apple_strudel",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(8).saturation(5.0f).build())));
	public static final RegistryObject<Item> APPLE_STRUDEL_PIECE = ITEMS.register("apple_strudel_piece",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(3).saturation(1.5f).build())));

	public static final RegistryObject<Item> APPLE_STRUDEL_PIECE_SUGARD = ITEMS.register("apple_strudel_piece_sugard",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 3600, 1), (float) 1.0)
							.hunger(3).saturation(1.6f).build())));

	public static final RegistryObject<Item> APPLE_STRUDEL_PIECE_CUSTARD = ITEMS.register("apple_strudel_piece_custard",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(2.0f).build())));

	public static final RegistryObject<Item> APPLE_STRUDEL_PIECE_SUGARD_CUSTARD = ITEMS
			.register("apple_strudel_piece_sugard_custard",
					() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
							.food(new Food.Builder()
									.effect(() -> new EffectInstance(Effects.SPEED, 3600, 1), (float) 1.0).hunger(5)
									.saturation(2.2f).build())));

	// curd
	public static final RegistryObject<Item> CURD_STRUDEL_RAW = ITEMS.register("curd_strudel_raw",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(2).saturation(1.2f).build())));

	public static final RegistryObject<Item> CURD_STRUDEL = ITEMS.register("curd_strudel",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(8).saturation(5.0f).build())));

	public static final RegistryObject<Item> CURD_STRUDEL_PIECE = ITEMS.register("curd_strudel_piece",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(3).saturation(1.3f).build())));

	public static final RegistryObject<Item> CURD_STRUDEL_PIECE_SUGARD = ITEMS.register("curd_strudel_piece_sugard",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 3600, 1), (float) 1.0)
							.hunger(3).saturation(1.3f).build())));

	public static final RegistryObject<Item> CURD_STRUDEL_PIECE_CUSTARD = ITEMS.register("curd_strudel_piece_custard",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(2.0f).build())));

	public static final RegistryObject<Item> CURD_STRUDEL_PIECE_SUGARD_CUSTARD = ITEMS
			.register("curd_strudel_piece_sugard_custard",
					() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
							.food(new Food.Builder()
									.effect(() -> new EffectInstance(Effects.SPEED, 3600, 1), (float) 1.0).hunger(5)
									.saturation(2.2f).build())));

	// kaiserschmarrn
	// raisins
	public static final RegistryObject<Item> KAISERSCHMARRN_RAISINS = ITEMS.register("kaiserschmarrn_raisins",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.8f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_RAISINS_APPLE_PURE = ITEMS
			.register("kaiserschmarrn_raisins_apple_pure", () -> new Item(new Item.Properties()
					.group(Curd_mod.CURD_MOD_FOOD_GROUP).food(new Food.Builder().hunger(5).saturation(2.0f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_RAISINS_POWIDL = ITEMS
			.register("kaiserschmarrn_raisins_powidl", () -> new Item(new Item.Properties()
					.group(Curd_mod.CURD_MOD_FOOD_GROUP).food(new Food.Builder().hunger(5).saturation(2.0f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_RAISINS_SWEETBERRY = ITEMS
			.register("kaiserschmarrn_raisins_sweetberry", () -> new Item(new Item.Properties()
					.group(Curd_mod.CURD_MOD_FOOD_GROUP).food(new Food.Builder().hunger(5).saturation(2.0f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_RAISINS_APRICOT = ITEMS
			.register("kaiserschmarrn_raisins_apricot", () -> new Item(new Item.Properties()
					.group(Curd_mod.CURD_MOD_FOOD_GROUP).food(new Food.Builder().hunger(5).saturation(2.0f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_RAISINS_CHERRY = ITEMS
			.register("kaiserschmarrn_raisins_cherry", () -> new Item(new Item.Properties()
					.group(Curd_mod.CURD_MOD_FOOD_GROUP).food(new Food.Builder().hunger(5).saturation(2.0f).build())));

	// empty
	public static final RegistryObject<Item> KAISERSCHMARRN = ITEMS.register("kaiserschmarrn",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_POWIDL = ITEMS.register("kaiserschmarrn_powidl",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.5f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_APRICOT = ITEMS.register("kaiserschmarrn_apricot",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.5f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_APPLE_PURE = ITEMS.register("kaiserschmarrn_apple_pure",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.5f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_SWEETBERRY = ITEMS.register("kaiserschmarrn_sweetberry",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.5f).build())));

	public static final RegistryObject<Item> KAISERSCHMARRN_CHERRY = ITEMS.register("kaiserschmarrn_cherry",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.5f).build())));

	// omlett
	public static final RegistryObject<Item> OMLETT_CHOCO = ITEMS.register("omlett_choco",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	public static final RegistryObject<Item> OMLETT_SWEETBERRY = ITEMS.register("omlett_sweetberry",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	public static final RegistryObject<Item> OMLETT_APRICOT = ITEMS.register("omlett_apricot",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	public static final RegistryObject<Item> OMLETT_POWIDL = ITEMS.register("omlett_powidl",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	public static final RegistryObject<Item> OMLETT_APPLE = ITEMS.register("omlett_apple",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_FOOD_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	// Kefir

	public static final RegistryObject<Item> KEFIR_TUMBLER = ITEMS.register("kefir_tumbler",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> KEFIR_PLUM = ITEMS.register("kefir_plum",
			() -> new KefirItem((new Item.Properties()).maxStackSize(16).group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.STRENGTH, 2400, 1), (float) 1.0)
							.build())));

	public static final RegistryObject<Item> KEFIR_CHERRY = ITEMS.register("kefir_cherry",
			() -> new KefirItem((new Item.Properties()).maxStackSize(16).group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.RESISTANCE, 2400, 2), (float) 1.0)
							.build())));

	public static final RegistryObject<Item> KEFIR_LEMON = ITEMS.register("kefir_lemon",
			() -> new KefirItem((new Item.Properties()).maxStackSize(16).group(Curd_mod.CURD_MOD_MATERIALS_GROUP).food(
					new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 2400, 2), (float) 1.0).build())));

	public static final RegistryObject<Item> KEFIR_APRICOT = ITEMS.register("kefir_apricot",
			() -> new KefirItem((new Item.Properties()).maxStackSize(16).group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.ABSORPTION, 2400, 1), (float) 1.0)
							.build())));

	public static final RegistryObject<Item> KEFIR_SWEETBERRY = ITEMS.register("kefir_sweetberry",
			() -> new KefirItem((new Item.Properties()).maxStackSize(16).group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 2400), (float) 1.0)
							.build())));

	public static final RegistryObject<Item> KEFIR_APPLE = ITEMS.register("kefir_apple",
			() -> new KefirItem((new Item.Properties()).maxStackSize(16).group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder()
							.effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 2400), (float) 1.0).build())));

	// food materials
	public static final RegistryObject<Item> KEFIR_CRYSTAL = ITEMS.register("kefir_crystal",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> CURD = ITEMS.register("curd",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> WHEY = ITEMS.register("whey",
			() -> new WheyItem(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP).maxStackSize(16)
					.food(new Food.Builder().hunger(1).saturation(0.3f).build())));

	public static final RegistryObject<Item> RAISINS = ITEMS.register("raisins", () -> new Item(new Item.Properties()
			.group(Curd_mod.CURD_MOD_MATERIALS_GROUP).food(new Food.Builder().hunger(1).saturation(1).build())));

	public static final RegistryObject<Item> COCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties()
			.group(Curd_mod.CURD_MOD_MATERIALS_GROUP).food(new Food.Builder().hunger(2).saturation(0.6f).build())));

	public static final RegistryObject<Item> COCO_BEAN_ROASTED = ITEMS.register("coco_bean_roasted",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> VANILLE = ITEMS.register("vanille",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> VANILLIN = ITEMS.register("vanillin",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> PUFF_PASTE_RAW = ITEMS.register("puff_paste_raw",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(1).saturation(0.8f)
							.effect(() -> new EffectInstance(Effects.HUNGER, 20 * 5, 0), (float) 0.6).build())));

	public static final RegistryObject<Item> PUFF_PASTE = ITEMS.register("puff_paste",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(1).saturation(1.5f).build())));

	public static final RegistryObject<Item> CUSTARD = ITEMS.register("custard", () -> new Item(new Item.Properties()
			.group(Curd_mod.CURD_MOD_MATERIALS_GROUP).food(new Food.Builder().hunger(2).saturation(1.9f).build())));

	public static final RegistryObject<Item> DUFF_RAW = ITEMS.register("duff_raw",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> DUFF_RAW_RAISINS = ITEMS.register("duff_raw_raisins",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> SIEVE = ITEMS.register("sieve",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<Item> TIBICOS = ITEMS.register("tibicos",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	// jam
	public static final RegistryObject<Item> JAM_APRICOT = ITEMS.register("jam_apricot",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(2).saturation(2.0f).build())));

	public static final RegistryObject<Item> JAM_SWEETBERRY = ITEMS.register("jam_sweetberry",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(2).saturation(2.0f).build())));

	public static final RegistryObject<Item> JAM_APPLE_PURE = ITEMS.register("jam_apple_pure",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(2).saturation(2.0f).build())));

	public static final RegistryObject<Item> JAM_POWIDL = ITEMS.register("jam_powidl",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(2).saturation(2.0f).build())));

	public static final RegistryObject<Item> JAM_CHERRY = ITEMS.register("jam_cherry",
			() -> new Item(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(2).saturation(2.0f).build())));

	public static final RegistryObject<Item> APRICOT = ITEMS.register("apricot", () -> new Item(new Item.Properties()
			.group(Curd_mod.CURD_MOD_MATERIALS_GROUP).food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	public static final RegistryObject<FruitItem> PLUM = ITEMS.register("plum",
			() -> new FruitItem(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(1).saturation(0.45f).build())));

	public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties()
			.group(Curd_mod.CURD_MOD_MATERIALS_GROUP).food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	public static final RegistryObject<FruitItem> CHERRY = ITEMS.register("cherry",
			() -> new FruitItem(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(6).saturation(1.3f).build())));

	public static final RegistryObject<PitItem> PIT = ITEMS.register("pit",
			() -> new PitItem(new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	// Block_Items
	// normal Blocks
	public static final RegistryObject<BlockItem> CURD_POT = ITEMS.register("curd_pot",
			() -> new BlockItem(BlockInit.CURD_POT.get(),
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<BlockItem> KEFIR_CRYSTALLIZER = ITEMS.register("kefir_crystallizer",
			() -> new BlockItem(BlockInit.KEFIR_CRYSTALLIZER.get(),
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<BlockItem> LOST_CCP_ORE = ITEMS.register("lost_ccp_ore",
			() -> new BlockItem(BlockInit.LOST_CCP_ORE.get(),
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));
	
	public static final RegistryObject<BlockItem> LOST_CCP_BLOCK = ITEMS.register("lost_ccp_block",
			() -> new BlockItem(BlockInit.LOST_CCP_BLOCK.get(),
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<BlockItem> OPUNTIEN_BLOSSOM = ITEMS.register("opuntien_blossom",
			() -> new BlockItem(BlockInit.OPUNTIEN_CACTUS.get(),
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
							.food(new Food.Builder().hunger(1).saturation(0.8f).fastToEat()
									.effect(() -> new EffectInstance(Effects.REGENERATION, 20 * 5, 0), (float) 0.2)
									.build())));

	// jam maker
	public static final RegistryObject<BlockItem> STOVE = ITEMS.register("stove",
			() -> new BlockItem(BlockInit.STOVE.get(), new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	public static final RegistryObject<BlockItem> KEFIR_JAR = ITEMS.register("kefir_jar",
			() -> new BlockItem(BlockInit.KEFIR_JAR.get(),
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)));

	// duff blocks

	public static final RegistryObject<BlockItem> DUFF = ITEMS.register("duff",
			() -> new BlockItem(BlockInit.DUFF.get(), new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
					.food(new Food.Builder().hunger(3).saturation(1.5f).build())));

	public static final RegistryObject<BlockItem> DUFF_RAISINS = ITEMS.register("duff_raisins",
			() -> new BlockItem(BlockInit.DUFF_RAISINS.get(),
					new Item.Properties().group(Curd_mod.CURD_MOD_MATERIALS_GROUP)
							.food(new Food.Builder().hunger(3).saturation(1.5f).build())));

}
