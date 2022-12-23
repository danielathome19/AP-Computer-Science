# Unit 3 - Boolean Expressions and *if* Statements
Conditional statements, commonly referred to as *if* statements, are snippets of code that allow us to do simple decision-making. 
We can use them to run a particular block of code *if* the given condition is **true**, and either do nothing or do something *else* 
if the original condition is **false**.

For example, consider the following *pseudocode*:
```java
gasPrice = 3.75
if (gasPrice > 2.50)
  println("These gas prices are way too high!")
else
  println("Gas is pretty cheap for once")
```

## Boolean Expressions and Conditions
Recall that the **boolean** data type specifically stores ONLY the values `true` or `false`. Knowing this, we can do simple 
conditional expressions, or *boolean statements*, and store the result inside of a variable (or use them directly inside an *if* statement):
```java
int x = 17;
boolean isEven = x % 2 == 0;
System.out.println(isEven);  // Prints "false"

// or...
boolean isLt20 = x < 20;
System.out.println(isLt20);  // Prints "true"
```

### Conditional Operators
Java supports the following conditional/relational operators (use ONLY for primitive types, otherwise these will compare the memory address of an object):
* `==`: exactly equal to 
* `!=`: not exactly equal to
* `>`: greater than
* `<`: less than
* `>=`: greater than or equal to
* `<=`: less than or equal to

Note the important distinction between `==` being our **equality** operator, versus `=`, our **assignment** operator.

## Conditional (*if*) Statements
The *if* statement is the simplest form of conditional statement. It's usage is the same as written language — *if* a condition is **true**, then we'll run the code inside its curly braces. Otherwise, we'll do something else or nothing at all.

For example:
```java
int x = 5;
int y = 5;

if (x == y) {
  // The code between these curly braces
  // will only run if x is exactly equal to y
  System.out.println("x and y are equal!");
}

// If x and y were not equal, nothing would be printed.
```

### *if-else* Statements
By attaching an *else* block/statement to the end of an *if* statement, we can create blocks of code for both possible conditions: **if** the condition is true, **otherwise**, do something **else**. Note that __we can only have exactly ONE *if* and ONE *else* statement per condition__.

For example:
```java
if (x > y) {
  // The code between these curly braces 
  // will only run if x is greater than y
} else {  // Otherwise...
  // The code between these curly braces 
  // will only run if x is less than or equal to y
}
```

### Using *else if* Statements
The *else if* statement allows us to add additional chains of conditions to our *if* statement — if the first *if* statement is false, we'll check the next *else if* statement to see if it's true. If it's still false, we'll either:
  * Check another *else if* condition,
  * Fallback to an *else* statement (if one is provided), or,
  * Do nothing at all (if there are no more *else if* or *else* statements.
  
For example:
```java
if (x > y) {
  // This code will only run if x is greater than y
} else if (x == 10) {
  // This code will run if x is equal to 10 and less than or equal to y
} else {
  // This code will run if x is less than or equal to y but not equal to 10
}
```

We can have as many `else if` conditions as we want, but only one `if` and (optionally) `else`:
```java
if (condition1) {
  // ...
} else if (condition2) {
  // ...
} else if (condition3) {
  // ...
} else if (condition4) {
  // ...
}
```

## Compound Conditions and Logical Operators
More often than not, one condition is not enough to validate if we should run some snippet of code — a realistic example would be logging in to a website: `if (username is correct AND password is correct) then log in`. We create these *compound conditional statements* using operators for **boolean operations** such as `AND`, `OR`, and `NOT`.

Java provides 3 logical operators for compound and negated conditions:
* `&&`: AND
* `||`: OR
* `!`: NOT

That is, we can combine multiple conditions in the same boolean statement, for example:
```java
int age = 18;
int time = 2000;

if (age == 18 && time >= 2000) {
  System.out.println("You're an adult and it's past 8 PM, "
        + "might as well go to sleep!");
}
```

Likewise, we can also check if a condition is NOT true (i.e., false):
```java
if (!allHomeworkCompleted()) {
  System.out.println("Not all of your homework is completed. Back to it!");
}
```

### Truth Tables
Truth tables are a method of breaking down compound conditions into each of their smaller parts to deduce their result based on all possible combinations of **true** and **false**. 
For example: the truth table for the statement ```if (A or B) and (!A and B)```

<table>
    <thead>
        <tr>
            <th>A</th>
            <th>B</th>
            <th>!A</th>
            <th>A or B</th>
            <th>(!A and B)</th>
            <th>(A or B) and (!A and B)</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>T</td>
            <td>T</td>
            <td>F</td>
            <td>T</td>
            <td>F</td>
            <td>F</td>
        </tr>
        <tr>
            <td>T</td>
            <td>F</td>
            <td>F</td>
            <td>T</td>
            <td>F</td>
            <td>F</td>
        </tr>
        <tr>
            <td>F</td>
            <td>T</td>
            <td>T</td>
            <td>T</td>
            <td>T</td>
            <td>T</td>
        </tr>
        <tr>
            <td>F</td>
            <td>F</td>
            <td>T</td>
            <td>F</td>
            <td>F</td>
            <td>F</td>
        </tr>
    </tbody>
</table>


### Equivalent Conditions
One thing we can do to make our code easier to read and organize is to optimize conditions to their reduced equivalent, often seen in the technique known as [**Guard Clauses**](https://www.youtube.com/shorts/Zmx0Ou5TNJs)[^1] (a technique often used to prevent/decrease nested *if* statements). By rewriting a condition as their opposite form, we can often drastically reduce code and/or increase readability (and possibly performance!).


For example:
* *Greater Than* `>` is the direct opposite of *Less Than or Equal to* `<=` (and vice versa), so `!(x > y)` is the same as `(x <= y)`.
* Not true `!true` is the same as `false`, and vice versa.

Also check out [De Morgan's Law](https://blog.penjee.com/what-is-demorgans-law-in-programming-answered-with-pics/)[^2] for one of the most important rules in *Discrete Mathematics* to get a better idea of how, when, and where this is applied!


## Comparing Objects
Perhaps the most important occurrence of object comparison in most Java programs is that of comparing **Strings**. Since a **String** is NOT a primitive type (i.e., it's a *class* that we instantiate as an ***object***), we have to use the `.equals(anotherStr)` to check if two strings contain the same exact text, case-sensitive. Using `==` on an ***object*** checks to see if two things share the exact same **memory address** in RAM.

For example:
```java
String str1 = "Hello!";
String str2 = "Hello";
if (str1.equals(str2)) {
  System.out.println("String 1 is the same as String 2");
} else {
  System.out.println("String 2 is different than String 1");
}

// Prints "String 2 is different than String 1"
```


[^1]: https://www.youtube.com/shorts/Zmx0Ou5TNJs
[^2]: https://blog.penjee.com/what-is-demorgans-law-in-programming-answered-with-pics/
