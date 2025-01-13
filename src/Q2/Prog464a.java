package Q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog464a {
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/prog464a.dat"));

            // 5 arrays (rows) of length 6
            int[][] mat = new int[5][6];  // 5 rows, 6 cols
            for (int r = 0; r < mat.length; r++) {
                for (int c = 0; c < mat[0].length-1; c++) {  // mat[r].length-1
                    mat[r][c] = file.nextInt();
                }
            }

            // Find the biggest # in each row, then set the last col to that #
            for (int r = 0; r < mat.length; r++) {
                int rowBig = Integer.MIN_VALUE;  // mat[r][0];
                for (int c = 0; c < mat[r].length-1; c++) {
                    if (mat[r][c] > rowBig)
                        rowBig = mat[r][c];
                }
                mat[r][5] = rowBig;
            }

            // Print 2D array nicely
            for (int[] row : mat) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
/*
45 67 89 12 -3 89
-3 -6 -7 -4 -9 -3
96 81 -8 52 12 96
14 -7 72 29 -1 72
19 43 28 63 87 87
*/