package characters;

public class Saint extends GenericCharacter {

    //CONSTRUCTOR:
    public Saint () {
        super();
        this.characterType = "Saint";
    }

    public void genericDescription () {
        System.out.println("Saint: Saints are kind people who disdain " +
                "violence and seek rather to understand than to be understood" +
                ". They can convert monsters into friends that will help them" +
                " in battle. They can also 'buy' alms for the poor to " +
                "increase their spiritual power. Unfortunately this is a very" +
                " difficult career and most Saints end up becoming martyrs.");
    }
}
