package Q4.SocketLab;

public class CaeserCipher {
    public static String encrypt(String input, int offset) {
        String cipher = "";
        for (char c : input.toCharArray())
            cipher += (char)(c + offset);
        return cipher;
    }

    public static String decrypt(String cipher, int offset) {
        return encrypt(cipher, -offset);
    }
}
