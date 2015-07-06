package RedstoneBlock.API;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class DisguisedRedstone {
	
	//these are values that stay to this class. In this case, all Disguised Redstone will have these 2 data stores as different values. You need to grab 
	//the classes by static methods
	Block BLOCK;
	byte POWER;
	
	//this keeps track of all disguised redstone that has been set, so we and others can know where they are 
	static List<DisguisedRedstone> BLOCKS = new ArrayList<DisguisedRedstone>();
	
	//if it only has public <X>() it is a constructor. This is one. 
	//constructors are used to create classes. its the code that allows you to write
	//new <classname>(); and make it actually work
	//constructors are always found at the top of classes with the exception of abstract classes. in them they are found 2nd to the top
	
	//in this case you need the variables Bukkit's block, and java's Integer or Bukkit's block and java's Byte or just using Bukkit's block
	public DisguisedRedstone(Block block, int redstone){
		//this sets all the values for this single class, create more classes using the 'new' statement
		BLOCK = block;
		POWER = (byte)redstone;
		
		//this adds this new created class to the static list of all saved
		BLOCKS.add(this);
	}
	
	public DisguisedRedstone(Block block, byte redstone){
		BLOCK = block;
		POWER = redstone;
		BLOCKS.add(this);
	}
	
	public DisguisedRedstone(Block block){
		BLOCK = block;
		POWER = 0;
		BLOCKS.add(this);
	}
	
	//returns the value of Bukkit's block for this class only
	public Block getBlock(){
		return BLOCK;
	}
	
	//returns the value of the power of this class only
	public byte getPower(){
		return POWER;
	}
	
	//allows us to change the power of the redstone
	//this also allows someone to change the power without calling the DRPowerChangeEvent for those stealth changes
	public void setPower(int redstone, boolean event){
		//checks if the event should be called
		if (event){
			//event called
			
			//creates a event to be called
			DRPowerChangeEvent event2 = new DRPowerChangeEvent(this, redstone);
			//calls the event just created
			Bukkit.getServer().getPluginManager().callEvent(event2);
			
			//checks if the event was cancelled. if not run the code inside the if statment
			if (!event2.isCancelled()){
				//sets the power
				POWER = (byte)event2.getPower();
			}
		}else{
			//event not called
			
			//sets the power
			POWER = (byte)redstone;
		}
	}
	
	//this grabs all DisguisedRedstone next to the current DisguisedRedstone 
	public List<DisguisedRedstone> getNextTo(){
		//creates a blank list
		List<DisguisedRedstone> blocks = new ArrayList<DisguisedRedstone>();
		
		//this for statement creates the value of X and sets it to -1. the for statement will repeat if 'X < 2' every time the code is repeated, increase X
		//if the line above did not explain it then try the following
		//split the for statement by the ';' so you gain the following
		//int X = -1;
		//X < 2
		//X++
		//int X = -1; creates the variable X and sets it to -1. X can only be used in this for statement
		//the for statement needs a true/false (boolean) check otherwise it will continue for the rest of time, so it checks if X < 2. if it is then run code, else stop running for statement
		//last bit is the 'X++' this means increase X by 1 each time this is read. In a for statement, where it's placed means it will be read every time the for statement repeats
		for(int X = -1; X < 2; X++){
			for(int Y = -1; Y < 2; Y++){
				for(int Z = -1; Z < 2; Z++){
					//the 3 for statements work together to get every possible location next to a block (touching and diagonal touching) 
					//this line gets the preset DisguisedRedstone at the place XYZ is currently set at
					DisguisedRedstone block2 = getBlock(getBlock().getRelative(X, Y, Z));
					//this checks if the block does not equal null. if it does, it means no DisguisedRedstone is there
					if (block2 != null){
						//this adds the block to the blank list we created earlier. when the for statement end it will have all the blocks 
						blocks.add(block2);
					}
				}
			}
		}
		//return statement means go back to what ever line of code called this method. in this case we are bring the list with it as well
		return blocks;
	}
	
	//follows the same structure as before, only instead of DisguisedRedstone, it checks for normal redstone 
	public List<Block> getRedstoneNextTo(){
		List<Block> blocks = new ArrayList<Block>();
		for(int X = -1; X < 2; X++){
			for(int Y = -1; Y < 2; Y++){
				for(int Z = -1; Z < 2; Z++){
					Block block2 = getBlock().getRelative(X, Y, Z);
					if (block2.getType().equals(Material.REDSTONE_BLOCK)){
						blocks.add(block2);
					}
				}
			}
		}
		return blocks;
	}
	
	//the following code is so similar to code before that they are not labelled. they should make sense if you understood above. 
	//static methods mean you do not need a class, you just need the import of the class
	//static methods are located at the bottom of a class
	
	//this static method returns the list of all classes, so if someone wants to do a custom search they can (EG. searching for every DisguisedRedstone with power of 7)
	public static List<DisguisedRedstone> getBlocks(){
		return BLOCKS;
	}
	
	//this static method will convert a Bukkit block to DisguisedRedstone (if that block is a DisguisedRedstone)
	public static DisguisedRedstone getBlock(Block block){
		for(DisguisedRedstone block2 : BLOCKS){
			if (block2.getBlock().equals(block)){
				return block2;
			}
		}
		return null;
	}
	
	//this static method will return all DisguisedRedstone touching (and diagonal touching) a bukkits block 
	public static List<DisguisedRedstone> getNextTo(Block block){
		List<DisguisedRedstone> blocks = new ArrayList<DisguisedRedstone>();
		for(int X = -1; X < 2; X++){
			for(int Y = -1; Y < 2; Y++){
				for(int Z = -1; Z < 2; Z++){
					DisguisedRedstone block2 = getBlock(block.getRelative(X, Y, Z));
					if (block2 != null){
						blocks.add(block2);
					}
				}
			}
		}
		return blocks;
	}

}
