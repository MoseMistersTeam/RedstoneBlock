package RedstoneBlock.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import RedstoneBlock.API.DisguisedRedstone;

public class Listeners implements Listener{
	@EventHandler
	public static void clickevent(PlayerInteractEvent event){
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			Player player = event.getPlayer();
			if(player.getItemInHand().equals(Material.REDSTONE)){
				ItemStack is = player.getItemInHand();
				is.setAmount(is.getAmount()-1);
				Block block = event.getClickedBlock();
				new DisguisedRedstone(block);
			}
		}
	}
}
