package Battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUpdatePlayer() {
		Board testBoard = new Board();
		testBoard.updatePlayer(5, 5, 'd');
		char result = testBoard.playerBoard[5][5];
		assertEquals(result, 'd');
		
		testBoard.updatePlayer(1, 9, 'e');
		char result1 = testBoard.playerBoard[9][1];
		assertEquals(result1, 'e');
	}
	
	@Test
	public void testUpdateComp() {
		Board testBoard = new Board();
		testBoard.updateComp(2, 5, 'f');
		char result = testBoard.playerShips[5][2];
		assertEquals(result, 'f');
		
		testBoard.updateComp(0, 1, 'a');
		char result1 = testBoard.playerShips[1][0];
		assertEquals(result1, 'a');
	}
	
	@Test
	public void testUpdatePlayerShips() {
		Board testBoard = new Board();
		char[][] playerBoard = new char[testBoard.MAX_ROW_COL][testBoard.MAX_ROW_COL];
		for(int i = 0;i <testBoard.MAX_ROW_COL;i++)
			for(int j = 0;j <testBoard.MAX_ROW_COL;j++)
				playerBoard[i][j] = 'o';
		testBoard.updatePlayerShips(playerBoard);
		for(int i = 0;i <testBoard.MAX_ROW_COL;i++)
			for(int j = 0;j <testBoard.MAX_ROW_COL;j++)
				assertEquals('o', testBoard.playerShips[i][j]);
	}
	
	@Test
	public void testUpdateCompShips() {
		Board testBoard = new Board();
		char[][] compBoard = new char[testBoard.MAX_ROW_COL][testBoard.MAX_ROW_COL];
		for(int i = 0;i <testBoard.MAX_ROW_COL;i++)
			for(int j = 0;j <testBoard.MAX_ROW_COL;j++)
				compBoard[i][j] = 'v';
		testBoard.updateCompShips(compBoard);
		for(int i = 0;i <testBoard.MAX_ROW_COL;i++)
			for(int j = 0;j <testBoard.MAX_ROW_COL;j++)
				assertEquals('v', testBoard.compShips[i][j]);
	}
	
	@Test
	public void testGetPlayer() {
		Board testBoard = new Board();
		testBoard.playerBoard[1][2] = 'p';
		assertEquals('p', testBoard.getPlayer(2, 1));
		
		testBoard.playerBoard[6][1] = 't';
		assertEquals('t', testBoard.getPlayer(1, 6));
	}

	@Test
	public void testGetComp() {
		Board testBoard = new Board();
		testBoard.compBoard[3][5] = 's';
		assertEquals('s', testBoard.getComp(5, 3));
		
		testBoard.compBoard[0][5] = 'r';
		assertEquals('r', testBoard.getComp(5, 0));
	}
	
	@Test
	public void testGetPlayerShips() {
		Board testBoard = new Board();
		testBoard.playerShips[0][7] = 'a';
		assertEquals('a', testBoard.getPlayerShips(7, 0));
		
		testBoard.playerShips[6][1] = 'q';
		assertEquals('q', testBoard.getPlayerShips(1,6));
	}

	@Test
	public void testGetCompShips() {
		Board testBoard = new Board();
		testBoard.compShips[9][8] = 'l';
		assertEquals('l', testBoard.getCompShips(8, 9));
		
		testBoard.compShips[4][2] = 'w';
		assertEquals('w', testBoard.getCompShips(2, 4));
	}
}