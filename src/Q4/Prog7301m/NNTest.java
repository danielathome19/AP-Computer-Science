package Q4.Prog7301m;

import java.util.Arrays;

public class NNTest {
    public static void main(String[] args) {
        // Test MLP using XOR dataset
        double[][] X_train = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        double[][] y_train = {{0}, {1}, {1}, {0}};
        var model = new MultiLayerPerceptron(new int[]{2, 3, 1}, 0.1,
                                             new Activations.Tanh());
        model.train(X_train, y_train, 1000);
        for (int i = 0; i < X_train.length; i++) {
            double[] result = model.predict(X_train[i]);
            System.out.printf("Input: %s Output: %.6f\n", Arrays.toString(X_train[i]), result[0]);
        }
        System.out.println("Final accuracy: " + model.accuracy(X_train, y_train));
    }
}
