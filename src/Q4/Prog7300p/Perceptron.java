package Q4.Prog7300p;

import java.util.function.Function;

public class Perceptron {
    private double learning_rate;
    private int epochs;
    private double[] weights;
    private double bias;
    private Function<Double, Double> activation;

    private Double unit_step(Double x) { return x > 0 ? 1.0 : 0.0; }

    public Perceptron(double learning_rate, int epochs) {
        this.learning_rate = learning_rate;
        this.epochs = epochs;
        this.bias = 1;
        this.activation = this::unit_step;
    }

    public double[] getWeights() { return weights; }
    public double getBias() { return bias; }

    public double forward(double[] X) {
        double dot_product = bias;
        for (int i = 0; i < X.length; i++)
            dot_product += X[i] * weights[i];
        return activation.apply(dot_product);
    }
}
