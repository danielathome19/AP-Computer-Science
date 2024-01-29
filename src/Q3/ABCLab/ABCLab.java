package Q3.ABCLab;

// https://www.cs.colostate.edu/~cs163/.Fall20/001/labs/16AbstractClasses
import java.util.Scanner;

public class ABCLab {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        // Circle
        System.out.print("Enter circle radius: ");
        double r = kbd.nextDouble();
        Shape sh1 = new Circle(r);
        // Rectangle
        System.out.print("Enter rectangle height: ");
        double rh = kbd.nextDouble();
        System.out.print("Enter rectangle width: ");
        double rw = kbd.nextDouble();
        Shape sh2 = new Rectangle(rh, rw);
        // Triangle
        System.out.print("Enter triangle base: ");
        double tb = kbd.nextDouble();
        System.out.print("Enter triangle height: ");
        double th = kbd.nextDouble();
        Shape sh3 = new Triangle(th, tb);

        ((Circle)sh1).printClass();
        sh1.calculateArea();
        sh1.calculateCircumference();

        ((Rectangle)sh2).printClass();
        sh2.calculateArea();
        ((Rectangle)sh2).calculatePerimeter();

        ((Triangle)sh3).printClass();
        sh3.calculateArea();
        ((Triangle)sh3).calculatePerimeter();
    }
}
