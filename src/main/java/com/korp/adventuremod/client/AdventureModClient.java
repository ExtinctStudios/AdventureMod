package com.korp.adventuremod.client;

import com.korp.adventuremod.registries.ModScreenHandlers;
import com.korp.adventuremod.screen.ArcaneExtractorScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class AdventureModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModEntityInitializer.initialize();

        HandledScreens.register(ModScreenHandlers.ARCANE_EXTRACTOR_SCREEN_HANDLER, ArcaneExtractorScreen::new);
    }
}
