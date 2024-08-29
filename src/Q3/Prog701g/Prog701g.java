package Q3.Prog701g;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prog701g {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("Langdat/prog701g.dat"));
            List<Person> list = new ArrayList<Person>();

            int num = input.nextInt();
            while (num != 99) {
                String f = input.next();
                String l = input.next();

                if (num == 1) {
                    double gpa = input.nextDouble();
                    Person p = new Student(f, l, gpa);
                    list.add(p);
                } else if (num == 2) {
                    int numStu = input.nextInt();
                    Person p = new Teacher(f, l, numStu);
                    list.add(p);
                } else if (num == 3) {
                    String fav = input.next();
                    Person p = new Admin(f, l, fav);
                    list.add(p);
                }
                num = input.nextInt();
            }

            double tot = 0;
            int cnt = 0;
            int totstus = 0;
            String large = "";
            String small = ";lsdkgh;dslkg;sdlkghjs;lgkdsh;lkgsdhjg;lkdsjhg;lksdjnvlksdnoiwenvioswlkxdgdlkwfjsdlkgjwd;lknewo;igndoignweoigjwelkgjwelkgjsdlkgjsdlkgjsdlkgjdslkgjsldgfjsldkjglsdkgj";

            for (Person x : list) {
                if (x instanceof Student) {
                    tot += ((Student)x).getGPA();
                    cnt++;
                }
                if (x instanceof Teacher)
                    totstus += ((Teacher)x).getNumStus();
                if (x instanceof Admin) {
                    String word = ((Admin)x).getFavw();
                    if (word.length() > large.length())
                        large = word;
                    if (word.length() < small.length())
                        small = word;
                }
            }

            System.out.printf("Average student GPA: %.2f\n", tot/cnt);
            System.out.println("Total number of students taught by teachers: " + totstus);
            System.out.println("Smallest favorite admin word: " + small);
            System.out.println("Largest favorite admin word: " + large);

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}

/*
Average student GPA: 3.06
Total number of students taught by teachers: 316
Smallest favorite admin word: done
Largest favorite admin word: coolbeans
*/