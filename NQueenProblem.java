public class NQueenProblem {
    final int N = 4; // Size of the chessboard

    // Function to print the solution
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". "); // Correctly printing '.' for empty spots
            }
            System.out.println();
        }
    }

    // Function to check if a queen can be placed safely on board[row][col]
    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive utility function to solve the N-Queens problem
    boolean solveNQUtil(int board[][], int col) {
        // If all queens are placed, return true
        if (col >= N)
            return true;

        // Try placing the queen in each row of the current column
        for (int i = 0; i < N; i++) {
            // Check if it's safe to place the queen at board[i][col]
            if (isSafe(board, i, col)) {
                // Place the queen
                board[i][col] = 1;

                // Recur to place the queen in the next column
                if (solveNQUtil(board, col + 1))
                    return true;

                // If placing the queen at board[i][col] doesn't lead to a solution
                // backtrack: remove the queen
                board[i][col] = 0;
            }
        }

        // If the queen cannot be placed in any row in this column, return false
        return false;
    }

    // This function solves the N-Queens problem using backtracking
    boolean solveNQ() {
        int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    // Main function to execute the program
    public static void main(String args[]) {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}
