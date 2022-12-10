# Unit 7 - ArrayList
Also known as Dynamic Arrays (or erroneously, *vector* in C++), the **ArrayList** class provides us with a simplified *abstraction* of a normal array where the list has no specific capacity. The class  Instead, ArrayLists automatically resize *"under the hood"* whenever they reach capacity (usually by some rules such as doubling when the array is full or halving when the array is less than 25% full) by making a temporary array of the new capacity, copying all the items over from the class' private array, and reassigning the private array to the temporary one (though some implementations simply use a **Doubly-Linked List** structure). This also allows us to interface with the list much easier using a large number of provided methods from the ArrayList class, such as using `add(item)` and `get(index)` methods rather than the index operator `[]`, searching for items using `contains(item)` or `indexOf(item)`, deleting items and (automagically) shifting the rest of the items down one index using `remove(item)`, and many others.

Just like with the **Scanner** class, we need to first import the **ArrayList** class from the **java.util** library, either using the entire library with ``import java.util.*;`` or just the ArrayList class with ``import java.util.ArrayList;``.

The syntax for an ArrayList is as follows:
```java
// First, import from java.util;
import java.util.ArrayList;
// ...
ArrayList<DATATYPE> varname = new ArrayList<DATATYPE>();
```
Like arrays, ArrayLists can store any singular type of data or class. However, the one disadvantage with this class is that **to use an ArrayList with a primitive type, you __MUST__ use the wrapper class for that type**; i.e., **Integer** for `int`, **Double** for `double`, **Character** for `char`, etc. When we add and retrieve these primitive values back from the list, Java will automatically **autobox** and **unbox** the objects to their primitive form. For everything else, like **String**, the name of the class is sufficient.

Like a normal array, we can easily populate an ArrayList using a **for** loop and the `add()` method (however, we need to specify the end number of elements, since an ArrayList's size is unrelated to its current capacity):
```java
ArrayList<Integer> nums = new ArrayList<Integer>();
for (int i = 0; i < 100; i++) {
  nums.add(i);
}
```

ArrayLists provide us with [a great number of built-in methods](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) for working with lists of data, though we only really need to know the following:
* `x.size()`: return the number of values/objects stored in the list
* `x.add(obj)`: appends an object to the end of the list
* `x.get(index)`: return the item stored at the specified index.
* `x.set(index, obj)`: replace the item at the specified index with the provided object
* `x.remove(index)`: remove the item at the specified index and shift all proceeding elements down 1 position in the list

Other useful methods include `contains(object)`, `indexOf(object)`, `toArray()`, and `addAll()`.

**Take careful note that ArrayLists do not support the array `[]` operators -- you have to use `.get(index)` instead.**

The **ArrayList** class is a type of ***generic class*** (sometimes ***template class***, such as in C++), meaning it works with any possible type of data. Generic typing is not on the AP subset, but it is extremely useful and practical (see the [Java documentation on Generic Types](https://docs.oracle.com/javase/tutorial/java/generics/types.html)). For reference, the class signature might look something like `public class ArrayList<T> { ... }` and contain a private array of the generic type `T` like `private T[] myArray`.

## Traversing ArrayLists
At its simplest, traversing an ArrayList is no different than traversing a normal array. Either start a loop at some index and increment/decrement to some end index, then *get* the item at that index to use it, or simply use a **for-each** loop if the index does not matter.

For example, to retrieve items, we could use either a normal **for** loop with the `get()` method or a **for-each** loop:
```java
// Print out all the items in the "nums" ArrayList
for (int i = 0; i < nums.size(); i++)
  System.out.print(nums.get(i) + " ";
System.out.println();

for (int n : nums)
  System.out.print(n + " ");
System.out.println();
```

### ArrayList Algorithms
ArrayLists often utilize the same algorithms that we learn with *arrays* in Unit 6 -- statistical analysis (max, min, average, duplicates, etc.), linear/binary search, and all of the many sorting algorithms still apply. However, it is much less common to see examples of searching and sorting algorithms being applied to ArrayLists as opposed to arrays, since we often perform those algorithms on intentionally-capped lists of data and/or learn them using arrays that are entirely full of data. Regardless, if you can write an algorithm for an array, it is nearly identical for an ArrayList.
