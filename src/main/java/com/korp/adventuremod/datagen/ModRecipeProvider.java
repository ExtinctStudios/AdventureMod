package com.korp.adventuremod.datagen;

import com.korp.adventuremod.registries.ModItem;
import com.korp.adventuremod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItem.IRON_ROD)
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .pattern("#")
                .pattern("#")
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItem.LEAF_INGOT)
                .input('1', Items.IRON_INGOT)
                .input('2', ModTags.Items.LEAVES)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .offerTo(recipeExporter);

        offerArmorRecipe(
                ModItem.LEAF_INGOT,
                ModItem.LEAF_HELMET,
                ModItem.LEAF_CHESTPLATE,
                ModItem.LEAF_LEGGINGS,
                ModItem.LEAF_BOOTS,
                recipeExporter
        );

        offerBowRecipe(
                ModItem.LEAF_INGOT,
                Items.STRING,
                ModItem.LEAF_BOW,
                recipeExporter
        );

        offerArmorRecipe(
                ModItem.BLOODSTONE,
                ModItem.BLOODSTONE_HELMET,
                ModItem.BLOODSTONE_CHESTPLATE,
                ModItem.BLOODSTONE_LEGGINGS,
                ModItem.BLOODSTONE_BOOTS,
                recipeExporter
        );

        offerEquipmentRecipe(
                ModItem.BLOODSTONE,
                ModItem.IRON_ROD,
                ModItem.BLOODSTONE_SWORD,
                ModItem.BLOODSTONE_PICKAXE,
                ModItem.BLOODSTONE_AXE,
                ModItem.BLOODSTONE_SHOVEL,
                ModItem.BLOODSTONE_HOE,
                recipeExporter
        );
    }

    static void offerArmorRecipe(
            ItemConvertible material,
            ItemConvertible helmet,
            ItemConvertible chestplate,
            ItemConvertible leggings,
            ItemConvertible boots,
            RecipeExporter recipeExporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, helmet)
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("###")
                .pattern("# #")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, chestplate)
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, leggings)
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, boots)
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("# #")
                .pattern("# #")
                .offerTo(recipeExporter);
    }

    static void offerEquipmentRecipe(
            ItemConvertible material,
            ItemConvertible stick,
            ItemConvertible sword,
            ItemConvertible pickaxe,
            ItemConvertible axe,
            ItemConvertible shovel,
            ItemConvertible hoe,
            RecipeExporter recipeExporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, sword)
                .input('m', material)
                .input('s', stick)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("m")
                .pattern("m")
                .pattern("s")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, pickaxe)
                .input('m', material)
                .input('s', stick)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("mmm")
                .pattern(" s ")
                .pattern(" s ")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, axe)
                .input('m', material)
                .input('s', stick)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern(" mm")
                .pattern(" sm")
                .pattern(" s ")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, shovel)
                .input('m', material)
                .input('s', stick)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("m")
                .pattern("s")
                .pattern("s")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, hoe)
                .input('m', material)
                .input('s', stick)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern(" mm")
                .pattern(" s ")
                .pattern(" s ")
                .offerTo(recipeExporter);
    }

    static void offerBowRecipe(
            ItemConvertible material,
            ItemConvertible string,
            ItemConvertible bow,
            RecipeExporter recipeExporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, bow)
                .input('m', material)
                .input('s', string)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("sm ")
                .pattern("s m")
                .pattern("sm ")
                .offerTo(recipeExporter);
    }
}
