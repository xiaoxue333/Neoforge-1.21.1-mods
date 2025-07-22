package com.xiaoxue333.earrring.item;

import com.xiaoxue333.earrring.EarringMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EarringMod.MODID);

    public static final DeferredItem<Item> EARRING = ITEMS.register("earring",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DONATIONS = ITEMS.register("donations",
            ()->new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
