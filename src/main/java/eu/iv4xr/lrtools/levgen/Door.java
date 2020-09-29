package eu.iv4xr.lrtools.levgen;

public class Door {
	String ID ;
	boolean initialState = false ; // by default closed
	public Door(String id) { this.ID = id ; }
	
	public void operatedBy(Button ... buttons) {
		for(var B : buttons) {
			B.associatedDoors.add(this) ;
		}
	}
}
