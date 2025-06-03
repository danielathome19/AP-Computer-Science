package Q4.Prog7301m;

import java.io.*;

public class MultiLayerPerceptron implements Serializable {
    private Layer[] layers;
    private Activations.Activation activation;

    public MultiLayerPerceptron(int[] layerSizes, Activations.Activation activation) {
        this.activation = activation;
        layers = new Layer[layerSizes.length];
        for (int i = 0; i < layerSizes.length; i++)
            layers[i] = (i == 0) ? new Layer(layerSizes[i], 0)
                                 : new Layer(layerSizes[i], layerSizes[i-1]);
    }

    public double[] feedForward(double[] x) {
        double result;
        double[] output = new double[layers[layers.length-1].Size];
        for (int i = 0; i < layers[0].Size; i++)
            layers[0].Neurons[i].Value = x[i];
        for (int k = 1; k < layers.length; k++) {
            for (int i = 0; i < layers[k].Size; i++) {
                result = 0;
                for (int j = 0; j < layers[k-1].Size; j++)
                    result += layers[k].Neurons[i].Weights[j] *
                              layers[k-1].Neurons[j].Value;
                result += layers[k].Neurons[i].Bias;
                layers[k].Neurons[i].Value = activation.activate(result);
            }
        }
        for (int i = 0; i < layers[layers.length-1].Size; i++)
            output[i] = layers[layers.length-1].Neurons[i].Value;
        return output;
    }

    public double backPropagate(double[] x, double[] output, double learningRate) {
        double[] result = feedForward(x);
        double error = 0;

        for (int i = 0; i < layers[layers.length-1].Size; i++) {
            error = output[i] - result[i];
            layers[layers.length-1].Neurons[i].Delta =
                    error * activation.activateDeriv(result[i]);
        }

        for (int k = layers.length-2; k >= 0; k--) {
            for (int i = 0; i < layers[k].Size; i++) {
                error = 0;
                for (int j = 0; j < layers[k+1].Size; j++)
                    error += layers[k+1].Neurons[j].Delta *
                             layers[k+1].Neurons[j].Weights[i];
                layers[k].Neurons[i].Delta = error *
                        activation.activateDeriv(layers[k].Neurons[i].Value);
            }
            for (int i = 0; i < layers[k+1].Size; i++) {
                for (int j = 0; j < layers[k].Size; j++)
                    layers[k+1].Neurons[i].Weights[j] += learningRate *
                        layers[k+1].Neurons[i].Delta * layers[k].Neurons[j].Value;
                layers[k+1].Neurons[i].Bias +=
                        learningRate * layers[k+1].Neurons[i].Delta;
            }
        }

        error = 0;
        for (int i = 0; i < output.length; i++)
            error += Math.abs(result[i] - output[i]);
        return error / output.length;
    }

    public double[] predict(double[] x) { return feedForward(x); }

    public double accuracy(double[][] X, double[][] output) {
        double error = 0;
        for (int i = 0; i < X.length; i++) {
            double[] result = feedForward(X[i]);
            for (int j = 0; j < output[i].length; j++)
                error += Math.abs(result[j] - output[i][j]);
        }
        return 1 - error / (X.length * output[0].length);
    }

    public void train(double[][] X_train, double[][] y_train,
                      int epochs, double learningRate) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            double loss = 0;
            for (int i = 0; i < X_train.length; i++)
                loss += backPropagate(X_train[i], y_train[i], learningRate);
            loss /= X_train.length;
            System.out.printf("Epoch %d:\tLoss: %.6f\t\tAccuracy: %.6f\n",
                              (epoch+1), loss, accuracy(X_train, y_train));
        }
    }

    public void saveModel(String filename) {
        try (var out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error saving model!");
        }
    }

    public static MultiLayerPerceptron loadModel(String filename) {
        try (var in = new ObjectInputStream(new FileInputStream(filename))) {
            return (MultiLayerPerceptron) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading model!");
            return null;
        }
    }
}
