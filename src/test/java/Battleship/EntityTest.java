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
		
		//TDD
		Entity e = new Player();
		e.iniciateShipsLocation();
		Ship ship = new Crusier();
		
		assertTrue(e.placeShip(ship, 0, 0, false));
		assertFalse(e.placeShip(ship, 0, 0, true));
		assertFalse(e.placeShip(ship, 9, 9, true));
		assertFalse(e.placeShip(ship, 9, 9, false));
		
		//TEST Equivalent Partition
		e = new Player();
		e.iniciateShipsLocation();
		ship = new Crusier();
		//Valid inputs
		int[] Xvalids = {0,3,7};
		int[] Yvalids = {0,3,6};
		boolean[] BoolValids = {true, false, false};
		
		for(int i=0;i<3;i++)
		{
			assertTrue(e.placeShip(ship, Xvalids[i], Yvalids[i], BoolValids[i]));
		}
		//Invalid inputs
		e = new Player();
		e.iniciateShipsLocation();
		ship = new Crusier();
		
		int[] Xinvalids = {9,2,5};
		int[] Yinvalids = {1,8,8};
		boolean[] BoolInvalids = {true, false, false};
		for(int i=0;i<3;i++)
		{
			assertFalse(e.placeShip(ship, Xinvalids[i],Yinvalids[i], BoolInvalids[i]));
		}
		
		//TEST Boundary values Test
		
		e = new Player();
		e.iniciateShipsLocation();
		ship = new Crusier();
		
		//Limit values
		int[] Xlimit = {1,1,8,8,10,0,10,1000,0,1000};
		int[] Ylimit = {1,8,1,8,0,10,10,0, 1000,1000};
		boolean[] BoolHoriz1 = {true, true, false, true, false, false, false, false, false, false};
		for(int i=0;i<3;i++)
		{
			assertTrue(e.placeShip(ship, Xlimit[i],Ylimit[i], BoolHoriz1[i]));
		}
		for(int i=3;i<10;i++)
		{
			assertFalse(e.placeShip(ship, Xlimit[i],Ylimit[i], BoolHoriz1[i]));
		}
		
		
		//Boundary values
		e = new Player();
		e.iniciateShipsLocation();
		ship = new Crusier();
		
		int[] Xboundary = {0,0,9,9};
		int[] Yboundary = {0,9,0,9};
		boolean[] BoolHoriz2 = {true, true, false, true};
		for(int i=0;i<3;i++)
		{
			assertTrue(e.placeShip(ship, Xboundary[i],Yboundary[i], BoolHoriz2[i]));
		}
		assertFalse(e.placeShip(ship, Xboundary[3],Yboundary[3], BoolHoriz2[3]));
	}
	@Test
	public void testAskCoords() {
		
		//TEST Equivalent Partition
		
		/**
		//Valid values
		Player player = new Player();
		int[] Xinputs = {0,5,2}; //1,6,3
		int[] Yinputs = {0,4,1}; //A,E,B
		for(int i=0;i<3;i++)
		{
			assertTrue(player.askCoords());
			assertEquals(Xinputs[i], player.posX);
			assertEquals(Yinputs[i], player.posY);
		}
		//Invalid values
		player = new Player();
		int[] Xinputs1 = {-1,0,-4,10000}; 
		int[] Yinputs1 = {2,-3,-100,-10000};
		for(int i=0;i<4;i++)
		{
			assertFalse(player.askCoords());
			assertNotEquals(Xinputs1[i], player.posX);
			assertNotEquals(Yinputs1[i], player.posY);
			assertEquals(0, player.posX);
			assertEquals(0, player.posY);
		} **/
	}
	@Test
	public void testHasWon() {
		//TDD
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
