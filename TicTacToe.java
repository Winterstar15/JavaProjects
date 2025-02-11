import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    // Task 1: Create an array with three rows of '_' characters.
    char[][] board = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
    char winner = ' ';
    int result;
    // Task 2: Call the function printBoard();
    printBoard(board);
    /*
     * { Task 3: Loop through turns.
     * 
     * if (X) turn {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value.
     * } else {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value. Then, print it.
     * 
     * }
     * 
     * Task 6 - Call the function.
     * if return value == 3 {
     * print: X wins and break the loop
     * } else if return value == -3 {
     * print: O wins and break the loop
     * }
     * 
     * }
     */
    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("Turn: X");
        int[] indices = askUser(board);
        board[indices[0] - 1][indices[1] - 1] = 'X';
        printBoard(board);
        result = checkWin(board);
        if (result == 3) {
          winner = 'X';
          break;
        }
      } else {
        System.out.println("Turn: O");
        int[] indices = askUser(board);
        board[indices[0] - 1][indices[1] - 1] = 'O';
        printBoard(board);
        result = checkWin(board);
        if (result == 3) {
          winner = 'O';
          break;
        }
      }
    }

    if (winner == 'X') {
      System.out.println("X wins! Congratulations!");
    } else if (winner == 'O') {
      System.out.println("O wins! Congratulations!");
    } else {
      System.out.println("It's a tie. Good game!");
    }
    scan.close();
  }

  /**
   * Task 2 - Write a function that prints the board.
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   *              Inside the function:
   *              1. print a new line.
   *              2. print the board.
   *              • separate each row by two lines.
   *              • each row precedes a tab of space
   *              • each character in the grid has one space from the other
   *              character
   */
  public static void printBoard(char[][] board) {
    System.out.print("\n");
    for (int i = 0; i < 3; i++) {
      System.out.print("\t");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j]);
        System.out.print(' ');
      }
      System.out.println("\n\n");
    }
  }

  /**
   * Task 4 - Write a function that lets the user choose a spot
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */
  public static int[] askUser(char[][] board) {
    int[] indices = new int[2];
    System.out.print("\tPick a row and column number: ");
    indices[0] = scan.nextInt();
    indices[1] = scan.nextInt();
    while (indices[0] < 1 || indices[0] > 3 || indices[1] < 1 || indices[1] > 3
        || board[indices[0] - 1][indices[1] - 1] != '_') {
      System.out.print("Choose a correct/different row and column number: ");
      indices[0] = scan.nextInt();
      indices[1] = scan.nextInt();
    }
    return indices;
  }

  /**
   * Task 6 - Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */
  public static int checkWin(char[][] board) {
    int result = 0;
    int i = 0;
    while (i < 3) {
      if ((board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
          || (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X')
          || (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
          || (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O')
          || (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
          || (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
          || (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
          || (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
        return 3;
      } else {
        i++;
      }
    }
    return result;
  }

}
