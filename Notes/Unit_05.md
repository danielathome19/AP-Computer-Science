# Unit 5 - Writing Classes
UNDER CONSTRUCTION

## Writing Methods

Methods, also known as functions or procedures, generally follow the following format:
```java
<access_level: public or private (or protected, but not on AP subset)> <static or blank> <datatype> <method_name>(<datatype arg1, datatype arg2, etc.>) {
  // ...
  // If not void: return datatype;
}
```

The first line of every function is known as the **Method Header** or function signature, since it tells us all core details about the function (ideally).
That is, consider the following method header: ```public static int getRandomInt(int min, int max)```

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
    return String.format("Var1: %s   Var2: %s   Var3: %s", myVar1, myVar2, myVar3);
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


### Documentation Comments



## Class Methods



### Accessor Methods



### Mutator Methods




### Static Variables and Methods


## Scope and Access


### The *this* Keyword
