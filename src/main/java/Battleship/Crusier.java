package Battleship;

/**
 * The  Cruiser  class  is  an  extension  of  the  
 * Abstract  Class  Ship.  It  creates  the Battleship 
 * type of ship. It consists only of a default 
 * constructor and some atributes.
 * @author Roger
 *
 */

public class Crusier extends Ship{
	private int SIZE = 3;
	public Crusier() {
		type = 'C';
		size = SIZE;
		name = "Crusier";
	}
}
