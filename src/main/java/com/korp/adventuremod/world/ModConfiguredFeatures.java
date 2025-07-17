package com.korp.adventuremod.world;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.registries.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLOODSTONE_ORE_MEDIUM = registerKey("bloodstone_ore_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLOODSTONE_ORE_SMALL = registerKey("bloodstone_ore_small");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>>  context){
        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> bloodstoneOre = List.of(
                OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.BLOODSTONE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.BLOODSTONE_ORE.getDefaultState())
        );

        register(context, BLOODSTONE_ORE_MEDIUM, Feature.ORE, new OreFeatureConfig(bloodstoneOre, 4));
        register(context, BLOODSTONE_ORE_SMALL, Feature.ORE, new OreFeatureConfig(bloodstoneOre, 2));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String id){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(AdventureMod.MOD_ID, id));
    }

    static <C extends FeatureConfig, F extends Feature<C>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key,
            F feature,
            C configuration){
        context.register(key, new ConfiguredFeature<>(feature,  configuration));
    }
}
