# Unit 9 - Inheritance
Inheritance is a fundamental concept in **Object-Oriented Programming (OOP)** languages, such as Java, C++, and Python. It allows one class (also known as a **"parent"** or _"super"_ class) to pass on its attributes and behaviors to another class (known as a **"child"** or _"sub"_ class). This allows the child class to reuse the functionality of the parent class while also adding its own unique features, as well for more efficient and organized code because it allows for code reuse and reduces duplication. It also provides better organization of related classes and makes it easier to create and maintain large programs.

For example, a **Dog** class could inherit from a more general **Animal** class. The Animal class might have a `move()` method that defines the general behavior for moving, while the Dog class could override this method to include specific behavior for how a dog moves. For example:
```java
public class Animal {
  protected String name;
  protected int numLegs;

  public Animal(String name, int numLegs) {
    this.name = name;
    this.numLegs = numLegs;
  }

  public void move() {
    System.out.println("Animal is moving");
  }
}

public class Dog extends Animal {
  public Dog(String name) {
    // Use the super keyword to call the constructor of the parent class
    super(name, 4);
  }

  // Override the move() method from the parent class
  @Override
  public void move() {
    System.out.println(name + " is running");
  }
}


public class InheritanceTest {
  public static void main(String[] args) {
    Animal animal = new Animal("animal", 4);
    animal.move();  // prints "Animal is moving"

    Dog dog = new Dog("dog");
    dog.move();  // prints "dog is running"
  }
}
```

Note that the `protected` keyword is NOT on the AP subset, but it is useful; it simply implies that **the method/variable is private to everyone except any child classes**.





## Creating Superclasses and Subclasses
A **Superclass** is a parent class that defines common attributes and methods that are inherited by subclasses. A **Subclass**, on the other hand, is a child class that inherits the attributes and methods of the superclass and can also have its own unique attributes and methods.

Let's look at an example; first, let's define a superclass called **Vehicle** that has two attributes: `make` and `model` and one method called `startEngine`:
```java
public class Vehicle {
  String make;
  String model;

  public void startEngine() {
    System.out.println("Starting engine...");
  }
}
```

Next, let's create a subclass called **Car** that _inherits_ the attributes and method of the Vehicle superclass and also has its own unique attribute called `numDoors` and method called `honkHorn`:
```java
public class Car extends Vehicle {
  int numDoors;

  public void honkHorn() {
    System.out.println("Honk honk!");
  }
}
```

To use the **Car** class, we can create an object of type `Car` and call the inherited and unique methods as follows:
```java
Car myCar = new Car();
myCar.make = "Toyota";
myCar.model = "Camry";
myCar.numDoors = 4;
myCar.startEngine();  // Output: "Starting engine..."
myCar.honkHorn();     // Output: "Honk honk!"
```

To summarize, the **Car** class is a _subclass_ of the **Vehicle** _superclass_ because it inherits the attributes and methods of the Vehicle class but also has its own unique attributes and methods.





### Writing Constructors for Subclasses
Recall that a constructor is a special method that is used to initialize an object's private data. When creating a subclass, it is often necessary to create a constructor for the subclass. This is done by defining a constructor method in the subclass that has the same name as the subclass. The constructor can then be used to initialize the properties ***specific to that subclass***.

For example, consider a simple class hierarchy with a base class called **Shape** and two subclasses called **Circle** and **Rectangle**:
```java
public class Shape {
    // Base class for shapes
}

public class Circle extends Shape {
    private int radius;
    
    public Circle(int radius) {
        // constructor for Circle objects
        this.radius = radius;
    }
}

public class Rectangle extends Shape {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        // constructor for Rectangle objects
        this.width = width;
        this.height = height;
    }
}
```

However, another extremely important component to writing subclasses is the `super` keyword, which allows us to pass values into the superclass' constructor.




### The *super* Keyword
The `super` keyword acts a reference variable referring to the immediate parent class object. It is mainly used to access the members (either methods or variables) of a parent class that have been hidden by a child class.

For example, if a class **A** is the parent of class **B**, and both classes have a method named `printMessage()`, the `printMessage()` method in class B can call the `printMessage()` method of class A using the `super` keyword:
```java
class A {
   public void printMessage() {
       System.out.println("This is a message from class A");
   }
}

class B extends A {
   public void printMessage() {
       // Call the printMessage() method of class A
       super.printMessage();
       System.out.println("This is a message from class B");
   }
}
```
Here the `printMessage()` method of class **B** calls the method of the same name from class A using the `super` keyword and then prints its own message. This allows the `printMessage()` method of class B to both inherit and extend the behavior of the original method from class A.





## Inheritance Hierarchies - The Theory of the Object-Oriented Programming Paradigm







### Encapsulation







### Polymorphism








## The *Object* Superclass





## Abstract Classes and Interfaces
NOT ON THE AP SUBSET BUT USEFUL
