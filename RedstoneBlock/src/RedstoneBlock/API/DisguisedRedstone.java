package RedstoneBlock.API;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;

public class DisguisedRedstone {
	
	Block BLOCK;
	
	static List<DisguisedRedstone> BLOCKS = new ArrayList<DisguisedRedstone>();
	
	public DisguisedRedstone(Block block){
		BLOCK = block;
		BLOCKS.add(this);
	}
	
	public Block getBlock(){
		return BLOCK;
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

}
