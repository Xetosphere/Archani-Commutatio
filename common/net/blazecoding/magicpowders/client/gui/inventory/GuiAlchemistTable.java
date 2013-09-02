package net.blazecoding.magicpowders.client.gui.inventory;

import net.blazecoding.magicpowders.inventory.ContainerAlchemistTable;
import net.blazecoding.magicpowders.lib.Strings;
import net.blazecoding.magicpowders.lib.Textures;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiAlchemistTable extends GuiContainer {

	public GuiAlchemistTable(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
		super(new ContainerAlchemistTable(par1InventoryPlayer, par2World, par3, par4, par5));
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(I18n.func_135053_a(Strings.CONTAINER_ALCHEMISTTABLE_NAME), 28, 6, 4210752);
		this.fontRenderer.drawString(I18n.func_135053_a(Strings.CONTAINER_INVENTORY), 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.func_110434_K().func_110577_a(Textures.GUI_ALCHEMISTTABLE);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}