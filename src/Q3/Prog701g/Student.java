package Q3.Prog701g;

public class Student extends Person {
    private double myGPA;

    public Student(String f, String l, double gpa) {
        super(f, l);
        myGPA = gpa;
    }

    public double getGPA() { return myGPA; }
}
