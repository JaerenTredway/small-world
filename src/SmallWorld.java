import characters.*;
import locations.GenericLocation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jaeren Tredway
 * This is a workroom for building a Dungeons and Dragons game for the command
 * line.
 */
public class SmallWorld {

	//MEMBER VARIABLES:
	private String dm = "DUNGEON MASTER:";
	private String playerName;
	private HumanPlayer player;
	private Scanner scanner;
	private Brawler brawler;
	private Rogue rogue;
	private Saint saint;
	private Wizard wizard;
	private ArrayList<GenericLocation> locationsList;
	private ArrayList<GenericCharacter> characters;

	//CONSTRUCTOR:
	private SmallWorld() {
		this.playerName = "";
		//this.player = new HumanPlayer(); assign human player in setupGame()
		this.scanner = new Scanner(System.in);
		this.brawler = new Brawler();
		this.rogue = new Rogue();
		this.saint = new Saint();
		this.wizard = new Wizard();
		this.locationsList = new ArrayList<>();
		this.characters = new ArrayList<>();
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
			System.out.println("I am your narrator named DUNGEON MASTER, in " +
				"tribute to the 1970's era game 'Dungeons and Dragons'. I am " +
				"all-knowing and all-powerful, and I attempt to defeat you. " +
				"Nevertheless, you can still win if you are clever and " +
				"persevering.\n");
		System.out.println("GAME DESCRIPTION:");
		System.out.println("In this role-playing game you will become a " +
				"player in a virtual world, and you can travel through the " +
				"world on an adventure. I will guide you along the way and " +
				"describe the world to you. The goal of the game is to " +
				"acquire a treasure called the Easy Button and take it back " +
				"to your chateau. The Easy Button is a wish-fulfilling " +
				"device that makes everything easy. The path will be fraught" +
				" with peril, but the reward is great! ");
	}//END printIntroBanner() ...............................................


	//MAKE A NEW PLAYER-CHARACTER:
	private void makePlayerCharacter () {
		System.out.println(dm + " What is your name?");
		playerName = scanner.nextLine();
		player = new HumanPlayer(playerName);
		System.out.println(dm + " " + playerName + ", you have " +
				"woken up in a strange Small World, in a beautiful medieval " +
				"house called Chateau d'" + playerName);
		System.out.println(dm + " Now that you are in this strange " +
				"realm, you will need to choose a new career. You can be one " +
				"of the following four character types:");
		brawler.genericDescription();
		wizard.genericDescription();
		rogue.genericDescription();
		saint.genericDescription();

		boolean needChoice = true;
		int choice = 0;
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
			if (choice == 1) {
				player.setCharacterType("Brawler");
			}
			else if (choice == 2) {
				player.setCharacterType("Wizard");
			}
			else if (choice == 3) {
				player.setCharacterType("Rogue");
			}
			else if (choice == 4) {
				player.setCharacterType("Saint");
			}
			else {
				System.out.println(dm + " Not a valid choice, pick again:");
				continue;
			}
			needChoice = false;
		} while (needChoice);
		System.out.println(dm + " Excellent choice, " +
				playerName + ", you have chosen wisely. You will " +
				"now train to become a " + player.getCharacterType() + ".");
		System.out.println(dm + " " + player.getName() + ", you have " +
				player.getSilver() + " silver coinage to buy supplies with in" +
				" the shoppe.");
	}//END makePlayerCharacter() .....................................................


	//MAKE THE GAME MAP OF LOCATIONS:
	private void makeGameLocations () {

	}//END makeGameLocations() .............................................

	//MAIN METHOD does not use command line arguments:
	public static void main(String[] args) {
		//1. construct SmallWorld object
		//2. run an intro banner and intro text that describes the game
		//3. set up the game: get user input to make player-character, then
		// make the locations, make the other characters, make the items, and
		// assign everything to its starting location.
		//4. run the game turn by turn until player is destroyed or player wins

		SmallWorld blastula = new SmallWorld();
		blastula.printIntroBanner();
		blastula.makePlayerCharacter();
	}//END main()

}//END class SmallWorld
