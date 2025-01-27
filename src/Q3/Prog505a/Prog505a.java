package Q3.Prog505a;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Prog505a {
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/prog505a.dat"));
            List<BookPerson> list = new ArrayList<BookPerson>();

            while (file.hasNext()) {
                String fname = file.next();
                String lname = file.next();
                int books = file.nextInt();
                String name = fname + " " + lname;
                BookPerson wowser = new BookPerson(name, books);
                list.add(wowser);
            }

            for (int lcv = 0; lcv < list.size(); lcv++) {
                BookPerson cur = list.get(lcv);
                cur.calc();
            }

            System.out.println("Reading Contest:\nName\tBooks\tPoints");
            for (BookPerson p : list)
                System.out.println(p);

            double tot = 0;
            for (BookPerson p : list) tot += p.getPoints();
            double avg = tot / list.size();
            System.out.println("\nAverage points: " + avg);

            int bestPoints = list.get(0).getPoints();
            String bestName = list.get(0).getName();
            for (int lcv = 1; lcv < list.size(); lcv++) {
                BookPerson bill = list.get(lcv);
                if (bill.getPoints() > bestPoints) {
                    bestPoints = bill.getPoints();
                    bestName = bill.getName();
                }
            }
            System.out.println("The winner is: " + bestName);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
/*
Reading Contest:
Name	Books	Points
Sam Summer	4	45
Linda Lazy	2	20
Paul Prodder	5	60
K.C. Master	8	115
Richie Reader	6	75

Average points: 63.0
The winner is: K.C. Master
*/