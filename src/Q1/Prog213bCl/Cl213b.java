package Q1.Prog213bCl;

public class Cl213b {
    private int myQuantity;
    private double myPrice;
    private double myAmt;

    public Cl213b(int quantity) {
        myQuantity = quantity;
        myPrice = 0;
        myAmt = 0;
    }

    public void calc() {
        if (myQuantity > 0 && myQuantity < 100)        myPrice = 5.95;
        else if (myQuantity > 99 && myQuantity < 200)  myPrice = 5.75;
        else if (myQuantity > 199 && myQuantity < 300) myPrice = 5.40;
        else if (myQuantity >= 300) myPrice = 5.15;
        myAmt = myPrice * myQuantity;
    }

    public String toString() {
        return String.format("Price = $%.2f\tAmount Due = $%.2f", myPrice, myAmt);
    }
}
