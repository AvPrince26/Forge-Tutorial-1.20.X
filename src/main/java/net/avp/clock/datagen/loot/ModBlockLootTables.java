package net.avp.clock.datagen.loot;

import net.avp.clock.block.ModBlocks;
import net.avp.clock.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
    this.dropSelf(ModBlocks.SOUND_BLOCK.get());
    this.dropSelf(ModBlocks.BLOCCO_MERDA.get());
    this.dropSelf(ModBlocks.BLOCCO_URANIUM.get());
    this.dropSelf(ModBlocks.BLOCCO_MANUG.get());
    this.dropSelf(ModBlocks.BLOCCO_PLATINUM.get());

    this.add(ModBlocks.URANIUM_GREZZO.get(),
            block  -> createCopperOreDrops(ModBlocks.URANIUM_GREZZO.get(),ModItems.URANIUM.get()));
    this.add(ModBlocks.PLATINUM_GREZZO.get(),
            block  -> createCopperOreDrops(ModBlocks.PLATINUM_GREZZO.get(),ModItems.PLATINUM.get()));
    }

    protected LootTable.Builder createCopperOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                        this.applyExplosionDecay(pBlock,
                                LootItem.lootTableItem(Items.REDSTONE)
                                .apply(SetItemCountFunction
                                .setCount(UniformGenerator.between
                                (2.0F, 5.0F)))
                                .apply(ApplyBonusCount
                                .addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
