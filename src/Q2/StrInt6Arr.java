package Q2;
import java.util.Scanner;

public class StrInt6Arr {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = kbd.nextLine().toUpperCase();
        String ab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] count = new int[26];

        for (int j = 0; j < str.length(); j++)
            for (int k = 0; k < ab.length(); k++)
                if (str.substring(j, j+1).equals(ab.substring(k, k+1)))
                    count[k]++;

        int unique = 0;
        for (int n : count)
            if (n > 0) unique++;
        System.out.println("Unique letters: " + unique);
    }
}
/*
Enter a string: Java
Unique letters: 3
*/