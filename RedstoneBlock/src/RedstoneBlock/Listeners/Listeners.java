package RedstoneBlock.Listeners;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import RedstoneBlock.RedstoneBlock;
import RedstoneBlock.API.DisguisedRedstone;

public class Listeners implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void clickevent(PlayerInteractEvent event){
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			Player player = event.getPlayer();
			if(player.getItemInHand().equals(RedstoneBlock.getWand())){
				ItemStack is = player.getItemInHand();
				is.setAmount(is.getAmount()-1);
				Block block = event.getClickedBlock();
				new DisguisedRedstone(block);
				player.updateInventory();
			}
		}
	}
	
	
	//remove comments when you understand it, the comments make it harder to read for me
	@EventHandler
	public static void redstoneEvent(BlockRedstoneEvent event){
		//gets the block that has had the bukkit's power changed
		Block redstone = event.getBlock();
		//gets and checks for any disguisedRedstone next to the block (see public static getNextTo(Block block){ for more detail)
		List<DisguisedRedstone> blocks = DisguisedRedstone.getNextTo(redstone);
		//gets the power of the redstone event
		int power = event.getNewCurrent();
		int oldPower = event.getOldCurrent();
		//checks if the event is a up in power or down in power
		if (power > oldPower){
			//up in power
			//for statement runs the same code for each object inside a list (not the only thing it does).
			for(DisguisedRedstone block : blocks){
				//checks if the power update should be applied. this checks the blocks power is less then the new power
				if (block.getPower() < power){
					//updates the power of the disguisedRedstone block to the new value
					block.setPower(power, true);
				}
			}
		}else{
			//down in power
			for(DisguisedRedstone block : blocks){
				//checks if the power update should be applied. This checks the redstone power of the new block got its power from the changing stream
				if ((oldPower + 1) <= block.getPower()){
					block.setPower(power - 1, true);
				}
			}
		}
	}
}
