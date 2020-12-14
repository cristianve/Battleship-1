package Battleship;

import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JTextArea;

import org.junit.Ignore;
import org.junit.Test;

/**
 * The GameMasterclass handles the game loop. It initiates the game, starting
 * the back and fort between the player and the computer. First the player
 * places its ships, then the computer randomly places his. Finally, the player
 * and computer take turns attacking each otheruntilall the ships of one entity
 * have been hit and the game won
 * 
 * @author Roger
 *
 */

public class GameMaster {

	JTextArea display;
	MockGUI mockGUIGM;
	private boolean gameOver = false;
	private Board board;
	private Scanner scan = new Scanner(System.in);
	private Player player;
	private Computer computer;

	public GameMaster() {
	}

	public GameMaster(MockGUI mockGUI) {
		mockGUIGM = mockGUI;
		this.board = new Board(mockGUI);
		this.player = new Player(mockGUI);
		this.computer = new Computer(mockGUI);
	}

	@Ignore
	public static void wait(int seconds) {
		int ms = seconds * 1000;
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public void ScannerLineTester(InputStream in) {
		scan = new Scanner(in);
	}

	public void printMainMenu() throws InterruptedException {

		int input = -1;
		while (input != 0) {

			display = mockGUIGM.getDisplay();
			display.append("\t\t\t\tBattleship Game!\n");
			display.append("\t\tGame options:\n");
			display.append("\t\t\t1: Play\n");
			display.append("\t\t\t0: Exit\n");
			display.append("\tEnter an option: ");

			String option = mockGUIGM.getDisplayValue();
			Thread.sleep(1000);
			display.setText("");

			System.out.println(option);
			switch (option) {
			case "1":
				this.Play(mockGUIGM);
				break;
			case "0":
				display.append("\tExiting the game...\n");
				break;
			default:
				this.printMainMenu();
				break;
			}
		}
		scan.close();
	}

	@Test
	public void Play(MockGUI mockGUI) throws InterruptedException {

		display = mockGUI.getDisplay();

		player.iniciateShipsLocation();
		player.setShipsLocation(board);
		computer.updateCompShips(board);
		board.drawCompShips();
		computer.populateMapList();
		while (!this.gameOver) {
			board.drawBoards();
			if (!computer.hasWon() && !gameOver) {
				player.attackShip(board);
		
			} else if (!gameOver) {
				gameOver = true;
				board.drawBoards();
				wait(1);
				display.append("\nGame Over: Computer won!\n\n\n");
				wait(1);
			}
			if (!player.hasWon() && !gameOver) {
			
				computer.attackShip(board);
			
				display.setText("");
			} else if (!gameOver) {
				gameOver = true;
				board.drawBoards();
				wait(1);
				display.append("\nGame Over: Player won!\n\n\n");
				wait(1);
			}
		}
		player = new Player(mockGUI);
		computer = new Computer(mockGUI);
		board = new Board(mockGUI);
		gameOver = false;
	}
}
