# Unit 6 - Array
Sometimes called a 1D Array or Vector, an **array** is simply a list of items (typically) of the same data type. Each item is assigned a unique **index**, or *slot*, acting as a sort-of "lookup table" for the items -- however, indices begin counting at 0 in Java, rather than 1 in other languages such as Lua, MATLAB, and R.

Arrays are essentially lists of **objects** -- they allow us to store multiple variables inside of one variable (i.e., an object that holds more objects). Hence, they can hold either primitive types/objects (`int`, `double`, `char`, etc.) or objects of classes (**String** and any other class we define).

## Array/Vector Creation and Access
To declare an array, we use the `new` keyword just as if we were declaring a new Class object (like **Scanner**) along with the array *"bracket operator"* `[]`. However, we must also have a capacity in mind -- regardless of if all slots are full, we need to specify a minimum size, which **CANNOT be modified** later. This is similar to a bookshelf or a permit-only parking lot: the parking lot has 100 spots, each numbered uniquely from 0 to 99; spots may not always be full, but we cannot add or remove spots without rebuilding the lot (theoretically). **Whenever a spot in the parking lot is empty, it has the value `null` meaning *nothing***, which we will look at a solution for below.

The following syntax is used to declare an array:
```java
DATATYPE[] arrname = new DATATYPE[arrLength];
```

We can also declare them **explicitly** using `{}`'s:
```java
DATATYPE[] arrname2 = { var1, var2, var3, var4, var5 };
```
Creating an array with the explicit notation is a bit unusual unless the array is intended to be very short, as Java will make the capacity of the array the same as the number of items you provide.

Typically, we use a **for** loop to initialize an empty array. For example, an array of `int`:
```java
int[] nums = new int[10];
for (int i = 0; i < nums.length; i++) {
  nums[i] = i;
}
```
Note the usage of `.length` to find the size of the array, and the `[index]` operator to assign and retrieve data from an array. 

There are numerous ways to approaching looping through arrays, either to **populate** or "fill" the list, or to print one or multiple arrays (of the **same size**) at once. For example:
```java
// Make two arrays that store all numbers [1-5]
int[] list1 = {1, 2, 3, 4, 5};
// or...
int[] list2 = new int[5];
for (int lcv = 1; lcv <= 5; lcv++) 
  list2[lcv - 1] = lcv;

// Print the arrays
for (int i = 0; i < 5; i++)
  System.out.printf("list1[%d] = %d,\tlist2[%d] = %d\n", i, list1[i], i, list2[i]);
```

## Array Traversal
The term ***traversal*** refers to the act of *iterating* through an array -- that is, checking multiple spots in an array using a loop, typically. This can of course be done with the `.length` property, or using a variable that is keeping track of the current size of the array (so as to not go into the "empty"/*null* slots), but Java also provides us with a simpler syntax.

### The *for-each* Loop (Enhanced For)
The **Enhanced For** loop, or **for-each** loop, is a simpler syntax for a **for** loop that iterates through an entire array without the need for an index. Instead, it gives us direct access to each object in the array sequentially.

A **for-each** loop uses the following syntax:
```java
for (DATATYPE tempvarname : myarray) {
  // ...
}
```

The `:` operator equates to the word ***in*** (i.e., `for 'each' (DATATYPE currentNum in DataTypeArray)`); if we wanted to loop through all ints in an integer array, for example:
```java
int[] mynums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
for (int temp : mynums) {
  System.out.println(temp);
}
```

Consider the following approach to printing out the "name" and "age" properties from some **Person** class for all objects inside an array of **Person objects**:
```java
Person[] people = new Person[50];
/* read in data file and populate array with 50 "Person" objects */

for (int slot = 0; slot < people.length; slot++) {
  Person currentperson = people[slot];
  System.out.println("Name: " + currentperson.getName());
  System.out.println("Age: " + currentperson.getAge());
}
```

In this case, we do not need the index beyond grabbing the current **Person** object that we want, so having the index variable is essentially useless.
Instead, we can reduce the first two lines of code in the **for** loop into the *signature* for a **for-each** loop:
```java
for (Person currentperson : people) {
  System.out.println("Name: " + currentperson.getName());
  System.out.println("Age: " + currentperson.getAge());
}
```

### Null-Safe Traversal
One issue we often encounter with arrays is that we may not always have all slots of an array filled, just like our parking lot example. When working with data files, we typically will keep a *counter* variable to track how many items are ACTUALLY in the array, rather than using the `length` property (which should really be called `capacity` instead). If we read in 50 objects from a data file, but out array has a capacity of 75, then the last 25 slots will all be `null`. If we try to call methods on these `null` objects, the program will crash -- this is a huge problem with us using a **for-each** loop instead of a normal **for** loop with our *counter* variable.

Consider a data file (named **mycars.dat**, for example) that looks similar to the following, containing the ID number, make, model, and year for 50 cars:
```
1   Pontiac   Trans Sport   1995
2   Chevrolet   Impala    2007
.
.
.
50    Buick   Rendesvous    2003
```

Now, we can make a simple car class to contain those four properties:
```java
public class Car {
  private int myID;
  private String myMake;
  private String myModel;
  private int myYear;
  
  public Car(int id, String make, String model, int year) {
    myID = id;
    myMake = make;
    myModel = model;
    myYear = year;
  }
  
  public int getID() { return myID; }
  public String getMake() { return myMake; }
  public String getModel() { return myModel; }
  public int getYear() { return myYear };
}
```

Once we have our **data class**, we can read in all of the files from the data file. However, in case the size of the data file changes, we need to provide a buffer space (i.e., extra slots in the array) instead of counting the number of cars by hand and updating our code every time it changes -- good luck trying that with a database! Lets make an array of **Car** objects that can hold up to 100 cars, similar to our parking lot example above:
```java
Scanner input = new Scanner(new File("mycars.dat"));
Car[] parkinglot = new Car[100];
int numcars = 0;

while (input.hasNext()) {
  // Read in the information on each car
  int id = input.nextInt();
  String make = input.next();
  String model = input.next();
  int year = input.nextInt();
  
  // Make a new "Car object" using the information of the current car we just read in
  Car parkedcar = new Car(id, make, model, year);
  
  // Increment the number of parked cars in the parking lot;
  numcars++;
}
```

Now, we have two options for safely printing out the information on every car without overflowing into our *buffer* space (the `null` slots): either use a **for** loop with our *counter* variable as the maxima, or use a **for-each** loop but check to make sure that the car is not equal to `null` before attempting to call methods on it:
```java
// Approach 1 (for loop)
for (int spot = 0; spot < numcars; spot++) {
  // Grab the car parked at the current spot so we do not 
  // have to write parkinglot[spot].getSomething() every time
  Car currentcar = parkinglot[spot];
  System.out.println("ID: " + currentcar.getID());
  System.out.println("Make: " + currentcar.getMake());
  System.out.println("Model: " + currentcar.getModel());
  System.out.println("Year: " + currentcar.getYear());
}


// Approach 2 (for-each loop with null-check)
for (Car currentcar : parkinglot) {
  if (currentcar != null) {
    System.out.println("ID: " + currentcar.getID());
    System.out.println("Make: " + currentcar.getMake());
    System.out.println("Model: " + currentcar.getModel());
    System.out.println("Year: " + currentcar.getYear());
  } 
  // else { currentcar is null, so don't print or call anything }
}
```

Typically, for regular arrays, it's safer to just use a *counter* variable so we know that we won't overflow into the empty slots. However, what if we intentionally set a slot in the middle of the array to `null` like `parkinglot[5] = null;` (i.e., a parked car leaves the lot at random)? Then we have to account for null-checking even inside of our regular **for** loop! So, there are many factors we can take into account, but unless we know that we will not be removing anything from the array, it's a bit more flexible to just use a normal **for** loop with a *counter* -- then we also have the index on hand in case we need to modify our code to use it at some point later on.





## Array Algorithms
To be discussed AFTER the AP curriculum... technically part of the normal AP units though

### Array Searching Algorithms

#### Linear Search



#### Binary Search




### Array Sorting Algorithms

While not discussed in this class, the **Quick Sort** and **Merge Sort** algorithms are extremely important real-world sorting algorithms.

#### Bubble Sort


#### Insertion Sort


#### Merge Sort
