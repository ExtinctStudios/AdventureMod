package com.korp.adventuremod.client;

import net.fabricmc.api.ClientModInitializer;

public class AdventureModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModEntityInitializer.initialize();
    }
}
