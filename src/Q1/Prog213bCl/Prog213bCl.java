package Q1.Prog213bCl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog213bCl {
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/prog213b.txt"));

            while (file.hasNext()) {
                int qnt = file.nextInt();
                Cl213b wowza = new Cl213b(qnt);
                wowza.calc();
                System.out.println(wowza);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
/*
Quantity: 15	Price: $5.95	Amount Due: $89.25
Quantity: 45	Price: $5.95	Amount Due: $267.75
Quantity: 55	Price: $5.95	Amount Due: $327.25
Quantity: 56	Price: $5.95	Amount Due: $333.20
Quantity: 42	Price: $5.95	Amount Due: $249.90
Quantity: 115	Price: $5.75	Amount Due: $661.25
Quantity: 92	Price: $5.95	Amount Due: $547.40
Quantity: 31	Price: $5.95	Amount Due: $184.45
Quantity: 75	Price: $5.95	Amount Due: $446.25
Quantity: 48	Price: $5.95	Amount Due: $285.60
Quantity: 58	Price: $5.95	Amount Due: $345.10
Quantity: 1	    Price: $5.95	Amount Due: $5.95
Quantity: 25	Price: $5.95	Amount Due: $148.75
Quantity: 16	Price: $5.95	Amount Due: $95.20
Quantity: 19	Price: $5.95	Amount Due: $113.05
*/