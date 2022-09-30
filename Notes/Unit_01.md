# Unit 1 - Primitive Types
There are four primitive types that the AP subset focuses on:
* **int**: any whole number (Integer), positive or negative
* **double**: any Real number (with or without a decimal), positive or negative; short-hand for "double-precision floating-point number"
* **boolean**: either `true` or `false`
* **~~char~~** (**_WARNING_**: *NOT IN AP SUBSET*): a single (keyboard) character wrapped in apostraphes/single-quotes, including numbers, letters, special characters, 
and escape characters (like `'\n'` for a newline, `'\t'` for a tab space); not tested on the AP subset but can be extremely useful

While not a *primitive* type, the **String** *class* is extremely important -- i.e., a "string" of characters, wrapped in quotes,
such as `"Hello, world!"`.

Variables, equivalent to a mathematical variable, are defined in the sequence `<TYPE> <NAME> = <VALUE>;`, such as `int x = 5;`.

Variable names can start with letters or underscores ( _ ), either of which can appear anywhere in the variable name. 
However, numbers may only appear at the END.

Some valid variable names include `_test`, `Te_ST_` `test_123`, `test`, and `TEST`. Note, however, we typically use an 
underscore before a name for private variables (inside a *class*) and all-caps for constants.

As well, we can define a constant variable using the **final** keyword:
```java
final double E = 2.71828;

// Or...
final char ENDL = '\n';
```

One other trick we can do is declare multiple variables, with or without instantiating them (providing initial values):
```java
int x, y, z;
x = 2;
y = 4;
z = 6;

// Or...
final double fedinctax = .15, statetax = .035, socsectax = .0575;
```
However, be careful with this, because if you do this on the AP exam and forget to provide a value, you've 
just caused a **"Not Initialized" error** which will cost you points on the question(s).


## Basic Programs and Console Output
Every Java program must start with `public class FILENAME {...}`, where **FILENAME** is the exact name of the *.java* file, minus the file-extension (case-sensitive).
Recall that Java is a case-sensitive language, but not whitespace-sensitive, also.

Most of our programs will include a `main` function, with the signature `public static void main(String[] args) {...}` -- this is where Java
looks for what code we actually want to run. Hence, it's given the name "entry-point" by most compilers.

Each line of code must end in a semicolon (;) unless it ends in a curly-brace ({ or }).

For example, a file named *Hello.java* should look like the following:
```java
public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }
}
```

To print to the console, we either use `System.out.println("...");` to print some text with a newline/line-break, or
`System.out.print("...");` to print the text without the added line-break. 

To print a variable, we can either
print it by itself, such as `System.out.println(xyz);` or append it to the end of or between strings:
`System.out.println("num = " + num);` or `System.out.println("x = " + x + "\ty = " + y);`.

It's less common, but we can also use `System.out.printf("some formatting: %.3f\n", doubleval);` to 
print out variables with specific formats (see [Format Specifiers](https://www.geeksforgeeks.org/format-specifiers-in-java/)) 
-- note that this function also does not append a line-break unless you put "\n", or "\t" for a tab-space. 
Likewise, if you wanted to print a double or String, or a mix of all, you simply write out the string followed 
by a comma-separated list of the arguments you want displayed in order of the format specifier:
```java
int a = 50;
double b = 3.14159;
String c = "Hello!";
System.out.printf("%d   %.3f   %s\n", a, b, c);
// Prints out:
// 50   3.142   Hello!
```

A few of the most important format specifiers to remember are:
* `%d`: int
* `%f`: double (`%.#f` to round to # decimal places)
* `%c`: char
* `%s`: String

This technique of formatting a String (alongside the same with the String.format() function) is known as ***string interpolation*** -- we specify inside the string what type of variable we want in that spot in the text, and pass in the variable(s) as arguments in the order we want them to appear.

You can also use the `","` format specifier to separate a large number with commas every third digit from the right (like hand-written numbers):
```java
int x = 1000000;
System.out.printf("%,d\n", x);
// Prints out:
// 1,000,000
```

You can even [write out large numbers](https://docs.oracle.com/javase/7/docs/technotes/guides/language/underscores-literals.html) with the `_` separator:
```java
double salary = 1_234_567.890;
System.out.printf("%,.2f\n", salary);
// Prints out:
// 1,234,567.89
```

## Comments
There are two ways to leave a comment in Java (i.e., some text that only we can see; the compiler will 
delete it from the actual program) -- either a line-comment (by itself or appearing at the end 
of a line of code) or a block comment (spans multiple lines, or can appear within a line of code):
* `// This is a single-line comment`
* `int x = y;  // set x equal to y`
* `double z /* z will be a placeholder */ = 5;`

or:

```java
/* 
This
comment
spans across
multiple lines
*/

// For documentation, these also tend to look like:
/**
 * Sets the tool tip text.
 *
 * @param text  the text of the tool tip
 */
public void setToolTipText(String text) {
// You will see these a lot on AP exam questions
```

## User Input
User input is also not on the AP subset, but again, is extremely useful to know. The **Scanner** class provides a great number of
input functions which we will use for both user and file input. 

First of all, we need to import the class from the **java.util** library, either using `import java.util.*;` to pull the 
entire library, or `import java.util.Scanner;` -- either way, this should be your FIRST line of code in an input program.

For user-input, we make a new **Scanner** object and give it a *name*, like "input": `Scanner input = new Scanner(System.in);`

Now, we have four major methods that the class provides:
* `NAME.nextInt()`: get an `int` from the user/file 
* `NAME.nextDouble()`: get a `double` from the user/file
* `NAME.nextLine()`: read an entire line of text (include the line-feed) as a `String`
* `NAME.next()`: reads one word (token) at a time from a line of text separated by a space (see [Example 1](https://www.javatpoint.com/post/java-scanner-next-method))

For example, a file named *Prog52a.java*:
```java
import java.util.*;
// Full Name
// Lang52a
// MM/DD/YYYY

public class Prog52a {
  public static void main(String[] args) {
    // Input Section
    Scanner input = new Scanner(System.in);
    System.out.print("What is the length of the rectangle: ");
    int len = input.nextInt();
    System.out.println();  // Print a blank line
    
    System.out.print("What is the width of the rectangle: ");
    int wid = input.nextInt();
    System.out.println();
    
    // Calculation Section
    int area = len * wid;
    int perim = len + len + 2 * wid; // Numerous ways to calculate
    
    // Output Section
    System.out.println("The area of the rectangle is " + area);
    System.out.println("The perimeter of the rectangle is " + perim);
  }
}

/*
What is the length of the rectangle: 5
What is the width of the rectangle: 6

The area of the rectangle is 30
The perimeter of the rectangle 
*/
```
## Elementary Mathematics
Java supports numerous elementary math operations, as well as trigonometric and algebraic functions provided by the **Math** class.

### Arithmetic Operators
Java supports 5 different elementary arithmetic operations:
* `+`: plus
* `-`: minus
* `*`: times
* `/`: divide
* `%`: modulus (or MOD) -- returns the remainder from long (integer) division

Remember that the result of these operations returns the same **type** as the variables; an `int + int` operation will
return an `int`. To get a `double`, **one** or **both** values must be defined as or *casted* as a `double`:
```java
// Either...
int x = 17;
int y = 3;
double quotient = (double)x / y;
// Could also do:
// double quotient = (double)x / (double)y;

// Or...
double miles = 235;
double gallons = 14.3;
double mpg = miles / gallons;
```

### Assignment Operators
Java supports shorthand assignment operators for each of its arithmetic operations:
* `x = y`: set *variable* on left side equal to *value* (or variable) on the right side
* `x += y`: shorthand for `x = x + y`; add `y` to the current value of `x`
* `x -= y`: shorthand for `x = x - y`
* `x *= y`: shorthand for `x = x * y`
* `x /= y`: shorthand for `x = x / y`
* `x %= y`: shorthand for `x = x % y`
* `x++`: shorthand for `x = x + 1` or `x += 1`
* `x--`: shorthand for `x = x - 1` or `x -= 1`

