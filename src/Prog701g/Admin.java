package Prog701g;

// Admin is a child of the parent class "Person"
public class Admin extends Person {
    private String myFavw;
    // Inherited myFirst and myLast from Person

    public Admin(String f, String l, String fav) {
        super(f, l);  // Call constructor of super/parent class
        myFavw = fav;
    }

    public String getFavw() { return myFavw; }
}
