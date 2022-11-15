package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Daniel Szelogowski
// Prog285bCl
// 10/24/2022

public class Prog285bClass {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("data/prog285b.dat"));

            while (input.hasNext()) {
                int id = input.nextInt();
                int c = input.nextInt();
                double s = input.nextDouble();

                Salesperson fred = new Salesperson(id, c, s);
                fred.setComm();
                System.out.println(fred.toString());
            }
        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
/*
101	17	2250.0	213.75
103	5	4000.0	300.0
117	3	7350.0	0.0
118	8	7350.0	574.75
125	5	6500.0	502.5
138	17	6375.0	677.5
192	8	8125.0	640.625
203	8	3250.0	243.75
218	5	5000.0	375.0
235	5	5250.0	396.25
264	17	4150.0	410.5
291	17	750.0	71.25
*/