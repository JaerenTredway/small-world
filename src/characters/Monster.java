package characters;

public class Monster extends GenericCharacter {

    String title = "Monster";

    //CONSTRUCTOR:
    public Monster () {
        super();
    }

    public void genericDescription () {
        System.out.println("Monster: This a generic dungeon beast, evil and " +
                "dangerous.");
    }

}
