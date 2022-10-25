# Unit 4 - Iteration
Loops are an extension of **if** statements, simply continuing to run the code within their scope 
(inside their curly braces `{}`) until the given condition becomes false. Noting this, we can use
the same [conditional and logic operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html) 
as our **if** statements; however, the conditions for a loop tend to be much simpler.


## The *while* Loop
A **while** loop is the closest type of statement to **if** statements -- their job is use nearly the 
same notation as an **if** statement, but continue looping the contained code *while* the given condition
continues to be ***true***. It's more common to use these where a condition is not numeric (i.e., not 
looping through a list or using a counter of some sort), but instead where a condition is simply deterministic.
The most common use case for a **while** loop would be to loop while a **Scanner** has data left to scan (e.g., 
from a file or for networking) or while some state has not changed (e.g., while a client is connected to a server).

The syntax is very simple:
```java
int counter = 0;
while (counter < 10) {
  // Run some code repeatedly, 10 times in total
  counter++;
}
```


## The *for* Loop
A **for** loop is a shorthand, counter-based loop (i.e., rather than being iterating specifically on a condition only, we iterate based on some counter variable). It allows us to declare a counter, check the condition for the counter, and increment/decrement the counter all in one line of code (similar to the **while** loop example above). For example:
```java
for (int counter = 0; counter < 10; counter++) {
  // Run some code repeatedly, 10 times in total (same as the while loop example)
}
```

Again, one must be careful (especially in hand-written code) with its use, but a one-line statement does not require curly braces:
```java
while (true) System.out.println("Infinite loop");
// Or...
for (int i = 0; i < 10; i++) System.out.println(i);

// Many people will also indent the inner-code, in a Pythonic-style
for (int i = 0; i < 10; i++)
  System.out.println(i * 2);
```

If you need to iterate backwards, there are two ways that work well; for example, printing the numbers from 10 to 0 (inclusive). First, the standard approach:
```java
for (int i = 10; i >= 0; i--) {
  System.out.println(i);
}
```

Secondly, we can use the `--` operator in conjunction with the `>` operator to form a sort-of *step-down* **for** loop:
```java
for (int i = 11; i --> 0;) {
  System.out.println(i);
}
```

This form is much more useful for working with list-based data types such as **Strings** and **Arrays**:
```java
// print a String in reverse
String text = "Hello, World!";
for (int lcv = text.length(); lcv --> 0;) {
  System.out.println(text.substring(lcv, lcv+1));  
}
```

## Iterating Through Strings
Iterating through each individual character in a **String** can be done in multiple ways (such as the `str.charAt(index)` method, but this is not on the AP subset), though we will only focus on the use of substrings. To select one character at a time, we can use `str.substring(index, index + 1)` in a **for** loop -- remember that the `substring(start, end)` method does NOT include the *end* index in the slice of the String, so we can safely iterate from index 0 to the length of the String. For example:
```java
// Print each letter of the text "Hello, world!" on a separate line
String hello = "Hello, world!";
for (int lcv = 0; lcv < hello.length(); lcv++)
  System.out.println(hello.substring(lcv, lcv + 1));
```

## Iterating Through Files
While not on the AP subset, this is an extremely useful (and real-world) skill that happens to be easier in Java than many other languages. 
However, this also requrires that we understand basic exception handling, as working with files is a task prone to many errors.
The `Scanner` class graciously provides us the ability to work with both user input AND files, so long as we pass in a `File` object 
rather than `System.in`.

For example, consider a data file, named **mydatafile.txt** in a folder called **datafolder**, structured as multiple lines of 3 numbers (of varying types) separated by a space:
```
192 8 8125.00
203 8 3250.00
218 5 5000.00
235 5 5250.00
264 17 4150.00
```

Consider that each row in the data file contains 3 numbers: an **int**, an **int**, and a **double**. We can grab this data using a `Scanner` and a loop that scans `while (input.hasNext())` as follows:
```java
try {
    Scanner input = new Scanner(new File("datafolder/mydatafile.txt"));
    while (input.hasNext()) {
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        double num3 = input.nextDouble();
        // Do stuff with the data here
    }
} catch (IOException e) {
    System.out.println("Can't find data file!");
}
```


### Exception Handling
The concept of **Exception Handling** refers to the process of responding to some event in the code that may be unintentional/unexpected, etc. Put simply, it is a way of preventing a program from crashing when a specified error occurs, and instead allows us to decide what to do if an **Exception** is caught. This is done using a ***try-catch*** statement, where `try` will attempt to run a block of (possibly) erroneous code, and `catch (SomeException ex)` tells us what to do if *SomeException* occurs while running the code in the `try` block. For example, catching a division by 0 error using the generic `Exception` type exception:
```java
try {
  // Run some code that may or may not throw an error
  int x = 5;
  int y = 0;
  int z = x / y;
  System.out.println(z);
} catch (Exception e) {
  System.out.println("Error: " + e.toString());
}
```

We typically use this when working with files to prevent an exception when a file is missing:
```java
try {  // On Replit, may need to put "../data/prog285b.dat"
    Scanner input = new Scanner(new File("data/prog285b.dat"));
    
    while (input.hasNext()) {
      // ...
    }
} catch (IOException e) {
    System.out.println("Can't find data file!");
}
```
