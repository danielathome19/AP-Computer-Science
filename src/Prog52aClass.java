// Daniel Szelogowski
// Prog52aCl
// 10/17/2022
import java.util.Scanner;

public class Prog52aClass {
    // Driver program
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        printer.print("Please enter length: ");
        int len = kbd.nextInt();
        printer.print("Please enter width: ");
        int wid = kbd.nextInt();
        printer.println();

        // Make a new object (instance) of Cl52a (instantiate the class)
        Cl52a wow = new Cl52a(len, wid);
        wow.setStuff();

        // int area = wow.getArea();
        // int perim = wow.getPerim();

        // printer.println("Area: " + area);
        // printer.println("Perim: " + perim);
        wow.print();
    }
}
