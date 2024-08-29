package Q4;

public class GenericsAndTernary {
    // Generic Typing
    static class MyBox<T> {  // Define a template type "T"
        private T myVal;

        public MyBox(T thing) { myVal = thing; }
        public void setVal(T thing) { myVal = thing; }
        public T getVal() { return myVal; }
        public String toString() { return myVal.toString(); }
    }

    public static void main(String[] args) {
        // ArrayList<TYPE> list = new ArrayList<TYPE>();
        var box = new MyBox<Integer>(5);  // 'var' infers the type from the RHS
        String msg = (box.getVal() >= 5) ? "val >= 5" : "val < 5";
        // Ternary Operator -> (condition) "if" ... "else" ...
        System.out.println(msg);
        box.setVal(10);
        System.out.println(box.getVal());
        // box.setVal("Hello");
        var sBox = new MyBox<String>("Hello");
        System.out.println(sBox);
        // ONLY EVER USE "var" IF YOU USE THE "new" KEYWORD
        // AND THE TYPE IS NOT A CHILD CLASS OR USES AN INTERFACE
        int day = 3;
        switch (day) {
            case 1:  // if (day == 1)
                System.out.println("Monday");
                break;
            case 2:  // else if (day == 2)
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                // break;
                // Break prevents you from falling into the case(s) below
            default:  // else
                System.out.println("Invalid");
                break;
        }
    }
}
