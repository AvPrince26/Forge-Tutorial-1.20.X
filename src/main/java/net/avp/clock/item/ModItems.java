package net.avp.clock.item;

import net.avp.clock.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
   public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

public static final RegistryObject<Item> POOP = ITEMS.register("poop",
        () ->new Item(new Item.Properties()));
public static final RegistryObject<Item> BOLELLI = ITEMS.register("bolelli",
        () ->new Item(new Item.Properties()));
public static final RegistryObject<Item> ALEXANDER = ITEMS.register("alexander",
        () ->new Item(new Item.Properties()));


public static void  register(IEventBus eventBus) {
    ITEMS.register(eventBus);
}

}
