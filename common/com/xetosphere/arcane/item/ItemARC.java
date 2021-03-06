package com.xetosphere.arcane.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.xetosphere.arcane.lib.Reference;

public class ItemARC extends Item {

	public ItemARC(int id) {

		super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
		setNoRepair();
		maxStackSize = 1;
	}

	public void registerIcons(IconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
