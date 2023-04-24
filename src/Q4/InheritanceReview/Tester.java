package Q4.InheritanceReview;

public class Tester {
    public static void main(String[] args) {
        Dog dog = new Dog(5, "Bucky", "White");
        dog.eat();
        dog.bark();
        dog.speak();
        dog.speak("Woof");
        System.out.println(dog);
    }
}
