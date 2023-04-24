package Q4.InheritanceReview;

public class Animal {
    private int myAge;
    private String myName;

    public Animal() {
        myAge = 0;
        myName = "";
    }

    public Animal(int age, String name) {
        myAge = age;
        myName = name;
    }

    public void eat() {
        System.out.println("I can eat");
    }

    public void speak() {
        System.out.println("Hello there!");
    }

    public int getAge() { return myAge; }
    public String getName() { return myName; }

}
