import java.util.Scanner;
public class TicTacToe {
	
	public static int maxMoves = 9;	
	public static int counter = 0;	
	public static char[][] board = new char[3][3];
	
	public static void updateBoard(char[][] b) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.print(b[row][col] + " ");
				}
			System.out.println();	
			}
		}
		
	public static void setUp(char[][] b) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				b[row][col] = '*';
				}	
			}
		}	
	
	public static void turn() {
		if (counter % 2 == 0) {
			makeMove1(board);
			}
		else {
			makeMove2(board);
			}
		updateBoard(board);		
		}
	
	public static void makeMove2(char[][] array) {
		Scanner keys = new Scanner(System.in);
		System.out.println("Player X please make your move.");
		int inputRow = keys.nextInt();
		int inputCol = keys.nextInt();
		if (array[inputRow][inputCol] == '*') {
			array[inputRow][inputCol] = 'X';
			counter++;
			}
		else {
			System.out.println("That space is taken! Choose again...");
			makeMove2(board);
			}
		}		
	
	public static void makeMove1(char[][] array) {
		Scanner keys = new Scanner(System.in);
		System.out.println("Player O please make your move.");
		int inputRow = keys.nextInt();
		int inputCol = keys.nextInt();
		if (array[inputRow][inputCol] == '*') {
			array[inputRow][inputCol] = 'O';
			counter++;
			}
		else {
			System.out.println("That space is taken! Choose again...");
			makeMove1(board);
			}
		}
		
	public static boolean victoryConditions(char[][] b) {
		boolean victory = false;
		if (((b[0][0] == 'X') && (b[0][1] == 'X') && (b[0][2] == 'X')) ||
		((b[0][0] == 'O') && (b[0][1] == 'O') && (b[0][2] == 'O'))) {
			victory = true;
			}
		if (((b[1][0] == 'X') && (b[1][1] == 'X') && (b[1][2] == 'X')) ||
		((b[1][0] == 'O') && (b[1][1] == 'O') && (b[1][2] == 'O'))) {
			victory = true;
			}
		if (((b[2][0] == 'X') && (b[2][1] == 'X') && (b[2][2] == 'X')) ||
		((b[2][0] == 'O') && (b[2][1] == 'O') && (b[2][2] == 'O'))) {
			victory = true;
			}		
		
		if (((b[0][0] == 'X') && (b[1][0] == 'X') && (b[2][0] == 'X')) ||
		((b[0][0] == 'O') && (b[1][0] == 'O') && (b[2][0] == 'O'))) {
			victory = true;
			}
		if (((b[0][1] == 'X') && (b[1][1] == 'X') && (b[2][1] == 'X')) ||
		((b[0][1] == 'O') && (b[1][1] == 'O') && (b[2][1] == 'O'))) {
			victory = true;
			}
		if (((b[0][2] == 'X') && (b[1][2] == 'X') && (b[2][2] == 'X')) ||
		((b[0][2] == 'O') && (b[1][2] == 'O') && (b[2][2] == 'O'))) {
			victory = true;
			}
			
		if (((b[0][0] == 'X') && (b[1][1] == 'X') && (b[2][2] == 'X')) ||
		((b[0][0] == 'O') && (b[1][1] == 'O') && (b[2][2] == 'O'))) {
			victory = true;
			}
		if (((b[0][2] == 'X') && (b[1][1] == 'X') && (b[2][0] == 'X')) ||
		((b[0][2] == 'O') && (b[1][1] == 'O') && (b[2][0] == 'O'))) {
			victory = true;
			}		
		return victory;	
		}	
		
	public static void game() {
		setUp(board);
		updateBoard(board);
		int countMoves = 1;
		while (countMoves <= maxMoves) {
			if (victoryConditions(board)) {
				System.out.println("The game is over!!!");
				System.exit(0);
				}
			turn();
			countMoves++;
			}
		System.out.println("No contest...");
		System.exit(0);			
		}	
	
	public static void main(String[] args) {
		TicTacToe demo = new TicTacToe();
		demo.game();
		}
	}
