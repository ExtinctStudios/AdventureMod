package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.items.LeatherElytraItem;
import com.korp.adventuremod.items.MagicMirrorItem;
import com.korp.adventuremod.overrides.ModArmorItem;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item IRON_ROD = register(new Item(new Item.Settings()), "iron_rod");
    public static final Item CLOTH = register(new Item(new Item.Settings()), "cloth");

    public static final int CLOTH_ARMOR_DURABILITY_MULTIPLIER = 15;
    public static final Item CLOTH_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.CLOTH,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(CLOTH_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "cloth_helmet"
    );
    public static final Item CLOTH_CHESTPLATE = register(
            new ArmorItem(
                    ModArmorMaterials.CLOTH,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(CLOTH_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "cloth_chestplate"
    );
    public static final Item CLOTH_LEGGINGS = register(
            new ArmorItem(
                    ModArmorMaterials.CLOTH,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(CLOTH_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "cloth_leggings"
    );
    public static final Item CLOTH_BOOTS = register(
            new ArmorItem(
                    ModArmorMaterials.CLOTH,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(CLOTH_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "cloth_boots"
    );

    public static final int CACTUS_ARMOR_DURABILITY_MULTIPLIER = 15;
    public static final Item CACTUS_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.CACTUS,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(CACTUS_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "cactus_helmet"
    );
    public static final Item CACTUS_CHESTPLATE = register(
            new ArmorItem(
                    ModArmorMaterials.CACTUS,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(CACTUS_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "cactus_chestplate"
    );
    public static final Item CACTUS_LEGGINGS = register(
            new ArmorItem(
                    ModArmorMaterials.CACTUS,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(CACTUS_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "cactus_leggings"
    );
    public static final Item CACTUS_BOOTS = register(
            new ArmorItem(
                    ModArmorMaterials.CACTUS,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(CACTUS_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "cactus_boots"
    );

    public static final Item CACTUS_SWORD = register(
            new SwordItem(ModToolMaterials.CACTUS, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CACTUS, 3, -2.4f))), "cactus_sword");


    public static final Item LEAF_INGOT = register(new Item(new Item.Settings()), "leaf_ingot");

    public static final int LEAF_ARMOR_DURABILITY_MULTIPLIER = 15;
    public static final Item LEAF_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.LEAF,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(LEAF_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "leaf_helmet"
    );
    public static final Item LEAF_CHESTPLATE = register(
            new ArmorItem(
                    ModArmorMaterials.LEAF,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(LEAF_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "leaf_chestplate"
    );
    public static final Item LEAF_LEGGINGS = register(
            new ArmorItem(
                    ModArmorMaterials.LEAF,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(LEAF_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "leaf_leggings"
    );
    public static final Item LEAF_BOOTS = register(
            new ArmorItem(
                    ModArmorMaterials.LEAF,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(LEAF_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(AdventureMod.MOD_ID, "speed_modifier"), 0.17, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.ARMOR).build())
            ),
            "leaf_boots"
    );

    public static final Item LEAF_BOW = register(new BowItem(new Item.Settings().maxDamage(584)), "leaf_bow");

    public static final int BLOOD_STONE_DURABILITY_MULTIPLIER = 15;
    public static final Item BLOODSTONE_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.BLOODSTONE,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(BLOOD_STONE_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "bloodstone_helmet"
    );
    public static final Item BLOODSTONE_CHESTPLATE = register(
            new ArmorItem(
                    ModArmorMaterials.BLOODSTONE,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(BLOOD_STONE_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "bloodstone_chestplate"
    );
    public static final Item BLOODSTONE_LEGGINGS = register(
            new ArmorItem(
                    ModArmorMaterials.BLOODSTONE,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(BLOOD_STONE_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "bloodstone_leggings"
    );
    public static final Item BLOODSTONE_BOOTS = register(
            new ArmorItem(
                    ModArmorMaterials.BLOODSTONE,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(BLOOD_STONE_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "bloodstone_boots"
    );

    public static final Item BLOODSTONE_SWORD = register(
            new SwordItem(ModToolMaterials.BLOODSTONE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BLOODSTONE, 3, -2.4f))), "bloodstone_sword");

    public static final Item BLOODSTONE_PICKAXE = register(
            new PickaxeItem(ModToolMaterials.BLOODSTONE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BLOODSTONE, 1, -3f))), "bloodstone_pickaxe");

    public static final Item BLOODSTONE_AXE = register(
            new AxeItem(ModToolMaterials.BLOODSTONE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BLOODSTONE, 5.5f, -3.4f))), "bloodstone_axe");

    public static final Item BLOODSTONE_SHOVEL = register(
            new ShovelItem(ModToolMaterials.BLOODSTONE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BLOODSTONE, 1.5f, -3.0f))), "bloodstone_shovel");

    public static final Item BLOODSTONE_HOE = register(
            new HoeItem(ModToolMaterials.BLOODSTONE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BLOODSTONE, -3.0f, -0.2f))), "bloodstone_hoe");

    public static final Item BLOODSTONE = register(new Item(new Item.Settings()), "bloodstone");
    public static final Item BLOODSTONE_EMPTY = register(new Item(new Item.Settings()), "bloodstone_empty");

    public static final Item MAGIC_MIRROR = register(new MagicMirrorItem(new Item.Settings().maxCount(1)), "magic_mirror");

    public static final Item WARP_ESSENCE = register(new Item(new Item.Settings().maxCount(1)), "warp_essence");

    public static final Item STEEL_INGOT = register(new Item(new Item.Settings()), "steel_ingot");

    public static final int STEEL_INGOT_DURABILITY_MULTIPLIER = 15;
    public static final Item STEEL_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.STEEL,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(STEEL_INGOT_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "steel_helmet"
    );
    public static final Item STEEL_CHESTPLATE = register(
            new ArmorItem(
                    ModArmorMaterials.STEEL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(STEEL_INGOT_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "steel_chestplate"
    );
    public static final Item STEEL_LEGGINGS = register(
            new ArmorItem(
                    ModArmorMaterials.STEEL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(STEEL_INGOT_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "steel_leggings"
    );
    public static final Item STEEL_BOOTS = register(
            new ArmorItem(
                    ModArmorMaterials.STEEL,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(STEEL_INGOT_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "steel_boots"
    );

    public static final Item STEEL_SWORD = register(
            new SwordItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STEEL, 3, -2.4f))), "steel_sword");

    public static final Item STEEL_PICKAXE = register(
            new PickaxeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 1, -3f))), "steel_pickaxe");

    public static final Item STEEL_AXE = register(
            new AxeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 5.5f, -3.4f))), "steel_axe");

    public static final Item STEEL_SHOVEL = register(
            new ShovelItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STEEL, 1.5f, -3.0f))), "steel_shovel");

    public static final Item STEEL_HOE = register(
            new HoeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STEEL, -3.0f, -0.2f))), "steel_hoe");

    public static final Item STEEL_HAMMER = register(
            new SwordItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STEEL, 7, -3.7f))), "steel_hammer");

    public static final Item LEATHER_ELYTRA = register(new LeatherElytraItem(new Item.Settings().maxDamage(231)), "leather_elytra");

    public static final int BONE_REINFORCED_CLOTH_DURABILITY_MULTIPLIER = 15;
    public static final Item BONE_REINFORCED_CLOTH_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.BONE_REINFORCED_CLOTH,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(BONE_REINFORCED_CLOTH_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "bone_reinforced_cloth_helmet"
    );
    public static final Item BONE_REINFORCED_CLOTH_CHESTPLATE = register(
            new ArmorItem(
                    ModArmorMaterials.BONE_REINFORCED_CLOTH,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(BONE_REINFORCED_CLOTH_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build())
            ),
            "bone_reinforced_cloth_chestplate"
    );

    public static final int SKULLISH_DURABILITY_MULTIPLIER = 15;
    public static final Item SKULLISH_HELMET = register(
            new ModArmorItem(
                    ModArmorMaterials.BONE_REINFORCED_CLOTH,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(SKULLISH_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build()),
                    StatusEffects.ABSORPTION),
            "skullish_helmet"
    );

    public static final Item BONE_WAND = register(
            new SwordItem(ModToolMaterials.BONE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BONE, 3, -2.4f))),
            "bone_wand");

    public static final int PIRATE_DURABILITY_MULTIPLIER = 15;
    public static final Item PIRATE_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.CLOTH,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(PIRATE_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build()).rarity(Rarity.UNCOMMON)
            ),
            "pirate_helmet"
    );

    public static final Item CURSED_PIRATE_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.CLOTH,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(PIRATE_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().build()).rarity(Rarity.RARE)
            ),
            "cursed_pirate_helmet"
    );

    public static void initialize(){}

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(AdventureMod.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }
}
