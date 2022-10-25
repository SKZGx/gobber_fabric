package com.kwpugh.gobber2.mixin;

import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.util.GobberForceManager;
import com.kwpugh.gobber2.util.PlayerEquipUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
    Mixins for various methods in PlayerEntity
    class to support Gobber Force

    Relies on events:
    - AfterKilledOtherEntityEvent
    - PlayerBlockBreak
 */

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixinGobberForce extends LivingEntity
{
    @Shadow public abstract void readCustomDataFromNbt(NbtCompound nbt);
    @Shadow public abstract void writeCustomDataToNbt(NbtCompound nbt);

    protected PlayerEntityMixinGobberForce(EntityType<? extends LivingEntity> type, World world)
    {
        super(type, world);
    }

    // Run various tasks each player tick
    @Inject(method = "tick", at = @At("TAIL"))
    public void gobberForceTick(CallbackInfo ci)
    {
        if(world instanceof ServerWorld && Gobber2.CONFIG.GENERAL.enableGobberForce)
        {
            PlayerEntity player = (PlayerEntity) (Object) this;
            GobberForceManager.update(player);
        }
    }

    // Gobber Force damage shield
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void gobberForceDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir)
    {
        if(world instanceof ServerWorld && Gobber2.CONFIG.GENERAL.enableGobberForce)
        {
            PlayerEntity player = (PlayerEntity) (Object) this;
            int damageAmount = (int) amount;

            // GobberForce Damage Shield
            if((PlayerEquipUtil.isWearingFullArmor(player)) &&
                    Gobber2.CONFIG.GENERAL.enableGFDamageShield &&
                    (GobberForceManager.getGobberForce(player) > Gobber2.CONFIG.GENERAL.forceDamageAbsorbLevel))
            {
                if(damageAmount <= GobberForceManager.getGobberForce(player))
                {
                    GobberForceManager.subtractGobberForce(player, damageAmount);
                    player.sendMessage((Text.translatable("gobber2.gobber_force.damage_absorbed", damageAmount).formatted(Formatting.GREEN).formatted(Formatting.BOLD)), true);

                    if(source.getAttacker() != null)
                    {
                        Entity attacker = source.getAttacker();

                        if(player.squaredDistanceTo(attacker) <= 4.0D)
                        {
                            Vec3d vec = new Vec3d(attacker.getX() - player.getX(), attacker.getY() - player.getY(), attacker.getZ() - player.getZ());
                            attacker.addVelocity(vec.x * 2, vec.y * 3, vec.z * 2);
                        }
                    }

                    cir.setReturnValue(false);
                }
                else if(damageAmount > GobberForceManager.getGobberForce(player))
                {
                    int excessDamage = damageAmount - GobberForceManager.getGobberForce(player);
                    amount = damageAmount - excessDamage;
                    player.sendMessage((Text.translatable("gobber2.gobber_force.damage_reduced", excessDamage).formatted(Formatting.RED).formatted(Formatting.BOLD)), true);
                    GobberForceManager.subtractGobberForce(player, excessDamage);
                }
            }
        }
    }

    // Cancel exhaustion
    @Inject(method = "addExhaustion", at = @At("HEAD"), cancellable = true)
    public void gobberForceAddExhaustion(float exhaustion, CallbackInfo ci)
    {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if(!player.world.isClient &&
                PlayerEquipUtil.isWearingFullArmor(player) &&
                Gobber2.CONFIG.GENERAL.enableGFVigor)
        {
            if((exhaustion > 0.0F) && (GobberForceManager.getGobberForce(player) > Gobber2.CONFIG.GENERAL.forceExhausionLevel))
            {
                player.sendMessage((Text.translatable("gobber2.gobber_force.vigor").formatted(Formatting.DARK_BLUE).formatted(Formatting.BOLD)), true);
                GobberForceManager.subtractGobberForce(player, Gobber2.CONFIG.GENERAL.forceExhausionCost);
                ci.cancel();
            }
        }
    }

    // Add writeNbt to player class
    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeNbtGobberForce(NbtCompound nbt, CallbackInfo ci)
    {
        if(world instanceof ServerWorld && Gobber2.CONFIG.GENERAL.enableGobberForce)
        {
            GobberForceManager.writeNbt(nbt);
        }
    }

    // Add readNbt to player class
    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readNbtGobberForce(NbtCompound nbt, CallbackInfo ci)
    {
        if(world instanceof ServerWorld && Gobber2.CONFIG.GENERAL.enableGobberForce)
        {
            if(nbt.contains("gobberForce"))
            {
                GobberForceManager.readNbt(nbt);
            }
        }
    }
}
