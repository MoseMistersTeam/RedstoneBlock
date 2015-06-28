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
	
	public static List<DisguisedRedstone> getBlocks(){
		return BLOCKS;
	}

}
