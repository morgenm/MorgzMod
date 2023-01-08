//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.fabricmc.morgz.mixin;

import net.fabricmc.morgz.HacksData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ChunkLightProvider.class})
public abstract class ChunkLightProviderMixin {
    private static HacksData hacksData = HacksData.getInstance();

    public ChunkLightProviderMixin() {
    }

    @Inject(
            at = {@At("TAIL")},
            method = {"getLightLevel(Lnet/minecraft/util/math/BlockPos;)I"},
            cancellable = true
    )
    private void getLightLevel(BlockPos pos, CallbackInfoReturnable<Integer> cir) {
        if (hacksData.getFullbrightEnabled()) {
            cir.setReturnValue(15);
        }

    }
}
