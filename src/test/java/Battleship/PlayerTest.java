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
	public void testSetShipsLocation() {
		
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

}
