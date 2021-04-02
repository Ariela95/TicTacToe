package game;

public class TicTacToe extends Game
{
	public TicTacToe(String player1, String player2)
	{
		
		super(3, 3,new Player (player1, 'X'), new Player (player2, 'O'));//????????
	}
	
	@Override
	protected boolean doesWin(int x, int y)
	{
			if(maxLineContaining(x, y) == 3)	return true;
			else	return false;
	}
}


/*
public class TicTacToe extends Game {

	
	public TicTacToe(String player1, String player2)
	{
		super(3,3, new Player(player1, 'X'), new Player(player2, 'O'));	
	}
	
	protected boolean doesWin(int x, int y)
	{
		if(board[0][y]==board[x][y]&&board[1][y]==board[x][y]&&board[2][y]==board[x][y]) return true;
		if(board[x][0]==board[x][y]&&board[x][1]==board[x][y]&&board[x][2]==board[x][y]) return true;
		if(board[0][0]==board[x][y]&&board[1][1]==board[x][y]&&board[2][2]==board[x][y]) return true;
		if(board[0][2]==board[x][y]&&board[1][1]==board[x][y]&&board[2][0]==board[x][y]) return true;
		return false;
	}

}
*/