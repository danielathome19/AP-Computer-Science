package Q1;
import java.util.*;

public class StrInt6 {
    public static void main(String[] args) {
        Scanner wow = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = wow.nextLine().toLowerCase().trim();

        // NO ARRAYS!!!!! maybe
        int ACount = 0;
        int BCount = 0;
        int CCount = 0;

        for (int lcv = 0; lcv < text.length(); lcv++) {
            // Maybe substring will work better than char?
            char cur = text.charAt(lcv);
        }
    }
}
