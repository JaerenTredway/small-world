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
        //set up the HashMap of exits:
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
        return exits.get(s);
    }
    public GenericCharacter getCharacter (String s) {
        int i = this.characters.indexOf(s);
        return characters.get(i);
    }
    public GenericItem getItem (String s) {
        int i = this.items.indexOf(s);
        return items.get(i);
    }
    //************** END GETTERS *******************************************


    //************** SETTERS: **********************************************
    public void setName () {

    }
    public void setDescription () {

    }
    public void setExit () {

    }
    public void setCharacter () {

    }
    public void setItem () {

    }
    //************** END SETTERS *******************************************

    //POPULATE HASHMAP OF EXITS WITH KEYS:
    // this has Strings N S E W as keys, and the values will be the location
    // that is reached if you go in that direction (the values are added later)
    public void populateHashMap () {
        String[] directions = {"N", "S", "E", "W"};
        for (int i = 0; i < directions.length; i++) {
            String key = directions[i];
            GenericLocation value = new GenericLocation();
            this.exits.put(key, value);
        }
    }

}//END class GenericLocation
