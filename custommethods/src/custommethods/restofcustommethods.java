package custommethods;

public class restofcustommethods {

	private static int checkDraw(String[][] board, int count) {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j] == "| X |" || board[i][j] == "| O |") {
					count++;
				}
			}
		}
		return count;
	}
	
	private static void boardInsertion(String[][] board) {
		String selection;
		if (playerTurn == 1) {
			selection = "| X |";
		}
		else selection = "| O |";

		board[row][column] = selection;

	}
	
	private static boolean checkWinner(String[][] board) {
		String token;
		if (playerTurn == 1) {
			token = "| X |";
		}
		else token = "| O |";
		return (checkColumn(board, token) || checkRow(board,token) || checkDiagonal(board, token));

	}

	private static boolean checkRow(String[][] board, String token) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == token) count++;
			}
			if (count == 3) return true;
			else count = 0;
		}

		return false;

	}

	private static boolean checkColumn(String[][] board, String token) {
		int count = 0;
		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] == token) count++;
			}
			if (count == 3) return true;
			else count = 0;
		}

		return false;
	}

	private static boolean checkDiagonal(String[][] board, String token) {
		int count = 0;
		int x = 0;
		int y = 0;
		while (x < board.length && y < board.length) {

			if (board[y][x] == token) count++;
			if (count == 3) return true;
			x++;
			y++;
		}
		count = 0;
		x = 0;
		y = board.length - 1;
		while (x < board.length && y >= 0) {

			if (board[y][x] == token) count++;
			if (count == 3) return true;
			y--;
			x++;
		}


		return false;

	}
}
}
