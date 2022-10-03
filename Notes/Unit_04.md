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

### The *break* and *continue* Statements
...


It is important to note that unless we have a controller variable for a loop, we will likely need additional
conditions within the loop to ensure we have some way to exit the loop (i.e., to prevent an infinite loop).
Sometimes, especially for networking and video games, an infinite loop is in fact desired:
```java
while (true) {
  DrawVideoGameFrames();
  if (userWantsToExit) break;
}
```


### The *do-while* Loop
Not on AP subset, but...



## The *for* Loop

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
```
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



## Iterating Through Files
While not on the AP subset, this is an extremely useful (and real-world) skill that happens to be easier in Java than many other languages.



### Exception Handling

