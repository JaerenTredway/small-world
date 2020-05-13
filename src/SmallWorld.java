import characters.*;
import com.sun.tools.javah.Gen;
import items.GenericItem;
import locations.GenericLocation;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Jaeren Tredway
 * This is a role-playing game in which the player goes on an adventure in a
 * Small World on a quest to find a magical treasure.
 */
@SuppressWarnings("FieldCanBeLocal")
public class SmallWorld {

	//MEMBER VARIABLES:
	private String dm = "Maître du Donjon:";
	private String playerName;
	private String home = "";
	private HumanPlayer player;
	private Scanner scanner;
	private Brawler brawler;
	private Rogue rogue;
	private Saint saint;
	private Wizard wizard;
	private boolean victory = false;
	private boolean deceased = false;
	private GenericLocation chateau;
	private GenericLocation shoppe;
	private GenericLocation emptyField;
	private GenericLocation caveEntrance;
	private GenericLocation creepyRoom;
	private GenericLocation orcTemple;
	private GenericLocation deadEnd;
	private GenericLocation inventory;
	private GenericLocation trophyCase;
	private GenericCharacter karl;
	private GenericCharacter farmer;
	private GenericCharacter caveSpider;
	private GenericCharacter orcKing;
	private ArrayList<GenericCharacter> characterList;
	private GenericItem coffee;
	private GenericItem rake;
	private GenericItem bagOfCoins;
	private GenericItem theBoutonFacile;
	private ArrayList<GenericItem> itemList;


	//CONSTRUCTOR: *********************************************************
	private SmallWorld() {
		this.playerName = "";
		//this.player = new HumanPlayer(); assign human player in setupGame()
		this.scanner = new Scanner(System.in);
		this.brawler = new Brawler();
		this.rogue = new Rogue();
		this.saint = new Saint();
		this.wizard = new Wizard();
		this.characterList = new ArrayList<>();
		this.itemList = new ArrayList<>();
		this.inventory = new GenericLocation(); //this stores the player's loot
		//place Bouton-Facile here to win:
		this.trophyCase = new GenericLocation();

	}

	//*********************MEMBER METHODS SECTION: *************************
	//PRINT AN INTRO BANNER:
	//this method prints an ASCII art banner with a brief intro to the game:
	private void printIntroBanner () {
		System.out.println(
"" +
"   _____ __  ______    __    __       _       ______  ____  __    ____  \n" +
"  / ___//  |/  /   |  / /   / /      | |     / / __ \\/ __ \\/ /   / __ \\\n" +
"  \\__ \\/ /|_/ / /| | / /   / /       | | /| / / / / / /_/ / /   / / / / \n" +
" ___/ / /  / / ___ |/ /___/ /___     | |/ |/ / /_/ / _, _/ /___/ /_/ /  \n" +
"/____/_/  /_/_/  |_/_____/_____/     |__/|__/\\____/_/ |_/_____/_____/  \n" +
"																	     \n" +
"	  	   		    _                __                                  \n" +
"	    ___  ____  (_)________  ____/ /__     ____  ____  ___  _         \n" +
"	   / _ \\/ __ \\/ / ___/ __ \\/ __  / _ \\   / __ \\/ __ \\/ _ \\(_) \n" +
"	  /  __/ /_/ / (__  ) /_/ / /_/ /  __/  / /_/ / / / /  __/           \n" +
"	  \\___/ .___/_/____/\\____/\\__,_/\\___/   \\____/_/ /_/\\___(_)    \n" +
"	     /_/                                                             \n" +
"	   ________            ____                      __         __       \n" +
"	  /_  __/ /_  ___     / __ \\________  ____ _____/ /__  ____/ /      \n" +
"	   / / / __ \\/ _ \\   / / / / ___/ _ \\/ __ `/ __  / _ \\/ __  /    \n" +
"	  / / / / / /  __/  / /_/ / /  /  __/ /_/ / /_/ /  __/ /_/ /         \n" +
"	 /_/ /_/ /_/\\___/  /_____/_/   \\___/\\__,_/\\__,_/\\___/\\__,_/    \n" +
"																	     \n" +
"			   ______                          ____                      \n" +
"			  / ____/___ __   _____     ____  / __/                      \n" +
"			 / /   / __ `/ | / / _ \\   / __ \\/ /_                      \n" +
"			/ /___/ /_/ /| |/ /  __/  / /_/ / __/                        \n" +
"			\\____/\\__,_/ |___/\\___/   \\____/_/                       \n" +
"																	     \n" +
"			   ____  __           __        __                           \n" +
"			  / __ )/ /___ ______/ /___  __/ /___ _                      \n" +
"			 / __  / / __ `/ ___/ __/ / / / / __ `/                      \n" +
"			/ /_/ / / /_/ (__  ) /_/ /_/ / / /_/ /                       \n" +
"		   /_____/_/\\__,_/____/\\__/\\__,_/_/\\__,_/                    \n" +
"");
		System.out.println("Welcome to SMALL WORLD episode one: The Dreaded " +
				"Cave of Blastula\n");
			System.out.println("I am your narrator named Maître du Donjon," +
				" in tribute to the 1970's era game 'Dungeons and Dragons'. " +
				"I am all-knowing and all-powerful, and I attempt to defeat " +
				"you. Nevertheless, you can still win if you are clever and " +
				"persevering.\n");
		System.out.println("GAME DESCRIPTION:");
		System.out.println("In this role-playing game you will become a " +
				"player in a virtual world, and you can travel through the " +
				"world on an adventure. I will guide you along the way and " +
				"describe the world to you. The goal of the game is to " +
				"acquire a treasure called the Bouton-Facile and take it back" +
				" to your chateau. The Bouton-Facile is a wish-fulfilling " +
				"device that makes everything easy. The path will be fraught" +
				" with peril, but the reward is great! ");
	}//END printIntroBanner() ...............................................


	//MAKE A NEW PLAYER-CHARACTER:
	private void makePlayerCharacter () {
		System.out.println(dm + " What is your name?");
		playerName = scanner.nextLine();
		player = new HumanPlayer(playerName);
		home = "Chateau d'" + playerName + " l'Aventurier";
 		System.out.println(dm + " Welcome " + playerName + "! It seems that " +
				"you have woken up in a strange Small World, in a beautiful " +
				"medieval house called " + home + "\n");
		System.out.println(dm + " Now that you are in this strange " +
				"realm, you will need to choose a new career. You can be one " +
				"of the following four character types:");
		brawler.genericDescription();
		wizard.genericDescription();
		rogue.genericDescription();
		saint.genericDescription();

		boolean needChoice = true;
		int choice;
		System.out.println("Choices:");
		System.out.println("Brawler = 1");
		System.out.println("Wizard = 2");
		System.out.println("Rogue = 3");
		System.out.println("Saint = 4");
		do {
			System.out.println(dm + " " + playerName + ", what career path do" +
					" you choose?");
			try {
				choice = scanner.nextInt();
				scanner.nextLine();//this clears the newline after nextInt()
			} catch (InputMismatchException ime1){
				scanner.nextLine();//this clears the bad input after nextInt()
				System.out.println(dm + " You must enter only a " +
						"number between 1 and 4:");
				continue;
			}
			switch (choice) {
				case 1 :
					player.setCharacterType("Brawler");
					break;
				case 2 :
					player.setCharacterType("Wizard");
					break;
				case 3 :
					player.setCharacterType("Rogue");
					break;
				case 4:
					player.setCharacterType("Saint");
					break;
				default:
					System.out.println(dm + " Not a valid choice, pick again:");
					continue;
			}//END switch
			needChoice = false;
		} while (needChoice);
		System.out.println(dm + " Excellent choice, " +
				playerName + ", you have chosen wisely. You will " +
				"now train to become a " + player.getCharacterType() + ".");
		System.out.println(dm + " " + player.getName() + ", you have " +
				player.getSilver() + " silver coinage to buy supplies with at" +
				" the shoppe.");
	}//END makePlayerCharacter() ...........................................


	//MAKE THE GAME MAP OF LOCATIONS:
	private void makeGameLocations () {
		chateau = new GenericLocation(home, "The lovely " +
				"medieval home of " + playerName + ", nestled in the " +
				"Alps-like land of SmallWorld.");
		shoppe = new GenericLocation("The Shoppe", "Karl " +
				"Bogenstein's Adventure Shoppe, where you can buy stuff.");
		emptyField = new GenericLocation("Empty Field", "An " +
				"empty field that used to be planted with turnips.");
		caveEntrance = new GenericLocation("Entrance to the " +
				"Dreaded Cave of Blastula", "A dark opening in the " +
                "1000 foot tall rock cliff.");
		creepyRoom = new GenericLocation("The Creepy Room",
				"A huge, scary, and dark cave chamber.");
		orcTemple = new GenericLocation("The Dreaded Orc " +
				"Temple", "A horrible temple surrounded by " +
                "bubbling lava");
		deadEnd = new GenericLocation("A dead end.",
				"Your path is blocked.");
		chateau.setExit("N", shoppe);
		chateau.setExit("S", deadEnd);
		chateau.setExit("E", deadEnd);
		chateau.setExit("W", deadEnd);
		shoppe.setExit("N", emptyField);
		shoppe.setExit("S", chateau);
		shoppe.setExit("E", deadEnd);
		shoppe.setExit("W", deadEnd);
		emptyField.setExit("N", caveEntrance);
		emptyField.setExit("S", shoppe);
		emptyField.setExit("E", deadEnd);
		emptyField.setExit("W", deadEnd);
		caveEntrance.setExit("N", creepyRoom);
		caveEntrance.setExit("S", emptyField);
		caveEntrance.setExit("E", deadEnd);
		caveEntrance.setExit("W", deadEnd);
		creepyRoom.setExit("N", orcTemple);
		creepyRoom.setExit("S", caveEntrance);
		creepyRoom.setExit("E", deadEnd);
		creepyRoom.setExit("W", deadEnd);
		orcTemple.setExit("N", deadEnd);
		orcTemple.setExit("S", creepyRoom);
		orcTemple.setExit("E", deadEnd);
		orcTemple.setExit("W", deadEnd);
		//set the player's starting location:
		player.setCurrentLocation(chateau);
		chateau.setCharacter(player);
		System.out.println(playerName + " is in the " + player.getCurrentLocation().getName());
	}//END makeGameLocations() .............................................


	//MAKE OTHER CHARACTERS:
	private void makeCharacters() {
		karl = new GenericCharacter("Karl Bogenstein",
				"the portly and friendly owner of The Adventure " +
						"Shoppe, with a Bronx accent");
		farmer = new GenericCharacter("Billy the Farmer",
				"a rugged and earthy turnip farmer with a rainbow " +
						"colored shirt and matted hair");
		caveSpider = new GenericCharacter("Blastadang",
				"a dangerous and huge glistening black spider, " +
						"dangling from his web");
		orcKing = new GenericCharacter("Prezio-Dontrum",
				"the Infamous and Dreaded Orc King, with orange " +
						"skin and swooping coiffure of yellow hair");
		karl.setCurrentLocation(shoppe);
		characterList.add(karl);
		farmer.setCurrentLocation(emptyField);
		characterList.add(farmer);
		caveSpider.setCurrentLocation(creepyRoom);
		characterList.add(caveSpider);
		orcKing.setCurrentLocation(orcTemple);
		characterList.add(orcKing);
	}//END makeCharacters() ...............................................


	//MAKE ITEMS FOUND IN THE WORLD:
	private void makeItems () {
		coffee = new GenericItem("Cup of Joe",
				" a steaming cup of aromatic coffee");
		rake = new GenericItem("Garden Rake",
				" an old but sturdy garden tool");
		bagOfCoins = new GenericItem("Treasure",
				" a cloth bag with 25 silver coins in it");
		theBoutonFacile = new GenericItem("The Bouton-Facile",
				" the magical treasure of legend, that makes " +
						"everything easy");
		coffee.setCurrentLocation(shoppe);
		itemList.add(coffee);
		rake.setCurrentLocation(emptyField);
		itemList.add(rake);
		bagOfCoins.setCurrentLocation(creepyRoom);
		itemList.add(bagOfCoins);
		theBoutonFacile.setCurrentLocation(orcTemple);
		itemList.add(theBoutonFacile);
	}//END makeItems() ....................................................


	//PLAY THE GAME TURN-BY-TURN:
	private void playGame () {
		String usage = "O = options\n" +
				"N = move North\n" +
				"S = move South\n" +
				"E = move East\n" +
				"W = move West\n" +
				"HOLLER = to yell\n" +
				"P = pick up item\n" +
				"V = view your inventory\n" +
				"T = place Bouton-Facile into trophy case";
		System.out.println(dm + " AND SO IT BEGINS. To fulfill your destiny, " +
				"you must seek out and recover the legendary Bouton-Facile " +
				"from the Dreaded Cave of Blastula. During any turn, enter " +
				"the letter O to see your options.");
		//EACH GAME TURN:
		do {
			//describe current location:::::::::::::::::::::::::::::::::::::::
			GenericLocation currentLocation = player.getCurrentLocation();
			System.out.println("\n" + dm + " " + playerName + ", you are in " +
                    "the " + currentLocation.getName());
			System.out.println(player.getCurrentLocation().getDescription());
			//describe characters present at current location:::::::::::::::::
			for (GenericCharacter character : characterList) {
				if (character.getCurrentLocation().equals(currentLocation)) {
					System.out.println(
							character.getDescription() + ", is here.");
				}
			}
			//describe items present at current location::::::::::::::::::::::
			for (GenericItem item : itemList) {
				if (item.getCurrentLocation().equals(currentLocation)) {
					System.out.println(
							item.getDescription() + ", is here.");
				}
			}
			//process player's choice of action:::::::::::::::::::::::::::::::
			System.out.println(dm + " Enter your action: (O for options)");
			String action = scanner.nextLine().toUpperCase();
			switch (action) {
				case "O":
					System.out.println("Action: Available commands:");
					System.out.println(usage);
					break;
				case "N":
					System.out.println("Action: Go North:");
					if (currentLocation.getExit("N").equals(deadEnd)) {
						System.out.println("You can't go that way.");

					} else {
						GenericLocation newLocation = currentLocation.getExit("N");
						player.setCurrentLocation(newLocation);
					}
					break;
				case "S":
					System.out.println("Action: Go South:");
					if (currentLocation.getExit("S").equals(deadEnd)) {
						System.out.println("You can't go that way.");

					} else {
						GenericLocation newLocation = currentLocation.getExit("S");
						player.setCurrentLocation(newLocation);
					}
					break;
				case "E":
					System.out.println("Action: Go East:");
					if (currentLocation.getExit("E").equals(deadEnd)) {
						System.out.println("You can't go that way.");

					} else {
						GenericLocation newLocation = currentLocation.getExit("E");
						player.setCurrentLocation(newLocation);
					}
					break;
				case "W":
					System.out.println("Action: Go West:");
					if (currentLocation.getExit("W").equals(deadEnd)) {
						System.out.println("You can't go that way.");

					} else {
						GenericLocation newLocation = currentLocation.getExit("W");
						player.setCurrentLocation(newLocation);
					}
					break;
				case "HOLLER" :
					System.out.println("YEEEEEEEEEEE-HAAAAAAAAAAAAAAAW!!");
					break;
				case "P" :
					System.out.println("Action: Pick up item:");
					boolean noItem = true;
					for (GenericItem item : itemList) {
						if (item.getCurrentLocation().equals(currentLocation)) {
							System.out.println("You picked up the " +
									item.getName());
							item.setCurrentLocation(inventory);
							noItem = false;
						}
					}
					if (noItem) {
						System.out.println("There is nothing to pick up here.");
					}
					break;
				case "V" :
					System.out.println("Action: View inventory:");
					boolean empty = true;
					System.out.println("Your inventory contains: ");
					for (GenericItem item : itemList) {
						if (item.getCurrentLocation().equals(inventory)) {
							System.out.println(item.getName());
							empty = false;
						}
					}
					if (empty) {
						System.out.println("nothing");
					}
					break;
				case "T" :
					System.out.println("Action: Place treasure in trophy " +
							"case:");
					if ( (player.getCurrentLocation().equals(chateau)) &&
						(theBoutonFacile.getCurrentLocation().equals(inventory)) ) {
							System.out.println("You placed the " +
									theBoutonFacile.getName() + " into your" +
									" trophy case.");
							victory = true;
					} else {
						System.out.println("You must acquire the " +
								theBoutonFacile.getName() + " first, and take" +
								" it to " + home + ", in order to place in " +
								"your trophy case and achieve victory.");
					}
					break;
			}//END switch block
		} while (!victory);
		//victory message:
		System.out.println("\n*********************************************");
		System.out.println(dm + playerName + ", you have achieved greatness " +
				"and completed the quest, you are VICTORIOUS!");
	}//END playGame() ......................................................

	//MAIN METHOD does not use command line arguments:
	public static void main(String[] args) {
		//1. construct SmallWorld object
		//2. run an intro banner and intro text that describes the game
		//3. set up the game: get user input to make player-character, then
		// make the locations, make the other characters, make the items, and
		// assign everything to its starting location.
		//4. run the game turn by turn until player wins

		SmallWorld blastula = new SmallWorld();
		blastula.printIntroBanner();
		blastula.makePlayerCharacter();
		blastula.makeGameLocations();
		blastula.makeCharacters();
		blastula.makeItems();
		blastula.playGame();

	}//END main()

}//END class SmallWorld
