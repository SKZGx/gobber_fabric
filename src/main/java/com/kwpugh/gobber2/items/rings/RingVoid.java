package com.kwpugh.gobber2.items.rings;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RingVoid extends BaseRing
{
	public RingVoid(Item.Settings settings)
	{
		super(settings);
	}
		
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
	{
		ItemStack stack = player.getStackInHand(hand);
		
		if (!world.isClient && !player.isSneaking())
		{		
			   if (world instanceof ServerWorld)
			   {
			         RegistryKey<World> registryKey = world.getRegistryKey() == World.END ? World.OVERWORLD : World.END;
			         ServerWorld serverWorld = ((ServerWorld)world).getServer().getWorld(registryKey);
			
			         if (serverWorld == null) 
			         {
			        	 return TypedActionResult.success(stack);
			         }

			         player.moveToWorld(serverWorld);
			   }
			   	
			   return TypedActionResult.success(stack);			
		}
		
		return TypedActionResult.success(stack);
	}
	
	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) 
	{
	    tooltip.add(Text.translatable("item.gobber2.gobber2_ring_void.tip1").formatted(Formatting.GREEN));
	    tooltip.add(Text.translatable("item.gobber2.right_click_activate").formatted(Formatting.YELLOW));
	}   
}