package dev.arrokoth.zunpet.zunpet.item;

import dev.arrokoth.zunpet.zunpet.Zunpet;
import net.minecraft.sounds.SoundEvent;

/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
public class ItemZunpet extends AbstractItemInstrument {
    public ItemZunpet(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public SoundEvent getSound() {
        return Zunpet.ZUN_PET_SOUND_EVENT;
    }
}
