# Unit 9 - Inheritance
Inheritance is a fundamental concept in **Object-Oriented Programming (OOP)** languages, such as Java, C++, and Python. It allows one class (also known as a **"parent"** or _"super"_ class) to pass on its attributes and behaviors to another class (known as a **"child"** or _"sub"_ class). This allows the child class to reuse the functionality of the parent class while also adding its own unique features, as well as more efficient and organized code because it allows for code reuse and reduces duplication. It also provides better organization of related classes and makes it easier to create and maintain large programs.

Put simply, a **Dog** class could inherit from a more general **Animal** class. The Animal class might have a `move()` method that defines the general behavior for moving, while the Dog class could override this method to include specific behavior for how a dog moves. For example:
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

Note that the `protected` keyword is NOT on the AP subset, but it is useful; it simply implies that ***the method/variable is private to everyone except any child classes***.





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
    this.radius = radius;
  }
}

public class Rectangle extends Shape {
  private int width;
  private int height;
  
  public Rectangle(int width, int height) {
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
* The method in the subclass SHOULD be marked with the `@Override` annotation. This tells the compiler that the method is intended to override a method in the superclass

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
It is very important to note that while some people use the terms "Overloading" and "Overriding" synonymously, they are two VERY different concepts in programming. Method **Overloading** refers to the ability of a class to ___have multiple methods with the same name, but with different parameters___. This allows for the creation of methods that can perform similar tasks, but with varying numbers and/or types of arguments. 

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
The `super` keyword acts as a reference variable referring to the immediate parent class object. It is mainly used to access the members (either methods or variables) of a parent class that has been hidden by a child class.

For example, if class **A** is the parent of class **B**, and both classes have a method named `printMessage()`, the `printMessage()` method in class B can call the `printMessage()` method of class A using the `super` keyword:
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

class Q2.Cat extends MyAnimal {
  private String color;

  public Q2.Cat(String name, int age, String color) {
    super(name, age);
    this.color = color;
  }
}
```
The **MyAnimal** class has a constructor that takes two arguments, `name` and `age`, and uses them to initialize the corresponding instance variables. The **Q2.Cat** class extends MyAnimal, so it inherits the name and age instance variables. In the Q2.Cat class, we have added a new instance variable, `color`, which is not present in the MyAnimal class. To initialize the `name` and `age` variables, which are inherited from MyAnimal, we use the `super` keyword to call the _superclass constructor_. ***The super keyword must be used as the first statement in the subclass constructor, and it must pass the values for the name and age variables as arguments***. This ensures that `name` and `age` are properly initialized before the Q2.Cat constructor proceeds to initialize the `color` variable.




## The *instanceof* Operator
In Java, the `instanceof` operator is a conditional operator used to determine if an object is an instance of a particular class or if it implements a particular interface. It returns a boolean value indicating whether or not the object is an instance of the specified class or interface.

Consider the following example:
```java
// Create an object of the String class
String str = "Hello, World!";

// Check if str is an instance of the String class
if (str instanceof String) {
  System.out.println("str is an instance of String");
} else {
  System.out.println("str is not an instance of String");
}
```
Here, `instanceof` is used to check if the `str` object is an instance of the **String** class. Since this is true, the code will print _"str is an instance of String"_ to the console.

You can also use the `instanceof` operator to check if an object implements a particular interface. For example:
```java
// Create an object of the ArrayList class
List<String> list = new ArrayList<>();

// Check if list implements the List interface
if (list instanceof List) {
  System.out.println("list implements the List interface");
} else {
  System.out.println("list does not implement the List interface");
}
```
Here, we check if the list object implements the List interface. Since the **ArrayList** class implements the **List** interface, the code will print _"list implements the List interface"_. Also note that ***when making an instance of a class that implements an interface or inherits from a superclass, we often declare the inherited or implemented class on the left-hand side and specify the object type with the `new` keyword***. For example:
```java
class Animal { }
class Dog extends Animal { }
class Q2.Cat extends Animal { }

public class CheckSuperInstance {
  public static void main(String[] args) {
    // Create a Dog object
    Animal animal = new Dog();

    // Check if animal is an instance of the Dog class
    if (animal instanceof Dog)
      System.out.println("animal is an instance of Dog");
    else
      System.out.println("animal is not an instance of Dog");

    // Check if animal is an instance of the Q2.Cat class
    if (animal instanceof Q2.Cat)
      System.out.println("animal is an instance of Q2.Cat");
    else
      System.out.println("animal is not an instance of Q2.Cat");
  }
}
```



## Inheritance Hierarchies - The Theory of Object-Oriented Programming
In Object-Oriented Programming, an **Inheritance Hierarchy** refers to the way that classes inherit attributes and behaviors from parent classes. This allows for a hierarchical relationship between classes, where child classes inherit the attributes and behaviors of their parent classes. Inheritance hierarchies can also have multiple levels of inheritance, where a child class inherits from a parent class, which itself inherits from a grandparent class, and so on, enabling a flexible and reusable code structure where common attributes and behaviors can be defined in parent classes and then inherited by child classes.






### Encapsulation
The idea of **Encapsulation** is one of the most fundamental concepts in Object-Oriented Programming. It is a technique for ensuring that the internal workings of a class are hidden from other classes and external users of an object. In other words, it is the process of enclosing all of the data and behavior of an object within a single, self-contained unit.

In Java (and most C-based programming languages like C++), encapsulation is implemented through the use of access modifiers, such as `private`, `protected`, and `public`. These modifiers determine the visibility and accessibility of the members of a class, such as its fields and methods. For example, a **private field** can only be accessed by the methods of the same class, while a **public field** can be accessed by any other class. This allows the developer to control how the internal data of an object is accessed and modified and ensures that the object's internal state remains consistent and correct.

Encapsulation has several benefits. It promotes modularity and code reusability, as it allows developers to create self-contained objects that can be easily reused in other parts of the program. It also increases code maintainability, as it allows us to make changes to the internal workings of an object without affecting other parts of the program. Finally, it enhances security, as it prevents external code from directly accessing or modifying the internal data of an object, which can help protect against malicious attacks.







### Polymorphism
Another important core OOP concept is **Polymorphism** (literally _"many forms"_), which refers to the ability of a variable, object, or function to take on multiple forms or behaviors. In the context of Java, polymorphism refers to the ability of an object to behave differently based on the current context in which it is used. This is achieved through the use of _inheritance_, _interfaces_, and _overridden_ methods, and is extremely valuable in writing flexible and reusable code.

Consider inheritance, which allows a child class to inherit the methods and properties of a parent class. This means that a child class can have its own unique behavior and attributes, while also being able to use the methods and properties of the parent class. For example, a parent class called **Animal** could have a `speak()` method that describes the general behavior of moving, while a child class called **Q2.Cat** could inherit the `speak()` method from the Animal class and also have its own unique `purr()` method.

Another way that polymorphism is achieved is through the use of **Interfaces**. An interface defines a set of methods that a class must implement, but it does not provide any implementation for those methods. This means that a class can implement multiple interfaces, each of which defines a different set of methods, and the class can provide its own unique implementation for each of those methods. This allows a single class to have multiple behaviors depending on which interface is being used to access its methods.

Finally, polymorphism can also be achieved through the use of overridden methods, meaning that a child class can provide its own implementation for a method that it has inherited from a parent class, which allows the child class to have its own unique behavior for that method. This is often used to provide more specific or specialized behavior for a particular child class, while still being able to use the more general behavior defined by the parent class.



## The *Object* Superclass
In Java (and many other OOP languages), the **Object** class is the superclass of all other classes. This means that ***every class in Java inherits the methods and fields defined in the Object class***. The class provides a set of methods that are available to all objects regardless of their specific type, including `equals()`, which allows you to compare two objects to see if they are equal, and `toString()`, which returns a String representation of the object.
The **default value** of an object reference (i.e., a variable that refers to an object) is `null`, which means that it doesn't refer to any object.

To override the `toString()` method, you would declare it as a method in your class that returns a string representation of the object. This method would have the following signature:
```java
public String toString() {
  // ...
}
```

Likewise, to override the `equals()` method, you would declare it as a method in your class that takes another object as a parameter and returns a **boolean** indicating whether the two objects are equal. This method would have the following signature:
```java
public boolean equals(Object other) {
  // ...
}
```

When overriding these methods, it is important to follow the general contract specified in the Object class. For example, the `equals()` method should return `true` if and only if the two objects are equal, and `toString()` should return a string representation of the object that is consistent with its `equals()` method.

Consider the following class definition that **explicitly** extends the Object class:
```java
public class SomeClass extends Object {
  // ...
}
```
Since SomeClass extends the Object class, it automatically has access to the methods defined in the Object class, including `equals()` and `toString()`.

Consider the following example:
```java
public class MyClass extends Object {
  private int x;
  private int y;
  
  public MyClass(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "MyClass[x=" + x + ",y=" + y + "]";
  }
}
```
Here, the `toString()` method returns a string representation of a MyClass object that includes the values of the `x` and `y` fields.

The **Object** class and its methods are an important part of the object-oriented nature of Java. They provide a foundation for working with objects in the language and allow you to create classes that can be used in a consistent and predictable way.



## Interfaces and Abstract Classes
While not currently in the AP subset, two important concepts that extend the concept of inheritance are **Interfaces** and **Abstract Classes**. In Object-Oriented Programming, an **Interface** is a blueprint for a class that specifies the behavior that a class must implement. It defines a set of methods that a class MUST implement, but it does not provide any implementation for those methods. Thus, when a class *implements* an interface, it must implement all of the methods that the interface defined.

An **Abstract Class** is a class that cannot be instantiated but can be extended by other classes. Abstract classes can contain both concrete (normal) and *abstract* methods (marked with the `abstract` keyword), which are methods that lack implementation. Unlike interfaces, abstract classes can provide *some* implementations for their methods.

In Java, a class can implement multiple interfaces, but can only extend a single abstract class. This is because Java (unfortunately) does not support multiple inheritance, which is the ability of a class to inherit from multiple classes. However, ***it is very important to note that you cannot make an instance of an abstract class or an interface***, since abstract classes are meant to be a superclass from which other classes can inherit, and interfaces provide no functionality. Since abstract classes can have abstract and non-abstract methods, the subclasses MUST provide implementations for the abstract methods.




### Interfaces
In Java, an **Interface** is a reference type that is similar to a **Class**. Put simply, it is a collection of abstract methods and constant values. ***A class implements an interface by providing implementations for all of the interface's methods***.

Consider the following example:
```java
public interface Shape {
  double getArea();
  double getPerimeter();
}
```
A class that implements the Shape interface (literally, using the `implements` keyword) would need to provide implementations for the `getArea()` and `getPerimeter()` methods — however, they must also be marked as overridden methods using `@Override`. 

For example:
```java
public class Circle implements Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double getPerimeter() {
    return 2 * Math.PI * radius;
  }
}
```
Here, the **Circle** class implements the **Shape** interface by providing implementations for the methods that the interface defines.

Another advantage of using interfaces is that a class can implement *multiple interfaces*. For example, a **Square** class that implements the methods of the **Shape** interface, as well as an interface named **Printable**:
```java
public interface Printable {
  void print();
}

public class Square implements Shape, Printable {
  private double sideLength;

  public Square(double sideLength) {
    this.sideLength = sideLength;
  }

  @Override
  public double getArea() {
    return sideLength * sideLength;
  }
  
  @Override
  public double getPerimeter() {
    return 4 * sideLength;
  }
  
  @Override
  public void print() {
    System.out.println("Side length: " + sideLength);
  }
}
```



### Abstract Classes and Methods
In OOP, an **Abstract Class** is a class that contains one or more abstract methods and possibly some concrete methods. An **Abstract Method** is a method that has a declaration but does not have an implementation. This means that the method does not have a body – it just specifies the method's *signature*, including the name of the method, the return type, and the list of parameters.

For example:
```java
public abstract class Animal {
  // Abstract method
  public abstract void makeSound();

  // Concrete method
  public void eat() {
    System.out.println("Eating...");
  }
}
```
In this example, the **Animal** class contains one abstract method called `makeSound()`, as well as one **Concrete (normal) Method** called `eat()`. The `makeSound()` is abstract because it does not have an implementation — it simply specifies that the method will take no parameters and return no value, whereas the `eat()` method is concrete since it has a complete implementation, including a method body.

To use an abstract class, you need to create a subclass that *extends* (like inheritance) the abstract class and provides implementations for all of the abstract methods. For example:
```java
public class Dog extends Animal {
  // Implement the abstract method
  @Override
  public void makeSound() {
    System.out.println("Woof!");
  }
}
```
Here, the **Dog** class extends the **Animal** class and provides an implementation for the `makeSound()` method, meaning we can make instances of dogs and `makeSound()` will have the desired behavior when it is called.

