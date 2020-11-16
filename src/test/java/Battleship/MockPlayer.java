package Battleship;

import org.junit.Test;

public class MockPlayer{
	
	public MockPlayer() {}
	
	int hits = 0;
	
	public int getHits()
	{
		return hits;
	}
	
	public void attackShip()
	{
		hits++;
	}
	
}