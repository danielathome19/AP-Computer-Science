// Daniel Szelogowski
// 1/3/2023
// Prog505a
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog505a {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("data/prog505a.dat"));
            List<Cl505a> list = new ArrayList<Cl505a>();
            while (input.hasNext()) {
                String fname = input.next();
                String lname = input.next();
                int books = input.nextInt();
                Cl505a wowser = new Cl505a(fname + " " + lname, books);
                list.add(wowser);
            }

            for (int lcv = 0; lcv < list.size(); lcv++) {
                Cl505a cur = list.get(lcv);
                cur.calc();
            }

            for (Cl505a x : list)
                System.out.println(x);

            double tot = 0;
            for (Cl505a b : list) tot += b.getPoints();
            double avg = tot / list.size();

            int bigPoints = list.get(0).getPoints();
            String bigName = list.get(0).getName();
            for (int lcv = 0; lcv < list.size(); lcv++) {
                Cl505a book = list.get(lcv);
                if (book.getPoints() > bigPoints) {
                    bigPoints = book.getPoints();
                    bigName = book.getName();
                }
            }
            System.out.println("\nAverage points: " + avg);
            System.out.println("The winner is: " + bigName);
        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
