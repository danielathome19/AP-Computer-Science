import java.util.*;

public class Prog52Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the length: ");
        int len = input.nextInt();
        System.out.println();

        System.out.print("Please enter the width: ");
        int wid = input.nextInt();
        System.out.println();

        int area = len * wid;
        int perim = 2 * len + 2 * wid;
        System.out.println("The area is " + area);
        System.out.println("The perimeter is " + perim);
    }
}

/*
Please enter the length: 5

Please enter the width: 10

The area is 50
The perimeter is 30
 */