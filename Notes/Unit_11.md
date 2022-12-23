# Unit 11 (Extras) - Useful Non-AP Java Concepts for After the Exam
There are many programming and Computer Science concepts that the AP exam leaves out that, while not necessary for the test, are extremely useful in real-world software. The most important of these is the concept of **Number Bases**, which describe how numbers are represented in various contexts within computing systems. As well, there are many types of statements and keywords, such as **switch** statements, generic typing, and **Functional Programming** concepts that are used constantly in real applications, but are left out of the exam. We will survey many of the most common ones here; though while not discussed, additional concepts to know include sockets and networking, cryptography, graphics libraries (such as JavaFX and Swing), game development, and web applications.





## Number Bases
In a number system, the **Base** (or *Radix*) is the number of digits or distinct symbols that are used to represent numbers. For example, in the **Decimal** number system, which is the most commonly used system, the base is 10 since there are 10 digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) used to represent numbers.


### Binary Encoding
Binary is a number system that uses only two digits, 0 and 1, to represent numbers. It is often used in computing and digital systems because it is a simple and efficient way to represent and manipulate data.

To represent a number in binary, you can use a series of digits to represent the value of each power of 2. For example, the binary number 1011 represents the decimal number 11.

To convert a number from **decimal to binary**, you can divide the number by 2 and keep track of the remainder until the result is 0. For example, to convert the decimal number 11 to binary:

$$
\begin{align*}
11 / 2 &= 5 \text{ remainder } 1\\
5 / 2 &= 2  \text{ remainder } 1\\
2 / 2 &= 1  \text{ remainder } 0\\
1 / 2 &= 0  \text{ remainder } 1
\end{align*}
$$

Hence, the binary representation of 11 is 1011.

To convert a number from **binary to decimal**, you can multiply each digit by the corresponding power of 2 and add the results. Let's convert the binary number 1011 back to decimal:

$$
1 * 2^3 + 0 * 2^2 + 1 * 2^1 + 1 * 2^0 = 8 + 0 + 2 + 1 = 11
$$

### Hexidecimal Encoding
Hexadecimal is one of the most important number systems that is used in computing. It uses a base of 16 with the digits (0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, and F) to represent numbers (where A=10, B=11, etc.), allowing extremely compact number storage for large amounts of data.

To convert a number from **decimal to hexadecimal**, you can divide the number by 16 and keep track of the remainder until the result is 0. For example, to convert the decimal number 28 to hexadecimal:

$$
\begin{align*}
28 / 16 &= 1 \text{ remainder } 12\\
1 / 16 &= 0  \text{ remainder } 1
\end{align*}
$$

Hence, the hexadecimal representation of 28 is 1C.

To convert a number from **hexadecimal to decimal**, you can multiply each digit by the corresponding power of 16 and add the results. Let's convert the hexadecimal number 1C back to decimal:

$$
1 * 16^1 + 12 * 16^0 = 16 + 12 = 28
$$


## The *do-while* Loop
A **do-while** loop is a simple looping structure that runs a block of code *at least once*, then repeatedly executes the block as long as a condition is true. The syntax is simply a **while** loop upside-down, where the condition is checked at the end of the loop (after iterating):
```java
do {
   // code block to be executed
} while (condition);
```

The code block inside the loop will be executed at least once, even if the condition is initially false. Consider the following example:
```java
int count = 10;
do {
   System.out.println(count);
   count--;
} while (count > 0);
```
Here, the code inside the loop will be executed 10 times because the condition `count > 0` is initially true. On each iteration, the value of count is decreased by 1 until it becomes 0, at which point the loop will terminate; hence, the loop prints out all the numbers from 10 to 1 (inclusive).





### The *break* and *continue* Keywords
The `break` and `continue` keywords are simple but powerful statements used to alter the flow of a loop. Put simply, `break` will immediately exit the current loop (not all if it is nested within two loops, though) and `continue` skips all remaining code in the loop and starts the next iteration. We can either *break* to exit a loop early or *continue* and skip the current iteration of a loop to move on to the next one.

For example, using `break`:
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;
    }
    System.out.println(i);
}
```
The loop will iterate from 0 to 9, but it will break out of the loop when `i` is equal to 5; hence, the output will be "0, 1, 2, 3, 4".

Likewise, `continue` can be used in a very similar manner:
```java
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue;
    }
    System.out.println(i);
}
```
Here, the loop loop iterates from 0 to 9, but it skips printing the value of `i` when it is even. Thus, the output of this loop will be "1, 3, 5, 7, 9".





## The *switch* Statement
One very useful statement Java inherits from C, the **switch** statement, is used to execute a block of code based on the value of a given expression. It is similar to having multiple **if/else-if/else** statements, but it is often more efficient when you have a large number of possible conditions for one variable. We simply make a `switch` on the variable we want to check, and make a `case` for all possible values for that variable — however, we also need to `break` at the end of the case, or we can actually fall into the next case down. As well, we can also provide an optional `default` case which acts as our **else** condition if no other cases match.

For example:
```java
int day = 3;

switch (day) {
  case 1:
    System.out.println("Monday");
    break;
  case 2:
    System.out.println("Tuesday");
    break;
  case 3:
    System.out.println("Wednesday");
    break;
  case 4:
    System.out.println("Thursday");
    break;
  case 5:
    System.out.println("Friday");
    break;
  case 6:
    System.out.println("Saturday");
    break;
  case 7:
    System.out.println("Sunday");
    break;
  default:
    System.out.println("Invalid choice");
}
```
Here, the `day` variable is 3, so the code inside the `case 3:` block will be executed. Breaking at the end of each case exits the **switch** statement and prevents the code in the following case blocks from being executed, just like breaking inside a loop.





## The *var* Type Name
In many programming languages, the `var` type name is used to declare a variable with an inferred type. It was introduced as a way to reduce the verbosity of code by allowing the compiler to implicitly determine the type of a variable based on the initializer expression.

For example:
```java
public class MyClass {
  public static void main(String[] args) {
    var myStr = "Hello, world!";
    
    // The type of 'myStr' is inferred to be 'String' by the compiler
    System.out.println(myStr);
  }
}
```

It's important to note that `var` can ***only be used to declare local variables and cannot be used to declare class-level variables or method parameters***. Additionally, the type must be inferable from the initializer expression, so it cannot be used to declare variables with an initial value of null. While a matter of preference, the most appropriate use case for `var` would be for variables that are instances of classes or variables returned from methods, especially with extremely long names — however, ***almost NEVER should you use this with primitive types or inherited, abstract, or interface classes***, as the behavior may not be what you expect. As such, you should avoid using `var` until you have a strong grasp of inheritance and mental type inference (or look at the documentation!) especially.

Consider the following *appropriate* example:
```java
var url = new URL("https://google.com/"); 
var conn = url.openConnection(); 
var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
```
Here, it is much clearer and easier to read our code if the left-hand side is less cluttered, which would normally look as follows:
```java
URL url = new URL("https://google.com/"); 
URLConnection conn = url.openConnection(); 
Reader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
```





## The Ternary Operator
The **Ternary Operator** is a conditional operator that can be used to assign a value to a variable based on a *boolean condition*. It uses the following syntax:
```java
variable = condition ? value1 : value2;
```
In this format, `condition` is a boolean expression, and `value1` and `value2` are values/expressions of any type. If condition is true, the ternary operator will evaluate to `value1`, otherwise it will evaluate to `value2`.

Consider the following example:
```java
int x = 10;
int y = 20;

int max = (x > y) ? x : y;
System.out.println(max);  // Output: "20"
```
Here, the boolean expression `x > y` is false, so the ternary operator evaluates to `y` and thus `max` is assigned as 20.

The ternary operator is often used as a shorthand way to write simple **if-else** statements. For example:
```java
int x = 10;
int y = 20;

int max;
if (x > y) {
  max = x;
} else {
  max = y;
}

System.out.println(max);  // Output: "20"
```
is equivalent to the previous code using the ternary operator.





## Enumerations
In Java, an `enum` (or **enumeration**) is a special data type that represents a fixed set of values. It is used to define a list of predefined constants, which can be useful when you want to define a set of values that a variable can take on and you want to ensure that the variable can only be assigned one of those specific values. One such example is the set of possible keys a user may press in a video game — which is extremely useful when paired with a `switch` statement.

For example:
```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// In main...
Day today = Day.MONDAY;
System.out.println("Today is " + today);
// Output: "Today is MONDAY"
```

Enums can also have additional methods and fields, and you can use them in a similar way to classes. For example:
```java
public enum Day {
    MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thursday"),
    FRIDAY("Friday"), SATURDAY("Saturday"), SUNDAY("Sunday");

    private final String fullName;

    private Day(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}

Day today = Day.MONDAY;
System.out.println("Today is " + today.getFullName());
// Output: "Today is Monday"
```
Now we have added a field fullName and a constructor to the enum **Day**, as well as a method `getFullName()` that returns the full name of the day in title case instead of all uppercase.





## Generic Typing
In Java, **Generics** (sometimes called *Templates* from C++) allow you to write code that can work with multiple types while still providing type safety. This is extremely useful and powerful when you want to create a class or method that can work with multiple types, but want to ensure that the types used are compatible. Generally, we represent this by appending the suffix `<T>` (or any other name like `<TYPE>` or multiple using `<T, U>` etc.) to the end of the class name. We have seen this exact syntax when using the **ArrayList** class, which we noted requires us to use the wrapper class for primitive types.

Consider the following simple example:
```java
public class MyClass<T> {
    private T value;

    public MyClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```
Here, the class MyClass has a *generic type* `T`. The `T` can be replaced with any type when the class is instantiated. For example:
```java
MyClass<String> stringClass = new MyClass<>("hello");
MyClass<Integer> intClass = new MyClass<>(123);
// Note that with generic classes, we can technically drop including the type on the right-hand side
// as long as we define it on the left — i.e., if we are not using `var`
```
The `T` type is used in the method `getValue()`, which returns an object of type `T`.

We can also make generic methods:
```java
public static <T>T getMiddleElement(T[] array) {
    return array[array.length / 2];
}
```
The `getMiddleElement()` method has a generic type `T`, which represents the type of the elements in the array. The method can be called with any type of array, given that the type is compatible with the return type of the method:
```java
String[] strArr = {"a", "b", "c"};
String sMid = getMiddleElement(strArr);
Integer[] intArr = {1, 2, 3};
Integer iMid = getMiddleElement(intArr);
```





## Functional Programming
The concept of **Functional Programming (FP)** is a programming paradigm that emphasizes the use of functions to model and solve problems. In functional programming, functions are treated as ***first-class citizens***, meaning that they can be passed as arguments to other functions, returned as values from functions, and assigned to variables.

Functional programming has a number of benefits, including:
1. **Simplicity**: By focusing on functions and immutable data, functional programming can help keep code simple and easy to reason about
2. **Modularity**: Functions can be easily composed and reused, making it easy to build modular, maintainable code
3. **Concurrency**: Because functional programming relies on immutable data and side-effect-free functions, it can make it easier to write concurrent and parallel code

Functional programming is a powerful tool for solving a wide range of problems and can be used in many different programming languages. In Java, FP can be achieved using **lambda expressions** especially, which allow you to create **anonymous functions** that can be passed as arguments to other functions.

One of the main benefits of using functional programming is that it allows you to write concise, expressive code that is easy to read and understand. This can make it easier to write and maintain code, particularly in large projects with many developers. It is especially useful in Java when working with data streams and collections, as it allows you to easily apply transformations and filters to data in a declarative way, as well as when working with concurrency and parallelism.



### Function Pointers or Functions as Objects
One extremely useful concept of FP is the idea of **Function Pointers**, also known as function references or function handles, which are references to functions that can be stored, passed around, and invoked. To use them, we can import the `java.util.function.Function` interface to ***define or store functions as variables***.

For example, you can use the **Function** interface to define a function pointer that takes an integer as input and returns a string:
```java
import java.util.function.Function;

public class FuncPointerExamples {
    public static void main(String[] args) {
        // Define a function pointer that takes an integer and returns a string
        Function<Integer, String> intToStr = i -> String.valueOf(i);

        // Use the function pointer to convert an integer to a string
        String str = intToStr.apply(123);
        System.out.println(str);
    }
}
```

You can also use *Method References* to create function pointers using the `::` operator in the form `CLASSNAME::METHODNAME`:
```java
import java.util.function.Function;

public class MethodRefPointers {
    public static double Exp(double n) {
        return Math.exp(n);
    }
    
    public static void main(String[] args) {
        Function<String, Integer> strLen = String::length;
        int length = strLen.apply("hello");
        System.out.println(length);
        
        Function<Double, Double> myExp = MethodRefPointers::Exp;
        double result = myExp.apply(3.0);
        System.out.println(result);
    }
}
```



#### Definitions of Derivative and Integral
One of the most practical ways we can use function pointers is to make methods that take functions as arguments. For example, consider the [Definition of the **Derivative**](https://tutorial.math.lamar.edu/classes/calci/defnofderivative.aspx)[^1] from Calculus:

$$
f'(x) = \frac{df}{dx} = \lim_{h \to 0} \frac{f(x+h) - f(x)}{h}
$$

This definition provides an approach to evaluating the slope (or rate of change) at any point within a function $f(x)$. Using function pointers, we can make a method and use the pointer to that method to calculate its derivative at some point using an arbitrarily small number $h \approx \text{0.000...1} \equiv 10^{-\varepsilon}$ for the limit. Likewise, we can find the $n\text{th}$ derivative (written $f^{(n)}(x)$ or $\frac{d^nf}{dx^n}$) by recursively taking the derivative of the derivative $n$ times and approximating a good $h$ value as $h \approx \frac{1}{10^n}$.

Consider the following example using $x=5$, $f(x)=x^3$, and by the *Power Rule*, $f'(x)=3x^2$, $f''(x)=6x$, and $f'''(x)=6$:
```java
import java.util.function.Function;

public class Derivatives {
    public static double f(double x) {
        return Math.pow(x, 3);
    }

    public static double derive(Function<Double, Double> f, double x) {
        final double h = 0.0000001;
        return (f(x + h) - f(x)) / h;
    }
    
    public static double derive(Function<Double, Double> f, double x, double h) {
        return (f(x + h) - f(x)) / h;
    }

    public static double deriveN(Function<Double, Double> f, double x, int n) {
        final double h = 1/Math.pow(10, n);
        if (n == 1) return derive(f, x);
        else return (deriveN(f, x + h, n - 1) - deriveN(f, x, n - 1)) / h;
    }

    public static void main(String[] args) {
        double x = 5;
        System.out.println("x = " + x);
        System.out.println("Does derive(f,x) match the power rule? f(x)=x^3 so f'(x)=3x^2: " + (3 * Math.pow(x, 2)));
        System.out.println("f(x) = " + f(x));
        System.out.println("f'(x) = " + derive(Derivatives::f, x));
        System.out.println("The second derivative using the power rule yields f''(x)=6x: " + (6 * x));
        System.out.println("f''(x) = " + deriveN(Derivatives::f, x, 2));
        System.out.println("The third derivative using the power rule yields f'''(x)=6: " + 6);
        System.out.println("f'''(x) = " + deriveN(Derivatives::f, x, 3));   
    }
}

/* Displays the following:
   x = 5.0
   Does derive(f,x) match the power rule? f(x)=x^3 so f'(x)=3x^2: 75.0  
   f(x) = 125.0
   f'(x) = 75.00000165805432
   The second derivative using the power rule yields f''(x)=6x: 30.0    
   f''(x) = 30.029994491087564
   The third derivative using the power rule yields f'''(x)=6: 6        
   f'''(x) = 6.011191544530448
*/
```
Here we overload the `derive` method to either accept a value for $h$ or use the arbitrarily small default value provided in the first definition, which can be useful if a certain function necessitates a different value.

We can also apply this same concept to the [Definition of the **Definite Integral** as the Limit of a Riemann Sum](https://www.sfu.ca/math-coursenotes/Math%20158%20Course%20Notes/sec_riemann.html)[^2] (also known as the *Antiderivative*) using the *Midpoint Rule* and some arbitrarily large number of divisions $n = 10^{\varepsilon}$ to approximate:

$$F(x) = \int_{a}^{b} f(x)dx = \lim_{n \to \infty} \sum_{i=1}^{n} f(c_{i}) \Delta{x}$$

where

$$
\begin{align*}
\Delta{x} &= \frac{b-a}{n} \\
x_i &\approx a + i * \Delta{x} \\
c_{i} &= \frac{x_i + x_{i+1}}{2}
\end{align*}
$$

This definition provides an approach to evaluating the area under a curve between two interval points $[a,b]$ below a function $f(x)$.

Consider the following example using $a=1$, $b=5$, $f(x)=x^3$, and by the *Power Rule* and *the Fundamental Theorem of Calculus*, $F(x) = \int_a^b x^{3}dx = \[\frac{x^4}{4}\]^b_a = \frac{b^4}{4} - \frac{a^4}{4}$:
```java
import java.util.function.Function;

public class Integrals {
    public static double f(double x) {
        return Math.pow(x, 3);
    }

    public static double integrate(Function<Double, Double> f, double a, double b, int n) {
        double sum = 0;
        double deltaX = (b - a) / n;
        for (int i = 0; i < n; i++) 
            sum += f(((a + i * deltaX) + (a + (i + 1) * deltaX)) / 2) * deltaX;
        return sum;
    }

    public static void main(String[] args) {
        double a = 1;
        double b = 5;
        int n = 100000000;
        System.out.printf("a = %f\tb = %f\n", a, b);
        System.out.println("Does integrate(f,x) match the power rule? By the Fundamental Theorem,");
        System.out.println("\tf(x)=x^3 so F(x)[a,b]=(b^4/4)-(a^4/4): " + ((Math.pow(b, 4) / 4) - (Math.pow(a, 4) / 4)));
        System.out.println("f(x) = " + f(b - a));
        System.out.println("F(x) = " + integrate(Integrals::f, a, b, n));
    }
}
/* Displays the following:
   a = 1.000000    b = 5.000000
   Does integrate(f,x) match the power rule? By the Fundamental Theorem,
           f(x)=x^3 so F(x)[a,b]=(b^4/4)-(a^4/4): 156.0
   f(x) = 64.0
   F(x) = 156.0000000000034
*/
```

Note that you could modify the Riemann estimation to use different approximation rules by simply changing the line inside the *for* loop and modifying $n$:
* **Left Hand Rule**: `sum += f(a + i * deltaX) * deltaX;`
* **Right Hand Rule**: `sum += f(a + (i+1) * deltaX) * deltaX;`
* **Midpoint Rule**: `sum += f(((a + i * deltaX) + (a + (i + 1) * deltaX)) / 2) * deltaX;`



### Anonymous Functions and Lambda Expressions
An **Anonymous Function** is simply a function without a name. It is defined and used in a single statement, typically as an argument to a method or constructor. These are also known as **Lambda Expressions**, coming from their origin of [*Lambda Calculus*](https://en.wikipedia.org/wiki/Lambda_calculus)[^3].

Consider the following anonymous function that defines a function to add two integers and returns the result:
```java
((int x, int y) -> x + y);
```
This function takes two integer arguments `x` and `y` and returns their sum.

We can also use this with the `Collections.sort()` method to define a custom sorting behavior for a list or array, such as in descending order:
```java
List<String> words = Arrays.asList("apple", "banana", "cherry");
Collections.sort(words, (a, b) -> b.compareTo(a));
System.out.println(words); // prints "[cherry, banana, apple]"
```
Here, the anonymous function takes two strings `a` and `b` and compares them using the `compareTo()` method. The `Collections.sort()` method thus sorts the list of strings in descending order by passing the lambda expression as the comparator.

Anonymous functions can be used in any context where a **Functional Interface** is expected, which is an interface with a single abstract method. For example, the `Comparator` interface is a functional interface because it has a single abstract method `int compare(T o1, T o2)`.

Here are a few additional examples:
1. Defining a function to add two integers and return the result:
```java
((int x, int y) -> x + y);
```
2. Defining a function to check if a string is empty:
```java
(String s) -> s.isEmpty();
```
3. Defining a function to compare two strings based on their length:
```java
(String s1, String s2) -> s1.length() - s2.length();
```
4. Defining a function to print a message:
```java
() -> System.out.println("Hello, world!");
```
5. Defining a function to convert a string to uppercase:
```java
(String s) -> s.toUpperCase();
```

These lambda expressions can be passed as arguments to methods or used to define functional interfaces. For example, the following code uses a lambda expression to define a **Runnable** object, which is a functional interface with a single abstract method `void run()`:
```java
Runnable r = () -> System.out.println("Running!");
```



### Map, Reduce, and Filter
In functional programming, **Map**, **Reduce**, and **Filter** are ***Higher-Order Functions*** (functions that take another function as an argument) that allow you to apply a function to a collection of elements and produce a new collection as a result. These three functions are the pillars of FP — their proper usage enables very powerful, concise code, especially when applied to large collections of data.
* Map applies a function to each element in a collection and returns a new collection with the results (coming from the [*map* operation](https://en.wikipedia.org/wiki/Map_(mathematics))[^4] in Discrete Math denoted by the $\mapsto$ operator). For example, given a list of numbers, you can use `map` to apply a function that increases each number by 1:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
List<Integer> incremented = numbers.stream()
                                   .map(x -> x + 1)
                                   .collect(Collectors.toList());
// incremented = [2, 3, 4, 5]
```
* Reduce combines all the elements in a collection into a single value by applying a function to the elements in a specific order. For example, given a list of numbers, you can use `reduce` to sum them up:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
int sum = numbers.stream().reduce(0, (x, y) -> x + y);
// sum = 10
```
* Filter returns a new collection that includes only the elements that meet a certain condition. For example, given a list of numbers, you can use `filter` to select only the even numbers:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
List<Integer> evens = numbers.stream()
                             .filter(x -> x % 2 == 0)
                             .collect(Collectors.toList());
// evens = [2, 4]
```

These functions can even be composed together to perform more complex operations on collections. You can use `filter` to select a subset of a collection, then `map` to transform the elements in that subset, and finally `reduce` to combine the transformed elements into a single value.



## Miscellaneous
If you want to go even further into computer science, I have additional lesson plans on [my website](http://danielszelogowski.com/education.php)[^5], including:
* **AI and Machine Learning for AP:** http://danielszelogowski.com/resources/apcsamachinelearning/
* **Python Crash Course for AP:** http://danielszelogowski.com/resources/PythonCrashCourseForAP.html
* **Taking Programming Language Notes using Jupyter Notebooks:** http://danielszelogowski.com/resources/JupyterLanguageNotebooks.pdf




[^1]: https://tutorial.math.lamar.edu/classes/calci/defnofderivative.aspx
[^2]: https://www.sfu.ca/math-coursenotes/Math%20158%20Course%20Notes/sec_riemann.html
[^3]: https://en.wikipedia.org/wiki/Lambda_calculus
[^4]: https://en.wikipedia.org/wiki/Map_(mathematics)
[^5]: http://danielszelogowski.com/education.php
