package Q1;
import java.util.*;

public class StrInt6 {
    public static void main(String[] args) {
        Scanner cool = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String mytext = cool.nextLine().toLowerCase().trim();

        int Acount = 0;
        int Bcount = 0;
        int Ccount = 0;

        for (int lcv = 0; lcv < mytext.length(); lcv++) {
            // Maybe substring will work better than char?
            char cur = mytext.charAt(lcv);

        }
    }
}
