
import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // ArrayList<WrapperType> varname = new ArrayList<WrapperType>();

        for (int lcv = 0; lcv < 100; lcv++) {
            int rand = (int)(Math.random() * 100) + 1;
            list.add(rand);
        }

        for (int lcv = 0; lcv < list.size(); lcv += 2)
            System.out.print(list.get(lcv) + " ");
        System.out.println();

        if (list.contains(50))
            System.out.println("Does list contain 50? " + list.contains(50));
        System.out.println("Index of 50: " + list.indexOf(50));

        for (int cur : list)
            System.out.println(cur);
    }
}
