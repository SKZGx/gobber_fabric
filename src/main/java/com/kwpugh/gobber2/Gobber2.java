package com.kwpugh.gobber2;

import com.kwpugh.gobber2.config.Gobber2Config;
import com.kwpugh.gobber2.events.ModEvents;
import com.kwpugh.gobber2.init.*;
import com.kwpugh.gobber2.util.GobberGroup;
import com.kwpugh.gobber2.world.GobberOreBiomeModifications;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gobber2 implements ModInitializer
{
	public static final String MOD_ID = "gobber2";
	public static final Gobber2Config CONFIG = AutoConfig.register(Gobber2Config.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new)).getConfig();
	public static final Logger LOGGER = LogManager.getLogger(Gobber2.class);

    @Override
    public void onInitialize()
    {
    	BlockInit.registerBlocks();
    	BlockInit.registerBlockItems();
    	BlockInit.registerBlockEntities();
    	ItemInit.registerItems();
    	GobberGroup.addGroup();
		GobberOreBiomeModifications.addOres();
    	FuelInit.registerFuels();;
    	EnchantmentInit.registerEnchantments();
    	EffectsInit.registerEffects();
		EntityInit.registerEntities();
		DispenserBehaviorInit.registerBehaviors();
		TraderOffersInit.registerOffers();
		ModEvents.registerEvents();
    }
}