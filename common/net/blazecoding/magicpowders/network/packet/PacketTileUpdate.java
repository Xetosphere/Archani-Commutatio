package net.blazecoding.magicpowders.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.blazecoding.magicpowders.MagicPowders;
import net.blazecoding.magicpowders.network.PacketTypeHandler;
import net.minecraft.network.INetworkManager;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.Player;

/**
 * 
 * Magic Powders
 * 
 * PacketTileUpdate
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class PacketTileUpdate extends PacketMP {

	public int x, y, z;
	public byte orientation;
	public byte state;
	public String customName;

	public PacketTileUpdate() {
		super(PacketTypeHandler.TILE, true);
	}

	public PacketTileUpdate(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {
		super(PacketTypeHandler.TILE, true);
		this.x = x;
		this.y = y;
		this.z = z;
		this.orientation = (byte) orientation.ordinal();
		this.state = state;
		this.customName = customName;
	}

	public void writeData(DataOutputStream data) throws IOException {
		data.writeInt(x);
		data.writeInt(y);
		data.writeInt(z);
		data.writeByte(orientation);
		data.writeByte(state);
		data.writeUTF(customName);
	}

	public void readData(DataInputStream data) throws IOException {
		x = data.readInt();
		y = data.readInt();
		z = data.readInt();
		orientation = data.readByte();
		state = data.readByte();
		customName = data.readUTF();
	}

	public void execute(INetworkManager manager, Player player) {
		MagicPowders.proxy.handleTileEntityPacket(x, y, z, ForgeDirection.getOrientation(orientation), state, customName);
	}

}
