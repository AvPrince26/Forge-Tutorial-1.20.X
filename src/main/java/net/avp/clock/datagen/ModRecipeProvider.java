package net.avp.clock.datagen;

import net.avp.clock.TutorialMod;
import net.avp.clock.block.ModBlocks;
import net.avp.clock.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> URANIUM_SMELTABLES = List.of(ModItems.URANIUM.get(),
            ModBlocks.URANIUM_GREZZO.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreBlasting(consumer,URANIUM_SMELTABLES,RecipeCategory.MISC, ModItems.URANIUM.get(), 0.25f,100,"uranium");
        oreSmelting(consumer,URANIUM_SMELTABLES,RecipeCategory.MISC, ModItems.URANIUM.get(), 0.25f,100,"uranium");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCCO_PLATINUM.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.URANIUM.get())
                .unlockedBy(getHasName(ModItems.URANIUM.get()),has(ModItems.URANIUM.get()))
                .save(consumer);

    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}),
            pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
            .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
            .save(pFinishedRecipeConsumer, TutorialMod.MOD_ID + ":" + getItemName(pResult)
            + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
