package Q4.Prog7301m;

public class Layer {
    class Neuron {
        public double[] Weights;
        public double Bias;
        public double Value;  // a_i^(l)
        public double Delta;

        public Neuron(int prevLayerSize) {
            Weights = new double[prevLayerSize];
            Bias = Math.random() - 0.5;
            Value = Math.random() - 0.5;
            Delta = Math.random() - 0.5;
            for (int i = 0; i < Weights.length; i++)
                Weights[i] = Math.random() - 0.5;
        }
    }

    public Neuron[] Neurons;
    public int Size;

    public Layer(int neurons, int prevLayerSize) {
        Size = neurons;
        Neurons = new Neuron[Size];
        for (int i = 0; i < Size; i++)
            Neurons[i] = new Neuron(prevLayerSize);
    }
}
