package Q1;
import java.util.*;

public class Prog54a {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // int, double, boolean, String
        System.out.print("Enter the car model: ");
        String model = keyboard.nextLine();

        System.out.print("Enter miles driven: ");
        int miles = keyboard.nextInt();
        // double miles = keyboard.nextDouble();

        System.out.print("Enter gallons used: ");
        int gallons = keyboard.nextInt();

        double mpg = miles / (double)gallons;
        System.out.println("MPG used by " + model + " is " + mpg + "m/g");
    }
}
/*
Enter the car model: car
Enter miles driven: 357
Enter gallons used: 16
MPG used by car is 22.3125m/g
 */
