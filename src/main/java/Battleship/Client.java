package Battleship;

/**
 * The  Client  class  contains  de  main  method  
 * of  the  project.  It  simply calls  the GameMaster 
 * class to start the game.
 * @author Roger
 *
 */

public class Client {
	public static void main(String[] args) {
		
		GameMaster gm = new GameMaster();
		gm.printMainMenu();
	}
}
