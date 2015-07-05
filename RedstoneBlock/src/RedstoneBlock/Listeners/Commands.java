package RedstoneBlock.Listeners;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import RedstoneBlock.RedstoneBlock;

public class Commands implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String length, String[] args) {
		if(cmd.getName().equalsIgnoreCase("disguisedredstone")){
			if(args.length == 0){
				sender.sendMessage("/disguisedredstone createinfuser - Creates infuser tool");
			}else {
				if (args[0].equalsIgnoreCase("createinfuser")){
					if (sender instanceof Player){
						Player player = (Player)sender;
						ItemStack item = player.getItemInHand();
						if (item.getType().equals(Material.WOOD_AXE)){
							ItemStack wand = RedstoneBlock.getWand();
							player.getInventory().remove(item);
							player.getInventory().addItem(wand);
							player.updateInventory();
							player.sendMessage("Successfully Created Redstone Infuser");
						}
					}
				}
				if(args[0].equalsIgnoreCase("removeinfuser")){
					if(sender instanceof Player){
						Player player = (Player)sender;
						ItemStack item = player.getItemInHand();
						ItemStack wand = RedstoneBlock.getWand();
						if (item.equals(wand)){
							player.getInventory().remove(item);
							player.updateInventory();
						}
					}
				}
			}
			return true;
		}
		return false;
	}

}
