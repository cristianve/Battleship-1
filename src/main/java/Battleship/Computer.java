package Battleship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class Computer extends Entity{
	
	protected List<Integer> map = new ArrayList<Integer>();
	
	public Computer(){
		
		this.iniciateShipsLocation();
		int i;
		Random rand = new Random();
		int posX;
		int posY;
		int posHorizontal;
		boolean array_horizontal[] = {true, false};
		
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
		for(Ship ship : shipList)
		{
			boolean res = false;
			while(!res)
			{
				posX = rand.nextInt(9);
				posY = rand.nextInt(9);
				posHorizontal = rand.nextInt(2);
				if(placeShip(ship, posX, posY, array_horizontal[posHorizontal]))
				{
					res = true;
					lifes += ship.getSize();
				}
			}
		}
	}
	
	@Test
	public void updateCompShips(Board board)
	{
		board.updateCompShips(shipsLocation);
	}
	@Test
	public void populateMapList(Board board)
	{
		for (int i = 0; i < (MAX_ROW_COL * MAX_ROW_COL); i++)
		{
			map.add(i);
		}
	}
	@Test
	public void attackShip(Board board)
	{
		int x = 0;
		int y = 0;
		
		Collections.shuffle(map);

		int randomPos = map.remove(0);
		
		if (randomPos > 0)
		{
			x = randomPos % 10;
			if (randomPos >= 10)
			{
				y = randomPos / 10;
			}
		}
		
		System.out.printf("\nComputer attacked coordinates %c%d\n", y+65, x+1);
		if (board.getComp(x, y) == ' ')
		{
			if (board.getPlayerShips(x, y) != ' ')
			{
				System.out.println("\nHit!");
				board.updateComp(x, y, 'H');
				hits +=1;
			} else {
				System.out.println("\nMiss!");
				board.updateComp(x, y, 'M');
			}
		} else {
			System.out.println("\nYou already attacked these coordinates.");
		}
		
	}
}