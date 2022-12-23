# Unit 5 - Writing Classes
Classes are the heart of Object-Oriented Programming (OOP) — in languages like Java, we divide programs up into multiple components, called **Classes**, to keep code organized and emphasize code reusability. Put simply, a Class is a thing that contains other things — be it a set of functions (or *methods*), public/private variables, or simply our ***Main*** method (known as the _"Entry Point"_). Some classes may also be instantiated as *objects*, such as the **Scanner** class.

## Writing Methods
A **method**, also known as a function or procedure, is a block of related lines of code that may contain any valid Java syntax. Methods may or may not also return a value (such as `Math.sin(x)` which returns a double, compared to `System.out.println()` which returns nothing). As such, we can flexibly use them as reusable snippets of code as desired, allowing us to make programs more efficient.

Methods generally follow the following format:
```java
<access_level: public or private (or protected, but not on AP subset)>
<static or blank> <datatype (return type)> 
<method_name>(<datatype arg1, datatype arg2, etc.>) {
  // ...
  // If not void: return datatype;
}

// or, simpler:
<access_level> <static/blank> <type> <name>(<type arg1, type arg2, ...>) {
  // Some code here
  // return varOfType;
}
```

The first line of every function is known as the **Method Header** or function signature since it tells us all core details about the function (ideally).
That is, consider the following method header: 
```java
public static int getRandomInt(int min, int max)
```
Clearly, this function can be accessed inside or outside of its defined class (*public*), it does not require its contained class to be instantiated first (*static*, just like we can call `Math.random()` from anywhere without making a **Math** class object), it returns an **int** value, the name is `getRandomInt`, and it takes two parameters: an `int` **min**, and an `int` **max**.

For example, a basic summation function (documented with docstrings/documentation comments):
```java
/**
 * Return the sum of all numbers 1 to n, inclusive.
 * @param n The maximum range to sum up to
 * @return The summation of the range [1, n]
 */
public int summation(int n) {
  int sum = 0;
  for (int i = 1; i <= n; i++)
    sum += i;
  return sum;
}
```

If a method's return type is `void`, it simply means that we are not required to return anything — though, often it is used to exit the method early.

### Documentation Comments
Comments are a fundamental need for large projects; unless you use extremely verbose and explicit variable, class, and method names, there will be parts of your code that do not make sense to other readers (including your future self!) especially. As well, we can use comments not only to explain what code does, but what unfinished code WILL do eventually (often marked with `// TODO: _____`) — for example, before even writing out any code, it is often useful to "sketch" out your program by breaking it down into smaller parts separated by comments describing what happens next.

Another standard in programming is the concept of **documentation comments**, which your text editor or development environment often uses to provide you with mouse-hover hints on what a *method* or *class* does and/or assist in code completion. These are multi-line comments that begin with `/**`, a `*` on each line, and end with `*/`. These can be as simple as describing who wrote the program and when, including HTML tags:
```java
/**
* <h1>Hello, World!</h1>
* The HelloWorld program simply displays "Hello World!" to the console.
* 
*
* @author  John Smith
* @version 1.0
* @since   2022-01-31
*/
public class HelloWorld {
   public static void main(String[] args) {
      System.out.println("Hello World!");
   }
}
```

Often, especially on the AP exam, documentation comments are used to explain the conditions for a given function, as well as the expected conditions after a function is run. These are typically defined as follows:
* **Precondition**: abc
* **Postcondition**: abc

For example, an AP-like question:
```java
** Constructs a GameBoard object having numRows rows and numCols columns.
* Precondition: numRows > 0, numCols > 0
* Postcondition: each tile has a 50% probability of being set to on.
*/
public GameBoard(int numRows, int numCols)
{ /* to be implemented ... */ }
```

#### Javadoc Tags
The **javadoc** tool provides a large number of standard annotations for documentation comments, such as `@return`, `@param`, and `@throws`/`@exception`, among [many others](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html#CHDBEFIF)[^1] such as the author/version/date annotations we saw previously. These allow us to specify things like descriptions of method parameters and/or what the method returns, if/what exceptions are thrown/what kind/when, deprecated methods, references to see something else, etc.

For example:
```java
/**
 * This method is used to add two integers. It is
 * a simple class method used to demonstrate the
 * various common javadoc tags.
 * @param num1 The first integer parameter.
 * @param num2 The second integer parameter.
 * @return int The sum of num1 and num2.
 */
 public int addInt(int num1, int num2) {
    return num1 + num2;
 }

/**
 * This is the main method which calls the addInt method.
 * @param args Unused.
 * @return Nothing.
 * @exception IOException On input error.
 * @see IOException
 */
 public static void main(String args[]) throws IOException {
    int sum = addInt(10, 20);
    System.out.println("10 + 20 = " + sum);
 }
```


## Class Design
A general-purpose Class (sometimes called a *data class* in other languages) typically consists of the following:
* **Private Data:** *instance* variables (i.e., variables specific to each object created of the class) that any method in the class can access but cannot be accessed outside the class directly; in good practice, we typically prefix these variable names with something like "my" or "\_", such as `private int myAge` or `private int _age`.
* **Constructor(s):** sets up the private data (taking in arguments for some and setting the rest to some default value, like 0)
* **Mutator (Setter) Methods**: modify private data
* **Accessor (Getter) Methods:** return private data
* *Sometimes* **Override Methods (such as `toString()`):** overridden methods from the **Object** class — usually some accessor method(s)

The general layout for classes is as follows:
```java
public class CLASS_NAME {
  // Private data
  private datatype myVar1;
  private datatype myVar2;
  private datatype myVar3;
   
  // Constructor
  public CLASS_NAME(datatype arg1, datatype arg2) {
    myVar1 = arg1;
    myVar2 = arg2;
  }
  
  // Calculation Function (Class Method and Mutator)
  public void calcVar3() {
    myVar3 = myVar1 * myVar2;
  }
  
  // Basic Class Method
  public datatype combineVar1AndVar2() {
    return myVar1 + myVar2;
  }
  
  // Getters (Accessor Methods)
  public datatype getMyVar1() { return myVar1; }
  public datatype getMyVar2() { return myVar2; }
  public datatype getMyVar3() { return myVar3; }
  
  // Setters (Mutator Methods)
  public datatype setMyVar1(datatype arg1) { myVar1 = arg1 };
  public datatype setMyVar1(datatype arg2) { myVar2 = arg2 };
  
  // Override Method
  public String toString() {
    return String.format("Var1: %FORMAT   Var2: %FORMAT   Var3: %FORMAT", 
                 myVar1, myVar2, myVar3);
  }
  
  // Easy Print Method
  public void print() {
    System.out.println(this.toString());
  }
}
```

Finally, we can instantiate it as a new object anywhere as follows:
```java
// In main, for example:
CLASS_NAME myClassObj = new CLASS_NAME(datatypev1, datatypev2);
myClassObj.calc();
System.out.println("Var3: " + myClassObj.getMyVar3());

// Modify the object's private values/fields/properties
myClassObj.setMyVar1(newdatatypev1);
myClassObj.setMyVar2(newdatatypev2);
myClassObj.calc();

// Print updated class
myClassObj.print();
// or, since the toString() method is implicitly called by print,
System.out.println(myClassObj);
```

We will break this class down to its components next.


### Constructors
A **Constructor** is a simple function that sets up the private data for a Class. It is a special type of method called through the `new CLASSNAME()` keyword (rather than a direct function call) that is used to initialize an object. When an object is created, the constructor is called to initialize the object and allocate memory for it. The constructor sets the initial values for the object's instance variables (the typically-private class data) and performs any other necessary initialization tasks. Constructors are typically defined with the same name as the class, and they do not have a return type.

It is worth noting that we can have multiple constructors — a process called ***"overloading"*** — which allow us to take in varying arguments if any. Sometimes a constructor may not even have any arguments, typically known as the **Default Constructor** since it usually sets up *default* or placeholder values for the class.

For example:
```java
public class Dog {
  private int age;
  private String name;
  
  // Default constructor
  public Dog() {
    age = 0;
    name = "";
  }
  
  // Normal constructor
  public Dog(int dogAge, String dogName) {
    age = dogAge;
    name = dogName;
  }
  
  // Overload constructor
  public Dog(String dogName) {
    age = 0;
    name = dogName;
  }
}


// Now, construct the class in 3 possible ways
Dog dog1 = new Dog();
Dog dog2 = new Dog("Buddy");
Dog dog3 = new Dog(10, "Bucky");
```


## Class Methods
Functions, or **Methods**, serve a variety of purposes. They may provide us with a way to modify some class data, perform some calculations independent of any class data (static methods), or simply return some class data. Just like with constructors, these can also be **overloaded** to consume different arguments. As such, methods in Java classes can generally be classified into one of three possible categories:
* **Accessor Methods**: return some private class variable (typically) or some result using them; may also be static
* **Mutator Methods**: modify some private class variable(s) and possibly return something; may also be static
* **Static Methods**: generally, perform some task independent of any class variables (that are not also static, at least)



### Accessor Methods
In _Object-Oriented Programming_, **Accessor Methods** are functions that are used to retrieve the value of an object's instance variables using the `return` keyword, which sends the value outside of the function so we can store it in a variable. These methods, also known as _getters_, allow other objects to access the value of the instance variable without directly accessing the variable itself. This can be useful for enforcing ***encapsulation***, which is the practice of hiding the internal details of an object and exposing only the necessary information to other objects. Accessor methods are typically named using the "**get**" prefix followed by the variable name, and they return the value of the instance variable. For example, if an object has an instance variable named "_name_", the corresponding accessor method would be called `getName()`. As well, these may also be overloaded from a parent class, such as `Object` which all classes inherit from — providing us with the `toString()` method that we can customize the behavior of.

Let's look at a very simple example:
```java
public class Vector3 {
  private double _x;
  private double _y;
  private double _z;
  
  public Vector3(int x, int y, int z) {
    _x = x;
    _y = y;
    _z = z;
  }
  
  // Getters (accessor methods)
  public double getX() {
    return _x;
  }
  
  public double getY() {
    return _y;
  }
  
  public double getZ() {
    return _z;
  }
  
  // Overload accessor from Object class
  public String toString() {
    return String.format("X: %f\t Y: %f\t Z: %f", 
                 this.getX(), this.getY(), this.getZ());
  }
}


// In main...
Vector3 position = new Vector3(0.5, 0.75, 3);

// Call the accessors and store their return value
double xPos = position.getX();
double yPos = position.getY();
double zPos = position.getZ();
System.out.println(position.toString());
// toString() is also called implicitly by println, 
// so `System.out.println(position);` is sufficient

// Or, call the accessors and directly utilize their return values
System.out.printf("X: %f\t Y: %f\t Z: %f\n",
      position.getX(), position.getY(), position.getZ());
```


### Mutator Methods
Similar to _getters_, **Mutator Methods** are methods that are used to modify the value of an object's instance variables. These methods, also known as _setters_, allow other objects to change the value of the instance variable without directly accessing the variable itself, which can also be useful for enforcing encapsulation. Setters seldom return anything — as such, we have a special type known as `void` which specifies that it returns nothing; sometimes we may even simply `return;` to exit the function earlier, such as if some condition does not pass. Mutator methods are typically named using the **set** prefix followed by the variable name, and they take a parameter that specifies the new value for the instance variable. For example, if an object has an instance variable named "_name_", the corresponding mutator method would be called `setName(String name)`; however, they may be also named something as simple as `calculate()`, which modifies numerous class variables at once. Again, these may also be overloaded to allow for varying arguments.

Let's look at an example:
```java
public class SimpleShape {
  private int myLength;
  private int myWidth;
  private int myArea;
  
  public SimpleShape(int length, int width) {
    myLength = length;
    myWidth = width;
    myArea = 0;
  }
  
  // Mutators
  public void calcArea() {
    myArea = myLength * myWidth;
  }
  
  public void setLength(int length) {
    myLength = length;
  }
  
  public void setWidth(int width) {
    myWidth = width;
  }
  
  // We can also combine these methods
  public void setLengthAndRecalculate(int length) {
    myLength = length;
    calcArea();
  }
  
  public void setWidthAndRecalculate(int width) {
    myWidth = width;
    calcArea();
  }
  
  // Overload mutator
  public void calcArea(int length, int width) {
    myLength = length;
    myWidth = width;
    myArea = length * width;
  }
  
  // Accessor
  public int getArea() {
    return myArea;
  }
}


// In main...
SimpleShape shape = new SimpleShape(5, 10);

// Call the mutators
shape.calcArea();
System.out.println(shape.getArea());

shape.setLength(3);
shape.setWidth(8);
shape.calcArea();
System.out.println(shape.getArea());

shape.setWidthAndRecalculate(16));
System.out.println(shape.getArea());

shape.setWidth(9);
shape.setLengthAndRecalculate(20);
System.out.println(shape.getArea());

shape.calcArea(15, 35);
System.out.println(shape.getArea());
```



### Static Variables and Methods
The **static** keyword is used to define a static member of a class. A static member is a member of a class that belongs to the class itself, rather than to any instance of the class. This means that a static member can be accessed directly on the class, without the need to create an object of the class — i.e., it is *ready at compile-time*. More simply, the `static` keyword implies that the method/variable belongs to the **Class** itself, rather than a specific *object* or *instance* of that class, meaning that the class does not have to be instantiated for us to use it.

The `static` keyword can be used to define static variables, static methods, and static inner classes:
* **Static Variables**: variables that are shared by all instances of a class. They are typically used to store values that are common to all objects of the class, such as constants
* **Static Methods**: methods that can be called directly on the class, without the need to create an object of the class. They are typically used to implement utility functions or to create methods that can be shared by all instances of a class
* **Static Inner Classes**: classes that are defined within another class, and are marked with the "static" keyword. These classes are associated with the outer class, rather than with any specific instance of the outer class

In general, the `static` keyword is used to define members of a class that can be accessed without an instance of the class. It is often used to create utility classes (as part of a library/package/module) or to implement methods that are common to all objects of a class.

For example:
```java
public class Counter {
  // Static variable
  public static int count = 0;

  // Instance variable
  private String name;

  // Static method
  public static void incrementCount() {
    count++;
  }

  // Constructor
  public Counter(String name) {
    this.name = name;
    // Increment the static count variable
    incrementCount();
  }
}


// In main...
// Print the initial value of the count variable
System.out.println(Counter.count); // Output: 0
// Create an instance of the MyClass class
Counter counter = new Counter("John");
// Print the value of the count variable again
System.out.println(Counter.count); // Output: 1
```



#### Static Methods
A static method is a method that belongs to a class rather than an instance of the class. This means that a static method can be called directly on the class itself, without the need to create an object of the class. Static methods are typically used to implement utility functions or to create methods that can be shared by all instances of a class.

To define a static method, the `static` keyword is used before the return type in the method declaration. For example:
```java
public static void printHello() {
    System.out.println("Hello!");
}
```
This method can then be called directly on the class using `MyClass.printHello();`.

Static methods can only access static variables and other static methods. They cannot access instance variables or instance methods because they do not have access to a specific instance of the class. This is the cause of the infamous _"Non-static variable cannot be referenced from a static context"_ error — which we often run into in our favorite `public static void main(String[] args) {}` method.




## Scope and Access
***Access*** refers to the level of accessibility of a variable or method within a class. If a method or class variable is `public`, then it can be accessed from anywhere — within or outside of the class, including in other classes/methods. Likewise, a method/variable marked as `private` can only be accessed within its containing class.

Similarly, ***scope*** refers to where exactly in the code something (usually a *variable*) is accessible. Typically, this refers to the set of curly braces that contain the variable.
Consider the following example:
```java
public static void main(String[] args) {
  int lcv = 0;
  while (lcv < 10) {
    System.out.println(lcv);
    lcv++;
  }

  // Versus
  for (int i = 0; i < 10; i++) {
    System.out.println(i);
    if (i > 8) {
      int temp = i * 2;
      System.out.println(temp);
    }
  }  
}
```
In the code above, we have three different variables, each with different *scopes*:
* `lcv` can be accessed from anywhere within `main` because it is declared outside of any block statements, such as a loop or condition (i.e, its "parent curly-braces" are the entirety of `main`)
* `i` can only be accessed within the `for` loop because it was declared inside of the loop — so, anything inside the `for` loop can also access `i`
* `temp` can only be accessed within the `if` statement inside the `for` loop — its "parent curly-braces" are the `if` statement, whose "parent curly-braces" are the `for` loop; so, every time the loop starts a new iteration, a new `int temp` will be made inside the `if` statement


### The *this* Keyword
The `this` keyword simply refers to the current class when working inside a constructor or method, typically. While it lacks any specific functionality, it is useful for eliminating any possible confusion when variable names are the same between a class variable and a method argument. For example:
```java
public class MyClass {
  private int x;

  public MyClass(int x) {
    this.x = x;
  }

  public static void main(String[] args) {
    MyClass thing = new MyClass(5);
    System.out.println("Value of x = " + thing.x);
  }
}
```

If `this` was not used in the example above, the program would print `0` instead of `5`, as the **argument** `x` would be assigned to itself, rather than assigning the **argument** `x` to the **class variable** `x`.

The `this` keyword can be used to:
* Invoke the current class constructor
* Invoke the current class method
* Pass an argument in the constructor call
* Pass an argument in the method call
* Return the current class object



[^1]: https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html#CHDBEFIF
