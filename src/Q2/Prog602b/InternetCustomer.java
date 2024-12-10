package Q2.Prog602b;

public class InternetCustomer {
    private int myAcc;
    private double myHours;
    private int myCode;
    private double myCharge;

    public InternetCustomer(int acc, double hours, int code) {
        myAcc = acc;
        myHours = hours;
        myCode = code;
        myCharge = 0;
    }

    public void setCharge() {
        double surcharge = 0;
        if      (myCode == 1) surcharge = 50;
        else if (myCode == 2) surcharge = 150;

        // TODO: calculate charge

        myCharge += surcharge;
    }

    public int    getAcc()    { return myAcc;    }
    public double getHours()  { return myHours;  }
    public int    getCode()   { return myCode;   }
    public double getCharge() { return myCharge; }
}
