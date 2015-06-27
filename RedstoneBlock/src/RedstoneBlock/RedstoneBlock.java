package RedstoneBlock;

import org.bukkit.plugin.java.JavaPlugin;

public class RedstoneBlock extends JavaPlugin{
	//work in progress
	
	static RedstoneBlock PLUGIN;
	
	public void onEnable(){
		PLUGIN = this;
	}
	
	public static RedstoneBlock getPlugin(){
		return PLUGIN;
	}

	
	//Test edit by jj
	// disguise redstone
	// Have rs + 'tool' in inventory
	//right clicking a suitable block 'infuses' rs in block
	//that block now behaves as a piece of redstone in function (can connect to other rs etc)
	// but retains block texture, break time etc
	// left-clicking with tool removes redstone inside block
	// breaking rs infused block yields original block + 1 rs
}

