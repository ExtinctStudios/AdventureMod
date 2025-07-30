package com.korp.adventuremod.registries;

import com.korp.adventuremod.AdventureMod;
import com.korp.adventuremod.screen.ArcaneExtractorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<ArcaneExtractorScreenHandler> ARCANE_EXTRACTOR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(AdventureMod.MOD_ID, "arcane_extractor_screen_handler"),
                    new ExtendedScreenHandlerType<>(ArcaneExtractorScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void initialize() {}
}
