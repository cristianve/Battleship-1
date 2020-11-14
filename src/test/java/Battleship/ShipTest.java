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
		assertEquals("Battleship", ship.getName());
		ship.name = "Crusier";
		assertEquals("Crusier", ship.getName());
	}
	@Test
	public void testGetSize() {
		Ship ship = new Ship();
		ship.size = 3;
		assertEquals(3, ship.getSize());
		ship.size = 10;
		assertEquals(10, ship.getSize());
	}
	@Test
	public void testGetType() {
		Ship ship = new Ship();
		ship.type = 'D';
		assertEquals('D',ship.getType());
		ship.type = 'Z';
		assertEquals('Z', ship.getType());
	}
}
