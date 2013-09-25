package com.xetosphere.arcane.lib;

public class Strings {

	/* General keys */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String TOKEN_DELIMITER = ",";

	/* Localization Prefixes */
	public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

	/* Fingerprint check related constants */
	public static final String NO_FINGERPRINT_MESSAGE = "The copy of Achani Commutatio that you are running is a development version of the mod, and as such may be unstable and/or incomplete.";
	public static final String INVALID_FINGERPRINT_MESSAGE = "The copy of Achani Commutatio that you are running has been modified from the original, and unpredictable things may happen. Please consider re-downloading the original version of the mod.";

	/* Version check related constants */
	public static final String VERSION_CHECK_INIT_LOG_MESSAGE = "version.arc:init_log_message";
	public static final String UNINITIALIZED_MESSAGE = "version.arc:uninitialized";
	public static final String CURRENT_MESSAGE = "version.arc:current";
	public static final String OUTDATED_MESSAGE = "version.arc:outdated";
	public static final String GENERAL_ERROR_MESSAGE = "version.arc:general_error";
	public static final String FINAL_ERROR_MESSAGE = "version.arc:final_error";
	public static final String MC_VERSION_NOT_FOUND = "version.arc:mc_version_not_found";

	/* NBT related constants */
	public static final String NBT_TE_STATE_KEY = "teState";
	public static final String NBT_TE_CUSTOM_NAME = "CustomName";
	public static final String NBT_TE_DIRECTION_KEY = "teDirection";

	/* Block name constants */
	public static final String POWDERORES_NAME = "powderOres";
	public static final String STORAGEBLOCKS_NAME = "ingotBlocks";
	public static final String ARCANE_FUSER_NAME = "arcaneFuser";
	public static final String DUPLICATOR_NAME = "duplicator";
	public static final String ALCHEMISTTABLE_NAME = "alchemistTable";

	/* Item name constants */
	public static final String MAGICDUST_NAME = "magicDust";
	public static final String MAGICINGOT_NAME = "magicIngot";
	public static final String ARCANE_GEM_NAME = "arcaneGem";

	/* Tool name constants */
	public static final String SORONITEPAXEL_NAME = "paxelSoronite";
	public static final String TARDITEPAXEL_NAME = "paxelTardite";
	public static final String KORONINPAXEL_NAME = "paxelKoronin";

	public static final String SORONITESWORD_NAME = "swordSoronite";
	public static final String SORONITEPICK_NAME = "pickaxeSoronite";
	public static final String SORONITEAXE_NAME = "axeSoronite";
	public static final String SORONITESHOVEL_NAME = "shovelSoronite";
	public static final String SORONITEHOE_NAME = "hoeSoronite";

	public static final String TARDITESWORD_NAME = "swordTardite";
	public static final String TARDITEPICK_NAME = "pickaxeTardite";
	public static final String TARDITEAXE_NAME = "axeTardite";
	public static final String TARDITESHOVEL_NAME = "shovelTardite";
	public static final String TARDITEHOE_NAME = "hoeTardite";

	public static final String KORONINSWORD_NAME = "swordKoronin";
	public static final String KORONINPICK_NAME = "pickaxeKoronin";
	public static final String KORONINAXE_NAME = "axeKoronin";
	public static final String KORONINSHOVEL_NAME = "shovelKoronin";
	public static final String KORONINHOE_NAME = "hoeKoronin";

	/* Armour name constants */
	public static final String SORONITEHELMET_NAME = "helmetSoronite";
	public static final String SORONITECHEST_NAME = "chestplateSoronite";
	public static final String SORONITELEGS_NAME = "leggingsSoronite";
	public static final String SORONITEBOOTS_NAME = "bootsSoronite";

	public static final String TARDITEHELMET_NAME = "helmetTardite";
	public static final String TARDITECHEST_NAME = "chestplateTardite";
	public static final String TARDITELEGS_NAME = "leggingsTardite";
	public static final String TARDITEBOOTS_NAME = "bootsTardite";

	public static final String KORONINHELMET_NAME = "helmetKoronin";
	public static final String KORONINCHEST_NAME = "chestplateKoronin";
	public static final String KORONINLEGS_NAME = "leggingsKoronin";
	public static final String KORONINBOOTS_NAME = "bootsKoronin";

	public static final String SORONITEARMOUR_NAME = "soroniteArmour";
	public static final String TARDITEARMOUR_NAME = "tarditeArmour";
	public static final String KORONINARMOUR_NAME = "koroninArmour";

	/* TileEntity name constants */
	public static final String TE_ARCANE_FUSER_NAME = "tileArcaneFuser";
	public static final String TE_DUPLICATOR_NAME = "tileDuplicator";
	public static final String TE_ALCHEMISTTABLE_NAME = "tileAlchemistTable";

	/* Container related constants */
	public static final String CONTAINER_INVENTORY = "container.inventory";
	public static final String CONTAINER_ARCANE_FUSER_NAME = "container." + ARCANE_FUSER_NAME;
	public static final String CONTAINER_DUPLICATOR_NAME = "container." + DUPLICATOR_NAME;
	public static final String CONTAINER_ALCHEMISTTABLE_NAME = "container." + ALCHEMISTTABLE_NAME;

	/* Miscellaneous */
	public static final String ENABLE_CUSTOM_GEN = "Enable custom structures";
	public static final String ENABLE_RECIPE_ALCTAB = "Enable the recipe for the Alchemist Table";

}
