package Q4.Prog7000l;

import java.util.Arrays;
public class LinearRegression {
    private double theta0;  // y-Intercept
    private double theta1;  // Slope
    private double alpha;   // Learning Rate
    private double tolerance;
    private double[] objective;

    public LinearRegression(double thetaOne, double thetaZero,
                            double learning_rate, double tol) {
        theta1 = thetaOne;
        theta0 = thetaZero;
        alpha = learning_rate;
        tolerance = tol;
    }

    public void fit(double[][] X_train, double[] y_train, int epochs) {
        int m = X_train.length;
        objective = new double[epochs];
        double[] e = new double[m];

        for (int epoch = 0; epoch < epochs; epoch++) {
            if (epoch > 0) {
                double temp0 = 0;
                double temp1 = 0;
                for (int i = 0; i < m; i++) {
                    double temp = (theta1 * X_train[i][0] + theta0 - y_train[i]);
                    // predicted label - actual label
                    temp0 += temp;
                    temp1 += temp * X_train[i][0];
                }
                // Gradient Descent
                theta0 -= (1.0/m) * alpha * temp0;
                theta1 -= (1.0/m) * alpha * temp1;
            }
            for (int i = 0; i < m; i++)
                e[i] = theta1 * X_train[i][0] + theta0 - y_train[i];  // J
            double obj = 0;
            for (int i = 0; i < m; i++)
                obj += e[i] * e[i];
            objective[epoch] = obj;

            if ((epoch > 1) && (Math.abs(objective[epoch]-objective[epoch-1])
                    < tolerance))
                break;
        }
    }

    public String toString() {
        return "Regression Line: y = " + theta1 + " * x + " + theta0 +
               "\nObjective: " + Arrays.toString(objective) +
               "\nMin. Objective: " + (double)Arrays.stream(objective).min().getAsDouble();

    }

    public double getIntercept() { return theta0; }
    public double getSlope() { return theta1; }
    public double predict(double x) { return theta1 * x + theta0; }
}
