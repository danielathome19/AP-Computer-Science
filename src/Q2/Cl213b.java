package Q2;

// Daniel Szelogowski
// Q2.Prog213b
// 11/7/2015
public class Cl213b {
    private int myQuant;
    private double myPrice;
    private double myAmt;

    public Cl213b(int quantity) {
        myQuant = quantity;
        myPrice = 0;
        myAmt = 0;
    }

    public void calc() {
        if (myQuant > 0 && myQuant < 100) myPrice = 5.95;
        else if (myQuant > 99 && myQuant < 200) myPrice = 5.75;
        else if (myQuant > 199 && myQuant < 300) myPrice = 5.40;
        else if (myQuant >= 300) myPrice = 5.15;
        myAmt = myPrice * myQuant;
    }

    public String toString() {
        return "Price = $" + myPrice + "\tAmount Due = $" + String.format("%.2f", myAmt);
    }
}
