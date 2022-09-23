// Daniel Szelogowski
// 9/23/2022
// String Interview Question 3
public class StrInterview3 {
    public static void main(String[] args) {
        String inputStr = "Morning";
        inputStr = inputStr.toLowerCase();

        for (int lcv = 0; lcv < inputStr.length(); lcv++) {
            char c = inputStr.charAt(lcv);
            if (inputStr.indexOf(c) == inputStr.lastIndexOf(c)) {
                System.out.println("First non-repeating character is: " + c);
                break;
            }
        }
    }
}
/*
First non-repeating character is: m
*/