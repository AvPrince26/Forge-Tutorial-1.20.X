package net.avp.clock.block;

import net.avp.clock.TutorialMod;
import net.avp.clock.block.custom.soundBlock;
import net.avp.clock.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
public class ModBlocks {
//  DeferredRegister for custom blocks
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> BLOCCO_MERDA = registerBlock("blocco_merda",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.MUD)));
    public static final RegistryObject<Block> BLOCCO_MANUG = registerBlock("blocco_manug",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GRAVEL)));



    public static final RegistryObject<Block> BLOCCO_NETHERURANIUM = registerBlock("blocco_netheruranium",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                    .strength(15f).requiresCorrectToolForDrops(), UniformInt.of(1,10)));
    public static final RegistryObject<Block> BLOCCO_URANIUM = registerBlock("blocco_uranium",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                    .strength(7f).requiresCorrectToolForDrops(), UniformInt.of(1,6)));
    public static final RegistryObject<Block> BLOCCO_PLATINUM = registerBlock("blocco_platinum",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                    .strength(7f).requiresCorrectToolForDrops(), UniformInt.of(1,6)));

    public static final RegistryObject<Block> URANIUM_GREZZO = registerBlock("uranium_grezzo",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                    .strength(7f).requiresCorrectToolForDrops(), UniformInt.of(1,6)));
    public static final RegistryObject<Block> PLATINUM_GREZZO = registerBlock("platinum_grezzo",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                    .strength(7f).requiresCorrectToolForDrops(), UniformInt.of(1,6)));


    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new soundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GRAVEL)));


    // Generic method to register a block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    // Register the corresponding block item
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    // Register the DeferredRegister
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
