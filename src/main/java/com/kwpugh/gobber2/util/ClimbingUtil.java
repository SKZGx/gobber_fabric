package com.kwpugh.gobber2.util;

import com.kwpugh.gobber2.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/*
    Wall climbing for Ring of Ascent

    Credit to Technovision and
    code in Advancced Genetics
    for basis of design
 */

public class ClimbingUtil
{
    public static boolean canClimb(World world, LivingEntity livingEntity)
    {
        boolean value = false;  // just to be safe, should be false when called

        if(livingEntity instanceof PlayerEntity player)
        {
            BlockPos pos = player.getBlockPos();

            if(PlayerEquipUtil.hasItemInInventory(player, ItemInit.GOBBER2_RING_ASCENT))
            {
                ItemStack ring = PlayerEquipUtil.getItemStackInInventory(player, ItemInit.GOBBER2_RING_ASCENT);
                if(!EnableUtil.isEnabled(ring)) return value;

                BlockState stateNorth = world.getBlockState(pos.north());
                BlockState stateSouth = world.getBlockState(pos.south());
                BlockState stateEast = world.getBlockState(pos.east());
                BlockState stateWest = world.getBlockState(pos.west());

                if(player.isOnGround())  // starting point
                {
                    if(canBeginClimbing(player.world, pos.north(), pos.south(), pos.east(), pos.west(), stateNorth, stateSouth, stateEast, stateWest))
                    {
                        value = true;
                    }
                }
                else if(canContinueClimbing(stateNorth, stateSouth, stateEast, stateWest))
                {
                    value = true;
                }
            }
        }

        return value;
    }

    public static boolean canBeginClimbing(World world, BlockPos north, BlockPos south, BlockPos east, BlockPos west, BlockState stateNorth, BlockState stateSouth, BlockState stateEast, BlockState stateWest)
    {
        BlockState stateNorthUp = world.getBlockState(north.up());
        BlockState stateSouthUp = world.getBlockState(south.up());
        BlockState stateEastUp = world.getBlockState(east.up());
        BlockState stateWestUp = world.getBlockState(west.up());

        if(checkBeginSpace(stateNorth, stateNorthUp))
        {
            return true;
        }
        else if(checkBeginSpace(stateSouth, stateSouthUp))
        {
            return true;
        }
        else if(checkBeginSpace(stateEast, stateEastUp))
        {
            return true;
        }
        return checkBeginSpace(stateWest, stateWestUp);
    }

    public static boolean checkBeginSpace(BlockState state, BlockState stateUp)
    {
        return !state.isAir() && !stateUp.isAir() && !state.isIn(BlockTags.REPLACEABLE_PLANTS) && !stateUp.isIn(BlockTags.REPLACEABLE_PLANTS);
    }

    public static boolean canContinueClimbing(BlockState stateNorth, BlockState stateSouth, BlockState stateEast, BlockState stateWest)
    {
        if(checkContinueSpace(stateNorth))
        {
            return true;
        }
        if(checkContinueSpace(stateSouth))
        {
            return true;
        }
        if(checkContinueSpace(stateEast))
        {
            return true;
        }
        return checkContinueSpace(stateWest);
    }

    public static boolean checkContinueSpace(BlockState state)
    {
        return !state.isAir() && !state.isIn(BlockTags.REPLACEABLE_PLANTS);
    }
}