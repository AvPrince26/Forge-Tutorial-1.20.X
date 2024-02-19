package net.avp.clock.datagen;

import net.avp.clock.TutorialMod;
import net.avp.clock.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output,ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SOUND_BLOCK);
        blockWithItem(ModBlocks.URANIUM_GREZZO);
        blockWithItem(ModBlocks.PLATINUM_GREZZO);
        blockWithItem(ModBlocks.BLOCCO_MANUG);
        blockWithItem(ModBlocks.BLOCCO_NETHERURANIUM);
        blockWithItem(ModBlocks.BLOCCO_URANIUM);
        blockWithItem(ModBlocks.BLOCCO_PLATINUM);
        blockWithItem(ModBlocks.BLOCCO_MERDA);



    }
        private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
            simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
        }

}
