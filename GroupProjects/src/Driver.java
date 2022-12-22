import java.util.List;

public class Driver {

    static double[][] X = { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } };
    static double[][] Y = { { 0 }, { 1 }, { 1 }, { 0 } };

    public static void main(String[] args) {

        NeuralNetwork network = new NeuralNetwork(2, 10, 1);

        List<Double> output;
        network.fit(X, Y, 50000);
        double[][] input = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        for (double[] inputs : input) {
            output = network.predict(inputs);
            System.out.println(output.toString());
        }

    }

}