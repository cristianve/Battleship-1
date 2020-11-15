package Battleship;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public abstract class Entity{
	protected int MAX_ROW_COL = 10;
	protected int MAX_BATTLESHIP = 1;
	protected int MAX_CRUSIER = 1;
	protected int MAX_DESTROYER = 1;
	protected int posX;
	protected int posY;
	protected boolean horizontal;
	protected char[][] shipsLocation = new char[MAX_ROW_COL][MAX_ROW_COL];
	protected int lifes = 0;
	protected int hits = 0;
	protected List<Ship> shipList = new ArrayList<Ship>();
	protected Scanner scan = new Scanner(System.in);
	
	Entity(){}
	@Test
	public void iniciateShipsLocation() {
		for(int i=0;i<MAX_ROW_COL;i++)
		{
			for(int j=0;j< MAX_ROW_COL;j++)
			{
				shipsLocation[i][j] = ' ';
			}
		}
	}
	public void ScannerLineTester(InputStream in)
	{
		scan = new Scanner(in);
	}
	@Test
	boolean askHorizontal()
	{
		int letter = 0;
		boolean isValid = false;
		String input;
		
		System.out.println("\nType Y or N for if you want to place it horizontal: ");
		input = scan.nextLine();
		if(!input.isEmpty() && input.length() == 1)
		{
		    char c = input.charAt(0);
		    letter = c;
		    if(letter == 89 || letter == 78)
		    {
		        isValid = true;
		    }
		    else { System.out.println("\nError: Type a correct option"); }
		}else{ System.out.println("\nError: Type something"); }
			
		if(letter == 89){
			horizontal = true;
		}else if(letter == 78) {
			horizontal = false;
		}
		return isValid;
	}
	@Test
	public boolean placeShip(Ship ship,int posX, int posY, boolean horizontal) {
		boolean resultat = true;
		char tipus = ship.getType();
		int size = ship.getSize();
		if((posX >= 0 && posY >= 0) && (posX <= 9 && posY <= 9))
		{
			if(horizontal)
			{	
				if(posX+size <= MAX_ROW_COL)
				{
					for(int i=posX;i<(posX+size);i++)
					{
						if(shipsLocation[posY][i] != ' ')
						{
							resultat = false;
						}
					}
				}else
				{
					resultat = false;
				}
				if(resultat)
				{
					for(int i=posX;i<(posX+size);i++)
					{
						shipsLocation[posY][i] = tipus;
					}
					return true;
				}

			}else {
				if(posY+size <= MAX_ROW_COL)
				{
					for(int i=posY;i<(posY+size);i++)
					{
						if(shipsLocation[i][posX] != ' ')
						{
							resultat = false;
						}
					}
				}else
				{
					resultat = false;
				}
				if(resultat)
				{
					for(int i=posY;i<(posY+size);i++)
					{
						shipsLocation[i][posX] = tipus;
					}
					return true;
				}
			}
		}
		return false;
	}
	@Test
	public boolean askCoords(){
		
		boolean valid = false;
		String input;

		System.out.println("\nEnter the coordinates, the format is: [LETTER][NUMBER] ");
		input = scan.nextLine();
		if(input.length() == 2 || input.length() == 3)
		{
			char coordY = input.charAt(0);
			String numberOnly = input.replaceAll("[^0-9]", "");
			if(!numberOnly.isEmpty())
			{
				int coordX =  Integer.parseInt(numberOnly);
				int letter = coordY;
				if((coordX >= 1 && coordX <= 10) && (coordY >= 'A' && coordY <= 'J')) {
					posX = coordX - 1;
					posY = letter - 65;
					valid = true;
				}else { System.out.println("\nPlease enter valid coordinates"); }
			}else { System.out.println("\nPlease enter valid coordinates"); }
		}else { System.out.println("\nPlease enter valid coordinates"); }
		return valid;
	}
	@Test
	public boolean hasWon() {
		if(lifes == hits)
		{
			return true;
		}else return false;
	}
}
