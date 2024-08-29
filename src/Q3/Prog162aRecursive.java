package Q3;

import java.util.Scanner;

public class Prog162aRecursive {
    public static int factLoop(int n) {
        int product = 1;
        for (int i = 1; i <= n; i++)
            product *= i;
        return product;
    }

    public static int factRevLoop(int n) {
        int product = 1;
        for (int i = n; i > 0; i--)
            product *= i;
        return product;
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;       // Base/ending Case
        return n * factorial(n-1);  // Recursive Case
    }

    public static void main(String[] args) {
        Scanner keys = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = keys.nextInt();
        while (num != 0) {
            int fact = factorial(num);
            System.out.println(num + "! = " + fact);
            System.out.print("Enter a number: ");
            num = keys.nextInt();
        }
    }
}

/*
Enter a number: 5
5! = 120
Enter a number: 99
99! = 0
Enter a number: 0
*/
