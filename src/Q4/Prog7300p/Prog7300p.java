package Q4.Prog7300p;

import java.util.Arrays;

public class Prog7300p {
    public static void main(String[] args) {
        // Test Perceptron using AND dataset
        double[][] X_train = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };
        double[] y_train = {0, 0, 0, 1};

        System.out.println("AND Neuron:");
        var model = new Perceptron(0.1, 15);
        model.fit(X_train, y_train);

        // Predict using the trained model
        double[] y_pred = model.predict(X_train);
        System.out.println("Prediction: " + Arrays.toString(y_pred));
        System.out.println("Actual: " + Arrays.toString(y_train));

        // Print weights and biases
        System.out.println("Weights: " + Arrays.toString(model.getWeights()));
        System.out.println("Bias: " + model.getBias());


        // Make neurons for OR, NOT, NAND, and NOR
    }
}
