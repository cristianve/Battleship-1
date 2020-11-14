package Battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetShipsLocation() {
		
		Player player = new Player();
		Board board = new Board();
		Ship ship = new Battleship();
		
		//TEST 1
		
		player.iniciateShipsLocation();
		player.posX = 0;
		player.posY = 0;
		player.horizontal = true;
		
		player.shipList.clear();
		player.shipList.add(ship);
		player.setShipsLocation(board);
		
		boolean horizontal = player.horizontal;
		int posX = player.posX;
		int posY = player.posY;
		
		if(horizontal)
		{	
			if(posX+ship.getSize() <= player.MAX_ROW_COL)
			{
				for(int i=posX;i<(posX+ship.getSize());i++)
				{
					assertEquals(ship.getType(), player.shipsLocation[posY][i]);
				}
			}

		}
		
		//TEST 2
		Ship ship2 = new Crusier();
		
		player.posX = 2;
		player.posY = 2;
		player.horizontal = false;
		
		player.shipList.clear();
		player.shipList.add(ship2);
		player.setShipsLocation(board);
		
		horizontal = player.horizontal;
		posX = player.posX;
		posY = player.posY;
		
		if(!horizontal)
		{
			if(posY+ship2.getSize() <= player.MAX_ROW_COL)
			{
				for(int i=posY;i<(posY+ship2.getSize());i++)
				{
					assertEquals(ship2.getType(), player.shipsLocation[i][posX]);
				}
			}
		}
	}
		
	
	@Test
	public void testAttackShip() {
		Computer comp = new Computer();
		comp.iniciateShipsLocation();
		comp.shipList.clear();
		Ship ship = new Battleship();
		comp.placeShip(ship, 0, 0, true);
		
		Player player = new Player();
		player.iniciateShipsLocation();
		
		Board board = new Board();
		board.updateCompShips(comp.shipsLocation);
		//TEST 1
		int hitsBefore = player.hits;
		player.posX = 0;
		player.posY = 0;
		player.attackShip(board);
		int hitsAfter = player.hits;
		assertEquals(hitsBefore+1, hitsAfter);
		assertEquals('H', board.playerBoard[0][0]);
		
		//TEST 2
		int hitsBefore1 = player.hits;
		player.posX = 4;
		player.posY = 1;
		player.attackShip(board);
		int hitsAfter1 = player.hits;
		assertEquals(hitsBefore1, hitsAfter1);
		assertEquals('M', board.playerBoard[1][4]);
	}

}
