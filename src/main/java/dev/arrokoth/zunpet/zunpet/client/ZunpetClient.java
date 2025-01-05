package dev.arrokoth.zunpet.zunpet.client;

import dev.arrokoth.zunpet.zunpet.client.screen.HudInstrument;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;

/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
public class ZunpetClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudInstrument hud = new HudInstrument(Minecraft.getInstance());
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            hud.render(matrixStack);
        });
    }
}
