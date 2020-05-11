package locations;

import characters.GenericCharacter;
import items.GenericItem;
import java.util.ArrayList;

//This class is the basis of all location objects. It will make the buildings
//and rooms within the Small World. Each location will be connected to the
//locations around it using exits that are compass points N E S W:
public class GenericLocation {

    //MEMBER VARIABLES:
    private String name;
    private String description;
    private ArrayList<String> exits;
    //these are lists of the characters and items at this location:
    private ArrayList<GenericCharacter> characters;
    private ArrayList<GenericItem> items;

    //CONSTRUCTOR:
    public GenericLocation (String name, String description) {
        this.exits = new ArrayList<>();
        this.characters = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    //no arg constructor:
    public GenericLocation () {

    }

    //METHODS:
    public void addExit (String exit) {

    }

    public void addCharacter (GenericCharacter character) {

    }

    public void addItem (GenericItem item) {

    }

    public void getName () {

    }

    public void getDescription () {

    }

    public void getExit () {

    }

    public void getCharacter () {

    }

    public void getItem () {

    }



}//END class GenericLocation
