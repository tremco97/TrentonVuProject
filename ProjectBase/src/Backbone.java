import java.util.Scanner;
public class SomeCode {

	static int row = 0;
	static int column = 0;
	static int playerTurn = 1;


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[][] board = createBoard());

		int Xwins = 0;
		int Owins = 0;

		boolean gameOn = true;
		while (gameOn) {
			displayBoard(board);

			boolean emptyspace;

			do {
				row = rowSelection();
				column = columnSelection();

				String position = board[row][column];

				if (position.equals("|   |")) {
					emptyspace = true;
				}
				else { 
					emptyspace = false;
					System.out.println("That position has been chosen. Try again.");
				}
			} while (emptyspace==false);

			boardInsertion(board);

			if (checkWinner(board)) {
				displayBoard(board);
				String player;
				if (playerTurn == 1) player = "X";
				else player = "O";
				System.out.println("Player " + player + " has won.");
				System.out.print("Do you want to play again? y/n: ");
				String option = input.next();
				gameOn = (option.equalsIgnoreCase("y"));
				board = createBoard();
			}
			int count = 0;
			checkDraw(board,count);
			if (count>=9) {
				System.out.println("Tie game!");
				System.out.print("Do you want to play again? y/n: ");
				String option = input.next();
				if ((option=="y")||(option=="Y")) {
					gameOn=true;
				}
				else gameOn=false;
				board = createBoard();
			}

			if (playerTurn == 1) playerTurn = 2;
			else playerTurn = 1;
		}
		System.out.println("Game over!");

	}