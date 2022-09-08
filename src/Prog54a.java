import java.util.Scanner;

public class Prog54a {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is the model of the car: ");
        String model = keyboard.nextLine();

        System.out.print("How many miles were driven: ");
        double miles = keyboard.nextDouble();

        System.out.print("How many gallons were used: ");
        double gallons = keyboard.nextDouble();

        double mpg = miles / gallons;
        System.out.println("The average MPG used by the " + model + " are " + mpg + " m/g");
    }
}

/*
What is the model of the car: 1970 VW Bug
How many miles were driven: 937
How many gallons were used: 35
The average MPG used by the 1970 VW Bug are 26.771428571428572 m/g
 */