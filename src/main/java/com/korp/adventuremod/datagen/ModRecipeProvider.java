package com.korp.adventuremod.datagen;

import com.korp.adventuremod.registries.ModItems;
import com.korp.adventuremod.registries.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.ChestBlock;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_INGOT,1)
                .input('1', Items.IRON_INGOT)
                .input('2', Items.COAL)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .pattern("1")
                .pattern("2")
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
                ModItems.STEEL_INGOT,
                ModItems.STEEL_HELMET,
                ModItems.STEEL_CHESTPLATE,
                ModItems.STEEL_LEGGINGS,
                ModItems.STEEL_BOOTS,
                recipeExporter
        );

        offerEquipmentRecipe(
                ModItems.STEEL_INGOT,
                Items.STICK,
                ModItems.STEEL_SWORD,
                ModItems.STEEL_PICKAXE,
                ModItems.STEEL_AXE,
                ModItems.STEEL_SHOVEL,
                ModItems.STEEL_HOE,
                recipeExporter
        );

        offerHammerRecipe(
                ModItems.STEEL_INGOT,
                Items.STICK,
                ModItems.STEEL_HAMMER,
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
                .input('4', Items.BLAZE_ROD)
                .criterion(hasItem(ModItems.WARP_ESSENCE), conditionsFromItem(ModItems.WARP_ESSENCE))
                .pattern("424")
                .pattern("131")
                .pattern(" 4 ")
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEATHER_ELYTRA)
                .input('1', Items.STICK)
                .input('2', Items.LEATHER)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .pattern("212")
                .pattern("2 2")
                .offerTo(recipeExporter);

        offerUpgradeableItemRecipe(Items.BONE, ModItems.CLOTH_HELMET, ModItems.BONE_REINFORCED_CLOTH_HELMET, recipeExporter);
        offerUpgradeableItemRecipe(Items.BONE, ModItems.CLOTH_CHESTPLATE, ModItems.BONE_REINFORCED_CLOTH_CHESTPLATE, recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SKULLISH_HELMET)
                .input('#', Items.BONE)
                .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .offerTo(recipeExporter);
    }

    static void offerHelmetRecipe(
            ItemConvertible material,
            ItemConvertible helmet,
            RecipeExporter recipeExporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, helmet)
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("###")
                .pattern("# #")
                .offerTo(recipeExporter);
    }

    static void offerChestplateRecipe(
            ItemConvertible material,
            ItemConvertible chestplate,
            RecipeExporter recipeExporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, chestplate)
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .offerTo(recipeExporter);
    }

    static void offerArmorRecipe(
            ItemConvertible material,
            ItemConvertible helmet,
            ItemConvertible chestplate,
            ItemConvertible leggings,
            ItemConvertible boots,
            RecipeExporter recipeExporter){
        offerHelmetRecipe(material, helmet, recipeExporter);
        offerChestplateRecipe(material, chestplate, recipeExporter);
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

    static void offerUpgradeableItemRecipe(
            ItemConvertible material,
            ItemConvertible baseItem,
            ItemConvertible item,
            RecipeExporter recipeExporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, item)
                .input('#', material)
                .input('b', baseItem)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern(" # ")
                .pattern("#b#")
                .pattern(" # ")
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
        offerUpgradeableItemRecipe(material, baseHelmet, helmet, recipeExporter);
        offerUpgradeableItemRecipe(material, baseChestplate, chestplate, recipeExporter);
        offerUpgradeableItemRecipe(material, baseLeggings, leggings, recipeExporter);
        offerUpgradeableItemRecipe(material, baseBoots, boots, recipeExporter);
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

    static void offerHammerRecipe(
            ItemConvertible material,
            ItemConvertible stick,
            ItemConvertible hammer,
            RecipeExporter recipeExporter
    ){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, hammer)
                .input('m', material)
                .input('s', stick)
                .criterion(hasItem(material), conditionsFromItem(material))
                .pattern("mmm")
                .pattern("mmm")
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
