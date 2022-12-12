# Unit 5 - Writing Classes
Classes are the heart of Object-Oriented Programming (OOP) -- in languages like Java, we divide programs up into multiple components, called **Classes**, to keep code organized and emphasize code reusability. Put simply, a Class is a thing that contains other things -- be it a set of functions (or *methods*), public/private variables, or simply our ***Main*** method (known as the _"Entry Point"_). Some classes may also be instantiated as *objects*, such as the **Scanner** class.

## Writing Methods
A **method**, also known as a function or procedure, is a block of related lines of code which may contain any valid Java syntax. Methods may or may not also return a value (such as `Math.sin(x)` which returns a double, compared to `System.out.println()` which returns nothing). As such, we can flexibly use them as reusable snippets of code as desired, allowing us to make programs more efficiently.

Methods generally follow the following format:
```java
<access_level: public or private (or protected, but not on AP subset)> <static or blank> <datatype> <method_name>(<datatype arg1, datatype arg2, etc.>) {
  // ...
  // If not void: return datatype;
}
```

The first line of every function is known as the **Method Header** or function signature, since it tells us all core details about the function (ideally).
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

### Documentation Comments
Comments are a fundamental need for large projects; unless you use extremely verbose and explicit variable, class, and method names, there will be parts of your code that do not make sense to other readers (including your future self!) especially. As well, we can use comments not only to explain what code does, but what unfinished code WILL do eventually (often marked with `// TODO: _____`) -- for example, before even writing out any code, it is often useful to "sketch" out your program by breaking it down into smaller parts separated by comments describing what happens next.

Another standard in programming is the concept of **documentation comments**, which your text editor or development environment often uses to provide you with mouse-hover hints on what a *method* or *class* does and/or assisting in code-completion. These are multi-line comments that begin with `/**`, a `*` on each line, and end with `*/`. These can be as simple as describing who wrote the program and when, including HTML tags:
```java
/**
* <h1>Hello, World!</h1>
* The HelloWorld program simply displays "Hello World!" to the standard output.
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

Often, especially on the AP exam, documentation comments are used to explain the conditions for a given function, as well as the expected conditions after a function is ran. These are typically defined as follows:
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
The **javadoc** tool provides a large number of standard annotations for documentation comments, such as `@return`, `@param`, and `@throws`/`@exception`, among [many others](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html#CHDBEFIF) such as the author/version/date annotations we saw previously. These allow us to specify things like descriptions of method parameters and/or what the method returns, if/what exceptions are thrown/what kind/when, deprecated methods, references to see something else, etc.

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
* **Private Data:** *instance* variables (i.e., variables specific to each object created of the class) which any method in the class can access but cannot be accessed outside the class directly
* **Constructor(s):** sets up the private data (taking in arguments for some and setting the rest to some default value, like 0)
* **Mutator (Setter) Methods**: modify private data
* **Accessor (Getter) Methods:** return private data
* *Sometimes* **Override Methods (such as `toString()`):** overidden methods from the **Object** class -- usually some accessor method(s)

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
    return String.format("Var1: %FORMAT   Var2: %FORMAT   Var3: %FORMAT", myVar1, myVar2, myVar3);
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
A **constructor** is a simple function that sets up the private data for a Class.


## Class Methods



### Accessor Methods



### Mutator Methods




### Static Variables and Methods

static means it belongs to the type itself rather than a specific object
does not have to be instantiated
ready at compile-time


## Scope and Access
***Access*** refers to the level of accessibility a variable or method within a class is. If a method or class variable is `public`, then it can be accessed from anywhere -- within or outside of the class, including in other classes/methods. Likewise, a method/variable marked as `private` can only be accessed within its containing class.

Similarly, ***scope*** refers to where exactly in the code something (usually a *variable*) is accessible. Typically, this refers to the set of curly-braces that contain the variable.
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
* `i` can only be accessed within the `for` loop, because it was declared inside of the loop -- so, anything inside the `for` loop can also access `i`
* `temp` can only be accessed within the `if` statement inside the `for` loop -- its "parent curly-braces" are the `if` statement, whose "parent curly-braces" are the `for` loop; so, every time the loop starts a new iteration, a new `int temp` will be made inside the `if` statement


### The *this* Keyword
The `this` keyword simply refers to the current class when working inside a constructor or method, typically. While it lacks any specific functionality, it is useful for eliminating any possible confusion when variable names are the same between a class variable and a method argument. For example:
```java
public class MyClass {
  int x;

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
* Invoke current class constructor
* Invoke current class method
* Pass an argument in the constructor call
* Pass an argument in the method call
* Return the current class object
