package Q3.Prog505a;

public class BookPerson {
    private String myName;
    private int myBooks;
    private int myPoints;

    public BookPerson(String name, int books) {
        myName = name;
        myBooks = books;
        myPoints = 0;
    }

    public void calc() {
        if (myBooks <= 3)
            myPoints = myBooks * 10;
        else if (myBooks <= 6)
            myPoints = (myBooks - 3) * 15 + 30;
        else
            myPoints = (myBooks - 6) * 20 + 30 + 45;
    }

    public String getName() { return myName;   }
    public int getBooks()   { return myBooks;  }
    public int getPoints()  { return myPoints; }

    @Override
    public String toString() {
        return myName + '\t' + myBooks + '\t' + myPoints;
    }
}