package Battleship;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
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
		String coords = "A1";
		InputStream is = new ByteArrayInputStream( coords.getBytes() );
		player.ScannerLineTester(is);
		
		int hitsBefore = player.hits;

		player.attackShip(board);
		int hitsAfter = player.hits;
		
		assertEquals(hitsBefore+1, hitsAfter);
		assertEquals('H', board.playerBoard[0][0]);
		
		//TEST 2
		int hitsBefore1 = player.hits;
		
		coords = "B4";
		InputStream is1 = new ByteArrayInputStream( coords.getBytes() );
		player.ScannerLineTester(is1);
		
		player.attackShip(board);
		int hitsAfter1 = player.hits;
		assertEquals(hitsBefore1, hitsAfter1);
		assertEquals('M', board.playerBoard[1][3]);
		
	}
	@Test 
	public void testIniciateShipsLocation(){
		/** Test Loop testing **/
		//Simple loop test
		Player player = new Player();
		int n = player.getMAX_ROW_COL();
		//Test case: Avoid loop
		player.shipsLocation = new char[n][n];
		player.setMAX_ROW_COL(0);
		player.iniciateShipsLocation();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j< n;j++)
			{
				assertNotEquals(player.shipsLocation[i][j],' ');
			}
		}
		//Test case: One time pass trough the loop
		player.shipsLocation = new char[n][n];
		player.setMAX_ROW_COL(1);
		player.iniciateShipsLocation();
		for(int i=0;i<1;i++)
		{
			for(int j=0;j< 1;j++)
			{
				assertEquals(player.shipsLocation[i][j],' ');
			}
		}
		//Test case: Two times pass trough the loop
		player.shipsLocation = new char[n][n];
		player.setMAX_ROW_COL(2);
		player.iniciateShipsLocation();
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				assertEquals(player.shipsLocation[i][j],' ');
			}
		}
		//Test case: m times pass trough the loop; m=5
		player.shipsLocation = new char[n][n];
		player.setMAX_ROW_COL(5);
		player.iniciateShipsLocation();
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				assertEquals(player.shipsLocation[i][j],' ');
			}
		}
		//Test case: n-1 times pass trough the loop
		player.shipsLocation = new char[n][n];
		player.setMAX_ROW_COL((n-1));
		player.iniciateShipsLocation();
		for(int i=0;i<(n-1);i++)
		{
			for(int j=0;j<(n-1);j++)
			{
				assertEquals(player.shipsLocation[i][j],' ');
			}
		}
	}

}
