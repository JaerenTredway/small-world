package items;

import locations.GenericLocation;

//This is the super-class that other items are extended from:
public class GenericItem {

	//MEMBER VARIABLES: (protected means child classes can use these)
	private String name;
	private String description;
	private GenericLocation currentLocation;


	//CONSTRUCTOR: makes an Item object. Used also by child classes:
	public GenericItem(String name, String description ) {
		this.name = name;
		this.description = description;
		this.currentLocation = new GenericLocation();
		System.out.println("Created a " + name);
	}

	//GETTER to access description variable:
	public String getDescription( ) {
		return name + ": " + description;
	}

	//GETTER to access name variable:
	public String getName( ) {
		return name;
	}

	//GETTER to access location variable:
	public GenericLocation getCurrentLocation( ) {
		return currentLocation;
	}

	//SETTER to set location variable:
	public void setCurrentLocation(GenericLocation location) {
		this.currentLocation = location;
	}

	//*********OTHER METHODS FROM CLASS DEMO:******************
//	//this checks if 'contents' ArrayList already has an item before adding it:
//	public void addContent( Thing t ) {
//		if (!contents.contains(t))   // short for a loop.
//			contents.add(t);
//		t.setLocation(this);
//	}
//	//this checks if 'exits' ArrayList already has an exit before adding it:
//	public void addExit( Place p ) {
//		if (!exits.contains( p ))
//			exits.add(p);
//	}
//
//	//this removes an item out of 'contents' list:
//	public void removeContent( Thing t) {
//		if (contents.contains(t))
//			contents.remove(t);
//	}
//this removes an exit out of 'exits' list:
//	public void removeExit( Place p ) {
//		if (exits.contains( p ))
//			exits.remove(p);
//	}


//	@Override
//	public boolean equals(Object o) {
//		if (o == null)
//			return false;
//		if (o.getClass() != getClass())
//			return false;
//		return (name.equals(((Thing)o).name));
//	}
	
	
}//END class Thing
