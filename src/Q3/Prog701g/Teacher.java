package Q3.Prog701g;

public class Teacher extends Person {
    private int myNumStuds;

    public Teacher(String f, String l, int stu) {
        super(f, l);
        myNumStuds = stu;
    }

    public int getNumStuds() { return myNumStuds; }
}
