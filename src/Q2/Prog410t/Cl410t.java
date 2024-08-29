package Q2.Prog410t;

public class Cl410t {
    private int myId;
    private double myIncome;
    private int myMembers;

    public Cl410t(int id, double income, int members) {
        myId = id;
        myIncome = income;
        myMembers = members;
    }

    public int getId()        { return myId; }
    public double getIncome() { return myIncome; }
    public int getMembers()   { return myMembers; }

    public String toString() {
        return String.format("%d\t%.2f\t%d", myId, myIncome, myMembers);
    }
}
