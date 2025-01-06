package Q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class BigArrayListCat {
    public static void printCat(Cat cat) {
        System.out.printf("%s\t%.2f\t%d\t$%.2f\n",
                          cat.getName(), cat.getWeight(), cat.getAge(), cat.getCost());
    }

    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/bigarraylist.dat"));
            int numCats = file.nextInt();
            file.nextLine();
            ArrayList<Cat> cats = new ArrayList<>();

            for (int lcv = 0; lcv < numCats; lcv++) {
                String n = file.nextLine();
                double w = file.nextDouble();
                int    a = file.nextInt();
                double c = file.nextDouble();
                file.nextLine();
                cats.add(new Cat(n, w, a, c));
            }

            // 1. Print out all the cats (there is no toString() available)
            System.out.println("1. All the cats: ");
            System.out.println("Name\tWeight\tAge\tCost");
            for (Cat cat : cats)
                printCat(cat);

            // 2. Print the name of the 3rd cat.
            System.out.println("\n2. The third cat is named: " + cats.get(2).getName());

            // 3. The last cat has gained 10 pounds. Update the weight on the object. Print the new weight.
            cats.get(cats.size()-1).setWeight(cats.get(cats.size()-1).getWeight() + 10);
            System.out.println("\n3. The updated weight is: " + cats.get(cats.size()-1).getWeight());

            // 4. The cat named Rascal died. Find that cat and remove it from the list.
            for (int i = 0; i < cats.size(); i++)
                if (cats.get(i).getName().equals("Rascal"))
                    cats.remove(i);

            // 5. A new kitten was brought in (Angel, 3.6, 1, 25.99).  Insert it into the 2nd cell.
            cats.add(1, new Cat("Angel", 3.6, 1, 25.99));

            // 6. A new geriatric cat was found (Gimpy, 14.3, 10,  29.99). Put him on the list.
            cats.add(new Cat("Gimpy", 14.3, 10, 29.99));

            // 7. Print the updated list with a for-each loop
            System.out.println("\n7. The updated list is: ");
            System.out.println("Name\tWeight\tAge\tCost");
            for (Cat cat : cats)
                printCat(cat);

            // 8. Replace the 3rd cat with (Sugar, 23.6, 7, 33.25) put the removed cat at the end of the list.
            Cat third = cats.get(2);
            cats.set(2, new Cat("Sugar", 23.6, 7, 33.25));
            cats.add(third);

            // 9. Switch the 2nd and 4th cats.
            Cat temp = cats.get(1);
            cats.set(1, cats.get(3));
            cats.set(3, temp);

            // 10. Print the names of the cats on the list.
            System.out.println("\n10. The current cat names are: ");
            for (Cat c : cats)
                System.out.print(c.getName() + "\t");
            System.out.println();

            // 11. Remove all cats under $26. Print the costs of each cat remaining on the list.
            for (int i = 0; i < cats.size(); i++) {
                if (cats.get(i).getCost() < 26) {
                    cats.remove(i);
                    i--;  // EXTREMELY IMPORTANT WHEN REMOVING FROM AN ARRAYLIST IN A LOOP!!!!!
                }
            }
            System.out.println("\n11. The costs of the remaining cats are: ");
            for (Cat c : cats)
                System.out.print(c.getCost() + "\t");
            System.out.println();

            // 12. All cats heavier than 15 pounds need to go on a diet <-- no for-each this time.
            //     Print the names of the cats being put on a diet.
            System.out.println("\n12. The cats being put on a diet are: ");
            for (int lcv = 0; lcv < cats.size(); lcv++) {
                Cat c = cats.get(lcv);
                if (c.getWeight() > 15)
                    System.out.print(c.getName() + "\t");
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
Inky	15.69	2	$35.79
Panda	14.30	6	$15.03
Rascal	21.10	21	$0.00
Blacky	13.99	3	$26.89
Taffy	24.50	10	$56.89
Toby	17.20	10	$37.57

2. The third cat is named: Rascal

3. The updated weight is: 27.2

7. The updated list is:
Name	Weight	Age	Cost
Inky	15.69	2	$35.79
Angel	3.60	1	$25.99
Panda	14.30	6	$15.03
Blacky	13.99	3	$26.89
Taffy	24.50	10	$56.89
Toby	27.20	10	$37.57
Gimpy	14.30	10	$29.99

10. The current cat names are:
Inky	Blacky	Sugar	Angel	Taffy	Toby	Gimpy	Panda

11. The costs of the remaining cats are:
35.79	26.89	33.25	56.89	37.57	29.99

12. The cats being put on a diet are:
Inky	Sugar	Taffy	Toby
*/