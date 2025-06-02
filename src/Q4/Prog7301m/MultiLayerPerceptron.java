package Q4.Prog7301m;

import java.io.Serializable;

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

}
