package Battleship;

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
	public Player() {
		
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

	public void setShipsLocation(Board board) {
		
		for(Ship ship : shipList)
		{
			boolean res = false;
			board.drawPlayerShips();
			while(!res)
			{
				System.out.printf("\nCurrent ship type is %s, size is %d ",ship.getName(), ship.getSize());
				System.out.println("\nPlacing the ship...");
				
				while(!askCoords()) {}
				while(!askHorizontal()) {}

				
				if(placeShip(ship, posX, posY, horizontal))
				{
					res = true;
					lifes += ship.getSize();
				}else {
					System.out.println("\nFailed to place the ship, try again");
				}
			}
			board.updatePlayerShips(shipsLocation);
			System.out.println("\nShip placed correctly");
		}
		board.drawPlayerShips();
	}
	
	@Test
	public void attackShip(Board board)
	{
		boolean repeated = true;
		while(repeated)
		{
			System.out.println("\nAttacking a ship: ");
			while(!askCoords()) {}
			if (board.getPlayer(posX, posY) == ' ')
			{	
				repeated = false;
				if (board.getCompShips(posX, posY) != ' ')
				{
					System.out.println("\nHit!");
					board.updatePlayer(posX, posY, 'H');
					hits+=1;
				} else {
					System.out.println("\nMiss!");
					board.updatePlayer(posX, posY, 'M');
				}
			} else {
				System.out.println("\nYou already attacked these coordinates.");
			}
		}

	}
	
}
