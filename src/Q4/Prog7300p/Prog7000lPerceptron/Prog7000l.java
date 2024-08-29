package Q4.Prog7300p.Prog7000lPerceptron;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog7000l {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("Langdat/prog7000l.csv"));
            ArrayList<Double[]> X = new ArrayList<>();
            ArrayList<Double> y = new ArrayList<>();
            // Home,Price,SqFt,Bedrooms,Bathrooms,Offers,Brick,Neighborhood
            input.nextLine();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(",");
                Double[] row = {
                  Double.parseDouble(data[2]),
                  Double.parseDouble(data[0])
                };
                y.add(Double.parseDouble(data[1]));
                X.add(row);
            }
            double[][] X_train = new double[X.size()][2];
            for (int i = 0; i < X.size(); i++) {
                X_train[i][0] = X.get(i)[0];
                X_train[i][1] = X.get(i)[1];
            }
            double[] y_train = new double[y.size()];
            for (int i = 0; i < y.size(); i++)
                y_train[i] = y.get(i);

            var lr = new PerceptronRegressor(0.0001, 1000);
            lr.fit(X_train, y_train);

            double sqFoot = 1897;
            // Find comparable data point
            double closestPoint = X_train[0][0];
            int closestIndex = 0;
            for (int i = 1; i < X_train.length; i++) {
                if (Math.abs(X_train[i][0]-sqFoot) < Math.abs(closestPoint-sqFoot)) {
                    closestPoint = X_train[i][0];
                    closestIndex = i;
                }
            }
            System.out.println("Predicted output for " + sqFoot + ": " + lr.predict(new double[][]{{sqFoot, 1}})[0]);
            System.out.println("Compared to " + closestPoint + ": " + y_train[closestIndex]);
        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
