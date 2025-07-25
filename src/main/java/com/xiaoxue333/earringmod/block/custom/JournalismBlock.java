package com.xiaoxue333.earringmod.block.custom;

import com.xiaoxue333.earringmod.EarringMod;
import com.xiaoxue333.earringmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class JournalismBlock extends Block {
    public JournalismBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        float volume = 1;
        float pitch =level.random.nextFloat() *0.2f+0.9f;
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, volume,pitch);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity){
            if(itemEntity.getItem().getItem() == ModItems.DONATIONS.get()){
                itemEntity.setItem(new ItemStack(Items.GOLD_INGOT, itemEntity.getItem().getCount()));

            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
