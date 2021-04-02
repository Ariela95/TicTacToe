package game;

import java.util.Scanner;

public class Game extends Board 
{
	protected Player[] players;
	protected Scanner s = new Scanner(System.in);
	
	public Game(int n, int m, Player p1, Player p2)
	{
		super(n,m);
		players = new Player[2] ;
		players[0] = p1;
		players[1] = p2;
	}
	
	protected boolean doesWin(int i, int j)
	{
		if(i==0 && j==0)	return true;
		else	return false;
	}
	
	protected boolean onePlay(Player p)
	{
		int i=-1, j=-1;
		
		do {
		System.out.println(p.getName() + "please enter x and y: ");
		while(s.hasNextInt())
		{
			i = s.nextInt();
			j = s.nextInt();
		}
		} while ((i ==-1 || j == -1)||!set(i, j, p));
		
		//s.close();
		return doesWin(i,j);
	}
	
	public Player play()
	{
		int p=-1;
		boolean win = false;
		
		while(!win && !isFull())
		{
			p++;
			win = onePlay(players[p%2]);
			
		}
	
		
		if(isFull())	return null;
		else	return players[p%2];
	}
	
	
}










/*
public class Game extends Board {
	protected Player[] players;
	protected Scanner s = new Scanner(System.in);

	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
		// s = new Scanner(System.in);
	}

	protected boolean doesWin(int i, int j) {

		if ((i == 0) && (j == 0))
			return true;
		return false;
	}

	protected boolean onePlay(Player p) {
		int row = -1, col = -1;
		boolean noInput = false;
		s = new Scanner(System.in);
		do {
			System.out.print(p.toString() + "please enter x and y: ");
			if (s.hasNextInt()) {
				row = s.nextInt();
				col = s.nextInt();
			}
			if(row == -1 || col == -1)	noInput = true;
		} while (!isEmpty(row, col)||!noInput);
		s.close();
		return doesWin(row, col);

	}

	public Player play() {
		boolean win = false;
		int i = 0;
		while (!win && !isFull()) {
			//System.out.println("HI!\n");
			win = onePlay(players[i % 2]);
			i++;
		}

		if (win)
			return players[i % 2];
		else
			return null;
	}
}

*/