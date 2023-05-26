package Q4.Prog7301m;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Prog7301m {
    public static int argmax(double[] a) {
        int max = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i] > a[max]) max = i;
        return max;
    }

    public static void main(String[] args) {
        try {
            // Training data
            Scanner input = new Scanner(new File("data/prog7301m_train.csv"));
            var Xtr = new ArrayList<Double[]>();
            var ytr = new ArrayList<Double[]>();
            // label,1x1,1x2,1x3,1x4,1x5,1x6,1x7,1x8,1x9,1x10,1x11,1x12,1x13,1x14,...,28x28
            input.nextLine();
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split(",");
                Double[] row = new Double[line.length-1];  // Images are 28x28, so 784 pixels
                Double[] label_onehot = new Double[10];  // 10 possible digits [0-9]
                int label = Integer.parseInt(line[0]);
                for (int i = 0; i < label_onehot.length; i++)
                    label_onehot[i] = 0.0;
                label_onehot[label] = 1.0;
                for (int i = 1; i < line.length; i++)
                    row[i-1] = Double.parseDouble(line[i]);
                Xtr.add(row);
                ytr.add(label_onehot);
            }

            // Test data
            input = new Scanner(new File("data/prog7301m_test.csv"));
            var Xte = new ArrayList<Double[]>();
            var yte = new ArrayList<Double[]>();
            input.nextLine();
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split(",");
                Double[] row = new Double[line.length-1];  // Images are 28x28, so 784 pixels
                Double[] label_onehot = new Double[10];  // 10 possible digits [0-9]
                int label = Integer.parseInt(line[0]);
                for (int i = 0; i < label_onehot.length; i++)
                    label_onehot[i] = 0.0;
                label_onehot[label] = 1.0;
                for (int i = 1; i < line.length; i++)
                    row[i-1] = Double.parseDouble(line[i]);
                Xte.add(row);
                yte.add(label_onehot);
            }

            double[][] X_train = new double[Xtr.size()][784];
            double[][] y_train = new double[ytr.size()][10];
            for (int i = 0; i < Xtr.size(); i++) {
                for (int j = 0; j < 784; j++)
                    X_train[i][j] = Xtr.get(i)[j];
                for (int j = 0; j < 10; j++)
                    y_train[i][j] = ytr.get(i)[j];
            }
            double[][] X_test = new double[Xte.size()][784];
            double[][] y_test = new double[yte.size()][10];
            for (int i = 0; i < Xte.size(); i++) {
                for (int j = 0; j < 784; j++)
                    X_test[i][j] = Xte.get(i)[j];
                for (int j = 0; j < 10; j++)
                    y_test[i][j] = yte.get(i)[j];
            }

            // Create model
            var model = new MultiLayerPerceptron(new int[]{784, 100, 10}, 0.1,
                                                 new Activations.Sigmoid());
            model.train(X_train, y_train, 10);
            System.out.println("Final Accuracy: " + model.accuracy(X_test, y_test));

            // Pick a random image from the test set
            int index = (int)(Math.random() * X_test.length);
            double[] X_val = X_test[index];
            double[] y_val = y_test[index];

            // Predict the label
            double[] y_pred = model.predict(X_val);
            int pred = argmax(y_pred);
            int actual = argmax(y_val);
            System.out.println("Predicted: " + pred + "\tActual: " + actual);

            // Display the image
            var image = new BufferedImage(28, 28, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < 28; i++)
                for (int j = 0; j < 28; j++)
                    image.setRGB(j, i, (int)X_val[i * 28 + j]);
            
            var frame = new JFrame("Image");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JLabel(new ImageIcon(image)));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
