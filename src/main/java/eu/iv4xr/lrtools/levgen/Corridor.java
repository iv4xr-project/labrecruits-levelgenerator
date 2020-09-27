package eu.iv4xr.lrtools.levgen;

import java.util.LinkedList;
import java.util.List;

import eu.iv4xr.lrtools.levgen.Room.Direction;

public class Corridor extends WalledStructure {
	
	public Room from ;
	public Room to ;
	// doors guarding the corridor
	public List<Door> doors = new LinkedList<>() ;
	
	public static Corridor connect(Room src, Room dest) {
		var c = new Corridor() ;
		c.from = src ; c.to = dest ;
		src.connections.add(new Pair(c,Direction.UNKNOWN)) ;
		dest.connections.add(new Pair(c,Direction.UNKNOWN)) ;
		return null ;
	}

}
