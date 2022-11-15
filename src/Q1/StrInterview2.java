package Q1;

// Daniel Szelogowski
// 9/23/2022
// String Interview Question 2
public class StrInterview2 {
    public static void main(String[] args) {
        String word = "Mary";
        String anagram = "Army";

        word = word.toLowerCase();
        anagram = anagram.toLowerCase();

        if (word.length() != anagram.length()) {
            System.out.println("Not anagrams");
        } else {
            for (int lcv = 0; lcv < word.length(); lcv++) {
                char c = word.charAt(lcv);
                int index = anagram.indexOf(c);

                if (index != -1) {
                    anagram = anagram.substring(0, index) +
                            anagram.substring(index + 1, anagram.length());
                } else {
                    System.out.println("Not anagrams");
                }
            }
        }

        System.out.println("Are the strings anagrams: " + anagram.isEmpty());
    }
}
/*
Are the strings anagrams: true
 */