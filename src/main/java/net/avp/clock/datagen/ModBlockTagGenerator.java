package net.avp.clock.datagen;

import net.avp.clock.TutorialMod;
import net.avp.clock.block.ModBlocks;
import net.avp.clock.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator  extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PLATINUM_GREZZO.get(),
                ModBlocks.BLOCCO_PLATINUM.get(),
                ModBlocks.BLOCCO_MANUG.get(),
                ModBlocks.URANIUM_GREZZO.get(),
                ModBlocks.BLOCCO_URANIUM.get(),
                ModBlocks.BLOCCO_NETHERURANIUM.get(),
                ModBlocks.BLOCCO_MERDA.get(),
                ModBlocks.SOUND_BLOCK.get());


        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.PLATINUM_GREZZO.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PLATINUM_GREZZO.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SOUND_BLOCK.get());
    }
}
