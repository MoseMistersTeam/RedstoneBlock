package RedstoneBlock.API;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;

import RedstoneBlock.RedstoneBlock;

public class DisguisedRedstone {
	
	Block BLOCK;
	byte POWER;
	
	static List<DisguisedRedstone> BLOCKS = new ArrayList<DisguisedRedstone>();
	
	public DisguisedRedstone(Block block, int redstone){
		BLOCK = block;
		POWER = (byte)redstone;
		BLOCKS.add(this);
	}
	
	public DisguisedRedstone(Block block, byte redstone){
		BLOCK = block;
		POWER = redstone;
		BLOCKS.add(this);
	}
	
	public DisguisedRedstone(Block block){
		BLOCK = block;
		POWER = 0;
		BLOCKS.add(this);
	}
	
	public Block getBlock(){
		return BLOCK;
	}
	
	public byte getPower(){
		return POWER;
	}
	
	public void setPower(int redstone, boolean event){
		if (event){
			DRPowerChangeEvent event2 = new DRPowerChangeEvent(this);
			Bukkit.getServer().getPluginManager().callEvent(event2);
			if (!event2.isCancelled()){
				POWER = (byte)redstone;
			}
		}else{
			POWER = (byte)redstone;
		}
	}
	
	public List<DisguisedRedstone> getNextTo(){
		List<DisguisedRedstone> blocks = new ArrayList<DisguisedRedstone>();
		for(int X = -1; X < 2; X++){
			for(int Y = -1; Y < 2; Y++){
				for(int Z = -1; Z < 2; Z++){
					DisguisedRedstone block2 = getBlock(getBlock().getRelative(X, Y, Z));
					if (block2 != null){
						blocks.add(block2);
					}
				}
			}
		}
		return blocks;
	}
	
	public List<Block> getRedstoneNextTo(){
		List<Block> blocks = new ArrayList<Block>();
		for(int X = -1; X < 2; X++){
			for(int Y = -1; Y < 2; Y++){
				for(int Z = -1; Z < 2; Z++){
					Block block2 = getBlock().getRelative(X, Y, Z);
					if (block2.getType().equals(Material.REDSTONE_BLOCK)){
						blocks.add(block2);
					}
				}
			}
		}
		return blocks;
	}
	
	public static List<DisguisedRedstone> getBlocks(){
		return BLOCKS;
	}
	
	public static DisguisedRedstone getBlock(Block block){
		for(DisguisedRedstone block2 : BLOCKS){
			if (block2.getBlock().equals(block)){
				return block2;
			}
		}
		return null;
	}
	
	public static List<DisguisedRedstone> getNextTo(Block block){
		List<DisguisedRedstone> blocks = new ArrayList<DisguisedRedstone>();
		for(int X = -1; X < 2; X++){
			for(int Y = -1; Y < 2; Y++){
				for(int Z = -1; Z < 2; Z++){
					DisguisedRedstone block2 = getBlock(block.getRelative(X, Y, Z));
					if (block2 != null){
						blocks.add(block2);
					}
				}
			}
		}
		return blocks;
	}

}
