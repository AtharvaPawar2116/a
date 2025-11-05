public class NQueens {
    static int N = 4; // You can change this value

    // Function to print the chessboard
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if a queen can be placed safely
    static boolean isSafe(int[][] board, int row, int col) {
        // Check same row on the left
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Backtracking function to solve N-Queens
    static boolean solveNQ(int[][] board, int col) {
        if (col >= N)
            return true;

        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // Place queen

                if (solveNQ(board, col + 1))
                    return true;

                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        // Place first queen manually
        board[0][0] = 1;

        // Solve from next column
        if (solveNQ(board, 1))
            printBoard(board);
        else
            System.out.println("No solution exists");
    }
}
