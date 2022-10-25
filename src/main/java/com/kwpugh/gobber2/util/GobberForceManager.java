package com.kwpugh.gobber2.util;

import com.kwpugh.gobber2.Gobber2;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

/*
    Collection of methods to
    support GobberForce

    - natural gobber force regen
    - player air refresh
    - player food restore
    - player health restore
    - extra yellow hearts
    - remove of bad omen curse

    Also relies on:
    - VillagerEntityMixinGobberForce for Charisma
    - AfterKilledOtherEntityEvent for earning GF from kills
    - PlayerBlockBreakEvent for earning GF from mining
    - PlayerEntityMixinGobberForce for tick update, damage shield, and vigor
 */

public class GobberForceManager
{
    private static int gobberForce;
    static int regenRate;

    // various methods trigger on every player tick
    public static void update(PlayerEntity player)
    {
        if(!player.world.isClient)
        {
            if(PlayerEquipUtil.isWearingFullArmor(player))
            {
                // Naturally earned gobber force
                if(Gobber2.CONFIG.GENERAL.enableGFNaturalRegen)
                {
                    regenRate = getArmorRegenDelay(player);

                    if((getGobberForce(player) < Integer.MAX_VALUE) && (player.age % regenRate == 0))
                    {
                        addGobberForce(player, Gobber2.CONFIG.GENERAL.forceEarnedFullArmor);
                    }
                }

                // Provide max air
                if(Gobber2.CONFIG.GENERAL.enableGFBreathing)
                {
                    if(player.getAir() < 2 && getGobberForce(player) > Gobber2.CONFIG.GENERAL.forceAirLevel)
                    {
                        player.setAir(300);
                        subtractGobberForce(player, Gobber2.CONFIG.GENERAL.forceAirCost);
                        player.sendMessage((Text.translatable("gobber2.gobber_force.breathing").formatted(Formatting.AQUA).formatted(Formatting.BOLD)), true);
                    }
                }

                // Restore food level
                if(Gobber2.CONFIG.GENERAL.enableGFAutoFeed)
                {
                    if((player.getHungerManager().getFoodLevel() < 20) && (getGobberForce(player) > Gobber2.CONFIG.GENERAL.forceHungerRestoreLevel))
                    {
                        player.getHungerManager().setFoodLevel(40);
                        subtractGobberForce(player, Gobber2.CONFIG.GENERAL.forceHungerRestoreCost);
                        player.sendMessage((Text.translatable("gobber2.gobber_force.feeding").formatted(Formatting.DARK_BLUE).formatted(Formatting.BOLD)), true);
                    }
                }

                // Restore full health
                if((player.getHealth() < 15) && (getGobberForce(player) > Gobber2.CONFIG.GENERAL.forceHealthRestoreLevel))
                {
                    player.setHealth(20.0F);
                    subtractGobberForce(player, Gobber2.CONFIG.GENERAL.forceHealthRestoreCost);
                    player.sendMessage((Text.translatable("gobber2.gobber_force.healing").formatted(Formatting.DARK_GRAY).formatted(Formatting.BOLD)), true);
                }

                // Give extra hearts
                if(Gobber2.CONFIG.GENERAL.enableGFExtraHearts)
                {
                    if((player.getHealth() == 20) && (getGobberForce(player) > Gobber2.CONFIG.GENERAL.forceExtraHeartsLevel))
                    {
                        float current = player.getAbsorptionAmount();
                        if(current < Gobber2.CONFIG.GENERAL.forceExtraHeartsGobber)
                        {
                            player.setAbsorptionAmount(current + 1.0F);
                            subtractGobberForce(player, Gobber2.CONFIG.GENERAL.forceExtraHeartsCost);
                            player.sendMessage((Text.translatable("gobber2.gobber_force.extra_hearts").formatted(Formatting.YELLOW).formatted(Formatting.BOLD)), true);
                        }
                    }
                }

                // Remove Bad Omen
                if(Gobber2.CONFIG.GENERAL.enableGFBadOmen && (getGobberForce(player) > Gobber2.CONFIG.GENERAL.forceRemoveBadOmenLevel))
                {
                    if(player.hasStatusEffect(StatusEffects.BAD_OMEN))
                    {
                        player.removeStatusEffect(StatusEffects.BAD_OMEN);
                        subtractGobberForce(player, Gobber2.CONFIG.GENERAL.forceRemoveBadOmenCost);
                        player.sendMessage((Text.translatable("gobber2.gobber_force.bad_omen").formatted(Formatting.DARK_PURPLE).formatted(Formatting.BOLD)), true);
                    }
                }
            }
        }
    }

    public static int getArmorRegenDelay(PlayerEntity player)
    {
        int rate = 0;

        if(PlayerEquipUtil.isWearingGobberArmor(player)) rate = Gobber2.CONFIG.GENERAL.forceNaturalRegenDelayGobber;
        if(PlayerEquipUtil.isWearingNetherArmor(player)) rate = Gobber2.CONFIG.GENERAL.forceNaturalRegenDelayNether;
        if(PlayerEquipUtil.isWearingEndArmor(player)) rate = Gobber2.CONFIG.GENERAL.forceNaturalRegenDelayEnd;
        if(PlayerEquipUtil.isWearingDragonArmor(player)) rate = Gobber2.CONFIG.GENERAL.forceNaturalRegenDelayDragon;

        return rate;
    }

    public static int getGobberForce(PlayerEntity player)
    {
        return gobberForce;
    }

    public static boolean canEnchantInAnvil(PlayerEntity player, int amount)
    {
        if(getGobberForce(player) > amount)
        {
            subtractGobberForce(player, amount);
            return true;
        }

        return false;
    }

    public static void addGobberForce(PlayerEntity player, int amount)
    {
        if(!player.world.isClient)
        {
            if(PlayerEquipUtil.isWearingFullArmor(player))
            {
                if(getGobberForce(player) < Integer.MAX_VALUE)
                {
                    gobberForce = gobberForce + amount;
                }
            }
        }
    }

    public static void subtractGobberForce(PlayerEntity player, int amount)
    {
        if(!player.world.isClient)
        {
            if(amount > getGobberForce(player))
            {
                gobberForce = 0;
            }
            else
            {
                gobberForce = gobberForce - amount;
            }
        }
    }

    public static void clearGobberForce(PlayerEntity player)
    {
        if(!player.world.isClient)
        {
            gobberForce = 0;
        }
    }

    // called from PlayerEntityMixinGobberForce#tick()
    public static void readNbt(NbtCompound nbt)
    {
        if(nbt.contains("gobberForce"))
        {
            gobberForce = nbt.getInt("gobberForce");
        }
    }

    // called from PlayerEntityMixinGobberForce#tick()
    public static void writeNbt(NbtCompound nbt)
    {
        nbt.putInt("gobberForce", gobberForce);
    }
}
