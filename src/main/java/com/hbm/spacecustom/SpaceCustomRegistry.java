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

import com.pam.harvestcraft.harvestcraft;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static com.hbm.inventory.OreDictManager.QUARTZ;

import com.pam.harvestcraft.ItemPamTool;


public class SpaceCustomRegistry {

	public static ItemStack STONE = new ItemStack(Blocks.stone);
	public static ItemStack BISMUTH_NUGGET = new ItemStack(ModItems.nugget_bismuth);
	public static ItemStack WOOD_TAR = new ItemStack(ModItems.oil_tar, 1, 3);
	public static ItemStack PINE_LOG = new ItemStack(Block.getBlockFromName("BiomesOPlenty:logs4"));
	public static Item LAVA_SIGIL = Item.getItemById(4207);
	public static Item STAINLESS_STEEL_PAN = new ItemPamTool().setUnlocalizedName("stainlessSteelPan").setCreativeTab(harvestcraft.tabHarvestCraft);

	public static final OreDictManager.DictFrame AMETHYST = new OreDictManager.DictFrame("Amethyst");


	public static void registerDefaults() {
		STAINLESS_STEEL_PAN.setContainerItem(STAINLESS_STEEL_PAN);
		AltarRecipeRegistry.registerAltarRecipe(BISMUTH_NUGGET, new ItemStack(ModItems.ingot_polonium)
			, 5, 10000, 200, 100, false);
//		DistilleryRecipes.instance().addRecipe(STONE, STONE, 1,
//			new ItemStack(ModItems.powder_iodine), new ItemStack(ModItems.powder_iodine), new ItemStack(ModItems.powder_iodine), new ItemStack(ModItems.powder_iodine));
		GameRegistry.addSmelting(PINE_LOG, WOOD_TAR, 20.0f);
		GameRegistry.addShapedRecipe(new ItemStack(Items.blaze_rod, 1), " a ", "aba", " a ", 'a', Items.stick, 'b', LAVA_SIGIL);
		ArcFurnaceRecipes.register(new RecipesCommon.OreDictStack(AMETHYST.gem()),
			new ArcFurnaceRecipes.ArcFurnaceRecipe().solid(new ItemStack(ModItems.nugget_silicon, 3))
				.fluid(new Mats.MaterialStack(Mats.MAT_SILICON, MaterialShapes.NUGGET.q(3))));
		GameRegistry.registerItem(STAINLESS_STEEL_PAN, "stainlessSteelPan");
		OreDictionary.registerOre("toolSaucepan", STAINLESS_STEEL_PAN);
		GameRegistry.addShapedRecipe(new ItemStack(STAINLESS_STEEL_PAN, 1), "a ", " b", 'a', ModItems.ingot_stainless, 'b', Items.stick);
	}
}
