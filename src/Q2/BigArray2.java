package Q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BigArray2 {
    public static void printCat(Cat cat) {
        System.out.printf("%s\t%f\t%d\t$%.2f\n",
                cat.getName(), cat.getWeight(), cat.getAge(), cat.getCost());
    }

    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/bigarraylist.dat"));
            int numCats = file.nextInt();
            file.nextLine();
            Cat[] cats = new Cat[50];

            for (int lcv = 0; lcv < numCats; lcv++) {
                String n = file.nextLine();
                double w = file.nextDouble();
                int    a = file.nextInt();
                double c = file.nextDouble();
                file.nextLine();
                cats[lcv] = new Cat(n, w, a, c);
            }

            // 1. Print out all the cats (there is no toString() available)
            System.out.println("1. All the cats:");
            System.out.println("Name\tWeight\tAge\tCost");
            for (int lcv = 0; lcv < numCats; lcv++)
                printCat(cats[lcv]);

            // 2. Print the name of the 3rd cat.
            System.out.println("\n2. The third cat is named: " + cats[2].getName());

            // 3. The last cat has gained 10 pounds. Update the weight on the object. Print the new weight.
            cats[numCats-1].setWeight(cats[numCats-1].getWeight() + 10);
            System.out.println("3. The updated weight is: " + cats[numCats-1].getWeight());

            // 4. The cat named Rascal died. Find that cat and remove it from the list.
            int rascalIndex = 0;
            for (int i = 0; i < numCats; i++)
                if (cats[i].getName().equals("Rascal"))
                    rascalIndex = i;
            for (int i = rascalIndex; i < numCats-1; i++)
                cats[i] = cats[i+1];
            numCats--;

            // 5. A new kitten was brought in (Angel, 3.6, 1, 25.99). Insert it into the 2nd cell.
            // for (int i = numCats+1; i --> 1;)
            for (int i = numCats; i > 1; i--)
                cats[i] = cats[i-1];
            cats[1] = new Cat("Angel", 3.6, 1, 25.99);
            numCats++;

            // 6. A new geriatric cat was found (Gimpy, 14.3, 10, 29.99). Put him on the list.
            cats[numCats] = new Cat("Gimpy", 14.3, 10, 29.99);
            numCats++;

            // 7. Print the updated list with a for-each loop
            System.out.println("\n7. The updated list is:");
            System.out.println("Name\tWeight\tAge\tCost");
            for (Cat cat : cats)
                if (cat != null) printCat(cat);

            // 8. Replace the 3rd cat with (Sugar, 23.6, 7, 33.25) put the removed cat at the end of the list.
            Cat temp = cats[2];
            cats[2] = new Cat("Sugar", 23.6, 7, 33.25);
            cats[numCats] = temp;
            numCats++;

            // 9. Switch the 2nd and 4th cats.
            Cat tempcat = cats[1];
            cats[1] = cats[3];
            cats[3] = tempcat;

            // 10. Print the names of the cats on the list.
            System.out.println("\n10. The current cat names are:");
            for (Cat cat : cats)
                if (cat != null) System.out.print(cat.getName() + "\t");
            System.out.println();

            // 11. Remove all cats under $26. Print the costs of each cat remaining on the list.
            int k = 0;
            while (k < numCats) {
                if (cats[k].getCost() < 26) {
                    for (int j = k; j < numCats - 1; j++)
                        cats[j] = cats[j + 1];
                    numCats--;
                } else {
                    k++;
                }
            }

            System.out.println("\n11. The cats costing >= $26 actually cost:");
            for (int c = 0; c < numCats; c++)
                System.out.print(cats[c].getCost() + " ");
            System.out.println();

            // 12. All cats heavier than 15 pounds need to go on a diet <-- no for-each this time.
            //     Print the names of the cats being put on a diet.
            System.out.println("\n12. The cats being put on a diet are:");
            for (int i = 0; i < numCats; i++) {
                Cat cat = cats[i];
                if (cat.getWeight() > 15)
                    System.out.print(cat.getName() + "\t");
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
/*
1. All the cats:
Name	Weight	Age	Cost
Inky	15.690000	2	$35.79
Panda	14.300000	6	$15.03
Rascal	21.100000	21	$0.00
Blacky	13.990000	3	$26.89
Taffy	24.500000	10	$56.89
Toby	17.200000	10	$37.57

2. The third cat is named: Rascal
3. The updated weight is: 27.2

7. The updated list is:
Name	Weight	Age	Cost
Inky	15.690000	2	$35.79
Angel	3.600000	1	$25.99
Panda	14.300000	6	$15.03
Blacky	13.990000	3	$26.89
Taffy	24.500000	10	$56.89
Toby	27.200000	10	$37.57
Gimpy	14.300000	10	$29.99

10. The current cat names are:
Inky	Blacky	Sugar	Angel	Taffy	Toby	Gimpy	Panda

11. The cats costing >= $26 actually cost:
35.79 26.89 33.25 56.89 37.57 29.99

12. The cats being put on a diet are:
Inky	Sugar	Taffy	Toby
*/