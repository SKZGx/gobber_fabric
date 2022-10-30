package com.kwpugh.gobber2.blocks;

import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.config.Gobber2Config;
import com.kwpugh.gobber2.init.BlockInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.List;

public class BaseOreBlock extends ExperienceDroppingBlock
{
    public static final Gobber2Config.Ores CONFIG = Gobber2.CONFIG.ORES;
    private static int maxLevel;
    private static int veinSize;
    private static int chunkChance;
    private static String miningLevel;
    private static String spawnDim;
    private static int blastRes;

    public BaseOreBlock(FabricBlockSettings settings)
    {
        super(settings.requiresTool());
        this.settings.requiresTool();
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack, boolean dropExperience)
    {
        super.onStacksDropped(state, world, pos, stack, dropExperience);

        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0)
        {
            this.dropExperience(world, pos, CONFIG.luckyExpOrbs);
        }
    }

    @Override
    public float getBlastResistance()
    {
        return Gobber2.CONFIG.ORES.oreBlastResistance;
    }
}


