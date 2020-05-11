package characters;

public class Brawler extends GenericCharacter{



    //CONSTRUCTOR: I dont think it actually needs this, it automatically uses
    // the Character constructor (superclass)
    public Brawler () {
        super();
        this.characterType = "Brawler";
    }

    public void genericDescription () {
        System.out.println("Brawler: Brawlers are athletes who are strong and" +
                " fast, and they can defeat monsters through physical force. " +
                "They can buy weapons like baseball bats and nunchuks to " +
                "become even more formidable.");
    }

}
