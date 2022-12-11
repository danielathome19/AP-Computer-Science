# Unit 10 - Recursion
UNDER CONSTRUCTION

## Practical Uses of Recursion
...

### Recursive Searching and Improved Binary Search
...

### Recursive Sorting and Divide-and-Conquer Algorithms
While not necessary for the AP exam, the [**Quick Sort**](https://www.programiz.com/dsa/quick-sort) and [**Merge Sort**](https://www.programiz.com/dsa/merge-sort) algorithms are extremely important real-world sorting algorithms. There are also sorting algorithms that do not require numeric comparison, such as [**Counting Sort**](https://www.programiz.com/dsa/counting-sort) and [**Radix Sort**](https://www.programiz.com/dsa/radix-sort).


#### Quicksort
Quicksort is a popular, very efficient sorting algorithm that operates by dividing a list of items into two smaller sub-lists, sorting those sub-lists, and then merging the sorted sub-lists back together to form a final, sorted list. The key to quicksort is the way it divides the list into sub-lists -- a process known as partitioning. This approach to sorting through solving smaller sub-problems is known as the ***divide-and-conquer*** method. Its efficiency makes it extremely *quick* even for large datasets, making it very applicable to real-world data.

The steps are as follows:
1. Choose an element from the list, known as the pivot. This element will be used to divide the list into sub-lists
2. Divide the list into two sub-lists: one that contains all of the elements that are less than or equal to the pivot, and one that contains all of the elements that are greater than the pivot. These sub-lists are known as the left and right partitions, respectively
3. Sort the left and right partitions by recursively applying the quicksort algorithm to each of them. This means that we will repeat steps 1-3 on each of the sub-lists, until they are each sorted
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
private void merge(int arr[], int p, int q, int r) {
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

public void mergeSort(int array[], int l, int r) {
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
