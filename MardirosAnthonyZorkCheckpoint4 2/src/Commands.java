/*
 * 
 * In Checkpoint 4, students you will add an inventory, update
 *  your map to your own world, and then make it fully functional.
 *
 */


/*
 * CLASS CONTAINS: 4 tasks
 * 
 * All green comments are tasks for this checkpoint
 * 
 */


import java.util.*;

/**
 * Creates the class Commands, 
 * There will only be one instance used by the game
 * therefore all of its methods are static to prevent multiple
 */
public class Commands {

/**
 * Variable to end the game
 */
 
  public static boolean quit;

/**
 * Class level variables that need to be accessible throughout the code
 **/
 
  public static Room[][] map;
  public static int row;
  public static int column;
  public static Room currentRoom;

/* 
 * TODO: Checkpoint 4 Task
 * 
 * Declare an ArrayList called "inventory".  
 * This should be type InventoryItem
 * This ArrayList will be needed to carry your various objects
 */
  public static ArrayList<InventoryItem> inventory;
  
  
  
	
/**
 * runGame method
 * method responsible for running a console version of the game
 * this method returns nothing and has no parameters
 * it contains the while loop that is used to run the game
 */
  
  
  
	public static void runGame(){
		
/* 
 * TODO: Checkpoint 4 Tasks 
 * 
 * Declare and Construct the objects for your game.
 * 
 */
 
		Key diamondKey = new Key("Diamond Key", "Key to unlock the tunnel to Room-S3.", 2.0);
		Food banana = new Food("Banana", "This is used to satisfy Guard Vincenzo. Not having it will get you sent back to find it.", 1.0);
		Item armor = new Item("Armor", "This is used to satisfy Guard Ismael, who desires to see a brave warrior wearing armor. "
				+ "Not wearing armor results in another search through the room.", 1.0);
		Item crystalCrown = new Item("Crystal Crown", "This is a highly valuable item, requested by Guard Jeremiah", 1.0);
		Item emeraldJewelry = new Item("Emerald Jewelry", "This is a mildly valuable item, requested by Guard Elijah.", 1.0);
		Item nobleRing = new Item("Noble Ring", "Slightly "
				+ "valuable item requested by Guard Henry.", 0.05);
		
		
		
		
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the map values for the rows and columns to the size required for your world
 * your world might not be 3 rows and 3 columns as noted below
 */
		map = new Room[5][5];
		
    
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the Room constructors to match the Rooms in your world and add constructors
 * for additional Rooms.
 * 
 * Be sure to construct every Room in your map (especially if you changed the size of 
 * the map)
 * 
 * If the space on the map is not actually a Room, use the default constructor
 *
 * Finally, construct Rooms that have objects by using the new 7 parameter 
 * constructor you made in the Room class.
 */    
    
		Room noRoom = new Room();
		Room lobby = new Room(true, false, false, false,
				"This is your starting point.\n" + "Begin to make your way through the corridors. Stay safe.",
				"Main Lobby");
		Room ismael = new Room(false, true, true, false,
				"Main entry door(s) not locked;\n" + " contains a slightly valuable potentially requested item.",
				"Room of Guard Isamel", nobleRing);
		
		Room corrFour = new Room(false, true, true, true, "Hallway between two unguarded rooms and the Basement",
				"Corridor #4");
		Room basement = new Room(false, true, true, true,
				"Contains the armor necessary to travel in the tunnel, \n"
						+ "as well as the key needed to unlock the door \n" + "to Room S3 at Canyon High School.",
				"Basement", armor);
		Room corrThree = new Room(false, true, true, true,
				"Simple hallway adjacent to an \n" + 
		"unguarded room and the Basement.", "Corridor #3", banana);
		Room vincenzo = new Room(false, true, false, true,
				"Main entry door(s) not locked; \n" + 
		"contains a moderately valuable potentially requested item.",
				"Room of Guard Vincenzo");
		Room matthias = new Room(true, false, true, false,
				"Main entry door(s) not locked; \n" + 
		"contains a highly valuable potentially requested item.",
				"Room of Guard Matthias", emeraldJewelry, diamondKey);
		Room corrFive = new Room(true, true, true, true,
				"Hallway directly beside a guarded room, \n" + 
		"an unguarded room, and the Main Lobby.", "Corridor #5");
		Room corrOne = new Room(true, true, true, true,
				"Simple hallway with the locked \n" + 
		"basement door to the north.", "Corridor #1");
		Room corrTwo = new Room(true, false, true, true, "Another simple hallway \n"
				+ "containing a Random Item Spawner tool \n"
				+ "which could be used to satisfy the command of a particular guard. \n"
				+ "Adjacent to a guarded room.", "Corridor #2");
		Room jeremiah = new Room(true, true, false, true, "The guarded room which must be \n"
				+ "accessed to unlock the Guarded Room of Elijah.", "Room of Guard Jeremiah");
		Room henry = new Room(true, false, false, false, "The most secluded of \n"
				+ "the three guarded rooms.", "Room of Guard Henry", crystalCrown);
		Room elijah = new Room(true, false, false, false, "The most challenging guarded room \n"
				+ "to unlock, particularly because it is only \n"
				+ "accessible through another guarded room.", "Room of Guard Elijah");
		Room tunnel = new Room(false, true, false, false, "Final passageway containing \n"
				+ "hitmen which must be defeated to be able \n"
				+ "to reach Room S3 (Winning Room).", "Tunnel");
		Room sThree = new Room(true, false, false, false, "The Final Room, as well as Mr. Underwood's classroom. \n"
				+ "You lose! You are empty-handed, which does not satisfy any of the guards. :(", "Room S3");
	map[2][0] = noRoom;
	map[2][3] = noRoom;
	map[3][0] = noRoom;
	map[3][1] = noRoom;
	map[3][3] = noRoom;
	map[3][4] = noRoom;
	map[4][0] = noRoom;
	map[4][1] = noRoom;
	map[4][3] = noRoom;
	map[4][4] = noRoom;
	map[2][2] = lobby;
	map[0][0] = ismael;
	map[0][1] = corrFour;
	map[0][2] = basement;
	map[0][3] = corrThree;
	map[0][4] = vincenzo;
	map[1][0] = matthias;
	map[1][1] = corrFive;
	map[1][2] = corrOne;
	map[1][3] = corrTwo;
	map[1][4] = jeremiah;
	map[2][1] = henry;
	map[2][4] = elijah;
	map[3][2] = tunnel;
	map[4][2] = sThree;
    
/* 
 * Checkpoint 4 alternate solution to adding items to Rooms for teacher reference
 * 
 * (optional) TODO: add items to desired Rooms if not done with constructors
 */
	
/*
 * TODO: Checkpoint 4 Task
 * 
 * Change the values of row and column to match the starting locations of your world
 * 
 */
    row = 2;
    column = 2;
  
  
    
    
    //Informational: initializes the currentRoom to the starting location 
    currentRoom = map[row][column];


/*
 * TODO: Checkpoint 4 Task
 * 
 * initialize the player's inventory
 */
 

        inventory = new ArrayList<InventoryItem>();

		/* Informational: Variables for the command, the command broken up, 
		*  the scanner, and boolean for game over
		*/ 
		String userInput = "";
		String command = "";
		String item = "ake";
		Scanner s = new Scanner(System.in);
		boolean done = false;
		quit = false;
		
		/* Informational:  
		 *  get the intro to the game and print
		 */
		String output = gameIntro();
		System.out.println(output);

		/* Informational:  
		 * run the game until it is over
		 */
		while(!done){
			//Informational: get the user input
			System.out.print("\n\n>>");       //Informational: note this is for readability
			userInput = s.nextLine().toLowerCase();
			
			//Informational: get the command from the user input
			command = getFirstWord(userInput);
			
			//Informational: get the rest of the string after the first word if available
			
			item = getRestOfSentence(userInput);
			
			//Informational: use the command and item to determine the proper output
			
			output = executeCommand(command, item);


			
			
			//Informational: print the output for the user
			if(!(command.equalsIgnoreCase("look")||command.equalsIgnoreCase("quit"))){
				if(!(currentRoom.getName().equalsIgnoreCase("sThree"))){
					System.out.println(output +"\n" + currentRoom.getName()+"\n"+currentRoom.getDescription());
				}
			} else {
				System.out.println(output);
			}
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the win condition to match your winning Room or scenario
 * if the player is in the winning room, provide the Room Name and
 * the Room description
 * then end the game
 *
 * Optional --
 * add losing conditions
 */
			if(currentRoom.getName().equalsIgnoreCase("Room S3")){
				System.out.println(currentRoom.getName());
				System.out.println(currentRoom.getDescription());
				done = true;
			}
	     
				
		  	if(command.equalsIgnoreCase("quit"))
			  done = true;
			
		
		}
		
		s.close();
	}

/**
 * gameIntro method 
 * used to set the scene to the opening of your game 
 * @return: a String that is the opening description to your game, 
 *          be sure to note the help option 
 *          (i.e. "type help for a list of commands").  
 */

/*
 * TODO: Checkpoint 4 Task
 * 
 * Update this to the Intro for your game.  You should be able to copy it
 * from checkpoint 3
 */
	public static String gameIntro(){
		return "You find yourself in the lobby of an abandoned hotel."
				+ "\n (Type \"help\" to see alist of commands)";
	}
	
/**
 * getFirstWord method
 * pulls the first word out of any phrase (1 or more words)
 * @param a string that contains the commands from the user
 * @return a string that is only the first word, 
 *         returns a blank string "" if nothing entered, 
 *         do not use print or println
 */
	public static String getFirstWord(String input){
		int spaceLocation = input.indexOf(" ");
		if(spaceLocation > 0)
			return input.substring(0,spaceLocation);
		if(input.length() >0)
			return input;
		return "";
	}

/**
 * getRestOfSentence 
 * pulls everything after the first word and the space behind it
 * @param a string that contains the commands from the user
 * @return a string that returns everything after the first word 
 *         and the space behind it, returns a blank string "" if 1 word entry 
 *         or nothing entered. 
 *         Do not use print or println
 */	
	public static String getRestOfSentence(String input){
		int spaceLocation = input.indexOf(" ");
		if(spaceLocation >= 0)
			return input.substring(spaceLocation+1);
		return "";
	}	

	
/**
 * north method
 * Method to state that you moved north, you will add movement functionality
 * in checkpoint 3
 * @return a string that states you moved North, do not use print or println	
 */

	public static String north(){
	  if(currentRoom.getCanGoNorth()){
	    row--;
	    updateRoom();
	    return "You moved North.";  
	  } else {
	    return "You cannot move North.";
	  }
		
	}


	
/**
 * south method
 * Method to state that you moved south, you will add movement functionality
 * in checkpoint 3
 * @return a string that states you moved South, do not use print or println
 */		

	public static String south(){
	  if(currentRoom.getCanGoSouth()){
	    row++;
	    updateRoom();
	    return "You moved South.";
	  } else if((currentRoom == map[2][2])&&(currentRoom.getCanGoSouth() == false)){
		  return "This door is locked. Use the diamond key to unlock it.";
	  }
	    return "You cannot move South.";
		
	}

/**
 * east method
 * Method to state the you moved East,  you will add movement functionality in 
 * checkpoint 3
 * @return a string that states you moved East, do not use print or println
 */
	

	public static String east(){
	  if(currentRoom.getCanGoEast()){
	    column++;
	    updateRoom();
	    return "You moved East";
	  } else {
		  return "You cannot move East.";
	  }
	}

/**
 * west method
 * Method to state the you moved West, you will add movement functionality in 
 * checkpoint 3
 * @return a string that states you moved West, do not use print or println
 */
	
	public static String west(){
	  if(currentRoom.getCanGoWest()){
	    column--;
	    updateRoom();
	    return "You moved West";
	  } else {
	    return "You cannot move West.";   
	  }
	}

/**  
 * updateRoom method
 * Method to update the room you are in (currentRoom)
 * this method uses the row and column values to 
 * update the currentRoom location
 * no parameters or return values
 */

	public static void updateRoom(){
		currentRoom = map[row][column];
	}	
	


	
/**
 * take method
 * Method to allow you to take an item, for now you will just state that 
 * "You took the <itemName>." where <itemName> is the actual name of the item.
 * 
 * example return statement:
 * "You took the apple." 
 * 
 * You will actually pick up items in checkpoint 4
 * 
 * @param s in a String to determine what object was picked up
 * @return a String that states "You took the <itemName>", do not use print or println
 */
	
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the "take" method to pick up an object specified only if it is in the room. 
 * This should add the object to your inventory if it is in the room.
 * @param name of the object to pick up
 * @return a String stating the you either picked up or cannot pick up the object as 
 * appropriate
 */

	public static String take(String item){
		if(currentRoom.hasObject(item)) {
			inventory.add(currentRoom.removeObject(item));
			return "You took the " + item + ".";
		}
		return "You can't do that.";
	}	
/** 
 * drop method
 * Method to allow you to drop an item, for now you will just state that 
 * "You dropped the <itemName>." where <itemName> is the actual name of the item.
 * 
 * example return statement:
 * "You dropped the apple."
 * 
 * You will actually drop items in checkpoint 4
 * @param takes in a string to determine what object was dropped
 * @return a string that states "You dropped the <itemName>", do not use print or println 
 */
	
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the "drop" method to drop an object only if it is in the player inventory. 
 * The object should be added to the room inventory.
 * @param name of the object to drop
 * @return a String stating the you either dropped or cannot drop the object as 
 * appropriate
 */
 
	public static String drop(String objectName){
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getName().equalsIgnoreCase(objectName)) {
				currentRoom.addObject(inventory.remove(i));
    			return "You dropped the " + objectName +".";
			}
		}
		return "You don't have any objects to drop.";
	}
	
/** 
 * look method
 * Method to allow you to look around the room
 * In checkpoint3, this will change to the room description
 *  @return a string that states "You looked around the room", do not use print or println
 */	
 
/* 
 * TODO: Checkpoint 4 task
 * 
 * add a new line with the names of the objects that can be picked up in the Room
 */
 
	public static String look(){
		if(currentRoom.getNameOfObjectsInRoom().length() != 0){
			return currentRoom.getNameOfObjectsInRoom() + "\n" + currentRoom.toString();
		}
			return "There are no objects in this room." + "\n" + currentRoom.toString();
	}
	
/** 
 * inventory method
 * Method to display the items in your inventory, for now state
 * "The current items in your inventory are:"
 * 
 * In checkpoint 4 you will create a String that consists of all of the 
 * items in your inventory
 *  @return the "The current items in your inventory are:", do not use print or println
 */
 
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the "inventory" method to state the items and their description from your inventory. 
 * @return a String that is all of the items in your inventory with descriptions, ideally on new lines
 */
	public static String inventory(){
		String names = "";
		if(inventory.size() != 0){
		names = "Current items in your inventory are: ";
		for(int i = 0; i < inventory.size(); i++){
			names += (i + 1) + ") " + inventory.get(i).getName() + " - " + inventory.get(i).getDescription() + ";\n ";
		}
		return names;
		}
		return "There are no items in your inventory.";
	}	
	
/**
 *  method
 * Method that returns the description on an item in your inventory, for now state:
 * "Description of <itemName>" where <itemName> is the itemName
 * 
 * example return statement:
 * "Description of apple"
 * 
 * In checkpoint 4 you will return the description of the object you are examining
 * @param takes in a string to determine what item you want the description of
 * @return a string that is the description of the item, do not use print or println
 */

/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the "examine" method to check if the item is in the player's inventory
 * If it is in the inventory, return the description of the item
 * If it is not in the player's inventory (even if it is in the room), state that
 * the player does not have that item
 */
	public static String examine(String item){
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getName().equalsIgnoreCase(item)){
				return "You examined the " + item + "."
						+"\n" + inventory.get(i).toString();
			}
		}
		
		return "You can't examine this object because it isn't present.";
	}	

/**
 * eat method
 * Method that allows you to eat a Food object, for now state:
 * "You ate the <itemName>" where <itemName> is the name of the itemName
 * 
 * example return statement:
 * "You ate the apple."
 * 
 * In checkpoint 4, you will update this method to remove it from your inventory, 
 * but not drop it in the room.  Advanced: this could be useful for a health system
 * 
 * 
 * @param takes in a string to determine what item you want to eat
 * @return a string that states you ate the item, do not use print or println
 */	
 
/*
 * TODO: Checkpoint 4 Task
 * Update the Eat method to allow the player to eat an Item only if
 * the item is in the player's inventory and is a food.
 * 
 * If it is in the player's inventory and not a food, state that you cannot eat the item
 * 
 * If it is not in the player's inventory, state that you do not have the item
 * 
 * Optional: if you are including a health system, do so here
 */
	public static String eat(String item){
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i) instanceof Food) {
				inventory.remove(inventory.get(i));
				currentRoom.removeObject(item);
				return "You ate the " + item + ".";
			}
		}
		return "You can't eat this because it either isn't food or you don't have it.";
	}		
	

/**  
 * use method
 * Method that allows you to use an item it, for now state:
 * "You used the <itemName>", where <itemName> is the name of the item.
 * 
 * example return statement:
 * "You used the apple."
 * 
 * In checkpoint 4 this will be updated to only allow the player to use a Key
 * in the room where the key can open a door
 * 
 * @param takes in a string to determine what item you want to use
 * @return a string that You used the item, do not use print or println
 */

/* 
 * TODO: Checkpoint 4 Task
 * 
 * Update the "use" method to make a Key open the door of a specific Room
 * 
 * If the player is in the Room where the key works and has the key, the door should be opened.  
 * You will need to update all impacted Rooms
 * 
 * If the player has the key but is not in the correct Room, state that the key will not work here
 * 
 * If the item noted by the player cannot be used ever, then state that the player cannot use that item
 * 
 * If the player does not have the item, state that the player does not have the item.
 */

		public static String use(String item){
			for(int i = 0; i < inventory.size(); i++){
				if((inventory.get(i).getName().equalsIgnoreCase(item))){
					if(inventory.get(i) instanceof Item){
						return "You used the object.";
					}
					if(inventory.get(i) instanceof Key){
						if(currentRoom.getName().equalsIgnoreCase("main lobby")){
							currentRoom.setCanGoSouth(true);
							if(inventory.size() > 1){
								map[4][2].setDescription("You win! You have retrieved one or "
										+ "more of the hidden objects which "
										+ "satisfy all of Mr. Underwood's Guards! :D");
							}
							return "You unlocked the south door!";
						} else {
							return "You cannot use that here.";
						}
					}
				}
			}
			
			return "You either do not have this object, or it is unusable food.";
		}	
	
	
/**
 * help method
 * Method that returns all of the commands and what they do
 * 
 * example return output:
 * "Command      Example      Description
 *  take         take apple   used to pick up objects"
 * 
 * @return a String that contains all the command names, an example of use, and a description of what they do.  Be sure to consider readability of the player.  Do not use print or println.
 */
	public static String help(){
		return "The following commands are used to play the game\n"
				+ "Command    Example      Description\n"
				+ "North      North        Allows you to move North\n"
				+ "South      south        Allows you to move South\n"
				+ "East       east         allows you to move East\n"
				+ "West       west         allows you to move West\n"
				+ "Look       Look         provides a detailed descriptoin of the room\n"
				+ "Take       take key     adds an item in a room to your inventory\n"
				+ "Drop        key     removes an item from your inventory and leaves it in the room\n"
				+ "Inventory  inventory    displays the names of items in your inventory\n"
				+ "Examine    examine key  provides a detailed description of the specified item, it must be in your inventory\n"
				+ "Eat        eat apple    Allows you to eat an edible item\n"
				+ "Use        use key      Allows you to use the item\n"
				+ "Help       help         displays the help menu\n"
				+ "Quit       quit         player initiated end of game\n";
	}

/**
 * quit Method
 * Method that states "You have decided to quit the game"
 * @return a message saying You have decided to quit the game, do not use print or println
 */
	public static String quit(){
		return "You have decided to quit the game.";
	}
	
/**
 * invalid method
 * Method called when a player tries a command that is not used in the game
 * @return message "I do not understand", do not use print or println
 */
		public static String invalid(){
			return "I do not understand.";
		}

		
/**
 * getCurrentRoom method
 * @return the currentRoom of the player
 */
		public static Room getCurrentRoom(){
			return currentRoom;
		}
		
		
		
/**
 * executeCommand method
 * This method uses the first word to call the appropriate method that you
 * made above.  Basically, this method manages complexity by hosting the 
 * logic to detemine which method should be used.
 * (for example, if the command is north, call the north() method). 
 * @param the String command used to check which method to call
 * @param the String item used for methods that interact with objects 
 * @return a String that is passed back from the appropriate method, 
 *         do not use print or println
 */
	public static String executeCommand(String command, String item){
		if(command.equalsIgnoreCase("north"))
			return north();
		if(command.equalsIgnoreCase("south"))
			return south();
		if(command.equalsIgnoreCase("east"))
			return east();
		if(command.equalsIgnoreCase("west"))
			return west();
		if(command.equalsIgnoreCase("inventory"))
			return inventory();
		if(command.equalsIgnoreCase("look"))
			return look();
		if(command.equalsIgnoreCase("take"))
			return take(item);
		if(command.equalsIgnoreCase("drop"))
			return drop(item);
		if(command.equalsIgnoreCase("examine"))
			return examine(item);
		if(command.equalsIgnoreCase("eat"))
			return eat(item);
		if(command.equalsIgnoreCase("use"))
			return use(item);
		if(command.equalsIgnoreCase("help"))
			return help();
		if(command.equalsIgnoreCase("quit"))
			return quit();
		return invalid();
				
	}
	
	
}


