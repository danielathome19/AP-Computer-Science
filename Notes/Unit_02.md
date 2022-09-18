# Unit 2 - Using Objects
UNDER CONSTRUCTION

## Objects


### Instantiation


## Calling Void Methods
A **void** method is simply a function that does not return anything (contrary to something like a 
mathematical function, which would return the result of its computation).
Perhaps the [most common example](https://docs.oracle.com/javase/7/docs/api/java/io/PrintStream.html#println()) 
is the `System.out.println(...)` method, which prints to the console but does not return a value that 
needs to be stored in a variable or used in a calculation, like `Math.sin(x)`.

To actually call a void method, we simply type out the method anywhere in the code that we want it to 
execute -- typically on its own separate line since it cannot be used in a calculation:
```java
public class Hello {
  public static void main(String[] args) {
    System.out.print("Hello, ");
    System.out.print("world!")
    System.out.println();
  }
}
```

### Calling Methods Without Arguments
Note that some methods may not require any arguments; that is, in the above example, we called
`System.out.println()` by itself without passing in a String or value. In this case, based on 
the documentation, we can infer that this will print an empty string followed by a line-break (`"\n"`).
This is very common within classes, such as the calculation functions we will write in our own classes.
Another great example is `Math.random()`, which returns a random double within $\[0.0, 1.0\)$ but requires no arguments.

## String Methods


## Wrapper Classes
The **Integer** and **Double** classes are wrappers to wrap the primitive types **int** and **double** in objects. For example:
```java
// To create an instance of these classes, we can either provide a value or variable
Integer x = new Integer(5);
// Or...
int y = 150;
Integer z = new Integer(y);

// To unbox the object into its primitive form...
int a = z.intValue();

// Likewise, the same is true for the Double class
Double b = new Double(3.14);
double PI = b.doubleValue();
```

While this is not particularly useful in general cases, the most important concepts to know between these two classes are the following numeric constants they provide:
* `Integer.MAX_VALUE`: returns the maximum possible value that can be stored in an **int** or **Integer**
* `Integer.MIN_VALUE`: returns the minimum possible value that can be stored in an **int** or **Integer**
* `Double.MAX_VALUE`: returns the maximum possible value that can be stored in an **double** or **Double**
* `Double.MIN_VALUE`: returns the minimum possible value that can be stored in an **double** or **Double**
* `Double.NaN`: returns a constant holding a Not-a-Number (NaN) value of type double
* `Double.POSITIVE_INFINITY`: returns a constant holding the negative infinity of type double
* `Double.NEGATIVE_INFINITY`: returns a constant holding the negative infinity of type double

You can also find the size (in bytes) of either data type using `Integer.SIZE` and `Double.SIZE`.

## The *Math* Class
The **Math** class provides constant definitions for $\pi$ (Math.PI) and $e$ (Math.E) a great number of methods,
as seen in the [documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html). A few important ones include:
* `Math.abs(a)`: returns the absolute value of some variable `a`
* `Math.ceil(a)`: rounds `a` ALWAYS UPWARD toward the closest integer ( ⌈ $a$ ⌉ )
* `Math.exp(a)`: returns $e^a$
* `Math.floor(a)`: rounds `a` ALWAYS DOWNWARD toward the closest integer ( ⌊ $a$ ⌋ )
* `Math.log(a)`: returns the natural logarithm of `a` (i.e., $\ln(a)$ or $\log_{e}(a)$ )
* `Math.log10(a)`: returns $\log_{10}(a)$
* `Math.max(a, b)`: returns the greater of two values
* `Math.min(a, b)`: returns the smaller of two values
* `Math.pow(a, b)`: returns $a^b$
* `Math.random()`: returns a random `double` in the range $\[0.0, 1.0\)$ -- i.e., $\ge 0$ but $< 1$
* `Math.round(a)`: rounds `a` by the standard elementary rounding definition: if a decimal is .5 or greater, round up (ceil);
  otherwise, round down (floor) -- ( ⌊ $a$ ⌉ )
* `Math.sqrt(a)`: returns $\sqrt{a}$

### Random Integer Generation
To get a random integer, we can use the following formula with `Math.random()`: `(int)(Math.random() * (max - min) + min);`

We could make this into a separate function, like:
```java
public int randInt(int min, int max) {
  return (int)(Math.random() * (max - min) + min);
}
```
Hence, to get a random number between 10 and 20, we could do `(int)(Math.random() * (20 - 10) + 10);`. If you want the max to be inclusive, you could change it to `(int)(Math.random() * (max - min + 1) + min);`.

### Float Rounding
Unfortunately, to properly round a number to $n$ decimal places for printing is to use String formatting, i.e.,
using `System.out.printf("%.nf\n", val);` to round `val` to $n$ decimals. You can also use the
`String.format(str, value);` function in a similar manner:
```java
// Either...
double x = 32.33434;
String sf = String.format("value is %.2f", x);
System.out.println(sf);

// Or...
System.out.println("X rounded to two decimals: " + String.format("%.2f", x) + " is a simple example.");
```

If you want to *clamp* your decimal to a number of decimals in the actual variable itself, one way that works for
a large majority of cases is to do `double xroundedtotwodecimals = Math.round(x * 100.0) / 100.0;`, where the number of 0's
corresponds to the number of decimal places (i.e., 1000 is 3 decimal places, 10 is 1 decimal place, etc.) -- however, note that
there are equally many edge-cases that this will fail due to the *roundoff error*.
