package Battleship;

import org.junit.Test;

public class Ship {
	protected String name;
	protected int size;
	protected char type;
	@Test
	public String getName() { return name; }
	@Test
	public void setName(String name) { this.name = name;}
	@Test
	public int getSize() { return size; }
	@Test
	public char getType() { return type; }
}
