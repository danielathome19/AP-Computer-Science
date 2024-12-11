package Q2.Prog213v;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Prog213v {
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("Langdat/prog213v.dat"));
            ArrayList<Transaction> list = new ArrayList<>();

            double balance = file.nextDouble();
            Bank bank = new Bank(balance);

            String code = file.next();
            while (!code.equals("E")) {
                double amount = file.nextDouble();
                Transaction coolbeans = new Transaction(code, amount);
                list.add(coolbeans);
                code = file.next();
            }

            for (int lcv = 0; lcv < list.size(); lcv++)
                bank.calc(list.get(lcv));

            System.out.println("The final balance is: $" + bank.getAmount());
            // TODO: the rest
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
/*
The final balance is: $219.15
*/
