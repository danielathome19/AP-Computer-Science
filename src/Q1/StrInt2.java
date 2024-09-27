package Q1;
import java.util.Scanner;

public class StrInt2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word   = input.nextLine();
        String word2  = input.nextLine();

        word = word.toLowerCase();
        word2 = word2.toLowerCase();

        if (word.length() != word2.length()) {
            System.out.println("Not anagrams :(");
        } else {
            for (int lcv = 0; lcv < word.length(); lcv++) {
                String c = word.substring(lcv ,lcv+1);
                int i = word2.indexOf(c);

                if (i != -1) {
                    word2 = word2.substring(0, i) + word2.substring(i+1);
                } else {
                    System.out.println("Not anagrams");
                    break;
                }
            }
        }
        System.out.println("Are the strings anagrams: " + word2.isEmpty());
    }
}
/*
Army
Mary
Are the strings anagrams: true
*/