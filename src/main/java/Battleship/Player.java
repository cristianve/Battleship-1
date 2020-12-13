package Battleship;

import javax.swing.JTextArea;

import org.junit.Test;

/**
 * The  Player  class  is  an  extension  of  the  
 * Abstract  Class  Entity,it  handles  the interaction of 
 * the Player with the game. The player chooses where to
 *  place its ships and then chooses where to attack the 
 *  Computer.
 * @author Roger
 *
 */

public class Player extends Entity{
	
	JTextArea display;
	MockGUI mockGUIPlayer;
	
	
	public Player(MockGUI mockGUI) {
		
		super(mockGUI);
		mockGUIPlayer=mockGUI;
		
		this.iniciateShipsLocation();
		
		int i;
		for(i=0;i<MAX_BATTLESHIP;i++)
		{
			shipList.add(new Battleship());
		}
		for(i=0;i<MAX_CRUSIER;i++)
		{
			shipList.add(new Crusier());
		}
		for(i=0;i<MAX_DESTROYER;i++)
		{
			shipList.add(new Destroyer());
		}
	}

	public void setShipsLocation(Board board) throws InterruptedException {
		


		for(Ship ship : shipList)
		{
			boolean res = false;
			board.drawPlayerShips();
			while(!res)
			{
				
				display=mockGUIPlayer.getDisplay();
				String aux= String.format("\nCurrent ship type is %s, size is %d ",ship.getName(), ship.getSize());
				display.append(aux);
				display.append("\nPlacing the ship...");
	
				
				while(!askCoords()) {}
				while(!askHorizontal()) {}

				
				if(placeShip(ship, posX, posY, horizontal))
				{
					res = true;
					lifes += ship.getSize();
				}else {

					display.append("\nFailed to place the ship, try again");
				}
			}
			board.updatePlayerShips(shipsLocation);
			display.append("\nShip placed correctly");
		}
		display.setText("");
		board.drawPlayerShips();
		
	}
	
	@Test
	public void attackShip(Board board) throws InterruptedException
	{
	

		boolean repeated = true;
		while(repeated)
		{
			display.append("\nAttacking a ship: ");
	
			while(!askCoords()) {}
			if (board.getPlayer(posX, posY) == ' ')
			{	
				repeated = false;
				if (board.getCompShips(posX, posY) != ' ')
				{
					display.append("\nHit!");
					board.updatePlayer(posX, posY, 'H');
					hits+=1;
				} else {
					display.append("\nMiss!");
					board.updatePlayer(posX, posY, 'M');
				}
			} else {

				display.append("\nYou already attacked these coordinates.");
			}
		}

	}
	
}
