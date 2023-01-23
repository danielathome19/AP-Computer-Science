package Q2;

public class NumberCubeMain {
    private int notReady;
    private static int isReady = 18;

    /** Returns an array of the values obtained by tossing
     * a number cube numTosses times.
     * @param cube a Q2.NumberCube
     * @param numTosses the number of tosses to be recorded
     * Precondition: numTosses > 0
     * @return an array of numTosses values
     */
    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        // Static means ready at compile-time
        // i.e., we don't have to make an object to use the method/variable
        // Much like all of our math functions
        int[] tosses = new int[numTosses];
        for (int lcv = 0; lcv < numTosses; lcv++)
            tosses[lcv] = cube.toss();
        return tosses;
    }

    /** Returns the starting index of a longest run of two or more
     * consecutive repeated values in the array values.
     * @param values an array of integer values representing a series
     * of number cube tosses
     * Precondition: values.length > 0
     * @return the starting index of a run of maximum size;
     * -1 if there is no run
     */
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
