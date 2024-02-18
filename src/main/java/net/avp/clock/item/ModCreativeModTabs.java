package net.avp.clock.item;

import net.avp.clock.TutorialMod;
import net.avp.clock.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    // DeferredRegister for custom creative mode tabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    // Custom creative mode tab: Random Tab, icon item poop
    public static final RegistryObject<CreativeModeTab> RANDOM_TAB = CREATIVE_MODE_TABS.register("random_tab",
            ()   -> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.POOP.get()))
                    .title(Component.translatable("creativetab_random_tab"))
                    .displayItems((itemDisplayParameters, output) ->{

                        // Add custom items to the creative mode tab
                        output.accept(ModItems.POOP.get());
                        output.accept(ModItems.BOLELLI.get());
                        output.accept(ModItems.URANIUM.get());
                        output.accept(ModItems.PLATINUM.get());

                        output.accept(ModBlocks.BLOCCO_MERDA.get());
                        output.accept(ModBlocks.BLOCCO_MANUG.get());
                        output.accept(ModBlocks.BLOCCO_NETHERURANIUM.get());
                        output.accept(ModBlocks.BLOCCO_URANIUM.get());
                        output.accept(ModBlocks.BLOCCO_PLATINUM.get());
                        output.accept(ModBlocks.URANIUM_GREZZO.get());
                        output.accept(ModBlocks.PLATINUM_GREZZO.get());

                    })

                    .build());

    // Register the DeferredRegister
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
