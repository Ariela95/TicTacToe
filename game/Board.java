package game;

public class Board {
	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) {
		board = new Player[n][m];
		this.n = n;
		this.m = m;
	}

	protected boolean set(int i, int j, Player p) {
		if (!isEmpty(i, j))
			return false;
		else
			board[i][j] = p;
		return true;
	}

	public boolean isEmpty(int i, int j) {
		if (board[i][j] != null)
			return false;
		else
			return true;
	}

	public Player get(int i, int j) {
		return board[i][j];
	}

	public boolean isFull() {
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (isEmpty(i, j))
					return false;
			}
		}
		return true;
	}

	public String toString() {
		String gameBoard = new String();
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (isEmpty(i, j))
					gameBoard += ".";
				else
					gameBoard += board[i][j].getMark();
			}
			gameBoard += "\n";
		}
		return gameBoard;
	}

	protected int maxLineContaining(int i, int j) {
		char playerMark = board[i][j].getMark();
		int max, tempMax;
		max = maxLine(i, j, i, playerMark);
		tempMax = maxLine(i, j, j, playerMark);
		if (tempMax > max)
			max = tempMax;
		tempMax = maxDiagonal(i, j, i, playerMark);
		if (tempMax > max)
			max = tempMax;
		tempMax = maxDiagonal(i, j, j, playerMark);
		if (tempMax > max)
			max = tempMax;

		return max;
	}

	private int maxLine(int i, int j, int k, char pMark) {
		int a = i, b = j, max = 1;

		while (b > 0 && a > 0) {

			if (k == i)
				b--;
			else
				a--;
			if (board[a][b] == null)
				break;
			if (board[a][b].getMark() == pMark) {
				max++;
				continue;
			} else
				break;
		}

		a = i;
		b = j;
		while ((b < (m - 1)) && (a < (n - 1))) {

			if (k == i)
				b++;
			else
				a++;
			if (board[a][b] == null)
				break;
			if (board[a][b].getMark() == pMark) {
				max++;
				continue;
			} else
				break;
		}
		return max;

	}

	private int maxDiagonal(int i, int j, int k, char pMark) {
		int a = i, b = j, max = 1;

		while (b < (m - 1) && (a > 0 && a < (n - 1))) {
			if (k == i) {
				a++;
				b++;
			} else {
				a--;
				b++;
			}
			if (board[a][b] == null)
				break;
			if (board[a][b].getMark() == pMark) {
				max++;
				continue;
			} else
				break;
		}

		a = i;
		b = j;

		while (b > 0 && (a > 0 && a < (n - 1))) {
			if (k == i) {
				a--;
				b--;
			} else {
				a++;
				b--;

			}
			if (board[a][b] == null)
				break;
			if (board[a][b].getMark() == pMark) {
				max++;
				continue;
			} else
				break;
		}

		return max;
	}
}

	

/*
 * the last code????????????????? //import java.lang.Math; public class Board {
 * protected Player[][] board; protected int n, m;
 * 
 * public Board(int n, int m) { board = new Player[n][m]; this.n = n; this.m =
 * m; }
 * 
 * 
 * protected boolean set(int i, int j, Player p) { if (!isEmpty(i, j)) return
 * false; board[i][j] = p; return true; }
 * 
 * public boolean isEmpty(int i, int j) { if (board[i][j] != null) return false;
 * return true; }
 * 
 * public Player get(int i, int j) { return board[i][j]; }
 * 
 * public boolean isFull() { for (int i = 0; i < n; i++) { for (int j = 0; j <
 * m; j++) { if (isEmpty(i, j)) return false; } } return true; }
 * 
 * public String toString() { String res = ""; for (int i = 0; i < n; i++) { for
 * (int j = 0; j < m; j++) { if (isEmpty(i, j)) res += "."; else res +=
 * (board[i][j].getMark()); } res += "\n"; } return res; }
 * 
 * protected int maxLineContaining(int i, int j) { char cur =
 * board[i][j].getMark(); int mostMax, tempMax; mostMax = checkLine(i, j, i,
 * cur); // returns the max occurrences of cur in a column tempMax =
 * checkLine(i, j, j, cur); // returns the max occurrences of cur in a row if
 * (tempMax > mostMax) mostMax = tempMax; tempMax = checkDiagonal(i, j, i, cur);
 * // returns the max occurrences of cur in the left diagonal if (tempMax >
 * mostMax) mostMax = tempMax; tempMax = checkDiagonal(i, j, j, cur); // returns
 * the max occurrences of cur in the right diagonal if (tempMax > mostMax)
 * mostMax = tempMax;
 * 
 * return mostMax; }
 * 
 * private int checkLine(int i, int j, int k, char playerMark) { int a, b; int
 * max=1; a = i; b = j;
 * 
 * while (a < (n - 1) && b < (m - 1)) // counts the amount of occurrences of the
 * players mark { if (k == i) a++;// if k==i the we check the column else b++;
 * // else we check the row.
 * 
 * if (board[a][b] == null) break; if (board[a][b].getMark() == playerMark)
 * max++; else break;
 * 
 * }
 * 
 * a = i; b = j;
 * 
 * while ((a > 0) && (b > 0)) { if (k == i) a--; else b--;
 * 
 * if (board[a][b] != null) { if (board[a][b].getMark() == playerMark) max++;
 * else break; } else break;
 * 
 * } return max; }
 * 
 * private int checkDiagonal(int i, int j, int k, char playerMark) {// counts
 * the amount of occurrences of the players // mark in a diagonal int a, b; int
 * max=1; a = i; b = j;
 * 
 * while ((a > 0 && b > 0) || (a < n && b > 0)) {// first checks the upper part
 * of the diagonal. if (k == i) { // if k==i the we check the left diagonal a--;
 * b--; } else {// else we check the right diagonal. a++; b--; }
 * 
 * if (board[a][b] == null) break; if (board[a][b].getMark() == playerMark)
 * max++; else break; }
 * 
 * a = i; b = j; while ((a > 0 && b < (m - 1)) && (a < (n - 1) && b < (m - 1)))
 * {// then checks the lower part of the diagonal. if (k == i) { a++; b++; }
 * else { a--; b++; }
 * 
 * if (board[a][b] == null) break; if (board[a][b].getMark() == playerMark)
 * max++; else break; } return max; }
 * 
 * }
 */
