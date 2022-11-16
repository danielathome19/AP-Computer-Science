// Daniel Szelogowski
// 11/16/2022
// Big Array Part II
import java.io.*;
import java.util.*;

public class BigArray2 {
    /*
    Print out all the cats (there is no toString() available)
    Print the name of the 3rd cat.
    The last cat has gained 10 pounds. Update the weight on the object. Print the new weight.
    The cat named Rascal died. Find that cat and remove it from the list.
    A new kitten was brought in (Angel, 3.6, 1, 25.99).  Insert it into the 2nd cell.
    A new geriatric cat was found (Gimpy, 14.3, 10,  29.99). Put him on the list.
    Print the updated list with a for-each loop
    Replace the 3rd cat with (Sugar, 23.6, 7, 33.25) put the removed cat at the end of the list.
    Switch the 2nd and 4th cats.
    Print the names of the cats on the list.
    Remove all cats under $26. Print the costs of each cat remaining on the list.
    All cats heavier than 15 pounds need to go on a diet <--  no for-each this time.
    Print the names of the cats being put on a diet.
    */
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("data/bigarraylist.dat"));
            int numCats = input.nextInt();
            input.nextLine();
            Cat[] cats = new Cat[50];

            for (int lcv = 0; lcv < numCats; lcv++) {
                String name = input.nextLine();
                double weight = input.nextDouble();
                int age = input.nextInt();
                double cost = input.nextDouble();
                input.nextLine();
                cats[lcv] = new Cat(name, weight, age, cost);
            }

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
