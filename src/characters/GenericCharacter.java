package characters;
import items.GenericItem;
import locations.GenericLocation;

import java.util.ArrayList;

//SUPERCLASS for all the character types:
public class GenericCharacter {
    //MEMBER VARIABLES: (protected means child classes can use these)
    private String name;
    private String description; //short desc. of appearance
    protected String characterType; //string of the character type
    private int hitPoints; //how much damage character can take
    private ArrayList<GenericItem> cargo; //the items carried
    private GenericLocation currentLocation;
    private int silver; //money

    //CONSTRUCTOR: makes a Character object. Used also by child classes:
    public GenericCharacter(String characterName, String description) {
        this.name = characterName; //the particular character's name
        //'characterType' is assigned in each specific character class
        this.description = description; // the description of a particular char.
        this.characterType = "";
        this.hitPoints = 50;
        this.cargo = new ArrayList<>();
        this.currentLocation = new GenericLocation();
        this.silver = 50;
        System.out.println(name + " has been created.");
    }

    //no arg constructor:
    GenericCharacter() { }

    //******************** GETTERS SECTION: ********************************
    public String getName( ) {
        return name;
    }
    public String getDescription( ) {
        return name + ": " + description;
    }
    public String getCharacterType() {
        return characterType;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public ArrayList getCargo() {
        return cargo;
    }
    public GenericLocation getCurrentLocation() {
        return currentLocation;
    }
    public int getSilver() {
        return silver;
    }
    //************ END GETTERS SECTION *************************************


    //************ SETTERS SECTION: ****************************************
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public void setCargo(ArrayList<GenericItem> cargo) {
        this.cargo = cargo;
    }
    public void setCurrentLocation(GenericLocation location) {
        this.currentLocation = location;
    }
    public void setSilver(int silver) {
        this.silver = silver;
    }
    //**************** END SETTERS SECTION *********************************


}//END class GenericCharacter
