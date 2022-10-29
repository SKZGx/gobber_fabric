package com.kwpugh.gobber2.util;

import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.init.BlockInit;
import com.kwpugh.gobber2.init.ItemInit;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

public class GobberGroup
{
    public static void addGroup()
    {
        // force class run when we want
    }

    public static final ItemGroup GOBBER2_GROUP = new FabricItemGroup(new Identifier(Gobber2.MOD_ID, "gobber2_group"))
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ItemInit.GOBBER2_SWORD_NETHER);
        }

        @Override
        protected void addItems(FeatureSet enabledFeatures, Entries entries)
        {
            entries.add(BlockInit.GOBBER2_LUCKY_BLOCK);
            entries.add(BlockInit.GOBBER2_LUCKY_BLOCK_DEEPSLATE);
            entries.add(BlockInit.GOBBER2_LUCKY_BLOCK_NETHER);
            entries.add(BlockInit.GOBBER2_LUCKY_BLOCK_END);

            entries.add(BlockInit.GOBBER2_ORE);
            entries.add(BlockInit.GOBBER2_ORE_DEEPSLATE);
            entries.add(BlockInit.GOBBER2_ORE_NETHER);
            entries.add(BlockInit.GOBBER2_ORE_END);

            entries.add(BlockInit.GOBBER2_BLOCK);
            entries.add(BlockInit.GOBBER2_BLOCK_NETHER);
            entries.add(BlockInit.GOBBER2_BLOCK_END);

            entries.add(BlockInit.GOBBER2_GLASS);
            entries.add(BlockInit.GOBBER2_GLASS_NETHER);
            entries.add(BlockInit.GOBBER2_GLASS_END);
            entries.add(BlockInit.CLEAR_GLASS);

            entries.add(ItemInit.GOBBER2_GLOBETTE);
            entries.add(ItemInit.GOBBER2_GLOBETTE_NETHER);
            entries.add(ItemInit.GOBBER2_GLOBETTE_END);
            entries.add(ItemInit.GOBBER2_GLOB);
            entries.add(ItemInit.GOBBER2_GLOB_NETHER);
            entries.add(ItemInit.GOBBER2_GLOB_END);
            entries.add(ItemInit.GOBBER2_FOO);
            entries.add(ItemInit.GOBBER2_FOO_NETHER);
            entries.add(ItemInit.GOBBER2_FOO_END);
            entries.add(ItemInit.GOBBER2_GOO);
            entries.add(ItemInit.GOBBER2_GOOEY_APPLE);
            entries.add(ItemInit.GOBBER2_GOOEY_BEEF);
            entries.add(ItemInit.GOBBER2_GOOEY_BEEFSTEW);
            entries.add(ItemInit.GOBBER2_GOOEY_BREAD);
            entries.add(ItemInit.GOBBER2_GOO_NETHER);
            entries.add(ItemInit.GOBBER2_GOOEY_APPLE_NETHER);
            entries.add(ItemInit.GOBBER2_GOOEY_BEEF_NETHER);
            entries.add(ItemInit.GOBBER2_GOOEY_BEEFSTEW_NETHER);
            entries.add(ItemInit.GOBBER2_GOOEY_BREAD_NETHER);
            entries.add(ItemInit.GOBBER2_INGOT);
            entries.add(ItemInit.GOBBER2_INGOT_NETHER);
            entries.add(ItemInit.GOBBER2_INGOT_END);
            entries.add(ItemInit.GOBBER2_ROD);
            entries.add(ItemInit.GOBBER2_ROD_NETHER);
            entries.add(ItemInit.GOBBER2_ROD_END);
            entries.add(ItemInit.GOBBER2_RING);
            entries.add(ItemInit.GOBBER2_RING_NETHER);
            entries.add(ItemInit.GOBBER2_RING_END);
            entries.add(ItemInit.GOBBER2_MEDALLION);
            entries.add(ItemInit.GOBBER2_MEDALLION_NETHER);
            entries.add(ItemInit.GOBBER2_MEDALLION_END);

            entries.add(ItemInit.GOBBER2_SWORD);
            entries.add(ItemInit.GOBBER2_SWORD_NETHER);
            entries.add(ItemInit.GOBBER2_SWORD_END);
            entries.add(ItemInit.GOBBER2_SWORD_SNIPER);
            entries.add(ItemInit.GOBBER2_BOW);
            entries.add(ItemInit.GOBBER2_BOW_NETHER);
            entries.add(ItemInit.GOBBER2_BOW_END);
            entries.add(ItemInit.GOBBER2_ARROW);
            entries.add(ItemInit.GOBBER2_ARROW_NETHER);
            entries.add(ItemInit.GOBBER2_ARROW_END);
            entries.add(ItemInit.GOBBER2_PICKAXE);
            entries.add(ItemInit.GOBBER2_PICKAXE_NETHER);
            entries.add(ItemInit.GOBBER2_PICKAXE_END);
            entries.add(ItemInit.GOBBER2_AXE);
            entries.add(ItemInit.GOBBER2_AXE_NETHER);
            entries.add(ItemInit.GOBBER2_AXE_END);
            entries.add(ItemInit.GOBBER2_SHOVEL);
            entries.add(ItemInit.GOBBER2_SHOVEL_NETHER);
            entries.add(ItemInit.GOBBER2_SHOVEL_END);
            entries.add(ItemInit.GOBBER2_HOE);
            entries.add(ItemInit.GOBBER2_HOE_NETHER);
            entries.add(ItemInit.GOBBER2_HOE_END);
            entries.add(ItemInit.GOBBER2_PAXEL);
            entries.add(ItemInit.GOBBER2_PAXEL_NETHER);
            entries.add(ItemInit.GOBBER2_PAXEL_END);
            entries.add(ItemInit.GOBBER2_PAXEL_STARS);
            entries.add(ItemInit.GOBBER2_HAMMER);
            entries.add(ItemInit.GOBBER2_HAMMER_NETHER);
            entries.add(ItemInit.GOBBER2_HAMMER_END);
            entries.add(ItemInit.GOBBER2_EXCAVATOR);
            entries.add(ItemInit.GOBBER2_EXCAVATOR_NETHER);
            entries.add(ItemInit.GOBBER2_EXCAVATOR_END);
            entries.add(ItemInit.GOBBER2_TREE_AXE);
            entries.add(ItemInit.GOBBER2_TREE_AXE_NETHER);
            entries.add(ItemInit.GOBBER2_TREE_AXE_END);

            entries.add(ItemInit.GOBBER2_HELMET);
            entries.add(ItemInit.GOBBER2_CHESTPLATE);
            entries.add(ItemInit.GOBBER2_LEGGINGS);
            entries.add(ItemInit.GOBBER2_BOOTS);
            entries.add(ItemInit.GOBBER2_HELMET_NETHER);
            entries.add(ItemInit.GOBBER2_CHESTPLATE_NETHER);
            entries.add(ItemInit.GOBBER2_LEGGINGS_NETHER);
            entries.add(ItemInit.GOBBER2_BOOTS_NETHER);
            entries.add(ItemInit.GOBBER2_HELMET_END);
            entries.add(ItemInit.GOBBER2_CHESTPLATE_END);
            entries.add(ItemInit.GOBBER2_LEGGINGS_END);
            entries.add(ItemInit.GOBBER2_BOOTS_END);
            entries.add(ItemInit.DRAGON_ELYTRA);
            entries.add(ItemInit.DRAGON_STAR);
            entries.add(ItemInit.GOBBER2_HELMET_DRAGON);
            entries.add(ItemInit.GOBBER2_CHESTPLATE_DRAGON);
            entries.add(ItemInit.GOBBER2_LEGGINGS_DRAGON);
            entries.add(ItemInit.GOBBER2_BOOTS_DRAGON);

            entries.add(ItemInit.GOBBER2_RING_ATTRACTION);
            entries.add(ItemInit.GOBBER2_RING_RETURN);
            entries.add(ItemInit.GOBBER2_RING_SWIFTNESS);
            entries.add(ItemInit.GOBBER2_RING_FARMER);
            entries.add(ItemInit.GOBBER2_RING_MINER);
            entries.add(ItemInit.GOBBER2_RING_ASCENT);
            entries.add(ItemInit.GOBBER2_RING_SUNSHINE);
            entries.add(ItemInit.GOBBER2_RING_ABOVE);
            entries.add(ItemInit.GOBBER2_RING_LUCK);
            entries.add(ItemInit.GOBBER2_RING_CURING);
            entries.add(ItemInit.GOBBER2_RING_VISION);
            entries.add(ItemInit.GOBBER2_RING_STRENGTH);
            entries.add(ItemInit.GOBBER2_RING_HASTE);
            entries.add(ItemInit.GOBBER2_RING_PHOENIX);
            entries.add(ItemInit.GOBBER2_RING_REPAIR);
            entries.add(ItemInit.GOBBER2_RING_AIRWALKING);
            entries.add(ItemInit.GOBBER2_RING_ENDERCHEST);
            entries.add(ItemInit.GOBBER2_RING_EXPLORER);
            entries.add(ItemInit.GOBBER2_RING_BLINK);
            entries.add(ItemInit.GOBBER2_RING_VOID);
            entries.add(ItemInit.GOBBER2_RING_TELEPORT);
            entries.add(ItemInit.GOBBER2_RING_DISMISSAL);
            entries.add(ItemInit.GOBBER2_RING_STEALTH);
            entries.add(ItemInit.GOBBER2_RING_TRAVELER);

            entries.add(ItemInit.GOBBER2_MEDALLION_BREATHING);
            entries.add(ItemInit.GOBBER2_MEDALLION_HEALING);
            entries.add(ItemInit.GOBBER2_MEDALLION_HERO);
            entries.add(ItemInit.GOBBER2_MEDALLION_EXP);
            entries.add(ItemInit.GOBBER2_MEDALLION_HEALING2);
            entries.add(ItemInit.GOBBER2_MEDALLION_SHIELDING);
            entries.add(ItemInit.GOBBER2_MEDALLION_SEA);
            entries.add(ItemInit.GOBBER2_MEDALLION_HEALING3);
            entries.add(ItemInit.GOBBER2_MEDALLION_SUFFERING);

            entries.add(ItemInit.GOBBER2_STAFF_CLEARING);
            entries.add(ItemInit.GOBBER2_STAFF_TRANSFORMATION);
            entries.add(ItemInit.GOBBER2_STAFF_ENSNAREMENT);
            entries.add(ItemInit.GOBBER2_STAFF_FARMER);
            entries.add(ItemInit.GOBBER2_STAFF_NATURE);
            entries.add(ItemInit.GOBBER2_STAFF_STARS);
            entries.add(ItemInit.GOBBER2_STAFF_HOSTILE_ENSNAREMENT);
            entries.add(ItemInit.GOBBER2_STAFF_SNIPER);
            entries.add(ItemInit.GOBBER2_STAFF_CHANNELING);

            entries.add(ItemInit.GOBBER2_SPECIAL_ITEM);
        }
    };
}
