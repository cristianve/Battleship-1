package Battleship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JTextArea;

import org.junit.Test;

/**
 * The Computer  classis  an  extension  of  the  
 * Abstract  Class  Entity,  ithandles  the interaction of 
 * the simulated Computer AI with the game. 
 * The Computer randomly places ships on his map and 
 * attacks randomly at the player
 * @author Roger
 *
 */

public class Computer extends Entity{
	
	protected List<Integer> map = new ArrayList<Integer>();
	
	JTextArea display;
	MockGUI mockGUIComputer;
	
	public Computer(MockGUI mockGUI){
		
		mockGUIComputer = mockGUI;
		display=mockGUIComputer.getDisplay();
		
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
	public void populateMapList()
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

		String aux = String.format("\nComputer attacked coordinates %c%d\n", y+65, x+1);
		display.append(aux);
		if (board.getComp(x, y) == ' ')
		{
			if (board.getPlayerShips(x, y) != ' ')
			{
	
				display.append("\nHit!");
				board.updateComp(x, y, 'H');
				hits +=1;
			} else {
				display.append("\nMiss!");
				board.updateComp(x, y, 'M');
			}
		}
		
	}
}