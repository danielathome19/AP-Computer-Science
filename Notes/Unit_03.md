# Unit 3 - Boolean Expressions and *if* Statements
UNDER CONSTRUCTION

## Boolean Expressions and Conditions


### Conditional Operators
Java supports the following conditional/relational operators (use ONLY for primitive types, otherwise these will compare the memory address of an object):
* `==`: exactly equal to 
* `!=`: not exactly equal to
* `>`: greater than
* `<`: less than
* `>=`: greater than or equal to
* `<=`: less than or equal to


## Conditional (*if*) Statements
```java
int x = 5;
int y = 5;

if (x == y) {
  // The code between these curly braces will only run if x is exactly equal to y
  System.out.println("x and y are equal!");
}
```


### *if-else* Statements
```java
if (x > y) {
  // The code between these curly braces will only run if x is greater than y
} else {  // Otherwise...
  // The code between these curly braces will only run if x is less than or equal to y
}
```

### Using *else if* Statements
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
Java provides 3 logical operators for compound and negated conditions:
* `&&`: AND
* `||`: OR
* `!`: NOT

That is, we can combine multiple conditions in the same boolean statement, for example:
```java
int age = 18;
int time = 2000;

if (age == 18 && time >= 2000) {
  System.out.println("You're an adult and it's past 8 PM, might as well go to sleep!");
}
```

Likewise, we can also check if a condition is NOT true (i.e., false):
```java
if (!allHomeworkCompleted()) {
  System.out.println("Not all of your homework is completed. Back to it!");
}
```

### Equivalent Conditions


## Comparing Objects
Perhaps the most important occurrence of object comparison in most Java programs is that of comparing **Strings**.

...
```java
if (str1.equals(str2)) {
  System.out.println("String 1 is the same as String 2");
}
```
