import java.util.*;
import java.io.*;

public class Prog285b {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("data/prog285b.dat"));

            System.out.println("ID\t\tCode\tSales\t\tCommission");
            System.out.println("--------------------------------------");
            while (input.hasNext()) {
                int id = input.nextInt();
                int c = input.nextInt();
                double s = input.nextDouble();
                double com = 0;

                if (c == 5 || c == 8) {
                    if (s <= 5000)
                        com = s * 0.075;
                    else
                        com = 5000 * 0.075 + (s - 5000) * 0.085;
                } else if (c == 17) {
                    if (s <= 3500)
                        com = s * 0.095;
                    else
                        com = 3500 * 0.095 + (s - 3500) * 0.12;
                }

                System.out.printf("%d\t\t%d\t\t%.2f\t\t%.2f\n", id, c, s, com);
            }
        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
/*
ID		Code	Sales		Commission
--------------------------------------
101		17		2250.00		213.75
103		5		4000.00		300.00
117		3		7350.00		0.00
118		8		7350.00		574.75
125		5		6500.00		502.50
138		17		6375.00		677.50
192		8		8125.00		640.63
203		8		3250.00		243.75
218		5		5000.00		375.00
235		5		5250.00		396.25
264		17		4150.00		410.50
291		17		750.00		71.25
 */
