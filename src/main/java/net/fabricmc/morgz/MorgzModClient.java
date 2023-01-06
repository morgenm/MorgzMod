package net.fabricmc.morgz;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class MorgzModClient implements ClientModInitializer {
    private HacksData hacksData = HacksData.getInstance();
    private static KeyBinding keyBindingXray = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.morgzmod.xray", // The translation key of the keybinding's name
        InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
        GLFW.GLFW_KEY_X, // The keycode of the key
        "category.morgzmod.hack" // The translation key of the keybinding's category.
    ));

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBindingXray.wasPressed()) {
                MinecraftClient.getInstance().worldRenderer.reload();
                hacksData.toggleXrayEnabled();
                System.out.println("Morgz: Xray Hack Toggled!");

            }
        });
    }
}
