package dev.arrokoth.zunpet.zunpet;

import dev.arrokoth.zunpet.zunpet.item.ItemZunpet;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

/**
 * @author Arrokoth
 * @project Zunpet
 * @copyright Copyright © 2025 Arrokoth All Rights Reserved.
 */
public class Zunpet implements ModInitializer {
    public static final String MOD_ID = "zunpet";

    public static final Item ZUN_PET_ITEM = Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "zunpet"), new ItemZunpet(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final SoundEvent ZUN_PET_SOUND_EVENT = Registry.register(Registry.SOUND_EVENT, new ResourceLocation(MOD_ID, "zunpet"), new SoundEvent(new ResourceLocation(MOD_ID, "zunpet")));

    @Override
    public void onInitialize() {
    }
}
