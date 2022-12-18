# Unit Extras - Useful Non-AP Java Concepts for After the Exam
UNDER CONSTRUCTION


## Number Bases
...


### Binary Encoding
...


### Hexidecimal Encoding
...




## The *do-while* Loop
...



### The *break* and *continue* Keywords
...




## The *switch* Statement
...



## The *var* Type Keyword
...



## The Ternary Operator
...


## Enumerations
...



## Generic Typing
...



## Sockets
...




## Functional Programming
...



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
One of the most practical ways we can use function pointers is to make methods that take functions as arguments. For example, consider the [Definition of the **Derivative**](https://tutorial.math.lamar.edu/classes/calci/defnofderivative.aspx) from Calculus:

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


We can also apply this same concept to the [Definition of the **Definite Integral** as the Limit of a Riemann Sum](https://www.sfu.ca/math-coursenotes/Math%20158%20Course%20Notes/sec_riemann.html) (also known as the *Antiderivative*) using the *Midpoint Rule* and some arbitrarily large number of divisions $n = 10^{\varepsilon}$ to approximate:

$$F(x) = \int_{a}^{b} f(x)dx = \lim_{n \to \infty} \sum_{i=1}^{n} f(c_{i}) \Delta{x}$$

where

$$
\begin{align}
\Delta{x} = \frac{b-a}{n} \\
x_i \approx a + i * \Delta{x} \\
c_{i} = \frac{x_i + x_{i+1}}{2}
\end{align}
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
...




### Map, Reduce, and Filter
...
