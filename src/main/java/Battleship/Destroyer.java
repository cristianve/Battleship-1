package Battleship;

/**
 * The  Destroyer  class  is  an  extension  of  
 * the  Abstract  Class  Ship.  It  creates  the Battleship 
 * type of ship. It consists only of a default 
 * constructor and some atributes.
 * @author Roger
 *
 */

public class Destroyer extends Ship{
	private static int SIZE = 2;
	public Destroyer() {
		type = 'D';
		size = SIZE;
		name = "Destroyer";
	}
}