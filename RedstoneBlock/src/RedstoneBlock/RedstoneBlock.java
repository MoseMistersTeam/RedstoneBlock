package RedstoneBlock;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import RedstoneBlock.Listeners.Listeners;

public class RedstoneBlock extends JavaPlugin{
	//work in progress
	
	static RedstoneBlock PLUGIN;
	
	public void onEnable(){
		PLUGIN = this;
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
	}
	
	public static RedstoneBlock getPlugin(){
		return PLUGIN;
	}
	
	public static ItemStack getWand(){
		ItemStack is = new ItemStack(Material.WOOD_AXE);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("Redstone Infuser");
		is.setItemMeta(im);
		return is;
	}

	
	//Test edit by jj
	// disguise redstone
	// Have rs + 'tool' in inventory
	//right clicking a suitable block 'infuses' rs in block
	//that block now behaves as a piece of redstone in function (can connect to other rs etc)
	// but retains block texture, break time etc
	// left-clicking with tool removes redstone inside block
	// breaking rs infused block yields original block + 1 rs
	
	
	//test4
	
}
