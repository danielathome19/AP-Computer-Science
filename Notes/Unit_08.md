# Unit 8 - 2D Array
Often called a Matrix from its mathematical derivative, a **2D Array** is an array containing two **dimensions** or *features* of data (here, the term "dimension" is borrowed from dimensions in a *Hilbert Space* from Calculus, i.e., the "size" of a set of vectors, rather than a physical *Euclidian Space* dimension). In simpler terms, it is an array of arrays, which are typically all the same length. Here, we think of each array as being a **row** in the matrix, and each *feature* (position) refers to the **columns** in the matrix. Their mathematical equivalent, matrices, are denoted using italicized uppercase letters, such as $\textit{A}$.

$$
\begin{bmatrix}
1 & 2 & 3\\
a & b & c
\end{bmatrix}
$$

We can declare a 2D Array using the same syntax as a normal array (with `new` keyword), but by attaching an additional set of array braces `[size]`, like so:
```java
DATATYPE[][] multiDimArr = new DATATYPE[numRows][numCols];
// However, the number of columns is technically optional, 
// since we may have jagged arrays
```
Just like with any other data standard data structure, this works with any data type:
```java
// Create an matrix with 5 rows, 6 columns 
// i.e., 5 internal array of length 6
int[][] matrix = new int[5][6];
double[][] matrix2 = new double[5][6];
```

However, we can also use the *explicit* notation, either by building each row-array individually and making an array of row-arrays, or by defining the entire matrix together:
```java
// Matrix-style (very common)
int[][] mat1 = {
    {0, 1, 2},
    {3, 4, 5},
    {6, 7, 8}
};

// Array of arrays (more confusing to read)
int[] row1 = {0, 1, 2};
int[] row2 = {3, 4, 5};
int[] row3 = {6, 7, 8};
int[][] mat2 = {row1, row2, row3};
```

Then, we can access items based on their `[row][column]` index, much like a 1D array: `int rowOneColTwo = mat1[1][2];` Likewise, we can apply many of the same algorithms from 1D arrays to 2D arrays, but there are many mathematical operations specific to matrices that are also useful, such as computing things like the determinant, eigenvalues, eigenvectors, and many more (check out finite mathematics and linear algebra!).

## Multidimensional and Jagged Arrays
2D Arrays are often classified into two different categories:
* **Multidimensional Array (Matrix)**: an $n \times m$ matrix (i.e., $n$ rows and $m$ columns) where all rows have the exact same length; typically declared using the explicit matrix notation or `new DATATYPE[numRows][numCols]`
* **Jagged Array**: an array of arrays, where the inner-arrays may possibly vary in length; typically declared using the explicit jagged array notation or `new DATATYPE[numRows][]`

Let's compare the two:
```java
// Matrix Notation
int[][] mat1 = new int[2][3];
int[][] mat2 = {
    {0, 1, 2},
    {3, 4, 5}
};

// Jagged Array Notation
int[][] ja1 = new int[3][];
ja1[0] = new int[]{0, 1};
ja1[1] = new int[]{2, 3, 4};
ja1[2] = new int[]{5};

int[][] ja2 = {
    {0, 1},
    {2, 3, 4},
    {5}
};
```

### Nested Iteration for Matrix Traversal
To both populate and traverse matrices and jagged arrays, we must use a **_for loop inside_ another _for loop_** for simplicity. For a traditional matrix (multidimensional array) where the number of columns is the same for all rows, we can loop using `matrixName.length` for the rows and `matrixName[0].length` for the columns; otherwise, we might need to use our row counter to find the length of the current row (i.e., `multiDimArrName[row].length` if we have a jagged array. We typically loop through 2D arrays in a style known as ***Row-Major Order***, where we start at the first item of the first row, traverse to the end of the row, then start the next row at its first item (i.e., nest the *column* loop inside the *row* loop). If we nested our *row* loop inside the *column* loop instead, this would become ***Column-Major Order***.

For example:
```java
// Create and populate a matrix of ints
int[][] powers = new int[5][3];
for (int row = 0; row < powers.length; row++) {
    for (int col = 0; col < powers[0].length; col++) {
        powers[row][col] = (int)Math.pow(col + 1, row + 1);
    }
}

// Print out the matrix in Row-Major Order
for (int r = 0; r < powers.length; r++) {
    for (int c = 0; c < powers[0].length; c++) {
        System.out.print(powers[r][c] + " ");
    }
    System.out.println();
}

// Print out the matrix in Column-Major Order
for (int c = 0; c < powers[0].length; c++) {
    for (int r = 0; r < powers.length; r++) {
        System.out.print(powers[r][c] + " ");
    }
    System.out.println();
}
```

However, with a jagged array, we need to use `jaggedArr[row].length` when looping through the columns. Or, more commonly, we can use a **for-each** (or *Enhanced for*) loop to grab each inner-array and loop through each of its values:
```java
int[][] jagArr = {
    {0, 1, 2},
    {3, 4, 5, 6, 7},
    {8, 9},
    {10}
};

// Option 1: double-for
for (int r = 0; r < jagArr.length; r++) {
    for (int c = 0; c < jagArr[r].length; c++) {
        System.out.print(jagArr[r][c] + " ");
    }
    System.out.println();
}

// Option 2: double-for-each
for (int[] row : jagArr) {
    for (int x : row) {
        System.out.print(x + " ");
    }
    System.out.println();
}
```

## *n*D Arrays/Tensors (3D and Beyond)
Technically, we can extend the multidimensional array syntax to any number of dimensions, i.e., an *n*D array, often referred to as a **Tensor** (which can technically be any number of dimensions but is often used when $n > 2$). For data scientists and machine learning engineers, tensors are one of the most important data structures that exists -- especially because of its use in deep learning/neural networks. Simply add an additional set of `[]` to your array initialization, or painstakingly define a jagged array of arrays explicitly:
```java
DATATYPE[][][] tensor = new DATATYPE[numRows][numCols][numLayers];

// Or...
int[][][] jaggedTensor = {
    {
        {0, 1},
        {2, 3, 4},
        {5}
    },
    {
        {6, 7},
        {8}
    },
    {
        {9, 10} 
    }
};

// Or, a 5D Array
DATATYPE[][][][][] hugeTensor = new DATATYPE[x][y][z][w][alpha];
```

Likewise, to traverse a tensor (and/or populate it), add on an additional loop for every dimension:
```java
// Create a random 5x5x5 tensor
int[][][] tens = new int[5][5][5];
for (int x = 0; x < tens.length; x++) {
    for (int y = 0; y < tens[x].length; y++) {
        for (int z = 0; z < tens[x][y].length; z++) {
            tens[x][y][z] = (int)(Math.random() * 9 + 1);
        }
    }
}

// Option 1: triple-for
for (int x = 0; x < tens.length; x++) {
    for (int y = 0; y < tens[x].length; y++) {
        for (int z = 0; z < tens[x][y].length; z++) {
            System.out.print(tens[x][y][z] + " ");
        }
        System.out.print("\t");
    }
    System.out.println();    
}

// Option 2: triple-for-each
for (int[][] mat : tens) {
    for (int[] vec : mat) {
        for (int scalar : vec) {
            System.out.print(scalar + " ");
        }
        System.out.print("\t");
    }
    System.out.println();
}
```

## Matrix Operations
Below is a library of matrix methods based on operations found in calculus and linear algebra, which are extremely useful for statistics, machine learning, and deep learning algorithms. Like with vector operations, while these are not on the AP exam , they can be very helpful for understanding the purpose of arrays in various contexts (i.e., physics, image processing, quantum computing, artificial intelligence, etc.) especially coming from a mathematical background.
```java
/* Matrix Library by Daniel Szelogowski, 2022 */
public class MatrixLib {
    
    public static double[][] add(double[][] a, double[][] b) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                c[i][j] = a[i][j] + b[i][j];
        return c;
    }

    public static double[][] sub(double[][] a, double[][] b) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                c[i][j] = a[i][j] - b[i][j];
        return c;
    }

    public static double[][] scalarMult(double[][] a, double b) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                c[i][j] = a[i][j] * b;
        return c;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[0].length; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }

    public static double[][] transpose(double[][] a) {
        double[][] c = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                c[j][i] = a[i][j];
        return c;
    }

    public static double[][] id(double[][] a) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if (i == j)
                    c[i][j] = 1;
                else
                    c[i][j] = 0;
        return c;
    }

    public static double determinant(double[][] a) {
        double det = 0;
        if (a.length == 1) return a[0][0];
        for (int i = 0; i < a.length; i++) {
            double[][] sub = new double[a.length - 1][a.length - 1];
            for (int j = 1; j < a.length; j++)
                for (int k = 0; k < a.length; k++)
                    if (k < i)
                        sub[j - 1][k] = a[j][k];
                    else if (k > i)
                        sub[j - 1][k - 1] = a[j][k];
            det += a[0][i] * Math.pow(-1, i) * determinant(sub);
        }
        return det;
    }

    public static double[][] inverse(double[][] a) {
        double[][] c = new double[a.length][a[0].length];
        double det = determinant(a);
        if (det == 0) return null;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) {
                double[][] sub = new double[a.length - 1][a.length - 1];
                for (int k = 0; k < a.length; k++)
                    for (int l = 0; l < a.length; l++)
                        if (k < i && l < j)
                            sub[k][l] = a[k][l];
                        else if (k < i && l > j)
                            sub[k][l - 1] = a[k][l];
                        else if (k > i && l < j)
                            sub[k - 1][l] = a[k][l];
                        else if (k > i && l > j)
                            sub[k - 1][l - 1] = a[k][l];
                c[i][j] = Math.pow(-1, i + j) * determinant(sub) / det;
            }
        return transpose(c);
    }

    public static double[][] convolve(double[][] a, double[][] b) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                for (int k = 0; k < b.length; k++)
                    for (int l = 0; l < b[0].length; l++)
                        if (i + k < a.length && j + l < a[0].length)
                            c[i + k][j + l] += a[i][j] * b[k][l];
        return c;
    }

    public static double[][] eigenvectors(double[][] a) {
        double[][] c = new double[a.length][a[0].length];
        double[][] id = id(a);
        double[][] sub = sub(a, id);
        double[][] inverse = inverse(sub);
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                c[i][j] = inverse[i][j] / inverse[i][j];
        return c;
    }

    public static double[] eigenvalues(double[][] a) {
        double[] c = new double[a.length];
        double[][] id = id(a);
        double[][] sub = sub(a, id);
        double[][] inverse = inverse(sub);
        for (int i = 0; i < a.length; i++)
            c[i] = 1 / inverse[i][i];
        return c;
    }
}
```
