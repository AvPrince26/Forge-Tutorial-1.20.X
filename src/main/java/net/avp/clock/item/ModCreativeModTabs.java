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
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RANDOM_TAB = CREATIVE_MODE_TABS.register("random_tab",
            ()   -> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.POOP.get()))
                    .title(Component.translatable("creativetab_random_tab"))
                    .displayItems((itemDisplayParameters, output) ->{

                        output.accept(ModItems.POOP.get());
                        output.accept(ModItems.BOLELLI.get());

                        output.accept(ModBlocks.BLOCCO_MERDA.get());
                        output.accept(ModBlocks.BLOCCO_MANUG.get());
                    })

                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
