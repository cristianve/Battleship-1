package Battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		Ship ship = new Ship();
		ship.name = "Battleship";
		String tName = "Battleship";
		assertEquals(tName, ship.getName());
	}
	@Test
	public void testSetName() {
		Ship ship = new Ship();
		String tName = "Crusier";
		ship.setName(tName);
		assertEquals(tName, ship.getName());
	}
	@Test
	public void testGetSize() {
		Ship ship = new Ship();
		ship.size = 3;
		assertEquals(3, ship.getSize());
	}
	@Test
	public void testGetType() {
		Ship ship = new Ship();
		ship.type = 'D';
		assertEquals('D',ship.getType());
	}
}
