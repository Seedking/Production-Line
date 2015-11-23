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
package com.mcgoodtime.gti.common.blocks;

import com.mcgoodtime.gti.common.init.GtiBlocks;
import com.mcgoodtime.gti.common.items.ItemBlockGti;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

import static com.mcgoodtime.gti.common.core.Gti.MOD_ID;
import static com.mcgoodtime.gti.common.core.Gti.RESOURCE_DOMAIN;

/**
 * Created by suhao on 2015.10.18.0018.
 *
 * @author suhao
 */
public class BlockMisc extends BlockGti implements IMultiMetaBlock {

    public static List<String> internalNameList = new ArrayList<String>();
    protected IIcon[] icons;

    static {
        internalNameList.add("CompressedWaterHyacinth");
        internalNameList.add("DehydratedWaterHyacinthBlock");
    }

    public BlockMisc() {
        super(Material.rock, "BlockMisc");
        this.icons = new IIcon[this.getMaxMeta()];
        this.setHardness(1.0F);
        GameRegistry.registerBlock(this, ItemBlockGti.class, "BlockMisc");

        GtiBlocks.compressedWaterHyacinth = new ItemStack(this, 1, 0);
        GtiBlocks.dehydratedWaterHyacinthblock = new ItemStack(this, 1, 1);
    }

    public int getMaxMeta() {
        return internalNameList.size();
    }

    /**
     * Returns the unlocalized name of this block. This version accepts an ItemStack so different stacks can have
     * different names based on their meta or NBT.
     */
    public String getBlockName(ItemStack itemStack) {
        return "tile." + MOD_ID + ".block." + this.getInternalName(itemStack.getItemDamage());
    }

    /**
     * Get block's unlocalized name
     * @return unlocalized name
     */
    @Override
    public String getBlockName(int meta) {
        return "tile." + MOD_ID + ".block." + this.getInternalName(meta);
    }

    public String getInternalName(int meta) {
        return internalNameList.get(meta);
    }

    @Override
    public void registerBlockIcons(IIconRegister iir) {
        for (int i = 0; i < this.getMaxMeta(); i++) {
            this.icons[i] = iir.registerIcon(RESOURCE_DOMAIN + ":" + "block" + this.getInternalName(i));
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[meta];
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        for(int meta = 0; meta < this.getMaxMeta(); ++meta) {
            ItemStack stack = new ItemStack(this, 1, meta);
            list.add(stack);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        return new ItemStack(this, 1, world.getBlockMetadata(x, y, z));
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
