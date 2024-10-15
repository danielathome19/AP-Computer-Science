package Q1.Prog93aCl;

public class Cl93a {
    private int kwh;
    private double baseRate;
    private double surcharge;
    private double cityTax;
    private double total;
    private double lateTotal;

    public Cl93a(int kwh) {
        this.kwh = kwh;
        baseRate = 0;
        surcharge = 0;
        cityTax = 0;
        total = 0;
        lateTotal = 0;
    }

    public void calc() {}  // TODO

    public String toString() {
        return "KWH Used: " + kwh +
               "\nBase Rate: " + baseRate +
               "\nSurcharge: " + surcharge;  // TODO: the rest
    }
}
