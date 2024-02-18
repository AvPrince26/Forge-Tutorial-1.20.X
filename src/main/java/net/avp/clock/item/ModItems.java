package net.avp.clock.item;

import net.avp.clock.TutorialMod;
import net.avp.clock.item.custom.Fuelitem;
import net.avp.clock.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // DeferredRegister for items
   public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
//Items
public static final RegistryObject<Item> POOP = ITEMS.register("poop",
        () ->new Item(new Item.Properties()));
public static final RegistryObject<Item> BOLELLI = ITEMS.register("bolelli",
        () ->new Fuelitem(new Item.Properties(),400));
public static final RegistryObject<Item> ALEXANDER = ITEMS.register("alexander",
        () ->new Item(new Item.Properties()));
public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium",
        () ->new Item(new Item.Properties()));
public static final RegistryObject<Item> PLATINUM = ITEMS.register("platinum",
        () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () ->new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () ->new MetalDetectorItem(new Item.Properties().durability(100)));

// Register the DeferredRegister
public static void  register(IEventBus eventBus) {
    ITEMS.register(eventBus);
}

}
