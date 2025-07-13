package com.korp.adventuremod.armor;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.registries.ModItem;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static void init(){};

    public static RegistryEntry<ArmorMaterial> LEAF_ARMOR = registerMaterial(
            "leaf_armor",
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 3,
                    ArmorItem.Type.LEGGINGS, 3,
                    ArmorItem.Type.BOOTS, 3
            ),
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            () -> Ingredient.fromTag(ItemTags.LEAVES),
            0f,
            0f,
            false
    );
    public static final int LEAF_ARMOR_DURABILITY_MULTIPLIER = 15;
    public static final Item LEAF_HELMET = ModItem.register(
            new ArmorItem(
                    LEAF_ARMOR,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(LEAF_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(AdventureMod.MOD_ID, "speed_modifier"), 5, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ARMOR).build())
            ),
            "leaf_helmet"
    );
    public static final Item LEAF_CHESTPLATE = ModItem.register(
            new ArmorItem(
                    LEAF_ARMOR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(LEAF_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(AdventureMod.MOD_ID, "speed_modifier"), 5, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ARMOR).build())
            ),
            "leaf_chestplate"
    );
    public static final Item LEAF_LEGGINGS = ModItem.register(
            new ArmorItem(
                    LEAF_ARMOR,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(LEAF_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(AdventureMod.MOD_ID, "speed_modifier"), 5, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ARMOR).build())
            ),
            "leaf_leggings"
    );
    public static final Item LEAF_BOOTS = ModItem.register(
            new ArmorItem(
                    LEAF_ARMOR,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(LEAF_ARMOR_DURABILITY_MULTIPLIER))
                            .attributeModifiers(AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(AdventureMod.MOD_ID, "speed_modifier"), 5, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ARMOR).build())
            ),
            "leaf_boots"
    );


    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(AdventureMod.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(AdventureMod.MOD_ID, id), material);

        return RegistryEntry.of(material);
    }
}
