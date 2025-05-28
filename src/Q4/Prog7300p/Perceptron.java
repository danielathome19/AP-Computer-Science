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

    // TODO: predict and fit
}
