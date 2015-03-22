package com.mcgoodtime.gti.common.Items;

import com.mcgoodtime.gti.common.core.CreativeTabGTI;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class Food extends Item {
	
	public static Item DimApple = new ItemFood(1005, 10 , false)
	.setUnlocalizedName("DiamondApple")
	.setCreativeTab(CreativeTabGTI.tab)
	.setTextureName("gti:itemDiamondApple");
	
    public static void preInit() {
		GameRegistry.registerItem(DimApple, "DiamondApple");
	}
		
}