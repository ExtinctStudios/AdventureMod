package com.korp.adventuremod.screen;

import com.korp.adventuremod.AdventureMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ArcaneExtractorScreen extends HandledScreen<ArcaneExtractorScreenHandler> {
    private static final Identifier GUI_TEXTURE =
            Identifier.of(AdventureMod.MOD_ID, "textures/gui/arcane_extractor/arcane_extractor_gui.png");
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(AdventureMod.MOD_ID, "textures/gui/arrow_progress.png");

    public ArcaneExtractorScreen(ArcaneExtractorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(ARROW_TEXTURE, x + 72, y + 33, 0, 0,
                    handler.getScaledArrowProgress(), 38, 32, 38);
        }
    }
}
