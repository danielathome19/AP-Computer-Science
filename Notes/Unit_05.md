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

## Class Design
A general-purpose Class (sometimes called a *data class* in other languages) typically consist of the following:
* Private data
* Constructor(s)
* Mutator (Setter) Methods
* Accessor (Getter) Methods
* *Sometimes* Override Methods (such as `toString()`)

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


### Documentation Comments



## Class Methods



### Accessor Methods



### Mutator Methods




### Static Variables and Methods



## Scope and Access
Access refers to the level of accessibility a variable or method within a class is. If a method or class variable is `public`, then it can be accessed from anywhere -- within or outside of the class, including in other classes/methods. Likewise, a method/variable marked as `private` can only be accessed within its containing class.

Scope ...


### The *this* Keyword
