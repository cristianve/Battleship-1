package Battleship;

import org.junit.Test;

/**
 * The Ship class  is  an  abstract  class  that  
 * handles  common  methods  for the different kinds 
 * of ships (Battleship, Cruiser, Destroyer). It contains 
 * a method to get the name, size and type of a ship
 * @author Roger
 *
 */

public class Ship {
	protected String name;
	protected int size;
	protected char type;
	@Test
	public String getName() { return name; }
	@Test
	public int getSize() { return size; }
	@Test
	public char getType() { return type; }
}
