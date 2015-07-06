package RedstoneBlock.API;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

//extends Bukkits event class to make it launchable under Bukkit's API
//implements Cancellable to make it cancellable under Bukkit's API
public class DRPowerChangeEvent extends Event implements Cancellable{
	
	//if you dont know what this part is for, look at DisguisedRedstone class first
	DisguisedRedstone REDSTONE;
	int NEW_POWER;
	boolean CANCELLED;
	
	//handlers make the event work, i dont understand why plugin developers have access to them but we do. this is how they work. Dont ask
	static final HandlerList HANDLERS = new HandlerList();
	
	//constructor
	public DRPowerChangeEvent(DisguisedRedstone redstone, int power){
		REDSTONE = redstone;
		NEW_POWER = power;
	}
	
	//gets the DisgusedRedstone class that fired the event
	public DisguisedRedstone getRedstone(){
		return REDSTONE;
	}
	
	//gets the power that is being changed to
	public int getPower(){
		return NEW_POWER;
	}
	
	//allows plugin developers to set the changed to power if they want
	public void setPower(int A){
		NEW_POWER = A;
	}
	
	//@Override overrides the source, its needed for implemented methods 
	//checks if the event has been cancelled
	@Override
	public boolean isCancelled() {
		return CANCELLED;
	}

	//allows plugin developers to set if they want to cancel it or uncancel it
	@Override
	public void setCancelled(boolean arg0) {
		CANCELLED = arg0;
	}

	//part of bukkits API. dont ask
	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
	public static HandlerList getHandlerList(){
		return HANDLERS;
	}

}
