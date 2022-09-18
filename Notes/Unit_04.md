# Unit 4 - Iteration
Loops are an extension of **if** statements, simply continuing to run the code within their scope 
(inside their curly braces `{}`) until the given condition becomes false. Noting this, we can use
the same [conditional and logic operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html) 
as our **if** statements; however, the conditions for a loop tend to be much simpler.


## The *while* Loop
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



Again, one must be careful (especially in hand-written code) with its use, but a one-line statement does not require curly braces:
```java
while (true) System.out.println("Infinite loop");
// Or...
for (int i = 0; i < 10; i++) System.out.println(i);

// Many people will also indent the inner-code, in a Pythonic-style
for (int i = 0; i < 10; i++)
  System.out.println(i * 2);
```

## Iterating Through Strings



## Iterating Through Files
While not on the AP subset, this is an extremely useful (and real-world) skill that happens to be easier in Java than many other languages.



### Exception Handling

