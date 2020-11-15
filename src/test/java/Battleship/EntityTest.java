package Battleship;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

public class EntityTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIniciateShipsLocation() {
		Entity e = new Player();
		e.iniciateShipsLocation();
		for(int i = 0;i <e.MAX_ROW_COL;i++)
			for(int j = 0;j <e.MAX_ROW_COL;j++)
				assertEquals(' ', e.shipsLocation[i][j]);
		
	}
	@Test
	public void testPlaceShip() {
		
		//TDD
		Entity e = new Player();
		e.iniciateShipsLocation();
		Ship ship = new Crusier();
		
		assertTrue(e.placeShip(ship, 0, 0, false));
		assertFalse(e.placeShip(ship, 0, 0, true));
		assertFalse(e.placeShip(ship, 9, 9, true));
		assertFalse(e.placeShip(ship, 9, 9, false));
		
		//TEST Equivalent Partition
		e = new Player();
		e.iniciateShipsLocation();
		ship = new Crusier();
		//Valid inputs
		int[] Xvalids = {0,3,7};
		int[] Yvalids = {0,3,6};
		boolean[] BoolValids = {true, false, false};
		
		for(int i=0;i<3;i++)
		{
			assertTrue(e.placeShip(ship, Xvalids[i], Yvalids[i], BoolValids[i]));
		}
		//Invalid inputs
		e = new Player();
		e.iniciateShipsLocation();
		ship = new Crusier();
		
		int[] Xinvalids = {9,2,5};
		int[] Yinvalids = {1,8,8};
		boolean[] BoolInvalids = {true, false, false};
		for(int i=0;i<3;i++)
		{
			assertFalse(e.placeShip(ship, Xinvalids[i],Yinvalids[i], BoolInvalids[i]));
		}
		
		//TEST Boundary values Test
		
		e = new Player();
		e.iniciateShipsLocation();
		ship = new Crusier();
		
		//Limit values
		int[] Xlimit = {1,1,8,8,10,0,10,1000,0,1000};
		int[] Ylimit = {1,8,1,8,0,10,10,0, 1000,1000};
		boolean[] BoolHoriz1 = {true, true, false, true, false, false, false, false, false, false};
		for(int i=0;i<3;i++)
		{
			assertTrue(e.placeShip(ship, Xlimit[i],Ylimit[i], BoolHoriz1[i]));
		}
		for(int i=3;i<10;i++)
		{
			assertFalse(e.placeShip(ship, Xlimit[i],Ylimit[i], BoolHoriz1[i]));
		}
		
		
		//Boundary values
		e = new Player();
		e.iniciateShipsLocation();
		ship = new Crusier();
		
		int[] Xboundary = {0,0,9,9};
		int[] Yboundary = {0,9,0,9};
		boolean[] BoolHoriz2 = {true, true, false, true};
		for(int i=0;i<3;i++)
		{
			assertTrue(e.placeShip(ship, Xboundary[i],Yboundary[i], BoolHoriz2[i]));
		}
		assertFalse(e.placeShip(ship, Xboundary[3],Yboundary[3], BoolHoriz2[3]));
	}
	@Test
	public void testAskCoords() {
		
		/** TDD **/
		//TEST 1
		String myString = "A1";
		InputStream is = new ByteArrayInputStream( myString.getBytes() );
		
		Player player = new Player();
		player.ScannerLineTester(is);
		assertTrue(player.askCoords());
		
		//TEST 2
		myString = "Z2";
		is = new ByteArrayInputStream( myString.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		/** TEST Equivalent Partitions **/
		//Valid values
		player = new Player();
		String[] str = {"A1","C5","G8","J2"};
		for(int i=0;i<4;i++)
		{
			is = new ByteArrayInputStream( str[i].getBytes() );
			player.ScannerLineTester(is);
			assertTrue(player.askCoords());
		}
		//Invalid values
		player = new Player();
		String[] str1 = {"Z1"," ","00",".-,!","+", "1B", "1 C","A-3"};
		for(int i=0;i<7;i++)
		{
			is = new ByteArrayInputStream( str1[i].getBytes() );
			player.ScannerLineTester(is);
			assertFalse(player.askCoords());
		}
		is = new ByteArrayInputStream( str1[7].getBytes() );
		player.ScannerLineTester(is);
		assertTrue(player.askCoords());
		
		/** TEST Boundary values Test **/
		
		//Limit values
		player = new Player();
		String[] str2 = {"K1","A0","A11","J11","K11","A-1","J-2"};
		for(int i=0;i<5;i++)
		{
			is = new ByteArrayInputStream( str2[i].getBytes() );
			player.ScannerLineTester(is);
			assertFalse(player.askCoords());
		}
		for(int i=5;i<7;i++)
		{
			is = new ByteArrayInputStream( str2[i].getBytes() );
			player.ScannerLineTester(is);
			assertTrue(player.askCoords());
		}
		//Boundary values
		player = new Player();
		String[] str3 = {"A1","A10","J1","J10"};
		for(int i=0;i<4;i++)
		{
			is = new ByteArrayInputStream( str3[i].getBytes() );
			player.ScannerLineTester(is);
			assertTrue(player.askCoords());
		}
		
		/** Decision Coverage Test **/

		//Test FALSE 1
		String input = "A221";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, FALSE 2
		input = "AA";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, TRUE 2, FALSE 3
		input = "A0";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, TRUE 2, TRUE 3
		input = "A1";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertTrue(player.askCoords());
		
		/** Condition Coverage Test **/
		
		//Test FALSE 1
		//input1 = false , input2 = false
		input = "A221";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, FALSE 2
		//input1 = false , input2 = true, input3 = false
		input = "AAA";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, FALSE 2
		//input1 = true , input2 = false, input3 = false
		input = "AA";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, TRUE 2, FALSE 3
		//input1 = true , input2 = false, input3 = true, input4 = false, input5= true
		input = "A0";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, TRUE 2, FALSE 3
		//input1 = true , input2 = false, input3 = true, input4 = true, input5= false
		input = "P1";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, TRUE 2, FALSE 3
		//input1 = true , input2 = false, input3 = true, input4 = false, input5= false
		input = "P0";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askCoords());
		
		//Test TRUE 1, TRUE 2, TRUE 3
		//input1 = true , input2 = false, input3 = true, input4 = false, input5= false
		input = "B5";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertTrue(player.askCoords());
		
	}
	@Test
	public void testAskHorizontal() {
		
		/** TDD **/
		//TEST 1
		String myString = "Y";
		InputStream is = new ByteArrayInputStream( myString.getBytes() );
		
		Player player = new Player();
		player.ScannerLineTester(is);
		assertTrue(player.askHorizontal());
		
		//TEST 2
		myString = "N";
		is = new ByteArrayInputStream( myString.getBytes() );
		
		player.ScannerLineTester(is);
		assertTrue(player.askHorizontal());
		
		//TEST 3
		myString = "P";
		is = new ByteArrayInputStream( myString.getBytes() );
		
		player.ScannerLineTester(is);
		assertFalse(player.askHorizontal());
		
		/** TEST Equivalent Partitions **/
		//Valid values
		player = new Player();
		String[] str = {"Y","N"};
		for(int i=0;i<2;i++)
		{
			is = new ByteArrayInputStream( str[i].getBytes() );
			player.ScannerLineTester(is);
			assertTrue(player.askHorizontal());
		}
		
		//Invalid values
		player = new Player();
		String[] str1 = {"a"," ","+",".-,!","+","3", "s1-","A-"};
		for(int i=0;i<7;i++)
		{
			is = new ByteArrayInputStream( str1[i].getBytes() );
			player.ScannerLineTester(is);
			assertFalse(player.askHorizontal());
		}
		
		/** TEST Boundary values Test **/
		//Limit values
		player = new Player();
		String[] str2 = {"M","O","X","Z","n","y"};
		for(int i=0;i<6;i++)
		{
			is = new ByteArrayInputStream( str2[i].getBytes() );
			player.ScannerLineTester(is);
			assertFalse(player.askHorizontal());
		}
		
		/** Boundary values **/
		// Not needed because it was tested on the valid input tests.
		
		/** Decision Coverage Test **/

		//Test FALSE1
		String input = "YY";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askHorizontal());
		
		//Test TRUE1, FALSE2
		input = "B";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askHorizontal());
		
		//Test TRUE1, TRUE2, FALSE3
		input = "N";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertTrue(player.askHorizontal());
		
		//Test TRUE1, TRUE2, TRUE3
		input = "Y";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertTrue(player.askHorizontal());
		
		/** Condition Coverage Test **/
		
		//Test FALSE 1
		//input1 = true , input2 = false
		//Cannot be tested because the function ByteArrayInputStream can't accept empty strings.
		/**
		input = "";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askHorizontal());
		**/
		
		//input1 = false , input2 = false
		input = "YYC";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askHorizontal());
		
		//Test TRUE1, FALSE2
		//input1 = false , input2 = true, input3 = false, input4 = false
		input = "P";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertFalse(player.askHorizontal());
		
		//Test TRUE1, TRUE2, FALSE3
		//input1 = false , input2 = true, input3 = false, input4 = true
		input = "N";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertTrue(player.askHorizontal());
		
		//Test TRUE1, TRUE2, TRUE3
		//input1 = false , input2 = true, input3 = true, input4 = false
		input = "Y";
		is = new ByteArrayInputStream( input.getBytes() );
		
		player = new Player();
		player.ScannerLineTester(is);
		assertTrue(player.askHorizontal());
	}
	@Test
	public void testHasWon() {
		//TDD
		Entity e = new Player();
		e.lifes = 5;
		assertFalse(e.hasWon());
		e.lifes = 5;
		e.hits = 5;
		assertTrue(e.hasWon());
		e.hits = 3;
		assertFalse(e.hasWon());
	}
	
}
