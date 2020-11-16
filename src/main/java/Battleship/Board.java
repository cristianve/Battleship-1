package Battleship;

import org.junit.Ignore;
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
	
	@Test
	public void drawBoards()
	{
		int i,j;
		char letterA = 'A';
		//Board numbers
		System.out.print("\t\tPlayer Board");
		System.out.print("\t\t\t");
		System.out.print("\t\t\t    Player Ships Status\n");
		
		for (j = 0; j < MAX_ROW_COL; j++) {
			System.out.printf("   %d", j+1);}
		System.out.print("\t\t\t");
		
		for (j = 0; j < MAX_ROW_COL; j++) {
			System.out.printf("   %d", j+1);}
		System.out.print("\n");
		
		//
		for (i = 0; i < MAX_ROW_COL; i++) {
			
			System.out.print("  +");			// "+" cantonada inicial
			for (j = 0; j < MAX_ROW_COL; j++) {
				System.out.print("---+");		//segment horitzontal	
			}
			System.out.print("\t\t\t");
			System.out.print("  +");			// "+" cantonada inicial
			for (j = 0; j < MAX_ROW_COL; j++) {
				System.out.print("---+");		//segment horitzontal	
			}
			
			System.out.print("\n");
			System.out.printf("%c |", letterA+i);	//Coordenades
			for (j = 0; j < MAX_ROW_COL; j++) {
				System.out.printf(" %c |", playerBoard[i][j]);		//lí­nies verticals
			}
			System.out.print("\t\t\t");
			System.out.printf("%c |", letterA+i);	//Coordenades
			for (j = 0; j < MAX_ROW_COL; j++) {
				System.out.printf(" %c |", playerShips[i][j]);		//lí­nies verticals
			}
			System.out.print("\n");
		}
		System.out.print("  +");
		for (j = 0; j < MAX_ROW_COL; j++) {
			System.out.print("---+");
		}
		System.out.print("\t\t\t");
		System.out.print("  +");
		for (j = 0; j < MAX_ROW_COL; j++) {
			System.out.print("---+");
		}
		System.out.print("\n");
	}
	
	@Test
	public void drawPlayerShips()
	{
		int i,j;
		char letterA = 'A';
		System.out.print("\t\tPlayer Ships\n");
		for (j = 0; j < MAX_ROW_COL; j++) {
			System.out.printf("   %d", j+1);}
		System.out.print("\n");
		for (i = 0; i < MAX_ROW_COL; i++) {
			System.out.print("  +");			// "+" cantonada inicial
			for (j = 0; j < MAX_ROW_COL; j++) {
				System.out.print("---+");		//segment horitzontal	
			}
			System.out.print("\n");
			System.out.printf("%c |", letterA+i);	//Coordenades
			for (j = 0; j < MAX_ROW_COL; j++) {
				System.out.printf(" %c |", playerShips[i][j]);		//lí­nies verticals
			}
			System.out.print("\n");
		}
		System.out.print("  +");
		for (j = 0; j < MAX_ROW_COL; j++) {
			System.out.print("---+");
		}
		System.out.print("\n");
	}

	@Test
	public void drawCompShips()
	{
		int i,j;
		char letterA = 'A';
		System.out.print("\t\tComputer Ships\n");
		for (j = 0; j < MAX_ROW_COL; j++) {
			System.out.printf("   %d", j+1);}
		System.out.print("\n");
		for (i = 0; i < MAX_ROW_COL; i++) {
			System.out.print("  +");			// "+" cantonada inicial
			for (j = 0; j < MAX_ROW_COL; j++) {
				System.out.print("---+");		//segment horitzontal	
			}
			System.out.print("\n");
			System.out.printf("%c |", letterA+i);	//Coordenades
			for (j = 0; j < MAX_ROW_COL; j++) {
				System.out.printf(" %c |", compShips[i][j]);		//lí­nies verticals
			}
			System.out.print("\n");
		}
		System.out.print("  +");
		for (j = 0; j < MAX_ROW_COL; j++) {
			System.out.print("---+");
		}
		System.out.print("\n");
	}
}
