package Q1.Prog52aCl;
import java.util.Scanner;

public class Prog52aCl {  // Driver Class (main)
    public static void main(String[] args) {
        // Input Section
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length: ");
        int l = input.nextInt();
        System.out.print("Enter width:  ");
        int w = input.nextInt();

        // Calculation Section
        Cl52a wow = new Cl52a(l, w);  // New object of "Cl52a" class
        wow.calc();  // Don't forget to call calc() or setThing()!
        int area  = wow.getArea();
        int perim = wow.getPerim();

        // Output Section
        System.out.println("Rectangle area:  " + area);
        System.out.println("Rectangle perim: " + perim);
    }
}
/*
Enter length: 5
Enter width:  10
Rectangle area:  50
Rectangle perim: 30
*/