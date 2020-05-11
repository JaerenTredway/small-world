package characters;

public class Rogue extends GenericCharacter{



    //CONSTRUCTOR:
    public Rogue () {
        super();
        this.characterType = "Rogue";
    }

    public void genericDescription () {
        System.out.println("Rogue: Rogues are stealthy and cunning. They can " +
                "try to sneak around without being seen and steal treasures " +
                "without having to fight the monsters guarding them. They can" +
                " also buy distance weapons like darts to attack monsters " +
                "from a safe distance.");
    }
}
