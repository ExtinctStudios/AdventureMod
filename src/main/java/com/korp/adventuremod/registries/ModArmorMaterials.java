package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
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
    public static void initialize(){};

    public static RegistryEntry<ArmorMaterial> LEAF = registerMaterial(
            "leaf",
            Map.of(
                    ArmorItem.Type.BOOTS, 2,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.CHESTPLATE, 7,
                    ArmorItem.Type.HELMET, 2,
                    ArmorItem.Type.BODY, 9
            ),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            () -> Ingredient.fromTag(ItemTags.LEAVES),
            2.0f,
            0f,
            false
    );

    public static RegistryEntry<ArmorMaterial> BLOODSTONE = registerMaterial(
            "bloodstone",
            Map.of(
                    ArmorItem.Type.BOOTS, 3,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.BODY, 11
            ),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(ModItems.BLOODSTONE),
            2.0f,
            0.1f,
            false
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
