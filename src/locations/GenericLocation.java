package locations;

import characters.GenericCharacter;
import items.GenericItem;
import java.util.ArrayList;
import java.util.HashMap;

//This class is the basis of all location objects. It will make the buildings
//and rooms within the Small World. Each location will be connected to the
//locations around it using exits that are compass points N E S W:
public class GenericLocation {

    //MEMBER VARIABLES:
    private String name;
    private String description;
    //a map that has N S E W as keys, and the location in that direction:
    private HashMap<String, GenericLocation> exits;
    //these are lists of the characters and items at this location:
    private ArrayList<GenericCharacter> characters;
    private ArrayList<GenericItem> items;

    //CONSTRUCTOR:
    public GenericLocation (String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.characters = new ArrayList<>();
        this.items = new ArrayList<>();
        //set up the HashMap of exits with its keys:
        String[] directions = {"N", "S", "E", "W"};
        for (String key : directions) {
            GenericLocation value = new GenericLocation();
            this.exits.put(key, value);
        }
    }//END CONSTRUCTOR......................................

    //no arg constructor:
    public GenericLocation () { }

    //************** GETTERS: **********************************************
    public String getName () {
        return this.name;
    }
    public String getDescription () {
        return this.description;
    }
    public GenericLocation getExit (String s) {
        return exits.get(s); //gets the value at that key
    }
    //get a character by name:
    public GenericCharacter getCharacter (String s) {
        int i = this.characters.indexOf(s);
        return characters.get(i);
    }
    //get item by name:
    public GenericItem getItem (String s) {
        int i = this.items.indexOf(s);
        return items.get(i);
    }
    //************** END GETTERS *******************************************


    //************** SETTERS: **********************************************
    public void setName (String s) {
        this.name = s;
    }
    public void setDescription (String s) {
        this.description = s;
    }
    //add a location (value) to a (N S E W) direction (key)
    public void setExit (String direction, GenericLocation location) {
        this.exits.put(direction, location);
    }
    //add a character to the list:
    public void setCharacter (GenericCharacter character) {
        this.characters.add(character);
    }
    public void setItem (GenericItem item) {
        this.items.add(item);
    }
    //************** END SETTERS *******************************************

//    @Override
//    public String toString () {
//        return
//    }

}//END class GenericLocation
