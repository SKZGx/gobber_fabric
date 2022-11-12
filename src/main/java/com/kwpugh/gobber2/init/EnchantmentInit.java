package com.kwpugh.gobber2.init;

import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.enchantments.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registries;
import net.minecraft.util.registry.Registry;

public class EnchantmentInit 
{
	public static final Enchantment APOTROPAIC = new ApotropaicEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
	public static final Enchantment BLESSING = new BlessingEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static final Enchantment BLINDERS = new BlindersEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
	public static final Enchantment FLUID_MASTER = new FluidMasterEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static final Enchantment FASTEROBSIDIAN = new FasterObsidianEnchantment(Enchantment.Rarity.COMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static final Enchantment EXP_BOOST = new ExperienceBoostEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static final Enchantment QUICKUSE = new QuickUseEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static final Enchantment QUIETFEET = new QuietFeetEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
	public static final Enchantment REBUFFING = new RebuffingEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
	public static final Enchantment SMITHBLADE = new SmithBladeEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static final Enchantment SOLIDFOOTING = new SolidFootingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
	public static final Enchantment SUMMONER = new SummonerEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static final Enchantment UNTOUCHABLE = new UntouchableEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS});


	public static void registerEnchantments()
    {
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "apotropaic"), APOTROPAIC);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "blessing"), BLESSING);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "blinders"), BLINDERS);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "faster_obsidian"), FASTEROBSIDIAN);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "fluid_master"), FLUID_MASTER);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "exp_boost"), EXP_BOOST);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "quickuse"), QUICKUSE);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "quietfeet"), QUIETFEET);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "rebuffing"), REBUFFING);
    	Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "smithblade"), SMITHBLADE);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "solidfooting"), SOLIDFOOTING);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "summoner"), SUMMONER);
		Registry.register(Registries.ENCHANTMENT, new Identifier(Gobber2.MOD_ID, "untouchable"), UNTOUCHABLE);
    }
}