// Daniel Szelogowski
// 9/23/2022
// String Interview Question 1
public class StrInterview1 {
    public static void main(String[] args) {
        String str = "beautiful beach";
        System.out.println("The string is: " + str);
        System.out.print("Duplicate characters: ");

        for (int lcv = 0; lcv < str.length(); lcv++) {
            for (int lcv2 = lcv + 1; lcv2 < str.length(); lcv2++) {
                char letter1 = str.charAt(lcv);
                char letter2 = str.charAt(lcv2);

                if (letter1 == letter2) {
                    System.out.print(letter2 + " ");
                    break;
                }
            }
        }
    }
}
/*
The string is: beautiful beach
Duplicate characters: b e a u
 */
