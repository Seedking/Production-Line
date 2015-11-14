/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 Minecraft-GoodTime <http://github.com/Minecraft-GoodTime>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mcgoodtime.gti.common.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BestOwl on 2015.11.8.0008.
 *
 * @author BestOwl
 */
public class FluidKineticGeneratorRecipes implements IProcessable {
    public static final FluidKineticGeneratorRecipes instance = new FluidKineticGeneratorRecipes();
    /** The list of smelting results. */
    private List<Recipes> processList = new ArrayList<Recipes>();

    private FluidKineticGeneratorRecipes() {
        register(FluidRegistry.getFluidStack("lava", 10));
    }

    public void register(FluidStack input) {
        processList.add(new Recipes(input));
    }

    /**
     * Returns the process result of an item.
     *
     */
    @Override
    public ItemStack getProcessResult(ItemStack itemStack) {
        return null;
    }

    /**
     * @return Whether this item can process
     */
    @Override
    public boolean canProcess(ItemStack itemStack) {
        FluidStack fluidStack = FluidContainerRegistry.getFluidForFilledItem(itemStack);
        if (fluidStack != null) {
            for (Recipes recipes : this.processList) {
                if (recipes.fluidStack.isFluidEqual(fluidStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Get required amount of process
     *
     * @param itemStack Input item
     * @return Required amount of process
     */
    @Override
    public int getRequiredProcessAmount(ItemStack itemStack) {
        return 1;
    }

    @Override
    public List getProcessRecipesList() {
        return this.processList;
    }

    /**
     * @param itemStack Input item
     */
    @Override
    public Object getRecipe(ItemStack itemStack) {
        for (Recipes recipes : this.processList) {
            if (recipes.fluidStack.isFluidEqual(FluidContainerRegistry.getFluidForFilledItem(itemStack))) {
                return recipes;
            }
        }
        return null;
    }


    public static class Recipes {
        public FluidStack fluidStack;

        public Recipes(FluidStack input) {
            this.fluidStack = input;
        }
    }
}
