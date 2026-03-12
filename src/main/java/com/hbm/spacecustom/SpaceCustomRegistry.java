package com.hbm.spacecustom;

import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;

import com.emoniph.witchery.blocks.BlockWitchesOven;
import com.emoniph.witchery.crafting.DistilleryRecipes;

import com.hbm.inventory.OreDictManager;
import com.hbm.inventory.RecipesCommon;
import com.hbm.inventory.material.MaterialShapes;
import com.hbm.inventory.material.Mats;
import com.hbm.inventory.recipes.ArcFurnaceRecipes;
import com.hbm.items.ModItems;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static com.hbm.inventory.OreDictManager.QUARTZ;


public class SpaceCustomRegistry {

	public static ItemStack STONE = new ItemStack(Blocks.stone);
	public static ItemStack BISMUTH_NUGGET = new ItemStack(ModItems.nugget_bismuth);
	public static ItemStack WOOD_TAR = new ItemStack(ModItems.oil_tar, 1, 3);
	public static ItemStack PINE_LOG = new ItemStack(Block.getBlockFromName("BiomesOPlenty:logs4"));

	public static final OreDictManager.DictFrame AMETHYST = new OreDictManager.DictFrame("Amethyst");


	public static void registerDefaults() {
		AltarRecipeRegistry.registerAltarRecipe(BISMUTH_NUGGET, new ItemStack(ModItems.ingot_polonium)
			, 5, 10000, 200, 100, false);
//		DistilleryRecipes.instance().addRecipe(STONE, STONE, 1,
//			new ItemStack(ModItems.powder_iodine), new ItemStack(ModItems.powder_iodine), new ItemStack(ModItems.powder_iodine), new ItemStack(ModItems.powder_iodine));
		GameRegistry.addSmelting(PINE_LOG, WOOD_TAR, 20.0f);
		ArcFurnaceRecipes.register(new RecipesCommon.OreDictStack(AMETHYST.gem()),
			new ArcFurnaceRecipes.ArcFurnaceRecipe().solid(new ItemStack(ModItems.nugget_silicon, 3))
				.fluid(new Mats.MaterialStack(Mats.MAT_SILICON, MaterialShapes.NUGGET.q(3))));
	}
}
