package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Prog460a {
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/sort.dat"));
            int[] list = new int[60];
            int count = 0;

            while (file.hasNext()) {
                list[count] = file.nextInt();
                count++;
            }
            Arrays.sort(list);

            Scanner input = new Scanner(System.in);
            int num = 0;
            while (num != -1) {
                System.out.print("\nEnter a number to search for [1-100]: ");
                num = input.nextInt();
                // int index = SearchAlgs.linearSearch(list, num);
                // int index = SearchAlgs.binarySearch(list, num);
                int index = SearchAlgs.binarySearchRec(list, num, 0, list.length-1);
                if (index == -1)
                    System.out.println("Number does not occur in this list");
                else
                    System.out.println("Number occurs at index: " + index);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
