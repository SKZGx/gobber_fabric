package com.kwpugh.gobber2.mixin;

import com.kwpugh.gobber2.init.EnchantmentInit;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.VibrationListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VibrationListener.class)
public class VibrationListenerMixin
{
    @Inject(at = @At("HEAD"), method = "listen", cancellable = true)
    public void listen(ServerWorld world, GameEvent event, GameEvent.Emitter emitter, Vec3d emitterPos, CallbackInfoReturnable<Boolean> cir)
    {
        //GameEvent.Emitter emitter = event.getEmitter();

        if(emitter.sourceEntity() instanceof PlayerEntity player)
        {
            if(EnchantmentHelper.getLevel(EnchantmentInit.QUIETFEET, player.getEquippedStack(EquipmentSlot.FEET)) > 0)
            {
                cir.setReturnValue(false);
            }
        }
    }
}
