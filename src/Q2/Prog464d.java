package Q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog464d {
    /**
     * Performs matrix transposition on a 2D array of integers.
     * @param mat   The 2D array to be transposed
     * @return      The transposition of `mat`
     */
    public static int[][] transpose(int[][] mat) {
        int[][] transposed = new int[mat[0].length][mat.length];
        for (int row = 0; row < mat.length; row++)
            for (int col = 0; col < mat[0].length; col++)
                transposed[col][row] = mat[row][col];
        return transposed;
    }

    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/prog464a.dat"));
            int[][] mat = new int[5][5];  // 5 rows, 5 cols

            // Read in matrix in Row-Major Order
            for (int r = 0; r < mat.length; r++)
                for (int c = 0; c < mat[0].length; c++)
                    mat[r][c] = file.nextInt();

            int[][] mat_T = transpose(mat);

            System.out.println("Original matrix:");
            for (int[] row : mat) {
                for (int n : row)
                    System.out.print(n + " ");
                System.out.println();
            }

            System.out.println("\nTransposed matrix:");
            for (int r = 0; r < mat_T.length; r++) {
                for (int c = 0; c < mat_T[0].length; c++)
                    System.out.print(mat_T[r][c] + " ");
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
/*
Original matrix:
45 67 89 12 -3
-3 -6 -7 -4 -9
96 81 -8 52 12
14 -7 72 29 -1
19 43 28 63 87

Transposed matrix:
45 -3 96 14 19
67 -6 81 -7 43
89 -7 -8 72 28
12 -4 52 29 63
-3 -9 12 -1 87
*/