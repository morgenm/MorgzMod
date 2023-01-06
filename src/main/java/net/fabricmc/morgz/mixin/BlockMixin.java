package net.fabricmc.morgz.mixin;

import net.fabricmc.morgz.HacksData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin {
	private static HacksData hacksData = HacksData.getInstance();

	@Inject( at = @At("HEAD"), method = "shouldDrawSide(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;Lnet/minecraft/util/math/BlockPos;)Z", cancellable = true)
	private static void shouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos otherPos, CallbackInfoReturnable<Boolean> cir) {
		if(hacksData.getXrayEnabled()) {
			Block b = state.getBlock();
			String blockName = Registries.BLOCK.getId(b).toString();
			if (!blockName.contains("ore")) {
				cir.setReturnValue(false);
			} else { // Always and only draw ores
				cir.setReturnValue(true);
			}
		}
	}
}