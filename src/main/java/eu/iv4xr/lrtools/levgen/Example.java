package eu.iv4xr.lrtools.levgen;

import static eu.iv4xr.lrtools.levgen.Corridor.* ;
import static eu.iv4xr.lrtools.levgen.Layout.* ;
import static eu.iv4xr.lrtools.levgen.Room.* ;


import java.io.IOException;

public class Example {
	
	public static void main(String[] args) throws IOException {
		// creating rooms:
		Room[] rooms = {new Room(0), new Room(1), new Room(2), new Room(3) } ;
		// adding buttons to the rooms:
		var button0 = rooms[0].addButton("b0") ;
		var button1a = rooms[1].addButton("b1a") ;
		var button1b = rooms[1].addButton("b1b") ;
		var button1c = rooms[1].addButton("b1c") ;
		// connecting the rooms
		var door1 = connect(rooms[0],rooms[1]).guard("d1") ;
		var door2 = connect(rooms[0],rooms[2]).guard("d2") ;
		var door3 = connect(rooms[0],rooms[3]).guard("d3") ;
		var door4 = connect(rooms[1],rooms[3]).guard("d4") ;
		// connecting buttons to doors:
		door1.operatedBy(button0);
		door1.operatedBy(button1a);
		door4.operatedBy(button1b);
		door2.operatedBy(button1c);
		door2.operatedBy(button1a);
		// putting one agent:
		rooms[0].placeAgent("Smith") ;
		
		// now construct the tiled-plannar graph
		Layout layout = drawLayoutWithRetries(rooms) ;
		if(layout==null) {
			System.out.println("*** Sorry... fail to produce a plannar graph.") ;
			return ;
		}
		System.out.println(layout.toString()) ;
		
		// now generate the csv level definition:
		new RendererToLRLevelDef() . saveAsLRLevelDef("example.csv",collectButtons(rooms), layout); ;

	}

}
