public class NumberCubeMain {
    private int notReady;
    private static int isReady = 18;
    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        // Static means ready at compile-time
        // i.e., we don't have to make an object to use the method/variable
        // Much like all of our math functions
        int[] tosses = new int[numTosses];
        for (int lcv = 0; lcv < numTosses; lcv++)
            tosses[lcv] = cube.toss();
        return tosses;
    }

    public static int getLongestRun(int[] values) {
        int max = 0;
        int maxIndex = -1;
        int curr = 0;
        for (int lcv = 0; lcv < values.length - 1; lcv++) {
            if (values[lcv] == values[lcv + 1]) {
                curr++;
            } else {
                if (curr > max) {
                    max = curr;
                    maxIndex = lcv - curr;
                }
                curr = 0;
            }
        }
        if (curr > max) {
            max = curr;
            maxIndex = values.length - curr;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        NumberCube x = new NumberCube();
        int[] y = getCubeTosses(x, isReady);
        for (int temp : y)
            System.out.print(temp + " ");
        System.out.println("\nLongest run: " + getLongestRun(y));
    }
}
