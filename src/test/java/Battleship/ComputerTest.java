//package Battleship;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class ComputerTest {
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@Test
//	public void testUpdateCompShips() {
//		Board testBoard = new Board();
//		Computer comp = new Computer();
//		
//		for(int i = 0;i <testBoard.MAX_ROW_COL;i++)
//			for(int j = 0;j <testBoard.MAX_ROW_COL;j++)
//				comp.shipsLocation[i][j] = 'o';
//		comp.updateCompShips(testBoard);
//		for(int i = 0;i <testBoard.MAX_ROW_COL;i++)
//			for(int j = 0;j <testBoard.MAX_ROW_COL;j++)
//				assertEquals('o', testBoard.compShips[i][j]);
//	}
//
//	@Test
//	public void testPopulateMapList() {
//		Computer comp = new Computer();
//		
//		for (int i = 0; i < (comp.MAX_ROW_COL * comp.MAX_ROW_COL); i++)
//		{
//			comp.map.add(i);
//		}
//		
//		for (Integer i = 0; i < (comp.MAX_ROW_COL * comp.MAX_ROW_COL); i++)
//		{
//			assertEquals(i, comp.map.get(i));
//		}
//	}
//
//	@Test
//	public void testAttackShip() {
//		Player play = new Player();
//		play.iniciateShipsLocation();
//		play.shipList.clear();
//		Ship ship = new Battleship();
//		play.placeShip(ship, 0, 0, true);
//		
//		Computer comp = new Computer();
//
//		Board board = new Board();
//		board.updatePlayerShips(play.shipsLocation);
//		comp.populateMapList();
//		//TEST 1
//		int hitsFinal = ship.getSize();
//		for(int i=0;i<comp.MAX_ROW_COL * comp.MAX_ROW_COL;i++)
//			comp.attackShip(board);
//		
//		int hitsAfter = comp.hits;
//		assertEquals(hitsFinal, hitsAfter);
//		for(int i=0;i<ship.getSize();i++)
//		{
//			assertEquals('H', board.playerShips[0][i]);
//			assertEquals('M', board.playerShips[1][i]);
//		}
//	}
//
//}
