package com.xiaoxue333.earringmod.item;

import com.xiaoxue333.earringmod.EarringMod;
import com.xiaoxue333.earringmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EarringMod.MODID);

    public static final Supplier<CreativeModeTab> EARRING_ITEMS_TAB = CREATIVE_MODE_TAB.register("earring_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.EARRING.get()))
                    .title(Component.translatable("creativetab.earringmod.earring_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.EARRING);
                        output.accept(ModItems.DONATIONS);
                        output.accept(ModBlocks.DONATION_BOX);
                    })
                    .build());




    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
