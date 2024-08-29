package Q2.LP48;

public class ClLP48 {
    private final int myA;
    private final int myC;
    private final int myM;
    private int myXn;  // Seed

    public ClLP48(int a, int c, int m, int X0) {
        myA = a;
        myC = c;
        myM = m;
        myXn = X0;
    }

    public int nextInt() {
        myXn = (myA * myXn + myC) % myM;
        return myXn;
    }

    public String toString() {
        return String.format("(%d * %d + %d) % d = %d",
                             myA, myXn, myC, myM, this.nextInt());
    }
}
