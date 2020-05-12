package characters;

public class Wizard extends GenericCharacter{

    //CONSTRUCTOR:
    public Wizard () {
        super();
        this.characterType = "Wizard";
    }

    public void genericDescription () {
        System.out.println("Wizard: Wizards are smart people who can learn to" +
                " use magic to change the world around them. They can also " +
                "buy magic scrolls and potions and learn how to use them.");
    }
}
