package RedstoneBlock.API;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DRPowerChangeEvent extends Event implements Cancellable{
	
	DisguisedRedstone REDSTONE;
	int NEW_POWER;
	boolean CANCELLED;
	static final HandlerList HANDLERS = new HandlerList();
	
	public DRPowerChangeEvent(DisguisedRedstone redstone, int power){
		REDSTONE = redstone;
		NEW_POWER = power;
	}
	
	public DisguisedRedstone getRedstone(){
		return REDSTONE;
	}
	
	public int getPower(){
		return NEW_POWER;
	}
	
	public void setPower(int A){
		NEW_POWER = A;
	}
	
	@Override
	public boolean isCancelled() {
		return CANCELLED;
	}

	@Override
	public void setCancelled(boolean arg0) {
		CANCELLED = arg0;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
	public static HandlerList getHandlerList(){
		return HANDLERS;
	}

}
