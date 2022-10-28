package com.kwpugh.gobber2.world;

import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.config.Gobber2Config;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.placementmodifier.*;
import java.util.List;
import java.util.function.Predicate;

public class GobberOrePlacedFeature
{
    public static final Gobber2Config.Ores CONFIG = Gobber2.CONFIG.ORES;

    public static void register()
    {
        // Inject into Biomes
        BiomeModifications.addFeature(overworldSelector(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Gobber2.MOD_ID, "ore_lucky_block_overworld")));
        BiomeModifications.addFeature(overworldSelector(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Gobber2.MOD_ID, "ore_gobber_overworld")));
        BiomeModifications.addFeature(netherSelector(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Gobber2.MOD_ID, "ore_lucky_block_nether")));
        BiomeModifications.addFeature(netherSelector(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Gobber2.MOD_ID, "ore_gobber_nether")));
        BiomeModifications.addFeature(endSelector(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Gobber2.MOD_ID, "ore_lucky_block_end")));
        BiomeModifications.addFeature(endSelector(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Gobber2.MOD_ID, "ore_gobber_end")));
    }

    public static Predicate<BiomeSelectionContext> overworldSelector()
    {
        return context -> context.getBiomeRegistryEntry().isIn(BiomeTags.IS_OVERWORLD);
    }

    public static Predicate<BiomeSelectionContext> netherSelector()
    {
        return context -> context.getBiomeRegistryEntry().isIn(BiomeTags.IS_NETHER);
    }

    public static Predicate<BiomeSelectionContext> endSelector()
    {
        return context -> context.getBiomeRegistryEntry().isIn(BiomeTags.IS_END);
    }

    // Used here because the vanilla ones are private
    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}

