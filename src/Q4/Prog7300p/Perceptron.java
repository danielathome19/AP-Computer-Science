package Q4.Prog7300p;

import java.util.function.Function;

public class Perceptron {
    private double[] weights;
    private double bias;
    private Function<Double, Double> activation;

    private Double unit_step(Double x) { return x > 0 ? 1.0 : 0.0; }

    public Perceptron() {
        bias = 1;
        activation = this::unit_step;
    }

    public double[] getWeights() { return weights; }
    public double getBias()      { return bias; }

    public double forward(double[] x) {
        double dot_product = 0;
        for (int i = 0; i < x.length; i++)
            dot_product += x[i] * weights[i];
        return activation.apply(dot_product + bias);
    }

    public double[] predict(double[][] X_test) {
        double[] predictions = new double[X_test.length];
        for (int i = 0; i < X_test.length; i++)
            predictions[i] = forward(X_test[i]);
        return predictions;
    }

    public void fit(double[][] X_train, double[] y_train,
                    int epochs, double learning_rate) {
        weights = new double[X_train[0].length];
        for (int i = 0; i < weights.length; i++)
            weights[i] = Math.random() - 0.5;
        int n_samples = X_train.length;
        for (int epoch = 0; epoch < epochs; epoch++) {
            double loss = 0;
            for (int i = 0; i < n_samples; i++) {
                double y_pred = forward(X_train[i]);
                double error = y_train[i] - y_pred;
                loss = Math.pow(error, 2);
                for (int j = 0; j < weights.length; j++)
                    weights[j] += learning_rate * error * X_train[i][j];
                bias += learning_rate * error;
            }
            System.out.println("Epoch " + (epoch+1) + " - Loss: " + (loss/n_samples));
        }
    }
}
