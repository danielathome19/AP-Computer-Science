# Unit 10 - Recursion
The concept of **Recursion** can be seen in countless real-life examples; simply put, it is a function that calls itself. Many everyday concepts are *recursive* -- think of Russian nesting dolls (a doll inside a doll inside a doll...), Ouroboros (the serpent eating its own tail), sourdough starter (which can be kept forever so long as you continue to add more over time), two mirrors facing each other, and in particular, **fractals**. For one of the most famous examples (often a programming interview question), check out the [**Tower of Hanoi**](https://www.digitalocean.com/community/tutorials/tower-of-hanoi) problem.

<p align="center">
  <img src="https://imgs.xkcd.com/comics/self_description.png"><br/>
  <i>From <a href="https://xkcd.com/688/">xkcd #688</a></i>
</p>

Consider the simplest example, a basic summation:
```java
public static int sum(int x) {
  int total = 0;
  for (int i = 1; i <= x; i++)
    total += i;
  return total;
}
```

In mathematics (especially Calculus and **Discrete Mathematics**), a **Summation** is represented by the *Sigma* (or $\Sigma$ ) operator, which adds all the numbers in a series together:

$$
\text{total} = \sum^x_{i=1} i
$$

This is our standard **Iterative** approach. To make it recursive, we first need to imagine running the summation backward, from the number down to 1 instead of the opposite:
```java
public static int sumBackward(int x) {
  int total = 0;
  for (int i = x; i > 0; i--)
    total += i;
  return total;
}
```
Given this code, it is clear that our ending condition occurs when `x == 0`; this is known as the **Base Case**. All of our iterations will become our **Recursive Case** (the point that the method calls itself), like so:
```java
public static int sumRecursive(int x) {
  if (x == 0) return 0;           // Base case
  return x + sumRecursive(x-1);   // Recursive case
}
```
As you can see, our `sumRecursive` method follows the same principle as `sumBackward`: make sure we haven't reached 0, otherwise, add `x-1`` to `x`. Hence, $\text{sumRecursive}(5) = 5 + 4 + 3 + 2 + 1 \to 15$.


## Practical Uses of Recursion
Recursion is still (typically) iterative, but there are many approaches to recursion that can drastically increase the speed of an algorithm by breaking it down into smaller sub-problems and solving those problems through sub-problems and combining their solutions -- a concept known as the [**Divide-and-Conquer Method**](https://www.programiz.com/dsa/divide-and-conquer), which is extended to even more practical concepts such as [**Dynamic Programming**](https://www.programiz.com/dsa/dynamic-programming) and the [**Greedy Approach**](https://www.programiz.com/dsa/greedy-algorithm). As well, computer scientists study *(Abstract) Data Structures* that are built from recursions, such as the **Linked List** or **Binary Search Tree**, or their core methods rely on recursions such as **Graphs** and their graph search algorithms. These concepts are beyond the scope of this course but are extremely practical with real-world programs and massive datasets.

One great example of recursion is the **factorial** operator ( $n!$ in mathematics), which returns $n! = n * (n-1) * (n-2) * (n-3) * \dots * (n-(n-1))$. For example, $5! = 5 * 4 * 3 * 2 * 1 \to 120$. Let's look at the code for this, both iteratively and recursively:
```java
// Iterative
public static int fact(int n) {
  int product = 1;
  for (int i = 1; i <= n; i++)
    product *= i;
  return product;
}

// Recursive
public static int factRec(int n) {
  if (n == 1) return 1;
  return n * factRec(n-1);
}
```

Like summation, we have an operator for a series of multiplicands as well -- the *Uppercase Pi* (or $\Pi$ for __Product__) operator, which multiplies all the numbers in a series together:

$$
\text{product} = \prod^n_{i=1} i
$$

Another extremely popular example of recursion is the **Fibonacci Sequence** -- a sequence of numbers that form the [*Fibonacci spiral* and the *Golden Ratio*](https://en.wikipedia.org/wiki/Fibonacci_number).

The Fibonacci numbers $F_n$ are defined by the following recurrence relation (the $\forall$ symbol means *"for all"*; the opposite is $\exists$ meaning *"there exists*"):

$$ F_0 = 0, \quad F_1 = 1, \quad \text{and} \quad F_n = F_{n-1} + F_{n-2} \quad \forall n > 1 $$

For example, the first 10 Fibonacci numbers:
| $F_0$ | $F_1$ | $F_2$ | $F_3$ | $F_4$ | $F_5$ | $F_6$ | $F_7$ | $F_8$ | $F_9$ |
|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|
| 0     | 1     | 1     | 2     | 3     | 5     | 8     | 13    | 21    | 34    |

We can easily implement this using recursion as follows:
```java
public static int fib(int n) {
    if (n <= 1) return n;
    return fib(n-1) + fib(n-2);
}
```
This series can also be represented as a fraction (much like most sums of a series), the *Golden Ratio*, which is famously represented symbolically by the letter $\phi$:

$$
  \phi = \frac{1 + \sqrt{5}}{2}
$$

If you find the mathematical notation interesting, we could have also written the factorial function as being the product of the set of all numbers from [1, n] using [**Set Notation**](https://www.mathsisfun.com/sets/symbols.html):

$$
\begin{align}
\text{let } \mathbb{Z}^+_n = \\{ 1, 2, 3, \dots, n \\} \\
n! = \prod^n_{i=1} x_i \quad \forall x \in \mathbb{Z}^+_n
\end{align}
$$

Written out, this says that [the set of positive integers](https://en.wikipedia.org/wiki/Integer) (known as $\mathbb{Z^+}$ ) subscript $n$ equals the set of positive numbers from 1 to $n$. Hence, $n!$ is equal to the product $\Pi$ of each number in the set multiplied together, where $x_i$ is the value $x$ at index $i$ in the set (think of $\Pi$ as a **for-each loop** basically). Also, check out [**Ring Theory**](https://en.wikipedia.org/wiki/Ring_theory)!


### Recursive Searching and Improved Binary Search
Using recursion, we can apply the *divide-and-conquer* approach to improve upon search algorithms like **Binary Search** (along with search algorithms for abstract data structures like *Graphs*).

For example, we can restructure Binary Search to use recursion:
```java
public static int binarySearchRec(int[] array, int x, int low, int high) {
    if (low > high) return -1;
    int mid = (low + high) / 2;
    if (array[mid] == x) return mid;
    if (array[mid] > x) return binarySearchRec(array, x, low, mid - 1);
    return binarySearchRec(array, x, mid + 1, high);
}

// Call with binarySearchRec(array, num, 0, array.length)
// or make a helper method that does this for you
```

Though they use two different approaches to the same implementation, both *iterative* and *recursive* Binary Search methods share the same **Time Complexity** ( $O(\log n)$ to be precise), so there is not much of a difference in performance. However, the recursive call could also be combined with some **Parallel Processing** method such as [*Multithreading*](https://www.geeksforgeeks.org/multithreading-in-java/) or [*Parallelization*](https://livebook.manning.com/book/java-8-in-action/chapter-7/79) to allow each recursive call to be performed **concurrently**, rather than **iteratively** -- although linear search could also be parallelized, removing the need for the array to be pre-sorted.



### Recursive Sorting and Divide-and-Conquer Algorithms
While not necessary for the AP exam, the [**Quick Sort**](https://www.programiz.com/dsa/quick-sort) and [**Merge Sort**](https://www.programiz.com/dsa/merge-sort) algorithms are extremely important real-world sorting algorithms. There are also sorting algorithms that do not require numeric comparisons, such as [**Counting Sort**](https://www.programiz.com/dsa/counting-sort) and [**Radix Sort**](https://www.programiz.com/dsa/radix-sort).


#### Quicksort
Quicksort is a popular, very efficient sorting algorithm that operates by dividing a list of items into two smaller sub-lists, sorting those sub-lists, and then merging the sorted sub-lists back together to form a final, sorted list. The key to quicksort is the way it divides the list into sub-lists -- a process known as partitioning. This approach to sorting through solving smaller sub-problems is known as the ***divide-and-conquer*** method. Its efficiency makes it extremely *quick* even for large datasets, making it very applicable to real-world data.

The steps are as follows:
1. Choose an element from the list, known as the pivot. This element will be used to divide the list into sub-lists
2. Divide the list into two sub-lists: one that contains all of the elements that are less than or equal to the pivot, and one that contains all of the elements that are greater than the pivot. These sub-lists are known as the left and right partitions, respectively
3. Sort the left and right partitions by recursively applying the quicksort algorithm to each of them. This means that we will repeat steps 1-3 on each of the sub-lists until they are each sorted
4. Once the left and right partitions are sorted, merge them together to form a final, sorted list. To do this, we simply combine the left partition, the pivot, and the right partition in that order
5. The final, sorted list is returned


Quicksort is broken down into two methods, one for finding a partition and the other for performing the sort:
```java
private static int partition(int arr[], int low, int high) { 
  int pivot = arr[high];
  int i = low - 1;
  for (int j = low; j < high; j++) {
    if (arr[j] <= pivot) {
      i++;
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }
  int temp = arr[i + 1];
  arr[i + 1] = arr[high];
  arr[high] = temp;
  return i + 1;
}

public static void quickSort(int array[], int low, int high) {
  if (low < high) {
    int pivot = partition(array, low, high);
    quickSort(array, low, pivot - 1);
    quickSort(array, pivot + 1, high);
  }
}

// Call using quickSort(array, 0, array.length)
// or make a helper method that does this for you and 
// rename the above function to "quickSortRecursive" and 
// modify its recursive call
```


#### Merge Sort
Merge sort is another popular and very efficient sorting algorithm that works by dividing a list of items into two smaller sub-lists, sorting those sub-lists, and then *merging* the sorted sub-lists back together to form a final, sorted list. This process of dividing and merging is repeated until the entire list is sorted, making this another ***divide-and-conquer*** algorithm.

The steps are as follows:
1. Divide the list of items into two smaller sub-lists. This is typically done by splitting the list in half, although other methods of dividing the list are also possible
2. Sort each of the two sub-lists by recursively applying the merge sort algorithm to each of them. This means that we will repeat steps 1 and 2 on each of the sub-lists until they are each sorted
3. Once the two sub-lists are sorted, we can merge them together to form a final, sorted list. This is done by comparing the first element of each sub-list and choosing the smaller of the two as the first element of the final list. We then repeat this process, comparing the second element of each sub-list, until all of the elements from both sub-lists have been added to the final list
4. The final, sorted list is returned

Merge Sort is also broken down into two methods, one for merging two subarrays and the other for performing the sort:
```java
private static void merge(int arr[], int p, int q, int r) {
  int n1 = q - p + 1;
  int n2 = r - q;
  int L[] = new int[n1];
  int M[] = new int[n2];

  for (int i = 0; i < n1; i++)
    L[i] = arr[p + i];
  for (int j = 0; j < n2; j++)
    M[j] = arr[q + 1 + j];

  int i, j, k;
  i = 0;
  j = 0;
  k = p;

  while (i < n1 && j < n2) {
    if (L[i] <= M[j]) {
      arr[k] = L[i];
      i++;
    } else {
      arr[k] = M[j];
      j++;
    }
    k++;
  }

  while (i < n1) {
    arr[k] = L[i];
    i++;
    k++;
  }

  while (j < n2) {
    arr[k] = M[j];
    j++;
    k++;
  }
}

public static void mergeSort(int array[], int l, int r) {
  if (l < r) {
    int m = (l + r) / 2;
    mergeSort(array, l, m);
    mergeSort(array, m + 1, r);
    merge(array, l, m, r);
  }
}

// Call using mergeSort(array, 0, array.length)
// or make a helper method that does this for you and 
// rename the above function to "mergeSortRecursive" and 
// modify its recursive call
```
