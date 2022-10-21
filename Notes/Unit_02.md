# Unit 2 - Using Objects
Objects, by definition, are *instances* of **Classes**, many of which are built into the language which we frequently use (i.e., **Scanner**, **File**, **Exception**, etc.) given the convenience they provide. A ***Class***, put simply, is a collection of methods/functions and/or variables -- **Scanner** provides us with all of the methods necessary to work with user and file input. One of the most important concepts to remember is that *objects* cannot use the traditional `==` operator -- we need to use `obj1.equals(obj2)` instead; likewise, for printing we need to use `obj.toString()` or we need implement a `toString()` method for the Class ourselves. 

## Objects
All types in Java are extensions of the **Object** class (for all primitive types and classes). This means that anything can be converted to an object through casting (known as **Boxing**) and back (**Unboxing**):
```java
int x = 5;

// Box int as Object
Object y = x;

// Unbox Object as int
int z = (int)y;

System.out.println(z);
```

We can also **Autobox** primitive types to their *Wrapper Class* and unbox them:
```java
// Creating an Integer Object with value 10
Integer i = new Integer(10);

// Unboxing the Object
int i1 = i;

// Print statements
System.out.println("Value of i:" + i);
System.out.println("Value of i1: " + i1);

// Autoboxing of character
Character chr = 'a';

// Auto-unboxing of Character
char ch = chr;

System.out.println("Value of ch: " + ch);
System.out.println("Value of gfg: " + gfg);
```

### Instantiation
Creating a new ***instance*** of a class is done using the `new` keyword nearly the exact same way as instantiating any other variable 
(i.e., in the form `ClassName var1 = new ClassName(classArgsHere);`). 
For example, we can make an instance of the **Scanner** class like so:
```java
import java.util.Scanner;
// ...
Scanner input = new Scanner();
int x = input.nextInt();
```

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
The *String* class provides a [great number of methods](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html) for working with text data. It is worth noting that a String is simply a mask for an array of **chars**, which means we have the ability to work with either the whole text or loop through it one letter at a time. A few of the most important/useful string methods for the AP exam include:
* `x.length()`: returns the length of the string (i.e., the total number of characters)
* `x.isEmpty()`: returns **true** if the length of the String is 0 (i.e., the String is empty)
* `x.substring(end)` or `x.substring(start, end)`: returns a slice of a string either 
  from \[0, end\) (where *end* is excluded) or \[start, end\) if a *start* is specified
* `x.indexOf(string)`: returns the **first** index of *string* ~~or *char*~~ in the String, otherwise returns -1
* `x.lastIndexOf(string)`: returns the **last** index of *string* ~~or *char*~~ in the String, otherwise returns -1
* `x.trim()`: returns a copy of the String with leading and trailing whitespace omitted
* `x.split(delimiter)`: returns an array of Strings split by either some delimiter (e.g., `","`, `" "`, or ";") or [regular expression](https://cheatography.com/davechild/cheat-sheets/regular-expressions/); useful for splitting a sentence into an array of individual words, for example

* `x.toLowerCase()`: returns the String in all-lowercase form
* `x.toUpperCase()`: returns the String in all-uppercase form
* `x.contains(string)`: returns **true** iff (if and only if) the entirety of **string** is found in the String (case-sensitive)
* `x.compareTo(string)`: returns a [lexicographical comparison](https://www.w3schools.com/java/ref_string_compareto.asp) of the Strings -- i.e., returns 0 if the Strings are exactly equal (case-sensitive); otherwise, returns 1 or -1
* `x.equals(string)`: returns **true** iff the entirety of **string** equals the String (case-sensitive) 
* `x.equalsIgnoreCase(string)`: returns **true** iff the entirety of **string** equals the String (_NOT_ case-sensitive)
* ~~`x.charAt(index)`~~ (**_WARNING_**: *NOT IN AP SUBSET*): returns the char at position *index* (within \[0, `x.length()` - 1\])
* ~~`x.toCharArray()`~~ (**_WARNING_**: *NOT IN AP SUBSET*): returns the String as an array of **chars**

Other useful functions include `format(formatStr)`, `startsWith(string)`, and `endsWith(string)`, but these are not necessarily useful for the exam.

### Primitive Types as Strings

One other important note is that if we want to convert/return a primitive type (**int**, **double**, **char**, etc.) as a String, we cannot use the `.toString()` function. Instead, we can simply concatenate the variable to an empty string:
```java
int x = 5;
String ret = "" + x;
char y = 'c';
String ret2 = "" + y;
```

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

Though they aren't on the AP subset, these classes provide two very useful functions to parse numbers from strings:
* `Integer.parseInt(str)`: attempts to return an int from a given **String**
* `Double.parseDouble(str)`: attempts to return an double from a given **String**

You can also find the size (in bytes) of either data type using `Integer.SIZE` and `Double.SIZE`.

## The *Math* Class
The **Math** class provide
s constant definitions for $\pi$ (Math.PI) and $e$ (Math.E) a great number of methods,
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
