/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 GoodTime Studio <https://github.com/GoodTimeStudio>
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
package com.mcgoodtime.productionline.common.crafting.nei.handler;

import com.mcgoodtime.productionline.client.gui.GuiHeatDryer;
import com.mcgoodtime.productionline.common.core.ProductionLine;
import com.mcgoodtime.productionline.common.recipes.HeatDryerRecipes;
import com.mcgoodtime.productionline.common.recipes.IProcessable;
import net.minecraft.client.gui.inventory.GuiContainer;

/**
 * Created by BestOwl on 2015.12.19.0019.
 *
 * @author BestOwl
 */
public class RecipeHandlerHeatDryer extends RecipeHandlerBase {
    @Override
    public IProcessable getRecipesList() {
        return HeatDryerRecipes.instance;
    }

    @Override
    public String getRecipeNameForCrafting() {
        return "HeatDryer";
    }

    @Override
    public String getRecipeID() {
        return "productionline.dryer";
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiHeatDryer.class;
    }

    @Override
    public String getGuiTexture() {
        return ProductionLine.RESOURCE_DOMAIN + ":" + "textures/gui/GuiHeatDryer.png";
    }

    @Override
    public String getOverlayIdentifier() {
        return "dryer";
    }
}