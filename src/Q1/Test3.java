package Q1;

public class Test3 {
    public static void main(String[] args) {
        String text = "BeAuTiFuL bEaCh".toLowerCase();
        // for (int lcv = text.length() - 1; lcv >= 0; lcv--) {}
        // region BackwardForLoop
        for (int lcv = text.length(); lcv --> 0;) {
            String chr = text.substring(lcv, lcv + 1);
            if (chr.equals("a") || chr.equals("e") || chr.equals("i") ||
                chr.equals("o") || chr.equals("u"))
                System.out.print(chr);
            else System.out.print(" ");
        }
        // endregion
        System.out.println();

        int x = 5;
        String ret = "" + x;
        char y = 'c';
        String ret2 = "" + y;
    }
}
//   ae   u i uae