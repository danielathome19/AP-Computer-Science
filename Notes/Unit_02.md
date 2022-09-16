# Unit 2 - Using Objects
UNDER CONSTRUCTION



### The *Math* Class
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
* `Math.random()`: returns a random `double` in the range \[0.0, 1.0) -- i.e., $\ge 0$ but $< 1$
* `Math.round(a)`: rounds `a` by the standard elementary rounding definition: if a decimal is .5 or greater, round up (ceil);
  otherwise, round down (floor) -- ( ⌊ $a$ ⌉ )
* `Math.sqrt(a)`: returns $\sqrt{a}$

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
