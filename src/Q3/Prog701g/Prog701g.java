package Q3.Prog701g;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Prog701g {
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/prog701g.dat"));
            List<Person> list = new ArrayList<Person>();

            int num = file.nextInt();
            while (num != 99) {
                String f = file.next();
                String l = file.next();

                if (num == 1) {
                    double gpa = file.nextDouble();
                    Person p = new Student(f, l, gpa);
                    list.add(p);
                } else if (num == 2) {
                    int ns = file.nextInt();
                    Person p = new Teacher(f, l, ns);
                    list.add(p);
                } else if (num == 3) {
                    String fw = file.next();
                    Person p = new Admin(f, l, fw);
                    list.add(p);
                }
                num = file.nextInt();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
