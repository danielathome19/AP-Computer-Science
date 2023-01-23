package Q2;// Daniel Szelogowski
// Prog213f
// 11/8/2022
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog213fArray {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("data/prog215a.dat"));

            Cl213f[] list = new Cl213f[1000];
            int cnt = 0;

            while (input.hasNext()) {
                int kwh = input.nextInt();

                Cl213f yikes = new Cl213f(kwh);
                list[cnt] = yikes;
                cnt++;
            }

            for (int lcv = 0; lcv < cnt; lcv++)
                list[lcv].calc();

            for (int lcv = 0; lcv < cnt; lcv++)
                System.out.println(list[lcv]);
                // System.out.println(list[lcv].toString());

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
