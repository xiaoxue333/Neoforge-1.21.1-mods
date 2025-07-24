package com.xiaoxue333.earringmod.item.custom;

import com.xiaoxue333.earringmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class MagnifyingGlassItem extends Item {
    public MagnifyingGlassItem(Properties properties){
        super(new Properties()
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON));
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        // 检查是否右键点击了捐赠箱
        if (state.is(ModBlocks.DONATION_BOX.get())) {
            if (!level.isClientSide()) {
                // 替换为新的方块
                level.setBlock(pos, ModBlocks.BLACK_BOX.get().defaultBlockState(), Block.UPDATE_ALL);


                // 播放音效
                level.playSound(null, pos, SoundEvents.AMETHYST_CLUSTER_STEP,
                        SoundSource.BLOCKS, 0.8F, 1.2F);
            }

            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return InteractionResult.PASS;
    }


}
