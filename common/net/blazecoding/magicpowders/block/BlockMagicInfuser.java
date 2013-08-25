package net.blazecoding.magicpowders.block;

import java.util.Random;

import net.blazecoding.magicpowders.MagicPowders;
import net.blazecoding.magicpowders.lib.Strings;
import net.blazecoding.magicpowders.tileentity.TileEntityMagicInfuser;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagicInfuser extends BlockContainer {

	private final Random furnaceRand = new Random();

	private final boolean isActive;

	private static boolean keepFurnaceInventory = false;

	@SideOnly(Side.CLIENT)
	private Icon magicInfuserTop;
	@SideOnly(Side.CLIENT)
	private Icon magicInfuserFront;

	protected BlockMagicInfuser(int id, boolean active) {
		super(id, Material.rock);
		setUnlocalizedName(Strings.MAGICINFUSERACTIVE_NAME);

		if (!active) {
			setUnlocalizedName(Strings.MAGICINFUSER_NAME);
			setCreativeTab(MagicPowders.tabMP);
		}

		this.isActive = active;
		setHardness(3.0F);
		setResistance(8.0F);
	}

	public int idDropped(int id, Random random, int meta) {
		return ModBlocks.magicInfuserIdle.blockID;
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	private void setDefaultDirection(World par1World, int par2, int par3, int par4) {

		if (!par1World.isRemote) {

			int l = par1World.getBlockId(par2, par3, par4 - 1);

			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);

			byte b0 = 3;

			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]) {
				b0 = 3;
			}

			if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]) {
				b0 = 2;
			}

			if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]) {
				b0 = 5;
			}

			if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]) {
				b0 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);

		}

	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return par1 == 1 ? this.magicInfuserTop : (par1 == 0 ? this.magicInfuserTop : (par1 != par2 ? this.blockIcon : this.magicInfuserFront));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {

		this.blockIcon = par1IconRegister.registerIcon("furnace_side");
		this.magicInfuserFront = par1IconRegister.registerIcon(this.isActive ? "furnace_front_on" : "furnace_front_off");
		this.magicInfuserTop = par1IconRegister.registerIcon("furnace_top");

	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity == null || player.isSneaking()) {
			return false;
		}

		player.openGui(MagicPowders.instance, 0, world, x, y, z);

		return true;

	}

	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4) {

		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		keepFurnaceInventory = true;

		if (par0) {
			par1World.setBlock(par2, par3, par4, ModBlocks.magicInfuserActive.blockID);
		} else {
			par1World.setBlock(par2, par3, par4, ModBlocks.magicInfuserIdle.blockID);
		}

		keepFurnaceInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		if (tileentity != null) {
			tileentity.validate();
			par1World.setBlockTileEntity(par2, par3, par4, tileentity);
		}

	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {

	}

	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMagicInfuser();
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {

		int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (l == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if (l == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (l == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}

		if (par6ItemStack.hasDisplayName()) {
			((TileEntityFurnace) par1World.getBlockTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
		}

	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {

		if (!keepFurnaceInventory) {

			TileEntityMagicInfuser tileentityfurnace = (TileEntityMagicInfuser) par1World.getBlockTileEntity(par2, par3, par4);

			if (tileentityfurnace != null) {

				for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1) {

					ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

					if (itemstack != null) {

						float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0) {

							int k1 = this.furnaceRand.nextInt(21) + 10;

							if (k1 > itemstack.stackSize) {
								k1 = itemstack.stackSize;
							}

							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(par1World, (double) ((float) par2 + f), (double) ((float) par3 + f1), (double) ((float) par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}

							float f3 = 0.05F;

							entityitem.motionX = (double) ((float) this.furnaceRand.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.furnaceRand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double) ((float) this.furnaceRand.nextGaussian() * f3);

							par1World.spawnEntityInWorld(entityitem);

						}

					}

				}
				par1World.func_96440_m(par2, par3, par4, par5);
			}

		}
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5) {
		return Container.calcRedstoneFromInventory((IInventory) par1World.getBlockTileEntity(par2, par3, par4));
	}

}
