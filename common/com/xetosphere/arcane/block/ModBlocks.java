package com.xetosphere.arcane.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.xetosphere.arcane.item.ModItems;
import com.xetosphere.arcane.item.block.ItemBlockMagicPowderOres;
import com.xetosphere.arcane.item.block.ItemBlockStorageBlocks;
import com.xetosphere.arcane.lib.BlockIDs;
import com.xetosphere.arcane.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block magicPowderOres;
	public static Block storageBlocks;
	public static Block fuser;
	public static Block duplicator;
	public static Block alchemistTable;
	public static Block crusher;

	/**
	 * Initializes the blocks that the mod contains. As well as block recipes and registering the blocks.
	 */
	public static void init() {

		magicPowderOres = new BlockMagicPowderOres(BlockIDs.MAGIC_ORES);
		storageBlocks = new BlockStorageBlocks(BlockIDs.STORAGE_BLOCKS);
		fuser = new BlockArcaneFuser(BlockIDs.ARCANE_FUSER);
		duplicator = new BlockDuplicator(BlockIDs.DUPLICATOR);
		alchemistTable = new BlockAlchemistTable(BlockIDs.ALCHEMISTTABLE);
		crusher = new BlockAuraCrusher(BlockIDs.AURA_CRUSHER);

		GameRegistry.registerBlock(fuser, Strings.ARCANE_FUSER_NAME);
		GameRegistry.registerBlock(duplicator, Strings.DUPLICATOR_NAME);
		GameRegistry.registerBlock(alchemistTable, Strings.ALCHEMISTTABLE_NAME);
		GameRegistry.registerBlock(crusher, Strings.AURA_CRUSHER_NAME);

		GameRegistry.registerBlock(magicPowderOres, ItemBlockMagicPowderOres.class, Strings.POWDERORES_NAME);
		GameRegistry.registerBlock(storageBlocks, ItemBlockStorageBlocks.class, Strings.STORAGEBLOCKS_NAME);

		addOreLevels();
		initToOreDictionary();
	}

	public static void addOreLevels() {

		MinecraftForge.setBlockHarvestLevel(magicPowderOres, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(magicPowderOres, 1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(magicPowderOres, 2, "pickaxe", 2);

		MinecraftForge.setBlockHarvestLevel(storageBlocks, 0, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(storageBlocks, 1, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(storageBlocks, 2, "pickaxe", 0);
	}

	public static void initToOreDictionary() {

		OreDictionary.registerOre("oreSoronite", new ItemStack(magicPowderOres, 1, 0));
		OreDictionary.registerOre("oreTardite", new ItemStack(magicPowderOres, 1, 1));
		OreDictionary.registerOre("oreKoronin", new ItemStack(magicPowderOres, 1, 2));

		OreDictionary.registerOre("dustCoal", new ItemStack(ModItems.metalDusts, 1, 0));
		OreDictionary.registerOre("dustIron", new ItemStack(ModItems.metalDusts, 1, 1));
		OreDictionary.registerOre("dustGold", new ItemStack(ModItems.metalDusts, 1, 2));
	}

}
