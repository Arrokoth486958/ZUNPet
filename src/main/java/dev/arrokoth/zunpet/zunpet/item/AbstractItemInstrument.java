package dev.arrokoth.zunpet.zunpet.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
public abstract class AbstractItemInstrument extends Item {
    public AbstractItemInstrument(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i) {
        if (livingEntity instanceof Player player) {
            player.awardStat(Stats.ITEM_USED.get(this));
        }
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int i) {
        if (level.getGameTime() % 3 != 0) {
            return;
        }

        if (livingEntity instanceof Player player) {
            playSound(level, player);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.startUsingItem(interactionHand);
        playSound(level, player);
        return InteractionResultHolder.consume(player.getItemInHand(interactionHand));
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 400;
    }

    public void playSound(Level level, Player player) {
        float pitch = Math.abs(player.xRotO / 90f) + 1;

        if (player.xRotO > 0) {
            pitch = (1 - pitch + 1) / 2f + 0.5f;
        }

        level.playSound(player, new BlockPos(player.position()), getSound(), SoundSource.PLAYERS, 2, pitch);
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BOW;
    }

    public abstract SoundEvent getSound();
}
