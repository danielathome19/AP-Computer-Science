package Q3.Prog701g;

// Admin is a child of the parent class "Person"
public class Admin extends Person {
    private String myFavw;
    // Inherited myFirst and myLast (indirectly) from Person

    public Admin(String fn, String ln, String fav) {
        super(fn, ln);  // Call the "super-class" (i.e., parent) constructor
        myFavw = fav;
    }

    public String getFavw() { return myFavw; }
}
