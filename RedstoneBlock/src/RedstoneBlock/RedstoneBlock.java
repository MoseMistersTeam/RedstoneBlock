package RedstoneBlock;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import RedstoneBlock.Listeners.Commands;
import RedstoneBlock.Listeners.Listeners;

public class RedstoneBlock extends JavaPlugin{
	//work in progress
	
	static RedstoneBlock PLUGIN;
	
	public void onEnable(){
		PLUGIN = this;
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		this.getCommand("disguisedredstone").setExecutor(new Commands());
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
	/* todo list
	 * Add command for creating wand
	 * Add chat message 'Block Infused'
	 * Add chat message 'Redstone removed'
	 * Add redstone mechanics
	 * Ensure redstone is in inv. + tool is held in hand + player right click + block is valid block (from config) to infuse redstone
	 * Ensure tool is held in hand + player left click + block contains redstone to remove redstone (if inv space, then +1 r/s to inv, if not, then drop 1 rs)
	 * Add config for valid blocks (eg so no leaves/transparent/less than full block (Unless half-slab))
	 * Add config for block emits light when r/s active
	 */
}
