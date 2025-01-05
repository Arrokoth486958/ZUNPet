package dev.arrokoth.zunpet.zunpet.client.screen;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.arrokoth.zunpet.zunpet.Zunpet;
import dev.arrokoth.zunpet.zunpet.item.AbstractItemInstrument;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;

/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
public class HudInstrument extends GuiComponent {
    public static final ResourceLocation NAME_BG = new ResourceLocation(Zunpet.MOD_ID, "textures/hud/name_bg.png");
    public static final ResourceLocation BAR_TEXTURE = new ResourceLocation(Zunpet.MOD_ID, "textures/hud/bar.png");
    public static final ResourceLocation POINTER_TEXTURE = new ResourceLocation(Zunpet.MOD_ID, "textures/hud/pointer.png");

    private static final String[] NOTE_NAMES = {"C", "D", "E", "F", "G", "A", "H"};
    private final Minecraft minecraft;

    public HudInstrument(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    public void render(PoseStack poseStack) {
        this.minecraft.getProfiler().push("instrument");
        Window window = Minecraft.getInstance().getWindow();
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null && player.getMainHandItem().getItem() instanceof AbstractItemInstrument) {
            Font textRenderer = Minecraft.getInstance().font;

            float var0 = Math.abs(player.xRotO / 90f * 7f);
            if (player.xRotO > 0) {
                var0 = 7 - var0;
            }
            String name = NOTE_NAMES[(int) (Math.abs(var0 + 0.5f) % 7)];

            RenderSystem.enableTexture();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();

            RenderSystem.setShaderTexture(0, NAME_BG);
            blit(poseStack, (int) (window.getGuiScaledWidth() / 1.5f - 4), window.getGuiScaledHeight() / 2 - 8, 0, 0, 16, 16, 16, 16);

            textRenderer.drawShadow(poseStack, name, window.getGuiScaledWidth() / 1.5f, window.getGuiScaledHeight() / 2f - textRenderer.lineHeight / 2f, 0xffffff);

            RenderSystem.setShaderTexture(0, BAR_TEXTURE);
            blit(poseStack, (int) (window.getGuiScaledWidth() / 1.5f + 6), window.getGuiScaledHeight() / 2 - 32, 0, 0, 16, 64, 16, 64);

            float accurate = (var0 + 0.5f) - ((int) (var0 + 0.5f));
            RenderSystem.setShaderTexture(0, POINTER_TEXTURE);
            blit(poseStack, (int) (window.getGuiScaledWidth() / 1.5f + 6), window.getGuiScaledHeight() / 2 - 32 + ((int) (60 * accurate)), 0, 0, 16, 5, 16, 5);
        }
        this.minecraft.getProfiler().pop();
    }
}
