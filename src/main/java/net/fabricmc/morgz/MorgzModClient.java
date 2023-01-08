//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.fabricmc.morgz;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil.Type;

public class MorgzModClient implements ClientModInitializer {
    private HacksData hacksData = HacksData.getInstance();
    private static KeyBinding keyBindingXray;
    private static KeyBinding keyBindingFullbright;

    public MorgzModClient() {
    }

    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            MinecraftClient.getInstance().inGameHud.getTextRenderer().drawWithShadow(matrixStack, "MorgzMod", 1.0F, 1.0F, 16777215);
        });
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            while(keyBindingXray.wasPressed()) {
                MinecraftClient.getInstance().worldRenderer.reload();
                this.hacksData.toggleXrayEnabled();
                if (this.hacksData.getXrayEnabled() && !this.hacksData.getFullbrightEnabled()) {
                    this.hacksData.enableFullbrightXray();
                } else if (!this.hacksData.getXrayEnabled() && !this.hacksData.getFullbrightManuallyEnabled() && this.hacksData.getFullbrightEnabled()) {
                    this.hacksData.disableFullbrightXray();
                }
            }

            while(keyBindingFullbright.wasPressed()) {
                if (!this.hacksData.getXrayEnabled()) {
                    MinecraftClient.getInstance().worldRenderer.reload();
                    this.hacksData.toggleFullbrightManuallyEnabled();
                }
            }

        });
    }

    static {
        keyBindingXray = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.morgzmod.xray", Type.KEYSYM, 88, "category.morgzmod.hack"));
        keyBindingFullbright = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.morgzmod.fullbright", Type.KEYSYM, 67, "category.morgzmod.hack"));
    }
}
