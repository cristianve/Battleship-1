package Battleship;

import javax.swing.JTextArea;

import org.junit.Test;

/**
 * The Board class handles the Player and Computer arrays where we store the
 * information of the location of ships and attacks done. It has methods to
 * print the information
 * 
 * @author Roger
 *
 */
public class Board {

	JTextArea display;
	MockGUI mockGUIBoard;

	protected int MAX_ROW_COL = 10;
	protected char[][] playerBoard = new char[MAX_ROW_COL][MAX_ROW_COL];
	protected char[][] compBoard = new char[MAX_ROW_COL][MAX_ROW_COL];
	protected char[][] playerShips = new char[MAX_ROW_COL][MAX_ROW_COL];
	protected char[][] compShips = new char[MAX_ROW_COL][MAX_ROW_COL];

	public Board(MockGUI mockGUI) {
		mockGUIBoard = mockGUI;
		display = mockGUIBoard.getDisplay();
		for (int i = 0; i < MAX_ROW_COL; i++) {
			for (int j = 0; j < MAX_ROW_COL; j++) {
				playerBoard[i][j] = ' ';
				compBoard[i][j] = ' ';
			}
		}
	}

	@Test
	public void updatePlayer(int posX, int posY, char status) {
		playerBoard[posY][posX] = status;
	}

	@Test
	public void updateComp(int posX, int posY, char status) {
		playerShips[posY][posX] = status;
	}

	@Test
	public void updatePlayerShips(char[][] board) {
		playerShips = board;
	}

	@Test
	public void updateCompShips(char[][] board) {
		compShips = board;
	}

	@Test
	public char getPlayer(int posX, int posY) {
		return (playerBoard[posY][posX]);
	}

	@Test
	public char getComp(int posX, int posY) {
		return (compBoard[posY][posX]);
	}

	@Test
	public char getPlayerShips(int posX, int posY) {
		return (playerShips[posY][posX]);
	}

	@Test
	public char getCompShips(int posX, int posY) {
		return (compShips[posY][posX]);
	}

	@Test
	public void drawBoards() {
		int i, j;
		char letterA = 'A';
		// Board numbers
		display.append("\t\tPlayer Board");
		display.append("\t\t\t");
		display.append("\t\t\t    Player Ships Status\n");

		for (j = 0; j < MAX_ROW_COL; j++) {
			String aux = String.format("   %d", j + 1);
			display.append(aux);
		}
		display.append("\t\t\t");

		for (j = 0; j < MAX_ROW_COL; j++) {
			String aux = String.format("   %d", j + 1);
			display.append(aux);

		}
		display.append("\n");

		//
		for (i = 0; i < MAX_ROW_COL; i++) {

			display.append("  +"); // "+" cantonada inicial
			for (j = 0; j < MAX_ROW_COL; j++) {
				display.append("---+"); // segment horitzontal
			}
			display.append("\t\t\t");
			display.append("  +"); // "+" cantonada inicial
			for (j = 0; j < MAX_ROW_COL; j++) {
				display.append("---+"); // segment horitzontal
			}

			display.append("\n");
			
			String aux = String.format("%c |", letterA + i);
			display.append(aux);
			
	
			for (j = 0; j < MAX_ROW_COL; j++) {
				aux = String.format(" %c |", playerBoard[i][j]);
				display.append(aux);
	
			}
			display.append("\t\t\t");
			
			
			aux = String.format("%c |", letterA + i);
			display.append(aux);
			
	
			for (j = 0; j < MAX_ROW_COL; j++) {
				aux = String.format(" %c |", playerShips[i][j]);
				display.append(aux);
				
			}
			display.append("\n");
		}
		display.append("  +");
		for (j = 0; j < MAX_ROW_COL; j++) {
			display.append("---+");
		}
		display.append("\t\t\t");
		display.append("  +");
		for (j = 0; j < MAX_ROW_COL; j++) {
			display.append("---+");
		}
		display.append("\n");
	}

	@Test
	public void drawPlayerShips() {
		display.setText("");
		int i, j;
		char letterA = 'A';
		display.append("\t\tPlayer Ships\n");
		for (j = 0; j < MAX_ROW_COL; j++) {
			
			String aux = String.format("   %d", j + 1);
			display.append(aux);
			
			
		}
		display.append("\n");
		for (i = 0; i < MAX_ROW_COL; i++) {
			display.append("  +"); // "+" cantonada inicial
			for (j = 0; j < MAX_ROW_COL; j++) {
				display.append("---+"); // segment horitzontal
			}
			display.append("\n");
			
			String aux = String.format("%c |", letterA + i);
			display.append(aux);
			
			
			for (j = 0; j < MAX_ROW_COL; j++) {
				
				aux = String.format(" %c |", playerShips[i][j]);
				display.append(aux);
				
			}
			display.append("\n");
		}
		display.append("  +");
		for (j = 0; j < MAX_ROW_COL; j++) {
			display.append("---+");
		}
		display.append("\n");
	}

	@Test
	public void drawCompShips() {
	
		int i, j;
		char letterA = 'A';
		display.append("\t\tComputer Ships\n");
		for (j = 0; j < MAX_ROW_COL; j++) {
			String aux = String.format("   %d", j + 1);
			display.append(aux);
		}
		display.append("\n");
		for (i = 0; i < MAX_ROW_COL; i++) {
			display.append("  +"); // "+" cantonada inicial
			for (j = 0; j < MAX_ROW_COL; j++) {
				display.append("---+"); // segment horitzontal
			}
			display.append("\n");
			
			String aux = String.format("%c |", letterA + i);
			display.append(aux);
			

			for (j = 0; j < MAX_ROW_COL; j++) {
				
				aux = String.format(" %c |", compShips[i][j]);
				display.append(aux);
				
			}
			display.append("\n");
		}
		display.append("  +");
		for (j = 0; j < MAX_ROW_COL; j++) {
			display.append("---+");
		}
		display.append("\n");
		display.setText("");
	}
	
}
