package com.korp.adventuremod.datagen;

import com.korp.adventuremod.registries.ModItems;
import com.korp.adventuremod.registries.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_ROD, 4)
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .pattern("#")
                .pattern("#")
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLOTH,2)
                .input('#', Items.STRING)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .pattern("#")
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEAF_INGOT)
                .input('1', Items.IRON_INGOT)
                .input('2', ItemTags.LEAVES)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .offerTo(recipeExporter);

        offerArmorRecipe(
                ModItems.CLOTH,
                ModItems.CLOTH_HELMET,
                ModItems.CLOTH_CHESTPLATE,
                ModItems.CLOTH_LEGGINGS,
                ModItems.CLOTH_BOOTS,
                recipeExporter
        );

        offerArmorRecipe(
                Items.CACTUS,
                ModItems.CACTUS_HELMET,
                ModItems.CACTUS_CHESTPLATE,
                ModItems.CACTUS_LEGGINGS,
                ModItems.CACTUS_BOOTS,
                recipeExporter
        );

        offerSwordRecipe(Items.CACTUS, Items.STICK, ModItems.CACTUS_SWORD, recipeExporter);

        offerUpgradeableArmorRecipe(
                ModItems.LEAF_INGOT,
                ModItems.CLOTH_HELMET,
                ModItems.CLOTH_CHESTPLATE,
                ModItems.CLOTH_LEGGINGS,
                ModItems.CLOTH_BOOTS,
                ModItems.LEAF_HELMET,
                ModItems.LEAF_CHESTPLATE,
                ModItems.LEAF_LEGGINGS,
                ModItems.LEAF_BOOTS,
                recipeExporter
        );

        offerBowRecipe(
                ModItems.LEAF_INGOT,
                Items.STRING,
                ModItems.LEAF_BOW,
                recipeExporter
        );

        offerArmorRecipe(
                ModItems.BLOODSTONE,
                ModItems.BLOODSTONE_HELMET,
                ModItems.BLOODSTONE_CHESTPLATE,
                ModItems.BLOODSTONE_LEGGINGS,
                ModItems.BLOODSTONE_BOOTS,
                recipeExporter
        );

        offerEquipmentRecipe(
                ModItems.BLOODSTONE,
                ModItems.IRON_ROD,
                ModItems.BLOODSTONE_SWORD,
                ModItems.BLOODSTONE_PICKAXE,
                ModItems.BLOODSTONE_AXE,
                ModItems.BLOODSTONE_SHOVEL,
                ModItems.BLOODSTONE_HOE,
                recipeExporter
        );

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGIC_MIRROR)
                .input('1', Items.IRON_INGOT)
                .input('2', Items.COMPASS)
                .input('3', ModItems.WARP_ESSENCE)
                .input('4', ModItems.IRON_ROD)
                .criterion(hasItem(ModItems.WARP_ESSENCE), conditionsFromItem(ModItems.WARP_ESSENCE))
                .pattern("121")
                .pattern("131")
                .pattern(" 4 ")
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WARP_ESSENCE)
                .input('#', Items.ENDER_PEARL)
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .pattern("##")
                .pattern("##")
                .offerTo(recipeExporter);
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

    static void offerUpgradeableArmorRecipe(
            ItemConvertible material,
            ItemConvertible baseHelmet,
            ItemConvertible baseChestplate,
            ItemConvertible baseLeggings,
            ItemConvertible baseBoots,
            ItemConvertible helmet,
            ItemConvertible chestplate,
            ItemConvertible leggings,
            ItemConvertible boots,
            RecipeExporter recipeExporter
    ) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, helmet)
                .input('#', material)
                .input('b', baseHelmet)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern(" # ")
                .pattern("#b#")
                .pattern(" # ")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, chestplate)
                .input('#', material)
                .input('b', baseChestplate)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern(" # ")
                .pattern("#b#")
                .pattern(" # ")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, leggings)
                .input('#', material)
                .input('b', baseLeggings)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern(" # ")
                .pattern("#b#")
                .pattern(" # ")
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, boots)
                .input('#', material)
                .input('b', baseBoots)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern(" # ")
                .pattern("#b#")
                .pattern(" # ")
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

        offerSwordRecipe(material, stick, sword, recipeExporter);
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

    static void offerSwordRecipe(
            ItemConvertible material,
            ItemConvertible stick,
            ItemConvertible sword,
            RecipeExporter recipeExporter
    ){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, sword)
                .input('m', material)
                .input('s', stick)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("m")
                .pattern("m")
                .pattern("s")
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
