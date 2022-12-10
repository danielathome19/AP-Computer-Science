# Unit 8 - 2D Array
UNDER CONSTRUCTION

## Multidimensional Arrays


### 2D Arrays/Matrices


### Nested Iteration


## *n*D Arrays/Tensors (3D and Beyond)



## Matrix Operations
Below is a library of matrix methods based on operations found in calculus and linear algebra, which are extremely useful for statistics, machine learning, and deep learning algorithms.
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
