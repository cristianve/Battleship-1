package Battleship;

import org.junit.Test;

public class Board {
	protected int MAX_ROW_COL = 10;
	protected char[][] playerBoard = new char[MAX_ROW_COL][MAX_ROW_COL];
	protected char[][] compBoard = new char[MAX_ROW_COL][MAX_ROW_COL];
	protected char[][] playerShips = new char[MAX_ROW_COL][MAX_ROW_COL];
	protected char[][] compShips = new char[MAX_ROW_COL][MAX_ROW_COL];
	
	public Board()
	{
		for(int i=0;i<MAX_ROW_COL;i++)
		{
			for(int j=0;j< MAX_ROW_COL;j++)
			{
				playerBoard[i][j] = ' ';
				compBoard[i][j] = ' ';
			}
		}
	}
	
	@Test 
	public void updatePlayer(int posX, int posY, char status) { playerBoard[posY][posX] = status; }
	@Test
	public void updateComp(int posX, int posY, char status) { playerShips[posY][posX] = status; }
	@Test
	public void updatePlayerShips(char[][] board) { playerShips = board; }
	@Test
	public void updateCompShips(char[][] board) { compShips = board; }
	@Test
	public char getPlayer(int posX, int posY) { return (playerBoard[posY][posX]); }
	@Test
	public char getComp(int posX, int posY) { return (compBoard[posY][posX]); }
	@Test
	public char getPlayerShips(int posX, int posY) { return (playerShips[posY][posX]); }
	@Test
	public char getCompShips(int posX, int posY) { return (compShips[posY][posX]); }
}
	
