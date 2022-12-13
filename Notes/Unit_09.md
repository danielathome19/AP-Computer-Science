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



### Overriding Methods
Method **Overriding** is a feature in Object-Oriented Programming that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its superclasses or parent classes. This allows for subclasses to have their own unique behavior, while still retaining some of the basic behavior of the parent class.

Let's look at an **Animal** class with a `makeNoise()` method that simply outputs the string `"Making noise"`. If you have a **Dog** class that _extends_ **Animal**, you could **override** the `makeNoise()` method in the Dog class to output the string `"Woof!"` instead. This allows the Dog class to have its own unique behavior, while still retaining the basic behavior of the Animal class.

In order to override a method in Java, the following conditions must be met:
* The method in the subclass must have the same name and parameter list as the method in the superclass
* The method in the subclass must have the same return type (or a subtype) as the method in the superclass
* The method in the subclass SHOULD be marked with the @Override annotation. This tells the compiler that the method is intended to override a method in the superclass

Consider the following example:
```java
class Animal {
  public void makeNoise() {
    System.out.println("Making noise");
  }
}

class Dog extends Animal {
  @Override
  public void makeNoise() {
    System.out.println("Woof!");
  }
}
```
Here, the **Dog** class overrides the `makeNoise()` method from the **Animal** class and provides its own implementation. When `makeNoise()` is called on an instance of the Dog class, it will output the string `"Woof!"` instead of `"Making noise"`.


#### Overloading Methods
It is very important to note that while some people use the terms "Overloading" and "Overriding" synonymously, they are two VERY different concepts in programming. Method **Overloading** refers to the ability of a class to ___have multiple methods with the same name, but with different parameters___. This allows for the creation of methods that can perform similar tasks, but with varying numbers and/or type of arguments. 

For example:
```java
public class Calculator {
  // Method that takes two integers and returns their sum
  public int add(int a, int b) {
    return a + b;
  }

  // Method that takes three integers and returns their sum
  public int add(int a, int b, int c) {
    return a + b + c;
  }

  // Method that takes a list of integers and returns their sum
  public int add(List<Integer> numbers) {
    int sum = 0;
    for (int num : numbers)
      sum += num;
    return sum;
  }
}
```
Here, the **Calculator** class has three methods named `add()`, but each method takes a different number and type of arguments.

Again, method overloading is different from method overriding, which refers to the ability of a subclass to provide a different implementation of a method that is already defined in the superclass. In method overriding, the method signature (i.e., the name and the number and type of arguments) must be the same in both the superclass and the subclass.

For example:
```java
public class Shape {
  // Method that calculates the area of the shape
  public double getArea() {
    // Method implementation goes here
  }
}

public class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  // Overridden method that calculates the area of a circle
  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }
}
```
We technically have two implementations of `getArea()`, but since they share the same arguments (none, in this case) and it is inherited, we _Override_ the original implementation from the parent class.
  
  


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


#### Super Constructors
A **Super Constructor** is a constructor that is used to create an instance of a _subclass_ while setting up the inherited class variables from the _superclass_. It is called using the `super` keyword just like any other inherited member accesses. For example:
```java
class MyAnimal {
    private String name;
    private int age;

    public MyAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Cat extends MyAnimal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }
}
```
The **MyAnimal** class has a constructor that takes two arguments, `name` and `age`, and uses them to initialize the corresponding instance variables. The **Cat** class extends MyAnimal, so it inherits the name and age instance variables. In the Cat class, we have added a new instance variable, `color`, which is not present in the MyAnimal class. To initialize the `name` and `age` variables, which are inherited from MyAnimal, we use the `super` keyword to call the _superclass constructor_. **The super keyword must be used as the first statement in the subclass constructor, and it must pass the values for the name and age variables as arguments**. This ensures that `name` and `age` are properly initialized before the Cat constructor proceeds to initialize the `color` variable.




## Inheritance Hierarchies - The Theory of the Object-Oriented Programming Paradigm
In Object-Oriented Programming, an **Inheritance Hierarchy** refers to the way that classes inherit attributes and behaviors from parent classes. This allows for a hierarchical relationship between classes, where child classes inherit the attributes and behaviors of their parent classes. Inheritance hierarchies can also have multiple levels of inheritance, where a child class inherits from a parent class, which itself inherits from a grandparent class, and so on, enabling a flexible and reusable code structure where common attributes and behaviors can be defined in parent classes and then inherited by child classes.






### Encapsulation







### Polymorphism








## The *Object* Superclass





## Abstract Classes and Interfaces
NOT ON THE AP SUBSET BUT USEFUL
