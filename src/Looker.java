import java.util.List;

public class Looker extends Thing implements Actor {

	public Looker(String name, String description) {
		super(name, description);
	}

	public Thing randomItem( List<Thing> stuff ) {
		int i = (int) (Math.random() * stuff.size());
		return stuff.get(i);
	}
	
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub

		List<Thing> stuff = location.getContents();
		
		Thing chosenItem = randomItem(stuff);
		System.out.println(name + " looks at " + chosenItem.getName());
		System.out.println(name + " sees: " + chosenItem.getDescription());
	}

}
