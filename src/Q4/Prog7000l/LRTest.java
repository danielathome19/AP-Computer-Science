package Q4.Prog7000l;

public class LRTest {
    public static void main(String[] args) {
        double[][] X_train = {
                {2.49, 1},
                {2.57, 1},
                {3.14, 1},
                {1.25, 1},
                {1.84, 1},
                {3.86, 1},
                {11.37, 1},
                {6.58, 1},
                {8.18, 1},
        };
        double[] y_train = {147.38, 130.38, 129.9, 113.6, 137.5, 162.3, 207.5, 177.9, 210.3};
        var lr = new LinearRegression(5, 100, 0.01, 0.001);
        lr.fit(X_train, y_train, 1000);
        System.out.println(lr);
        double new_x = 6.85;
        System.out.println("Predicted output for " + new_x + ": " + lr.predict(new_x));
        System.out.println("Compared to " + X_train[7][0] + ": " + y_train[7]);
        System.out.println("Compared to " + X_train[8][0] + ": " + y_train[8]);
    }
}
