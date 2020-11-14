package Battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EntityTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIniciateShipsLocation() {
		Entity e = new Player();
		e.iniciateShipsLocation();
		for(int i = 0;i <e.MAX_ROW_COL;i++)
			for(int j = 0;j <e.MAX_ROW_COL;j++)
				assertEquals(' ', e.shipsLocation[i][j]);
		
	}
	@Test
	public void testPlaceShip() {
		Entity e = new Player();
		e.iniciateShipsLocation();
		Ship ship = new Crusier();
		assertTrue(e.placeShip(ship, 0, 0, false));
		assertFalse(e.placeShip(ship, 0, 0, true));
		assertFalse(e.placeShip(ship, 9, 9, true));
		assertFalse(e.placeShip(ship, 9, 9, false));
	}

	@Test
	public void testHasWon() {
		Entity e = new Player();
		e.lifes = 5;
		assertFalse(e.hasWon());
		e.lifes = 5;
		e.hits = 5;
		assertTrue(e.hasWon());
		e.hits = 3;
		assertFalse(e.hasWon());
	}
}
