// Daniel Szelogowski
// 2/8/2023
// Prog162a with Recursion
import java.util.Scanner;
public class Prog162aRecursive {
    public static int factorial(int n) {
        if (n == 1) return n;               // Base/ending Case
        else return n * factorial(n-1);  // Recursive Case
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        while (num != 0) {
            int fact = factorial(num);
            System.out.println(fact);
            System.out.print("Enter a number: ");
            num = input.nextInt();
        }
    }
}
