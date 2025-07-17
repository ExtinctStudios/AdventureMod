package com.korp.adventuremod.world;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.world.gen.ModOrePlacement;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BLOODSTONE_ORE_MEDIUM = registerKey("bloodstone_ore_medium");
    public static final RegistryKey<PlacedFeature> BLOODSTONE_ORE_SMALL = registerKey("bloodstone_ore_small");

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(
                context,
                BLOODSTONE_ORE_MEDIUM,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOODSTONE_ORE_MEDIUM),
                ModOrePlacement.modifiersWithCount(16, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-42), YOffset.fixed(67)))
        );

        register(
                context,
                BLOODSTONE_ORE_SMALL,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOODSTONE_ORE_SMALL),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(74)))
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String id){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(AdventureMod.MOD_ID, id));
    }

    static void register(
            Registerable<PlacedFeature> context,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    static <C extends FeatureConfig, F extends Feature<C>> void register(
            Registerable<PlacedFeature> context,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> configuration,
            PlacementModifier... modifiers){
        register(context, key, configuration, List.of(modifiers));
    }
}
