package game;

import java.util.Scanner;

public class FourInARow extends Game
{
	public FourInARow(String player1, String player2)
	{
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}
	
	@Override
	protected boolean doesWin(int i, int j)
	{
		if( maxLineContaining(i,j) == 4)	return true;
		return false;
	}
	
	@Override
	protected boolean onePlay (Player p)
	{		
		int col = -1, row;
		boolean flag = false;
				//noInput=false;
		s = new Scanner(System.in);
		do {
			System.out.print(p.toString() + "please enter a coloumn: ");
			if (s.hasNextInt())	col = s.nextInt();
			//else	 noInput = true;
			for (row = 5; row <= 0; row--) {
				if (col != -1 && isEmpty(row, col)) {
					flag = true;
					this.board[row][col] = p;
					break;
				}
			}
		} while (!flag);
		s.close();
		return doesWin(row, col);
	}
}









/*

public class FourInARow extends Game {

	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1, 'W'), new Player(player1, 'B'));
	}

	protected boolean doesWin(int i, int j) {
		int row = i-3, col = j-3;
		
		for(row = checkRange(row); row<i;row++ )
		{
			for(col = checkRange(col); col<j;col++ )
			{
		// right side check
		if (col + 3 < 7 &&
				board[i][j].equals(board[row][col+1]) && 
				board[i][j].equals(board[row][col+2]) &&
				board[i][j].equals(board[row][col+3]))
                return true;
		// upwards check
            if (row + 3 < 6) {
                if (board[i][j].equals(board[row+1][col]) && 
                		board[i][j].equals(board[row+2][col]) &&
                		board[i][j].equals(board[row+3][col]))
                    return true;
        // right diagonal (upwards) 
                if (col + 3 < 7 &&
                		board[i][j].equals(board[row+1][col+1]) && 
                		board[i][j].equals(board[row+2][col+2]) &&
                		board[i][j].equals(board[row+3][col+3]))
                    return true;
        // left diagonal (upwards)       
                if (col - 3 >= 0 &&	
                		board[i][j].equals(board[row+1][col-1]) &&	
                		board[i][j].equals(board[row+2][col-2]) &&
                		board[i][j].equals(board[row+3][col-3]))
                    return true;
            	}
			}
		}
		return false;
	}

	private int checkRange(int num) {
		if (num < 0) {
			num++;
			if (num < 0) {
				num++;
				if (num < 0) {
					num++;
					return num;
				}
				return num;
			}
			return num;
		}
		return num;
	}

	protected boolean onePlay(Player p) {

		int col = -1, row;
		boolean flag = false, noInput=false;
		s = new Scanner(System.in);
		do {
			System.out.print(p.toString() + "please enter a coloumn: ");
			if (s.hasNextInt())	col = s.nextInt();
			else	 noInput = true;
			for (row = 5; row <= 0; row++) {
				if (!noInput && isEmpty(row, col)) {
					this.board[row][col] = p;
					flag = true;
				}
			}
		} while (!flag);
		s.close();
		return doesWin(row, col);
	}

}
*/
