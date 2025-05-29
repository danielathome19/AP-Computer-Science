package Q4.Prog7300p.Prog7000lPerceptron;

import Q4.Prog7300p.Perceptron;

public class PerceptronRegressor extends Perceptron {
    private double[] meanX, stdX;
    private double meanY, stdY;

    private void calculateFeatureScaling(double[][] X) {
        meanX = new double[X[0].length];
        stdX = new double[X[0].length];
        for (int i = 0; i < X[0].length; i++) {
            for (double[] x : X) meanX[i] += x[i];
            meanX[i] /= X.length;
            for (double[] x : X)
                stdX[i] += Math.pow(x[i] - meanX[i], 2);
            stdX[i] = Math.sqrt(stdX[i] / X.length);
        }
    }

    private void calculateLabelScaling(double[] y) {
        meanY = stdY = 0;
        for (double v : y) meanY += v;
        meanY /= y.length;
        for (double v : y)
            stdY += Math.pow(v - meanY, 2);
        stdY = Math.sqrt(stdY / y.length);
    }

    private double[][] scaleFeatures(double[][] X) {
        double[][] X_scaled = new double[X.length][X[0].length];
        for (int i = 0; i < X.length; i++)
            for (int j = 0; j < X[0].length; j++)
                X_scaled[i][j] = (X[i][j] - meanX[j]) / stdX[j];
        return X_scaled;
    }

    private double[] scaleLabels(double[] y, boolean unscale) {
        double[] y_scaled = new double[y.length];
        for (int i = 0; i < y.length; i++)
            y_scaled[i] = (!unscale) ? (y[i] - meanY) / stdY
                    : y[i] * stdY + meanY;
        return y_scaled;
    }

    @Override
    public double forward(double[] X) {
        double dot_product = getBias();
        for (int i = 0; i < X.length; i++)
            dot_product += X[i] * getWeights()[i];
        return dot_product;
    }

    @Override
    public double[] predict(double[][] X_test) {
        double[][] X_test_scaled = scaleFeatures(X_test);
        double[] y_pred_scaled = super.predict(X_test_scaled);
        return scaleLabels(y_pred_scaled, true);
    }

    @Override
    public void fit(double[][] X_train, double[] y_train, int epochs, double learning_rate) {
        calculateFeatureScaling(X_train);
        calculateLabelScaling(y_train);
        double[][] X_train_scaled = scaleFeatures(X_train);
        double[] y_train_scaled = scaleLabels(y_train, false);
        super.fit(X_train_scaled, y_train_scaled, epochs, learning_rate);
    }
}
