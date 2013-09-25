package com.xetosphere.arcane.core.handlers;

import java.util.EnumSet;

import net.minecraftforge.common.Configuration;

import com.xetosphere.arcane.configuration.ConfigurationHandler;
import com.xetosphere.arcane.configuration.ConfigurationSettings;
import com.xetosphere.arcane.core.util.VersionHelper;
import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.lib.Strings;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionCheckTickHandler implements ITickHandler {

	private static boolean initialized = false;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {

		if (ConfigurationSettings.DISPLAY_VERSION_RESULT) {
			if (!initialized) {
				for (TickType tickType : type) {
					if (tickType == TickType.CLIENT) {
						if (FMLClientHandler.instance().getClient().currentScreen == null) {
							if (VersionHelper.getResult() != VersionHelper.UNINITIALIZED || VersionHelper.getResult() != VersionHelper.FINAL_ERROR) {

								initialized = true;

								if (VersionHelper.getResult() == VersionHelper.OUTDATED) {
									FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(VersionHelper.getResultMessageForClient());
									ConfigurationHandler.set(Configuration.CATEGORY_GENERAL, ConfigurationSettings.DISPLAY_VERSION_RESULT_CONFIGNAME, Strings.FALSE);
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {

		return EnumSet.of(TickType.CLIENT);
	}

	@Override
	public String getLabel() {

		return Reference.MOD_NAME + ": " + this.getClass().getSimpleName();
	}

}
