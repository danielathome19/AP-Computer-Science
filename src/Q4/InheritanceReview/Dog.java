package Q4.InheritanceReview;

public class Dog extends Animal {
    private String myColor;

    public Dog(int age, String name, String color) {
        super(age, name);
        myColor = color;
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("I eat dog food");
    }

    // Overload
    public void speak(String word) {
        System.out.println(word);
    }

    // New method
    public void bark() {
        System.out.println("Bark!");
    }

    public String toString() {
        return "Age: " + this.getAge() +
                "\nName: " + super.getName() +
                "\nColor: " + myColor;
    }
}
