//package Battleship;
//
//import static org.junit.Assert.*;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class GameMasterTest {
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	/**
//	 * Test method for {@link Battleship.GameMaster#wait(int)}.
//	 */
//	@Test
//	public void testWaitInt() {
//
//		//Calling the function for statement coverage testing
//		GameMaster gm = new GameMaster();
//		gm.wait(1);
//	}
//
//	/**
//	 * Test method for {@link Battleship.GameMaster#ScannerLineTester(java.io.InputStream)}.
//	 */
//	@Test
//	public void testScannerLineTester() {
//		
//		//Calling the function for statement coverage testing
//		GameMaster gm = new GameMaster();
//
//		String myString = "Y";
//		InputStream is = new ByteArrayInputStream( myString.getBytes() );
//		gm.ScannerLineTester(is);
//	}
//
//	/**
//	 * Test method for {@link Battleship.GameMaster#printMainMenu()}.
//	 */
//	@Test
//	public void testPrintMainMenu() {
//		
//		//Calling the function for statement coverage testing
//		GameMaster gm = new GameMaster();
//
//		String myString = "0";
//		InputStream is = new ByteArrayInputStream( myString.getBytes() );
//		gm.ScannerLineTester(is);
//		gm.printMainMenu();
//	}
//
//	/**
//	 * Test method for {@link Battleship.GameMaster#Play()}.
//	 */
//
//
//	@Test
//	public void testPlay() {
//		MockPlayer mockplayer = new MockPlayer();
//		MockComputer mockcomputer = new MockComputer();
//		
//		int testRounds = 5;
//		int prevHits = 0;
//		
//		for (int i = 0; i < testRounds; i++)
//		{
//			prevHits = mockplayer.getHits();
//			mockplayer.attackShip();
//			assertEquals(prevHits + 1, mockplayer.getHits());
//			prevHits = mockcomputer.getHits();
//			mockcomputer.attackShip();
//			assertEquals(prevHits + 1, mockcomputer.getHits());
//		}
//	}
//
//}
