# Unit 6 - Array
UNDER CONSTRUCTION

Sometimes called a 1D Array or Vector, an array is simply a list of items (typically) of the same data type. Each item is assigned a unique index, acting as a sort-of "lookup table" for the items -- however, indices begin counting at 0 in Java, rather than 1 in other languages such as Lua or R.


## Array/Vector Creation and Access
...
```java
// Make two arrays that store all numbers [1-5]
int[] list1 = {1, 2, 3, 4, 5};
// or...
int[] list2 = [6];
for (int lcv = 1; lcv <= 5; lcv++) 
  list2[lcv - 1] = lcv;

// Print the arrays
for (int i = 0; i < 5; i++)
  System.out.printf("list1[%d] = %d,\tlist2[%d] = %d\n", i, list1[i], i, list2[i]);
```

### Array Traversal


### The *for-each* Loop


## Array Algorithms
To be discussed AFTER the AP curriculum...

### Array Searching Algorithms

#### Linear Search



#### Binary Search




### Array Sorting Algorithms

While not discussed in this class, the **Quick Sort** and **Merge Sort** algorithms are extremely important real-world sorting algorithms.

#### Bubble Sort


#### Insertion Sort


#### Merge Sort
