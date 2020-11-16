package Battleship;

/**
 * The  Battleship  class  is  an  extension  
 * of  the  Abstract  Class  Ship.  It  creates  the Battleship 
 * type of ship. It consists only of a 
 * default constructor and some atributes.
 * @author Roger
 *
 */

public class Battleship extends Ship{
	private int SIZE = 4;
	public Battleship() {
		type = 'B';
		size = SIZE;
		name = "Battleship";
	}
}