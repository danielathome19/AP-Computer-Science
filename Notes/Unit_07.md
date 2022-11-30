# Unit 7 - ArrayList
Also known as Dynamic Arrays (or erroneously, *vector* in C++), the **ArrayList** class provides

The syntax for an ArrayList is as follows:
```java
ArrayList<DATATYPE> varname = new ArrayList<DATATYPE>();
```
Like arrays, ArrayLists can store any singular type of data or class. However, **to use an ArrayList with a primitive type, you __MUST__ use the wrapper class for that type**; i.e., **Integer** for `int`, **Double** for `double`, **Character** for `char`, etc. For everything else, like **String**, the name of the class is sufficient.

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

Take careful note that ArrayLists do not support the array `[]` operators -- you have to use `.get(index)` instead.

## Traversing ArrayLists
...

To retrieve items, we can use either a normal **for** loop with the `get()` method or a **for-each** loop:
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


### Searching ArrayLists


### Sorting ArrayLists
