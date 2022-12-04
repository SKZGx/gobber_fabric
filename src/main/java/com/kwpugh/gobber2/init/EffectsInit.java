package com.kwpugh.gobber2.init;

import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.effects.Blessing;
import com.kwpugh.gobber2.effects.Experience;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EffectsInit 
{	
	public static final StatusEffect EXPERIENCE = new Experience();
    public static final StatusEffect BLESSING = new Blessing();

    public static void registerEffects()   
    {
    	Registry.register(Registries.STATUS_EFFECT, new Identifier(Gobber2.MOD_ID, "experience"), EXPERIENCE);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Gobber2.MOD_ID, "blessing"), BLESSING);
    }
}